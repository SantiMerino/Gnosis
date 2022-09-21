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
    MNotas modelGradoPerfil = new MNotas();
    
    MNotas modelTipoPerfil = new MNotas();
    MNotas modelGrado = new MNotas();
    MNotas modelPeriodo = new MNotas();
    MNotas modeloBusqueda = new MNotas();
    
    
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
    
    public ResultSet ObtenerGrado(int ID){
        return modelGradoPerfil.ObtenerId(ID, con);
    }
    
    /*Combobox*/
    
    public ResultSet CCargarTipoPerfil(){
       return modelTipoPerfil.MCargarTipoPerfil(con);
    }
    
    public ResultSet CCargarGrado(){
       return modelGrado.MCargarGrado(con);
    }
    
    public ResultSet CCargarFases(){
       return modelPeriodo.MCargarFase(con);
    }
    
    /*Filtro*/
    
    public ResultSet SearchParam(String busca, String param){
        return modeloBusqueda.BuscarPerfilParam(busca, param, con);
    }
    
}
