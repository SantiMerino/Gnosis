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
public class MUsers {
    PreparedStatement ps;
    
    public ResultSet CargaCmbEstadoUsuario() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbEstadoUsuarios";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbAlumnos() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbDocentes() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbDocentes";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet CargaCmbNivelUsuario() {
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM tbNivelUsuarios";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet mostrarUsuarios(Connection con){
        try {
            String query = "SELECT * FROM tbUsuario;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los usuarios: " + e.toString());
            return null;
        }
    }
    
    public boolean RegistrarUsuariosModel(int nivelusuario, String username, String clave, int pin, int estadousuario, int alumno, int docente, Connection con) {
        try {        
            if (alumno == 0) {
                alumno = 10;
            } 
            if(docente == 0){
                docente = 114;
            }
            String query = "INSERT INTO tbUsuario VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, nivelusuario);
            ps.setString(2, username);
            ps.setString(3, clave);
            ps.setInt(4, pin);
            ps.setInt(5, estadousuario);
            ps.setInt(6, alumno);
            ps.setInt(7, docente);
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
    
    public boolean ActualizarUsuariosModel(int ID, int nivelusuario, String username, String clave, int pin, int estadousuario, int alumno, int docente, Connection con){
         try {
            String query = "UPDATE tbUsuario SET idnivelusuario = ?, username = ?, clave = ?, pin = ?, idestadousuario = ?, idalumno = ?, iddocente = ? WHERE idusuario = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, nivelusuario);
            ps.setString(2, username);
            ps.setString(3, clave);
            ps.setInt(4, pin);
            ps.setInt(5, estadousuario);
            ps.setInt(6, alumno);
            ps.setInt(7, docente);
            ps.setInt(8, ID);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el registro" + e.toString());
            return false;
        }
    }
    
    public boolean EliminarUsuarioModel(int ID, Connection con) {     
        try {
             String query = "DELETE tbUsuario WHERE idusuario = ?";
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
