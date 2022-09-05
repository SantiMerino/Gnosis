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
 * @author PC
 */
public class MNotas {
    PreparedStatement ps;
    
    /*Llenado de combobox*/
    
    public ResultSet MCargarPefiles(Connection con){
        try {
            String query = "SELECT * FROM tbPerfiles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    public ResultSet MCargarAlumnos(Connection con){
        try {
            String query = "SELECT * FROM tbAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }

    /*Mostrar Tabla*/
    
    public ResultSet MCargarRegistrosNotas(Connection con){
        try {
            String query = "SELECT * FROM tbRegistroNotas";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    /*Insercion de datos*/
    public boolean RegistrarRegistroNotas(int idperfil, int idalumno,Connection con){
         try {
             String query = "INSERT INTO tbRegistroNotas VALUES(?,?)";
             ps = con.prepareStatement(query);
             ps.setInt(1, idperfil);
             ps.setInt(2, idalumno);
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
    
    /*Actualizacion*/
    
    public boolean ActualizarRegistroNotas(int ID, int idperfil, int idalumno, Connection con){
        try {
            String query = "UPDATE tbRegistroNotas SET idperfil = ?, idalumno = ? WHERE idnota = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idperfil);
            ps.setInt(2, idalumno);
            ps.setInt(3, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
             return false;
        }
    }
    
    /*Eliminacion*/
    
    public boolean EliminarEstudianteModel(int ID, Connection con){
         try {
             String query = "DELETE tbAlumnos WHERE idnota = ?";
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