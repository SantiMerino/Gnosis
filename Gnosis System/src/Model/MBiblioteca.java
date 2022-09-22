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
 * @author josec
 */
public class MBiblioteca {
    
    PreparedStatement ps;
    
    public ResultSet CargaCmbTipoClasificacion() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbClasificaciones";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbTipoRecurso() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbTipoRecursos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet mostrarBibliotecas(Connection con){
        try {
            String query = "SELECT * FROM tbBiblioteca";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron las tareas: " + e.toString());
            return null;
        }
    }
    
    /**
     * Metedo en el Modelo Biblioteca para subir un recurso en la biblioteca.
     * @param nombrerecurso
     * @param idtiporecurso
     * @param idclasificacion
     * @param link
     * @param pdf
     * @param con
     * @return 
     */
    public boolean SubirBibliotecaModel(String nombrerecurso, int idtiporecurso, int idclasificacion, String link, String pdf, Connection con) {
        try {            
            String query = "INSERT INTO tbBiblioteca VALUES (?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombrerecurso);
            ps.setInt(2, idtiporecurso);
            ps.setInt(3, idclasificacion);
            ps.setString(4, link);
            ps.setString(5, pdf);
            ps.setInt(6, 1);
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
    
    /**
     * Metedo en el Modelo Biblioteca para actualizar un recurso en la biblioteca.
     * @param ID
     * @param nombrerecurso
     * @param idtiporecurso
     * @param idclasificacion
     * @param link
     * @param pdf
     * @param con
     * @return 
     */
    public boolean ActualizarBibliotecasModel(int ID,String nombrerecurso, int idtiporecurso, int idclasificacion, String link, String pdf, Connection con){
        JOptionPane.showMessageDialog(null, idtiporecurso);
        JOptionPane.showMessageDialog(null, idclasificacion);
         try {
             String query = "UPDATE tbBiblioteca SET nombrerecurso = ?, idtiporecurso = ?, idclasificacion = ?, link = ?, pdf = ? WHERE idbiblioteca = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombrerecurso);
            ps.setInt(2, idtiporecurso);
            ps.setInt(3, idclasificacion);
            ps.setString(4, link);
            ps.setString(5, pdf);
            ps.setInt(6, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
    
    /**
     * Metedo en el Modelo Biblioteca para eliminar el recurso de la biblioteca.
     * @param ID
     * @param con
     * @return 
     */
    public boolean EliminarBibliotecasModel(int ID, Connection con) {
         
        try {
             String query = "DELETE tbBiblioteca WHERE idbiblioteca = ?";
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
     * Metodo en el Modelo Biblioteca para buscar un recurso mediante el nombre en la biblioteca.
     * @param carnet
     * @param con
     * @return 
     */
    public ResultSet Search(String carnet, Connection con) {
        try {
            String query = "select * from tbBiblioteca where nombrerecurso like(?)";
            ps = con.prepareStatement(query);
            ps.setString(1, carnet);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
     
     
    public ResultSet CargarRecursosVista(int id, Connection con){
        try {
            String query = "SELECT * FROM viewBiblioteca WHERE idalumno = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ResultSet BuscarRecursos(String categoria){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String sentencia = "SELECT * FROM viewBiblioteca WHERE tiporecurso LIKE '"+categoria+"%'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet BuscarRecursosClas(String clasificacion){
        try {
            ResultSet rs;
            Connection con = MConnection.getConnectionWithoutParameters();
            String sentencia = "SELECT * FROM viewBiblioteca WHERE clasificacion LIKE '"+clasificacion+"%'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
}
