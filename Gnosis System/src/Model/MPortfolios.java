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
    
    public boolean GuardarPortafolio(int idalumno, int materia, String contenido){
        boolean res;
        try {
           String query = "INSERT INTO tbPortafolios VALUES (?, ?, ?, ?)";
           Connection con = MConnection.getConnectionWithoutParameters();
           ps = con.prepareStatement(query);
            res = ps.execute();
            if (res == true) {
               return res;
            } else {
               return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}
