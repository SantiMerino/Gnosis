/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * Model of Methods of reading data on Portfolio. This class contains everything from the resource Portfolio.
 * @author santi
 */
public class MPortfolios {
    
    PreparedStatement ps;
    
    public ResultSet CargarPortafoliosPrev(){
        Connection con;
        try {
            con = MConnection.getConnectionWithoutParameters();
            String query = "SELECT * FROM viewPortafolios";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public ResultSet BuscarCategoria(String clasificacion,Connection con){
        try {
            ResultSet rs;
            String sentencia = "";
            sentencia = "SELECT * FROM viewPortafolios WHERE Categoria LIKE '"+clasificacion+"%'";
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
    public boolean GuardarPortafolio(int idalumno, int idmateriadocente, String contenido, Connection con){
        try {
            String query = "UPDATE tbPortafolio SET contenido = ? WHERE idalumno = ? AND idmateriadocente = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, contenido);
            ps.setInt(2, idalumno);
            ps.setInt(3, idmateriadocente);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
        public ResultSet CargarPortafolio(int idalumno,int idmateriadocente,Connection con){
        try {
            ResultSet rs;
            String sentencia = "";
            sentencia = "SELECT * FROM tbPortafolio WHERE idalumno = ? AND idmateriadocente = ?";
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, idalumno);
            ps.setInt(2, idmateriadocente);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
        
        public ResultSet ObtenerMateriaDocente(int idgrado, Connection con){
            try {
                ResultSet rs;
                String sentencia = "";
                sentencia = "SELECT a.idmateriadocente FROM tbMateriaDocentes a, tbDocentes b WHERE b.idgrado = ? AND a.iddocente = b.iddocente;";
                ps = con.prepareStatement(sentencia);
                ps.setInt(1, idgrado);
                rs = ps.executeQuery();
                return rs;
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        public boolean CrearPortafoliosAlumno(int idmateriadocente, Connection con){
            try {
                ResultSet rs;
                String sentencia = "EXEC CrearPortafolios ?, ?, ?";
                ps = con.prepareStatement(sentencia);
                ps.setEscapeProcessing(true);
                ps.setInt(1, idmateriadocente);
                ps.setInt(2, 1);
                ps.setInt(3, 1);
                rs = ps.executeQuery();
                return true;
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
        }
}
