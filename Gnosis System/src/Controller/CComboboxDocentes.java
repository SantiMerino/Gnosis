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
 *
 * @author Estudiante_PC10
 */
public class CComboboxDocentes {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    MTeacher modeloGeneros = new MTeacher();
    MTeacher modeloUsuarios = new MTeacher();
    MTeacher modeloDocentesC = new MTeacher();
    
    public ResultSet CCargarGeneros(){
       return modeloGeneros.MCargarGenero(con);
    }
    
    public ResultSet CCargarUsuarios() {
        return modeloUsuarios.MCargarUsuarios(con);
    }
    
    public ResultSet CCargarDocentes(){
        return modeloDocentesC.mostrarDocentes(con);
    }
}