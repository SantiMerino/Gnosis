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
 * Model of Methods of creating, deleting, modifying and reading data on Library. This class contains everything from the resource Library.
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
     * Method in the Library Model to isnert a resource in the library.
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
     * Method in the Library Model to update a resource in the library.
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
     * Method in the Library Model to remove the resource from the library.
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
     * Method in the Library Model to search for a resource by name in the library.
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
     
     /**
      * Method in the Library Model to load the view of the library.
      * @param id
      * @param con
      * @return 
      */
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
    
    public ResultSet BuscarRecursos(String categoria, int Id, Connection con){
        try {
            ResultSet rs;
            String sentencia = "SELECT * FROM viewBiblioteca WHERE tiporecurso LIKE '"+categoria+"%' AND idalumno = ?";
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, Id);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet BuscarRecursosClas(String clasificacion, int Id,Connection con){
        try {
            ResultSet rs;
            String sentencia = "SELECT * FROM viewBiblioteca WHERE clasificacion LIKE '"+clasificacion+"%' AND idalumno = ?";
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, Id);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
}
