/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class MConnection {
    
    /**
     *Method in the Connection Model to access the database with its own data.
     * @param IP
     * @param port
     * @param db
     * @param user
     * @param password
     * @return 
     */
    public static Connection getConnection(String IP, String port, String db, String user, String password){
        Connection con;
        try {
            String url = "jdbc:sqlserver://"+IP+":"+port+ ";"
                   + "databse = "+db+";"
                   + "user = " +user+ ";"
                   + "password = " +password+ ";"
                   + "loginTimeOut = 30";
            con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos, E001" + e.toString());
            return null;
        }
    }
    
    /**
     * Method in the Connection Model to access the database without parameters.
     * @return 
     */
    public static Connection getConnectionWithoutParameters() {
        //Variable conexión y será la variable a retornar.
        Connection con;
        try {
            //Valores de conexión
            String url = "jdbc:sqlserver://2.tcp.ngrok.io:13591;"
                    + "database = dbGnosis;"
                    + "user = inicio_sesion;"
                    + "password = itr2022;"
                    + "loginTimeOut = 10";
            //Assigning values to connection object
            con = DriverManager.getConnection(url);
            //Retorno de objeto conexión
            return con;
        } catch (Exception e) {
            //Error message in case a connection is not established correctly
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos, E001   " + e.toString());
            return null;
        }
    }
}
