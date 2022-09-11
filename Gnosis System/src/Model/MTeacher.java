/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class MTeacher {
     PreparedStatement ps;
    
    public ResultSet MCargarGenero(Connection con){
        try {
            String query = "SELECT * FROM tbGeneros";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    public ResultSet MCargarUsuarios(Connection con){
        try {
            String query = "SELECT * FROM tbUsuario";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los usuarios: " + e.toString());
            return null;
        }
    }
    
     public ResultSet MCargarGrado(Connection con){
        try {
            String query = "SELECT * FROM tbGrados";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los usuarios: " + e.toString());
            return null;
        }
    }
    
    /*Cargar tabla de registros*/
     public ResultSet mostrarDocentes(Connection con){
        try {
            String query = "SELECT * FROM tbDocentes";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los docentes: " + e.toString());
            return null;
        }
    }
     
    /*Inserción de datos*/
    public boolean RegistrarDocenteModel(String apellidosdocente, String nombresdocente, String direccion, String dui, 
            String correo, 
            String fecha_nac, int idgrado, int idgenero, String contacto, Connection con) {
        try {
             
            String query = "INSERT INTO tbDocentes VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, apellidosdocente);
            ps.setString(2, nombresdocente);
            ps.setString(3, direccion);
            ps.setString(4, dui);
            ps.setString(5, correo);
            ps.setString(6, fecha_nac);
            ps.setInt(7, idgrado);
            ps.setInt(8, idgenero);
            ps.setString(9, contacto);
//            ps.setInt(10, idusuario);
            if (ps.executeUpdate () == 1) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos, verifique la conexion. " + e.toString());
            return false;
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro critico. " + ex.toString());
            return false;
        }
    }
     
     /*Actualizacion de datos*/
     public boolean ActualizarDocenteModel(int ID, String apellidosdocente, String nombresdocente, String direccion, String dui, 
            String correo, 
            String fecha_nac, int idgrado, int idgenero, String contacto, Connection con){
         try {
            String query = "UPDATE tbDocentes SET apellidos_docente = ?, nombres_docente = ?, direccion = ?, dui = ?, correo = ?, fecha_nac = ?, idgrado = ?, idgenero = ?, contacto = ? WHERE iddocente = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, apellidosdocente);
            ps.setString(2, nombresdocente);
            ps.setString(3, direccion);
            ps.setString(4, dui);
            ps.setString(5, correo);
            ps.setString(6, fecha_nac);
            ps.setInt(7, idgrado);
            ps.setInt(8, idgenero);
            ps.setString(9, contacto);
//            ps.setInt(10, idusuario);
            ps.setInt(10, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
     }
     
     /*Eliminacion de datos*/
     
     public boolean EliminarDocenteModel(int ID, Connection con) {
         
        try {
            String query = "DELETE tbDocentes WHERE idDocente = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro seleccionado, verifique la conexion");
            return false;
        }        
     } 
     
     public ResultSet Search(String dui, Connection con) {
        try {
            String query = "select * from tbDocentes where dui like(?)";
            ps = con.prepareStatement(query);
            ps.setString(1, dui);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
     
}
