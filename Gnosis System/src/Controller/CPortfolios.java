/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MConnection;
import Model.MPortfolios;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Controller of Methods of reading data on Portfolio. This class contains everything from the resource Portfolio.
 * @author santi
 */
public class CPortfolios {
    
    Connection con = MConnection.getConnectionWithoutParameters();
    
    MPortfolios mdlPortfolios = new MPortfolios();
    
    public ResultSet CargarPortafolios(){
        return mdlPortfolios.CargarPortafoliosPrev();
    }
    
    public ResultSet CargarPortafoliosFiltro(String clasificacion){
        return mdlPortfolios.BuscarCategoria(clasificacion, con);
    }
    
}
