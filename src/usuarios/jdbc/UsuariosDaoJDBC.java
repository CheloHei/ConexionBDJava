/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import usuarios.dto.UsuarioDto;

/**
 * Esta clase implementa la clase UsuarioDao es una implementacion con la
 * tecnologia JDBC
 *
 * @author Chelo
 */
public class UsuariosDaoJDBC implements UsuarioDao {

    private Connection userConn;
    private final String SQL_INSERT = "insert into usuarios(nombre_usuario,apellido_usuario) values (?,?)";
    private final String SQL_UPDATE = "update usuarios set nombre_usuario=?,apellido_usuario=? where id_usuario=?";
    private final String SQL_DELETE = "delete from usuarios where id_usuario = ?";
    private final String SQL_SELECT = "select * from usuarios";

    public UsuariosDaoJDBC() {

    }

    public UsuariosDaoJDBC(Connection conn) {
        this.userConn = conn;
    }

    @Override
    public int insert(UsuarioDto usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setString(index++, usuario.getNombre_usuario());
            ps.setString(index, usuario.getApellido_usuario());
            rows = ps.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } finally {
            Conexion.close(ps);
            if (this.userConn == null) {
                Conexion.close(conn);
            }

        }
        return rows;
    }

    @Override
    public int update(UsuarioDto usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null ? this.userConn : Conexion.getConnection());
            System.out.println("Actualizando: " + SQL_UPDATE);
            ps = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            ps.setString(index++, usuario.getNombre_usuario());
            ps.setString(index++, usuario.getApellido_usuario());
            ps.setInt(index, usuario.getId_usuario());
            rows = ps.executeUpdate();

            System.out.println("Registros afectados: " + rows);
        } finally {
            Conexion.close(ps);
        
            if (this.userConn == null) {
                Conexion.close(conn);
            }

        }
        return rows;

    }

    @Override
    public int delete(UsuarioDto usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = (this.userConn != null ? this.userConn : Conexion.getConnection());
            System.out.println("Ejecutando Delete: " + SQL_DELETE);
            int index = 1;
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(index++, usuario.getId_usuario());
            rows = ps.executeUpdate();
            System.out.println("Registros Afectados: " + rows);
        } finally {
            Conexion.close(ps);
        }
            if (this.userConn!=null) {
                Conexion.close(conn);
            }
            return rows;
        }

        @Override
        public List<UsuarioDto> select() throws SQLException {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            UsuarioDto usuario = null;
            List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
            try{
                conn = (this.userConn!=null ? this.userConn : Conexion.getConnection());
                ps = conn.prepareStatement(SQL_SELECT);
                rs = ps.executeQuery();
                while(rs.next()){
           
                    usuario = new UsuarioDto();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setApellido_usuario(rs.getString("apellido_usuario"));
                    usuarios.add(usuario);
                }
                
            }finally{
            Conexion.close(rs);
            Conexion.close(ps);
                if (this.userConn == null) {
                    Conexion.close(conn);
                }
            
            }
            return usuarios;
        }

    }
