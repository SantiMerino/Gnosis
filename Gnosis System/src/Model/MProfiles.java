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
    
    public ResultSet DatosDocente(int iddocente){
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT CONCAT(b.apellidos_docente, ', ',b.nombres_docente) AS [Docente], e.grado, c.materia, d.modulo, b.iddocente\n"
                    + "FROM tbMateriaDocentes a, tbDocentes b, tbMaterias c, tbModulos d, tbGrados e\n"
                    + "WHERE a.iddocente = b.iddocente\n"
                    + "AND a.idmateria = c.idmateria\n"
                    + "AND a.idmodulo = d.idmodulo\n"
                    + "AND b.idgrado = e.idgrado\n"
                    + "AND b.iddocente = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, iddocente);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Method of the Profiles Model to upload profiles.
     * @param nombre
     * @param descripcion
     * @param porcentajedevaloracion
     * @param fechadeinicio
     * @param fechadevencimiento
     * @param tipoperfil
     * @param con
     * @return 
     */
    public boolean SubirPerfilesModel(String nombre, String descripcion, String porcentajedevaloracion, String fechadeinicio, String fechadevencimiento, int tipoperfil, Connection con) {
        double nota = 7.5;
        int idestadoperfil = 1;
        int idfase = 1;
        int idmateriadocente = 1;
        int idgrado = 8;
        try {            
            String query = "INSERT INTO tbPerfiles VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, porcentajedevaloracion);
            ps.setString(4, fechadeinicio);
            ps.setString(5, fechadevencimiento);
            ps.setInt(6, idestadoperfil);
            ps.setDouble(7, nota);
            ps.setInt(8, tipoperfil);
            ps.setInt(9, idfase);
            ps.setInt(10, idmateriadocente);
            ps.setInt(11, idgrado);
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
     * Method of the Profiles Model to update the profiles.
     * @param ID
     * @param nombre
     * @param descripcion
     * @param porcentajedevaloracion
     * @param fechadeinicio
     * @param fechadevencimiento
     * @param tipoperfil
     * @param grado
     * @param con
     * @return 
     */
    public boolean ActualizarProfilesModel(int ID, String nombre, String descripcion, String porcentajedevaloracion, String fechadeinicio, String fechadevencimiento, int tipoperfil,int grado, Connection con){
         try {
            String query = "UPDATE tbPerfiles SET nombreperfil = ?, descripcion = ?, porcentajeValoracion = ?, fechainicio = ?, fechavencimiento = ?, idtipoperfil = ?, idgrados = ? WHERE idperfil = ?";
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
    
    /**
     *Method in the Profiles Model to delete profiles.
     * @param ID
     * @param con
     * @return 
     */
    public boolean EliminarProfileModel(int ID, Connection con) {     
        try {
             String query = "DELETE tbPerfiles WHERE idperfil = ?";
             ps = con.prepareStatement(query);
             ps.setInt(1, ID);
             ps.execute();
             return true;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el registro seleccionado, verifique la conexion" + e.toString());
             return false;
        }        
    }
}
