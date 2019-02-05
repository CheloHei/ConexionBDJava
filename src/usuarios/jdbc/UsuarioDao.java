/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.jdbc;

import java.sql.SQLException;
import java.util.List;
import usuarios.dto.UsuarioDto;

/**
 *
 * @author Chelo
 */
//Interfaz para realizar crud 
public interface UsuarioDao {
    
        public int insert(UsuarioDto usuario)
                throws SQLException;
        public int update(UsuarioDto usuario)
                throws SQLException;
        public int delete(UsuarioDto usuario)
                throws SQLException;
        public  List<UsuarioDto> select() throws SQLException;
    }
    
    

