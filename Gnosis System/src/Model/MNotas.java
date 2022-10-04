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
 * Model of Methods of creating, deleting, modifying and reading data on Grades. This class contains everything from the resource Grades.
 * @author PC
 */
public class MNotas {
    PreparedStatement ps;
    
    /*Llenado de combobox*/  
    /**
     * Method in the Notes Module to load profiles from the model.
     * @param con
     * @return 
     */   
    public ResultSet MCargarPefiles(Connection con){
        try {
            String query = "SELECT * FROM tbPerfiles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    /**
     * Method in the Model Notes to load students from the model.
     * @param con
     * @return 
     */    
    public ResultSet MCargarAlumnos(Connection con){
        try {
            String query = "SELECT * FROM tbAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }

    /*Mostrar Tabla*/   
    /**
     * Method in the Model Notes to fill the table with a query from the model.
     * @param con
     * @return 
     */    
    public ResultSet MCargarRegistrosNotas(Connection con){
        try {
            String query = "SELECT * FROM tbRegistroNotas";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    /**
     * Method in the Notes Model for entering a note.
     * @param idperfil
     * @param idalumno
     * @param con
     * @return 
     */ 
    public boolean RegistrarRegistroNotas(int idperfil, int idalumno,Connection con){
         try {
             String query = "INSERT INTO tbRegistroNotas VALUES(?,?)";
             ps = con.prepareStatement(query);
             ps.setInt(1, idperfil);
             ps.setInt(2, idalumno);
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
    
    /*Update*/
    /**
     * Method in the Notes Model for updating a note.
     * @param ID
     * @param idperfil
     * @param idalumno
     * @param con
     * @return 
     */
    public boolean ActualizarRegistroNotas(int ID, int idperfil, int idalumno, Connection con){
        try {
            String query = "UPDATE tbRegistroNotas SET idperfil = ?, idalumno = ? WHERE idnota = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idperfil);
            ps.setInt(2, idalumno);
            ps.setInt(3, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
             return false;
        }
    }
    
    /*Elimination*/
    /**
     * Method in the Notes Model for deleting a note. 
     * @param ID
     * @param con
     * @return 
     */ 
    public boolean EliminarEstudianteModel(int ID, Connection con){
         try {
             String query = "DELETE tbAlumnos WHERE idnota = ?";
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
     * Method in the Model Notes for the search by name of the profile in the model.
     * @param ID
     * @param con
     * @return 
     */  
    public ResultSet SearchCrnt(int ID, Connection con) {
        try {
            String query = "SELECT nombreperfil FROM tbPerfiles WHERE idperfil = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
    
    /**
     * Method in the Notes Model to obtain a note by means of the profile id.
     * @param ID
     * @param con
     * @return 
     */  
    public ResultSet ObtenerId(int ID, Connection con) {
        try {
            String query = "SELECT nota FROM tbPerfiles WHERE idperfil = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return  null;
        }        
    }
     
    /*Combobox*/    
    public ResultSet MCargarTipoPerfil(Connection con) {
        try {
            String query = "SELECT * FROM tbTipoPerfiles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los tipos de perfiles: " + e.toString());
            return null;
        }
    }

    public ResultSet MCargarGrado(Connection con) {
        try {
            String query = "SELECT * FROM tbGrados";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los grados: " + e.toString());
            return null;
        }
    }
     
    public ResultSet MCargarFase(Connection con) {
        try {
            String query = "SELECT * FROM tbFases";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo las fases: " + e.toString());
            return null;
        }
    }
     
    /*Filtro*/
    /**
     * Method in the Notes Model with the search for records through filters
     *
     * @param busca
     * @param param
     * @param con
     * @return
     */
    public ResultSet BuscarPerfilParam(String busca, String param, Connection con) {
        //System.out.println(busca + " "+ param);
        try {
            String sentencia = "select * from viewPerfiles where tipoperfil like '" + busca + "%' and grado like '" + param + "%'";
            ps = con.prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleados" + e.toString(), "error de base de datos", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
