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
            String query = "SELECT * FROM tbTipoPerfiles";
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
            String query = "SELECT * FROM tbGrados";
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
            String query = "SELECT * FROM viewPerfiles;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los perfiles: " + e.toString());
            return null;
        }
    }
    
    public boolean SubirPerfilesModel(String nombre, String descripcion, String porcentajedevaloracion, String fechadeinicio, String fechadevencimiento, int tipoperfil,int grado, Connection con) {
        try {            
            String query = "INSERT INTO tbPerfiles(nombreperfil,descripcion,porcentajevaloracion,fechainicio,fechavencimiento,idtipoperfil,idgrados) VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, porcentajedevaloracion);
            ps.setString(4, fechadeinicio);
            ps.setString(5, fechadevencimiento);
            ps.setInt(6, tipoperfil);
            ps.setInt(7, grado);
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
    
    public boolean ActualizarProfilesModel(int ID, String nombre, String descripcion, String porcentajedevaloracion, String fechadeinicio, String fechadevencimiento, int tipoperfil,int grado, Connection con){
         try {
            String query = "UPDATE tbPerfiles SET nombreperfil = ?, descripcion = ?, porcentajeValoracion = ?, fechainicio = ?, fechavencimiento = ?, idtipoperfil = ?, idgrados = ? WHERE idperfil = ?";
            ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, porcentajedevaloracion);
            ps.setString(4, fechadeinicio);
            ps.setString(5, fechadevencimiento);
            ps.setInt(6, tipoperfil);
            ps.setInt(7, grado);
            ps.setInt(8, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
    
    public boolean EliminarProfileModel(int ID, Connection con) {     
        try {
             String query = "DELETE tbPerfiles WHERE idperfil = ?";
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
