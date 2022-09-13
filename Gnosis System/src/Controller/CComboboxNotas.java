/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MNotas;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class CComboboxNotas {
    Connection con = CConnection.getConnectionControllerWithoutParameters();
    MNotas modeloPerfil = new MNotas();
    MNotas modeloAlumno = new MNotas();
    MNotas modelRegistroNotas = new MNotas();
    MNotas modelNombrePerfil = new MNotas();
    
    public ResultSet CCargarPerfiles(){
       return modeloPerfil.MCargarPefiles(con);
    }
    
    public ResultSet CCargarAlumnos(){
        return modeloAlumno.MCargarAlumnos(con);
    }
    
    /*Cargar tabla de registros*/
    
    public ResultSet CCargarRegistroNotas(){
        return modelRegistroNotas.MCargarRegistrosNotas(con);
    }
    
    public ResultSet SearchCrnt(int ID){
        return modelNombrePerfil.SearchCrnt(ID, con);
    }
    
}
