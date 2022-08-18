/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class MTasks {

    PreparedStatement ps;
    
    public ResultSet CargaCmbTipoPerfil() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbPerfiles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbTipoTarea() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbTipoTarea";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet mostrarTareas(Connection con){
        try {
            String query = "SELECT * FROM tbTareas";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron las tareas: " + e.toString());
            return null;
        }
    }
    
    public boolean SubirTareasModel(String nombretarea, String fechainicio, String fechavencimiento, int idperfil, String rubrica, int idtipotarea, Connection con) {
        try {            
            String query = "INSERT INTO tbTareas VALUES (?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombretarea);
            ps.setString(2, fechainicio);
            ps.setString(3, fechavencimiento);
            ps.setInt(4, idperfil);
            JOptionPane.showMessageDialog(null, idperfil);
            ps.setString(5, rubrica);
            ps.setInt(6, idtipotarea);
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
    
    public boolean ActualizarTareasModel(int ID, String nombre, String nombretarea, String fechadeinicio, String fechadevencimiento, int idperfil, String rubrica, int idtipotarea, Connection con){
         try {
             String query = "UPDATE tbTareas SET nombretarea = ?, fechadeinicio = ?, fechavencimiento = ?, idperfil = ?, rubrica = ?, idtipotarea = ? WHERE idtarea = ?";
            ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setString(1, nombretarea);
            ps.setString(2, fechadeinicio);
            ps.setString(3, fechadevencimiento);
            ps.setInt(4, idperfil);
            ps.setString(5, rubrica);
            ps.setInt(6, idtipotarea);
            ps.setInt(7, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
    
    public boolean EliminarTareaModel(int ID, Connection con) {
         
        try {
             String query = "DELETE tbTareas WHERE idtarea = ?";
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
