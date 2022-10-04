/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MNotas;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 * Controller of of Methods reading data on Grades. This class contains everything from the resource Grades.
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
    
    /**
     * Method to load profiles
     * @return 
     */
    
    public ResultSet CCargarPerfiles(){
       return modeloPerfil.MCargarPefiles(con);
    }
    
    /**
     * Method to load students
     * @return 
     */
    
    public ResultSet CCargarAlumnos(){
        return modeloAlumno.MCargarAlumnos(con);
    }
    
    /*Cargar tabla de registros*/
    
   /**
    *  Method in the controller to fill the table with the view
    * @return 
    */
    
    public ResultSet CCargarRegistroNotas(){
        return modelRegistroNotas.MCargarRegistrosNotas(con);
    }
    
    /**
     * Method for searching by profile name
     * @param ID
     * @return 
     */
    
    public ResultSet SearchCrnt(int ID){
        return modelNombrePerfil.SearchCrnt(ID, con);
    }
    
    /**
     * Method to search profiles by id
     * @param ID
     * @return 
     */
    
    public ResultSet ObtenerGrado(int ID){
        return modelGradoPerfil.ObtenerId(ID, con);
    }
    
    /*Combobox*/
    /**
     * Methods for filling combobox with the view
     * @return 
     */
    
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
    
    /**
     * Method in controller for search by filter
     * @param busca
     * @param param
     * @return 
     */
    
    public ResultSet SearchParam(String busca, String param){
        return modeloBusqueda.BuscarPerfilParam(busca, param, con);
    }
    
}
