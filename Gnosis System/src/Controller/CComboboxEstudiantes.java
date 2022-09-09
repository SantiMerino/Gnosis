/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.MEstudents;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class CComboboxEstudiantes {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    MEstudents modeloGeneros = new MEstudents();
    MEstudents modeloGrados = new MEstudents();
    MEstudents modeloUsuarios = new MEstudents();
    MEstudents modeloAlumnos = new MEstudents();
    MEstudents mdlEstu = new MEstudents();
    
    
    public ResultSet CCargarGeneros(){
       return modeloGeneros.MCargarGenero(con);
    }
    
    public ResultSet CCargarGrados(){
       return modeloGrados.MCargarGrados(con);
    }
    
    public ResultSet CCargarUsuarios(){
       return modeloUsuarios.MCargarUsuarios(con);
    }
    
    public ResultSet CCargarEstudiantes(){
       return modeloAlumnos.mostrarEstudiantes(con);
    }
    
    public ResultSet SearchCrnt(String letra){
        return mdlEstu.SearchCrnt(letra, con);
    }
    
}
