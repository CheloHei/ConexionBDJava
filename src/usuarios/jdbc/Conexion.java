/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.jdbc;

import java.sql.*;

/**
 *
 * @author Chelo
 */
public class Conexion {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/javas?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static Driver driver = null;

    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null) {

            try {
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("Fallo al cargar driver de BD");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(URL, USER, "");
    }
    
    public static void close (ResultSet rs){
        try{
        if (rs!=null) {
            rs.close();
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void close (PreparedStatement ps){
        try{
        if (ps!=null) {
            ps.close();
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void close (Connection conn){
        try{
        if (conn!=null) {
            conn.close();
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
