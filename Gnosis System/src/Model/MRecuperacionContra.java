/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class MRecuperacionContra {
    PreparedStatement ps;
    
    public boolean RecuperarContraseña (String correo,String clave,Connection con){
        try {
            JOptionPane.showMessageDialog(null, correo);
            JOptionPane.showMessageDialog(null, clave);
            String query = "UPDATE tbUsuario SET clave = ? WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, clave);
            ps.setString(2, correo);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La contraseña no pudo reestablecerse" + e.toString());
            return false;
        }
    }
    
    public boolean ConsultarPINporCorreo (String correo, int pin, Connection con){
        try {
            String query = "SELECT * FROM tbUsuario WHERE username = ? AND pin = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ps.setInt(2, pin);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Las credenciales no son correctas" + e.toString());
            return false;
        }
    }
    
    public boolean ConsultarADMIN(String correo, String contra, Connection con){
        try {
            int nivelusuario = 3;
            String query = "SELECT * FROM tbUsuario WHERE username = ? AND clave = ? AND idnivelusuario = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ps.setString(2, contra);
            ps.setInt(3, nivelusuario);           
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Las credenciales no son correctas" + e.toString());
            return false;
        }
    }
}
