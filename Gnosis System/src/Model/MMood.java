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
 * Model of Methods of creating, deleting, modifying and reading data on Mood. This class contains everything from the resource Mood.
 * @author PC
 */
public class MMood {
    
    private PreparedStatement ps;
    
    public ResultSet MCargarMaterias(Connection con){
        try {
            String query = "SELECT * FROM tbMaterias";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    /**
     * Method in the Mood Model to register the time spent.
     * @param enfoque
     * @param tiempo
     * @param idmateria
     * @param con
     * @return 
     */
    public boolean RegistrarEventoModel(String tiempo, int enfoque, int alumno,  Connection con) {
        try {           
            String query = "INSERT INTO tbEstadisticasEnfoque VALUES (?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, tiempo);
            ps.setInt(2, enfoque);
            ps.setInt(3, alumno);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos, verifique la conexion. " + e.toString());
            return false;
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro critico. " + ex.toString());
            return false;
        }
    }
    
    public ResultSet UltimaEstadistica(int idalumno, Connection con){
        try {
            String query = "SELECT * FROM tbEstadisticasEnfoque WHERE idalumno = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idalumno);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No fue posible cargar las estadisticas del alumno");
            return null;
        }
    }
}
