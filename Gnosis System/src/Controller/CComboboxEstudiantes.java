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
    MEstudents modeloEstados = new MEstudents();
    MEstudents modeloConjunto = new MEstudents();
    MEstudents modeloUsuarios = new MEstudents();
    MEstudents modeloAlumnos = new MEstudents();
    
    public ResultSet CCargarGeneros(){
       return modeloGeneros.MCargarGenero(con);
    }
    
    public ResultSet CCargarEstados(){
       return modeloEstados.MCargarEstado(con);
    }
    
    public ResultSet CCargarConjuntos(){
       return modeloConjunto.MCargarConjunto(con);
    }
    
    public ResultSet CCargarUsuarios(){
       return modeloUsuarios.MCargarUsuarios(con);
    }
    
    public ResultSet CCargarEstudiantes(){
       return modeloAlumnos.mostrarEstudiantes(con);
    }
    
}
