/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MTasks;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class CTasks {

    MTasks MObj = new MTasks();
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    
    public ResultSet CLoadGender () {
        return MObj.LoadComboBoxGender(con);
    }
    
}
