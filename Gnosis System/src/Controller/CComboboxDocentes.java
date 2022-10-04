/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import Model.MTeacher;
import java.sql.ResultSet;

/**
 * Controller of of Methods reading data on Teachers. This class contains everything from the resource Teachers.
 * @author Usuario
 */

public class CComboboxDocentes {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    MTeacher modeloGeneros = new MTeacher();
    MTeacher modeloUsuarios = new MTeacher();
    MTeacher modeloGrados = new MTeacher();
    MTeacher modeloDocentesC = new MTeacher();
    MTeacher modeloBusqueda = new MTeacher();
    
    public ResultSet CCargarGeneros(){
       return modeloGeneros.MCargarGenero(con);
    }
    
      public ResultSet Search(String letra){
        return modeloBusqueda.Search(letra, con);
    }
    
    public ResultSet CCargarUsuarios() {
        return modeloUsuarios.MCargarUsuarios(con);
    }
    
    public ResultSet CCargarGrados() {
        return modeloUsuarios.MCargarGrado(con);
    }
    
    public ResultSet CCargarDocentes(){
        return modeloDocentesC.mostrarDocentes(con);
    }
}
