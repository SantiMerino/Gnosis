/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MConnection;
import java.sql.Connection;

/**
 *
 * @author santi
 */
public class CConnection {
    
    public static Connection getConnectionController(){
        return MConnection.getConnection(CConfiguracion.IP, CConfiguracion.Port, CConfiguracion.Database, CConfiguracion.User, CConfiguracion.Password);
    }
    
        public static Connection getConnectionControllerWithoutParameters(){
        return MConnection.getConnectionWithoutParameters();
    }
}
