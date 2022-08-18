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
     public boolean RegistrarDocenteModel(String NombresDocente, String ApellidosDocente, String DireccionDocente, String TelefonoDocente, String FechaNacimiento, 
             String DUI, String Correo, int idGeneroDocente, int idUsuario, Connection con) {
         try {
             
             String query = "INSERT INTO tbDocentes VALUES (?,?,?,?,?,?,?,?,?)";
             ps = con.prepareStatement(query);
             ps.setString(1, NombresDocente);
             ps.setString(2, ApellidosDocente);
             ps.setString(3, DireccionDocente);
             ps.setString(4, TelefonoDocente);
             ps.setString(5, FechaNacimiento);
             ps.setString(6, DUI);
             ps.setString(7, Correo);
             ps.setInt(8, idGeneroDocente);
             ps.setInt(9, idUsuario);
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
     public boolean ActualizarDocenteModel(int ID, String NombresDocente, String ApellidosDocente, String DireccionDocente, String TelefonoDocente, String FechaNacimiento, String DUI, String Correo, int idGeneroDocente, int idUsuario, Connection con){
         try {
             String query = "UPDATE tbDocentes SET NombresDocente = ?, ApellidosDocente = ?, DireccionDocente = ?, TelefonoDocente = ?, FechaNacimiento = ?, DUI = ?, Correo = ?, idGeneroDocente = ?, idUsuario = ? WHERE idDocente = ?";
             ps = con.prepareStatement(query);
             ps.setString(1, NombresDocente);
             ps.setString(2, ApellidosDocente);
             ps.setString(3, DireccionDocente);
             ps.setString(4, TelefonoDocente);
             ps.setString(5, FechaNacimiento);
             ps.setString(6, DUI);
             ps.setString(7, Correo);
             ps.setInt(8, idGeneroDocente);
             ps.setInt(9, idUsuario);
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
}
