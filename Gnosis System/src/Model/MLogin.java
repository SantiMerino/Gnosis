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
 *
 * @author santi
 */
public class MLogin {
      
    public static int InciarSesion (String user, String clave){
        int i = 0;
//        JOptionPane.showMessageDialog(null, user);
//        JOptionPane.showMessageDialog(null, clave);
//        JOptionPane.showMessageDialog(null, nivel);
        Connection conexion = MConnection.getConnectionWithoutParameters();
        PreparedStatement ps;
        int nivel;
        try {
            ps = conexion.prepareStatement("SELECT * FROM tbUsuario WHERE username = ? AND clave = ?");
            ps.setString(1, user);
            ps.setString(2, clave);
//            ps.setInt(3, nivel);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nivel = rs.getInt(2);
                return nivel;
            }else {
                JOptionPane.showMessageDialog(null, "Las credenciales  son incorrectas o no existen", "Creedenciales", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
            return 0;
        }
    }
}
