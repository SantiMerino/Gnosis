/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class MLogin {
      
    public static int InciarSesion (String user, String clave){
        int i = 0;
        Connection conexion = MConnection.getConnectionWithoutParameters();
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("SELECT idnivelusuario FROM tbUsuarios WHERE username = ? AND clave = ?");
            ps.setString(1, user);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            } else {
                i = 0;
            }
            return i;
        } catch (Exception e) {
            return i;
        }
    }
}
