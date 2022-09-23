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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * This java class is for all the methods for tasks managment
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
    
    public ResultSet CargarTareasPrev(){
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM viewTareas";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
        
    public ResultSet CargarTareasFull(int idtarea){
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM viewTareas WHERE idtarea = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idtarea);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs;
            } else{
                return null;
            }
            
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
    
    /**
     * Metedo en el Modelo Tareas para subir tareas asignadas a un perfil.
     * @param nombretarea
     * @param fechainicio
     * @param fechavencimiento
     * @param idperfil
     * @param rubrica
     * @param idtipotarea
     * @param con
     * @return 
     */
    public boolean SubirTareasModel(String nombretarea, String fechainicio, String fechavencimiento, int idperfil, String rubrica, int idtipotarea, Connection con) {
        try {            
            String query = "INSERT INTO tbTareas VALUES (?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombretarea);
            ps.setString(2, fechainicio);
            ps.setString(3, fechavencimiento);
            ps.setInt(4, idperfil);
            ps.setString(5, rubrica);
            ps.setInt(6, idtipotarea);
            if (ps.executeUpdate() == 1) {
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
    
    /**
     * Metedo en el Modelo Tareas para actualizar las tareas.
     * @param ID
     * @param nombretarea
     * @param fechadeinicio
     * @param fechavencimiento
     * @param idperfil
     * @param rubrica
     * @param idtipotarea
     * @param con
     * @return 
     */
    public boolean ActualizarTareasModel(int ID, String nombretarea, String fechadeinicio, String fechavencimiento, int idperfil, String rubrica, int idtipotarea, Connection con){
        try {
            String query = "UPDATE tbTareas SET nombretarea = ?, fechadeinicio = ?, fechavencimiento = ?, idperfil = ?, rubrica = ?, idtipotarea = ? WHERE idtarea = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombretarea);
            ps.setString(2, fechadeinicio);
            ps.setString(3, fechavencimiento);
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
    
    /**
     * Metodo en el Modelo Tareas para eliminar tareas
     * @param ID
     * @param con
     * @return 
     */
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
    
    public ResultSet Search(String nombre, Connection con) {
        try {
            String query = "select * from tbTareas where nombretarea like(?) or fechadeinicio like(?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
    
    
    public boolean UploadTaskStudent(String link, String pdf, int idalumno,int idtarea, Connection con){
            try {
                String query = "INSERT INTO tbTareasAlumnos VALUES (?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, idtarea);
                ps.setInt(1, idalumno);
                ps.setString(1, pdf);
                ps.setString(1, link);
                if (ps.executeUpdate() == 1) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Hubo un error en al subir la tarea " + ex.toString());
               return false;
            }
    }
    
     public ResultSet BuscarTipoPerfil(String clasificacion,Connection con){
        try {
            ResultSet rs;
            String sentencia = "SELECT * FROM viewTareas WHERE Estado LIKE '"+clasificacion+"%'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
     
     public ResultSet Estado(String clasificacion,Connection con){
        try {
            ResultSet rs;
            String sentencia = "SELECT * FROM viewTareas WHERE TipoPerfil LIKE '"+clasificacion+"%'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
}
