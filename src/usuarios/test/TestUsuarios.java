/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.test;

import java.sql.SQLException;
import java.util.List;
import usuarios.dto.UsuarioDto;
import usuarios.jdbc.UsuarioDao;
import usuarios.jdbc.UsuariosDaoJDBC;

/**
 *
 * @author Chelo
 */
public class TestUsuarios {

    /**
     * Se utiliza el tipo interface como referencia a una clase concreta
     */
    public static void main(String[] args) {
        UsuarioDao usuarioDao = new UsuariosDaoJDBC();
        //Se crea un nuevo registro 
        //Se utliza la clase persona Dao la cual se usa para transferir informacion entre capas
        UsuarioDto usuario = new UsuarioDto();
        usuario.setNombre_usuario("Jonh");
        usuario.setApellido_usuario("Gutierrez");

        try {
            //usuarioDao.insert(usuario);
            //usuarioDao.delete(new UsuarioDto(3));
           UsuarioDto usuarioTemp = new UsuarioDto();
           usuarioTemp.setId_usuario(2);
           usuarioTemp.setNombre_usuario("Mark");
           usuarioTemp.setApellido_usuario("Markquez");
           usuarioDao.update(usuarioTemp);
           
           
           
            List<UsuarioDto> usuarios = usuarioDao.select();
            for (UsuarioDto usuarioDto : usuarios) {
                System.out.println(usuarioDto);
                System.out.println();
            }
        }catch(SQLException ex){
            System.out.println("Excepcion en la capa de prueba");
            ex.printStackTrace();
        }

    }

}
