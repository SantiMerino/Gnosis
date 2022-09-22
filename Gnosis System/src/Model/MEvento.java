/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author josec
 */
public class MEvento {
    
    private PreparedStatement ps;
    
    public ResultSet CargarCmbTipoEvento(Connection con){
        try {
            String query = "SELECT * FROM tbTipoEventos";
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
    
    public ResultSet CargaCalendario(){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbEventos";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    /**
     * Metodo en el Modelo Evento para registrar un evento.
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado
     * @param con
     * @return 
     */
    public boolean RegistrarEventoModel(String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado, Connection con) {
        try {           
            String query = "INSERT INTO tbEventos VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombreevento);
            ps.setString(2, fechaevento);
            ps.setString(3, horainicioevento);
            ps.setString(4, fechafinalevento);
            ps.setString(5, horafinalizarevento);
            ps.setInt(6, idtipoevento);
            ps.setInt(7, idgrado);
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
    
    /**
     * Metodo en el Modelo Eventos actualizar el evento.
     * @param ID
     * @param nombreevento
     * @param fechaevento
     * @param horainicioevento
     * @param fechafinalevento
     * @param horafinalizarevento
     * @param idtipoevento
     * @param idgrado
     * @param con
     * @return 
     */
    public boolean ActualizarEventoModel(int ID, String nombreevento, String fechaevento, String horainicioevento, String fechafinalevento, String horafinalizarevento, int idtipoevento, int idgrado, Connection con){
        try {           
            String query = "UPDATE tbEventos SET nombreevento = ?,  fechaevento = ?, horainicioevento = ?, fechafinalevento = ?, horafinalizarevento = ?, idtipoevento = ?, idgrado = ? WHERE idevento = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombreevento);
            ps.setString(2, fechaevento);
            ps.setString(3, horainicioevento);
            ps.setString(4, fechafinalevento);
            ps.setString(5, horafinalizarevento);
            ps.setInt(6, idtipoevento);
            ps.setInt(7, idgrado);
            ps.setInt(8, ID);
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
    
    /**
     * Metedo en el Modelo Eventos para eliminar el evento.
     * @param ID
     * @param con
     * @return 
     */
    public boolean EliminarEventoModel(int ID, Connection con) {
         
        try {
            String query = "DELETE tbEventos WHERE idevento = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro seleccionado, verifique la conexion");
            return false;
        }        
     }
    
    /**
     * Metedo en el Modelo Evento para consultar los eventos seleccionados.
     * @param fechainicio
     * @param fechafinal
     * @return 
     */
    public ResultSet ConsultarEventosSeleccionadas(String fechainicio, String fechafinal){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM viewEventos";
            ps = con.prepareStatement(query);
//            ps.setString(1, fechainicio);
//            ps.setString(2,  fechafinal);
//            ps.setString(3, fechainicio);
//            ps.setString(4,  fechafinal);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    /**
     * Metedo en el Modelo Evento para buscar un evento mediante su nombre o la fecha en la que se realiza.
     * @param carnet
     * @param con
     * @return 
     */
    public ResultSet Search(String carnet, Connection con) {
        try {
            String query = "select * from tbEventos where nombreevento like(?) or fechaevento like(?)";
            ps = con.prepareStatement(query);
            ps.setString(1, carnet);
            ps.setString(2, carnet);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }  
    
    public ResultSet BuscarFechasRango(String buscar1, String Buscar2){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String sentencia = "SELECT * FROM viewEventos WHERE fechaevento BETWEEN '"+buscar1+"' AND '"+Buscar2+"' OR fechafinalevento BETWEEN '"+buscar1+"' AND '"+Buscar2+"'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet BuscarFechasUnRango(String buscar1){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String sentencia = "SELECT * FROM viewEventos WHERE fechaevento = '"+buscar1+"' OR fechafinalevento = '"+buscar1+"'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
}
