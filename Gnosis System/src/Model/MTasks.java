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
    
    public ResultSet CargaCmbCategoria() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM Categorias";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbTipoArchivo() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM TipoArchivo";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbEspecialidad() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM Especialidades";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbGrado() {
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
    
    public ResultSet mostrarTareas(Connection con){
        try {
            String query = "SELECT * FROM Tareas";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron las tareas: " + e.toString());
            return null;
        }
    }
    
    public boolean SubirTareasModel(String nombre, String etapa, String fechadeinicio, String fechadevencimiento, String ponderacion, String instrumentodeevaluacion, int tipoarchivo, int categoria, int grado, int especialidad, Connection con) {
        try {            
            String query = "INSERT INTO Tareas VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, etapa);
            ps.setString(3, fechadeinicio);
            ps.setString(4, fechadevencimiento);
            ps.setString(5, ponderacion);
            ps.setString(6, instrumentodeevaluacion);
            ps.setInt(7, tipoarchivo);
            ps.setInt(8, categoria);
            ps.setInt(9, grado);
            ps.setInt(10, especialidad);
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
    
    public boolean ActualizarTareasModel(int ID, String nombre, String etapa, String fechadeinicio, String fechadevencimiento, String ponderacion, String instrumentodeevaluacion, int tipoarchivo, int categoria, int grado, int especialidad, Connection con){
         try {
             String query = "UPDATE Tareas SET nombre = ?, etapa = ?, fechadeinicio = ?, fechadevencimiento = ?, ponderacion = ?, instrumentodeevaluacion = ?, idtipoarchivo = ?, idcategoria = ?, idgrado = ?, idespecialidad = ? WHERE idtarea = ?";
            ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, etapa);
            ps.setString(3, fechadeinicio);
            ps.setString(4, fechadevencimiento); 
            ps.setString(5, ponderacion);
            ps.setString(6, instrumentodeevaluacion);
            ps.setInt(7, tipoarchivo);
            ps.setInt(8, categoria);
            ps.setInt(9, grado);
            ps.setInt(10, especialidad);
            ps.setInt(11, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
    
    public boolean EliminarTareaModel(int ID, Connection con) {
         
        try {
             String query = "DELETE Tareas WHERE idtarea = ?";
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
