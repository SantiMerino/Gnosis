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
    
    /**
     * Connection controller for connection to the database with its own parameters.
     * @return 
     */
    public static Connection getConnectionController(){
        return MConnection.getConnection(CConfiguracion.IP, CConfiguracion.Port, CConfiguracion.Database, CConfiguracion.User, CConfiguracion.Password);
    }
    
    /**
     * Connection Controller to connect to the database without parameters. 
     * @return 
     */
    public static Connection getConnectionControllerWithoutParameters() {
        return MConnection.getConnectionWithoutParameters();
    }
}
