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
            String query = "SELECT * FROM tbTipoEvento";
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
            String query = "SELECT * FROM tbGrado";
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
            String query = "SELECT * FROM tbSecciones";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    /**
     * Metedo en el Modelo Calendario para registrar un evento.
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado
     * @param idseccion
     * @return 
     */
    public boolean RegistrarEvento(String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado, int idseccion){
        try {
            Connection con = MConnection.getConnectionWithoutParameters();
            String query = "INSERT INTO tbEventos VALUES (?,?,?,?,?,?,?,?)";  
            ps = con.prepareStatement(query);
            ps.setString(1, nombreevento);
            ps.setString(2, fechaevento);
            ps.setString(3, horainicioevento);
            ps.setString(4, fechafinalevento);
            ps.setString(5, horafinalizarevento);
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
 
    /**
     * Metodo en el Modelo Calendario para actualizar en evento.
     * @param ID
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado
     * @param idseccion
     * @param con
     * @return 
     */
    public boolean ActualizarEventoModelo(int ID, String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado, int idseccion, Connection con){
        try {
            String query = "UPDATE tbEventos SET nombreevento = ?, fechaevento = ?, horainicioevento = ?, fechafinalevento = ?, horafinalizarevento = ?, idtipoevento = ?, idgrado = ?, idseccion = ?  WHERE idevento = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, nombreevento);
            ps.setString(2, fechaevento);
            ps.setString(3, horainicioevento);
            ps.setString(4, fechafinalevento);
            ps.setString(5, horafinalizarevento);
            ps.setInt(6, idtipoevento);
            ps.setInt(7, idgrado);
            ps.setInt(8, idseccion);
            ps.setInt(9, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
  
    /**
     * Metedo en el Modelo Calendario para eliminar un evento.
     * @param ID
     * @param con
     * @return 
     */
    public boolean EliminarEventoModelo(int ID, Connection con){
        try {
            String query = "DELETE Eventos WHERE idevento = ?";
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
