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
public class MProfiles {
    PreparedStatement ps;
    
    public ResultSet CargaCmbTipoPerfil() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM TipoPerfil";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbGradoPerfil() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM Grados";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbSeccionesPerfil() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM Secciones";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet mostrarPerfiles(Connection con){
        try {
            String query = "SELECT * FROM Perfil";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los perfiles: " + e.toString());
            return null;
        }
    }
    
    public boolean SubirPerfilesModel(String nombre, String rubricadeevaluacion, String fechadeinicio, String fechadevencimiento, String porcentajedevaloracion, String descripcion, int tipoperfil,int grado, int seccion, Connection con) {
        try {            
            String query = "INSERT INTO Tareas VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, rubricadeevaluacion);
            ps.setString(3, fechadeinicio);
            ps.setString(4, fechadevencimiento);
            ps.setString(5, porcentajedevaloracion);
            ps.setString(6, descripcion);
            ps.setInt(7, tipoperfil);
            ps.setInt(9, grado);
            ps.setInt(10, seccion);
            if (ps.executeUpdate () == 1) {
                return true;
            } else {
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
    
    public boolean ActualizarProfilesModel(int ID, String nombre, String rubricadeevaluacion, String fechadeinicio, String fechadevencimiento, String porcentajedevaloracion, String descripcion, int tipoperfil,int grado, int seccion, Connection con){
         try {
             String query = "UPDATE Tareas SET nombre = ?, rubricadeevaluacion = ?, fechadeinicio = ?, fechadevencimiento = ?, ponderacion = ?, porcentajedevaloracion = ?, descripcion = ?, idtipoarchivo = ?, idgrado = ?, idseccion = ? WHERE idperfil = ?";
            ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, rubricadeevaluacion);
            ps.setString(3, fechadeinicio);
            ps.setString(4, fechadevencimiento);
            ps.setString(5, porcentajedevaloracion);
            ps.setString(6, descripcion);
            ps.setInt(7, tipoperfil);
            ps.setInt(8, grado);
            ps.setInt(9, seccion);
            ps.setInt(10, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
    
    public boolean EliminarProfileModel(int ID, Connection con) {     
        try {
             String query = "DELETE Tareas WHERE idperfil = ?";
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
