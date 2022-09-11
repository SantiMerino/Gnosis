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
    
    public ResultSet ConsultarEventosSeleccionadas(Date fecha){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT a.nombreevento, b.tipoevento, c.grado FROM tbEventos a, tbTipoEventos b, tbGrados c WHERE a.fechaevento BETWEEN ? AND ? AND a.idtipoevento = b.idtipoevento AND a.idgrado = c.idgrado";
            ps = con.prepareStatement(query);
            ps.setTimestamp(1, new java.sql.Timestamp(fecha.getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(fecha.getTime()));
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet Search(String carnet, Connection con) {
        try {
            String query = "select * from tbEventos where nombreevento like(?)";
            ps = con.prepareStatement(query);
            ps.setString(1, carnet);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
    
}
