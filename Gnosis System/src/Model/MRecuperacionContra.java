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
 * Model of Methods reading data on Password recovery. This class contains everything from the resource Password recovery.
 * @author santi
 */
public class MRecuperacionContra {
    PreparedStatement ps;
    
    /**
     * Method in the Password Recovery Model to update and recover the password.
     * @param correo
     * @param clave
     * @param con
     * @return 
     */
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
    
    /**
     * Method in the Password Recovery Model to check the PIN sent to the mail.
     * @param correo
     * @param pin
     * @param con
     * @return 
     */
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
    
    /**
     * Method in the Password Recovery Model to confirm the data of an administrator.
     * @param correo
     * @param contra
     * @param con
     * @return 
     */
    public ResultSet ConsultarADMIN(String correo, String contra, Connection con){
        try {
            int nivelusuario = 3;
            String query = "SELECT * FROM tbUsuario WHERE username = ? AND clave = ? AND idnivelusuario = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, correo);
            ps.setString(2, contra);
            ps.setInt(3, nivelusuario);           
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs;
            }else{
                JOptionPane.showMessageDialog(null, "Error al comprobar");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Las credenciales no son correctas" + e.toString());
            return null;
        }
    }
}
