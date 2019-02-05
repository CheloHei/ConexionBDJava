/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.dto;

/**
 *
 * @author Chelo
 */
//DTO DATA TRANSFER OBJECT
public class UsuarioDto {
    
    public UsuarioDto(){
        
    }
    
    public UsuarioDto(int id_usuario){
        this.id_usuario = id_usuario;
    }
    
    private int id_usuario;
    
    private String nombre_usuario;
    
    private String apellido_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }
    
    
    public String toString(){
        return "Persona{"+"id_usuario="+id_usuario+",nombre_usuario = "+nombre_usuario+", apellido_usuario"+apellido_usuario +  ')';
    }
    
    
    
}
