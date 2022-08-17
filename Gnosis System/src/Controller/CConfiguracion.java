/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author santi
 */
public class CConfiguracion {

    public static String getIP() {
        return IP;
    }

    public static void setIP(String IP) {
        CConfiguracion.IP = IP;
    }

    public static String getDatabase() {
        return Database;
    }

    public static void setDatabase(String Database) {
        CConfiguracion.Database = Database;
    }

    public static String getUser() {
        return User;
    }

    public static void setUser(String User) {
        CConfiguracion.User = User;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        CConfiguracion.Password = Password;
    }

    public static String getPort() {
        return Port;
    }

    public static void setPort(String Port) {
        CConfiguracion.Port = Port;
    }
    public static String IP;
    public static String Database;
    public static String User;
    public static String Password;
    public static String Port;
    
    
    
    //Constructor Vacio
    public CConfiguracion() {
    }    
}
