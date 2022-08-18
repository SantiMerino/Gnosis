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
 * @author PC
 */
public class MEstudents {
    /*Llenar combobox*/
    PreparedStatement ps;
    
    public ResultSet MCargarGenero(Connection con){
        try {
            String query = "SELECT * FROM tbGenerosAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los generos: " + e.toString());
            return null;
        }
    }
    
    public ResultSet MCargarEstado(Connection con){
        try {
            String query = "SELECT * FROM tbEstadosAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los estados: " + e.toString());
            return null;
        }
    }
    
    public ResultSet MCargarConjunto(Connection con){
        try {
            String query = "SELECT * FROM tbConjuntoNiveles";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los conjuntos: " + e.toString());
            return null;
        }
    }
    
    public ResultSet MCargarUsuarios(Connection con){
        try {
            String query = "SELECT * FROM tbUsuarios";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo los usuarios: " + e.toString());
            return null;
        }
    }
    
    /*Cargar tabla de registros*/
     public ResultSet mostrarEstudiantes(Connection con){
        try {
            String query = "SELECT * FROM tbAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los alumnos: " + e.toString());
            return null;
        }
    }
    
     /*Insercion de datos*/
     
     public boolean RegistrarDocenteModel(String NombresAlumno, String ApellidosAlumno, String DireccionAlumno, String TelefonoAlumno, String FechaNacimiento, 
             String DUIAlumno, String CorreoAlumno, String CodigoCarnet, int idGeneroALumno, int idEstadoAlumno, int idConjuntoNiveles, int idUsuario, Connection con) {
         try {
             
             String query = "INSERT INTO tbAlumnos VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
             ps = con.prepareStatement(query);
             ps.setString(1, NombresAlumno);
             ps.setString(2, ApellidosAlumno);
             ps.setString(3, DireccionAlumno);
             ps.setString(4, TelefonoAlumno);
             ps.setString(5, FechaNacimiento);
             ps.setString(6, DUIAlumno);
             ps.setString(7, CorreoAlumno);
             ps.setString(8, CodigoCarnet);
             ps.setInt(9, idGeneroALumno);
             ps.setInt(10, idEstadoAlumno);
             ps.setInt(11, idConjuntoNiveles);
             ps.setInt(12, idUsuario);
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
     
    /*Actualizacion*/ 
     public boolean ActualizarEstudianteModel(int ID, String NombresAlumno, String ApellidosAlumno, String DireccionAlumno, String TelefonoAlumno, String FechaNacimiento, 
             String DUIAlumno, String CorreoAlumno, String CodigoCarnet, int idGeneroALumno, int idEstadoAlumno, int idConjuntoNiveles, int idUsuario, Connection con){
         try {
             String query = "UPDATE tbAlumnos SET NombresAlumno = ?, ApellidosAlumno = ?, DireccionAlumnos = ?, TelefonoAlumno = ?, FechaNacimiento = ?, DUIAlumno = ?, CorreoAlumno = ?, CodigoCarnet = ?, "
                     + "idGeneroAlumno = ?, idEstadoAlumno = ?, idConjuntoNiveles = ?, idUsuario = ? WHERE idAlumno = ?";
            ps = con.prepareStatement(query);
             ps.setString(1, NombresAlumno);
             ps.setString(2, ApellidosAlumno);
             ps.setString(3, DireccionAlumno);
             ps.setString(4, TelefonoAlumno);
             ps.setString(5, FechaNacimiento);
             ps.setString(6, DUIAlumno);
             ps.setString(7, CorreoAlumno);
             ps.setString(8, CodigoCarnet);
             ps.setInt(9, idGeneroALumno);
             ps.setInt(10, idEstadoAlumno);
             ps.setInt(11, idConjuntoNiveles);
             ps.setInt(12, idUsuario);
             ps.setInt(13, ID);
             ps.execute();
             return true;
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
             return false;
         }
     }
     
     /*Eliminacion de datos*/
     public boolean EliminarEstudianteModel(int ID, Connection con){
         try {
             String query = "DELETE tbAlumnos WHERE idAlumno = ?";
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
