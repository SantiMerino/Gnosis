/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MPortfolios;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class CPortfolios {
    
    MPortfolios mdlPortfolios = new MPortfolios();
    
    public ResultSet CargarPortafolios(){
        return mdlPortfolios.CargarPortafoliosPrev();
    }
}
