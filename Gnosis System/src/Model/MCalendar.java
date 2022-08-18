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
 * @author devro
 */
public class MCalendar {
    
    private PreparedStatement ps;
    
    public ResultSet CargarTablaCalendario(){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM Eventos";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargarComboTipoEvento(Connection con){
        try {
            String query = "SELECT * FROM TipoEventos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargarComboGrado(Connection con){
        try {
            String query = "SELECT * FROM Grado";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargarComboSeccion(Connection con){
        try {
            String query = "SELECT * FROM Seccion";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public boolean RegistrarEvento(String NombreEvento, String FechaEvento, String HoraInicioEvento, String FechaFinEvento, String HoraFinalizarEvento, int idtipoevento, int idgrado, int idseccion){
        try {
            Connection con = MConnection.getConnectionWithoutParameters();
            String query = "INSERT INTO Eventos VALUES (?,?,?,?,?,?,?,?)";  
            ps = con.prepareStatement(query);
            ps.setString(1, NombreEvento);
            ps.setString(2, FechaEvento);
            ps.setString(3, HoraInicioEvento);
            ps.setString(4, FechaFinEvento);
            ps.setString(5, HoraFinalizarEvento);
            ps.setInt(6, idtipoevento);
            ps.setInt(7, idgrado);
            ps.setInt(8, idseccion);
            if (ps.executeUpdate() == 1) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException  e){
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos" + e.toString());
            return false;
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error critico" + ex.toString());
            return false;
        }     
    }
    
    public boolean EliminarEventoModelo(int ID, Connection con){
        try {
            String query = "DELETE Eventos WHERE idevente = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro, verifique que no existan datos dependientes, si el problema persiste consulte con el admin del sistema");           
        }
        return false;
    }
    
    
}
