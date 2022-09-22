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
    
    /**
     * Metodo para cargar perfiles
     * @return 
     */
    
    public ResultSet CCargarPerfiles(){
       return modeloPerfil.MCargarPefiles(con);
    }
    
    /**
     * Metodo para cargar alumnos 
     * @return 
     */
    
    public ResultSet CCargarAlumnos(){
        return modeloAlumno.MCargarAlumnos(con);
    }
    
    /*Cargar tabla de registros*/
    
    /**
     * Metodo en el controllador para el llenado de la tabla con la vista
     * @return 
     */
    
    public ResultSet CCargarRegistroNotas(){
        return modelRegistroNotas.MCargarRegistrosNotas(con);
    }
    
    /**
     * Metodo para la busqueda por nombre de perfil
     * @param ID
     * @return 
     */
    
    public ResultSet SearchCrnt(int ID){
        return modelNombrePerfil.SearchCrnt(ID, con);
    }
    
    /**
     * Metodo para buscar perfiles por id
     * @param ID
     * @return 
     */
    
    public ResultSet ObtenerGrado(int ID){
        return modelGradoPerfil.ObtenerId(ID, con);
    }
    
    /*Combobox*/
    /**
     * Metodos para el llenado de combobox con la vista
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
     * Metodo en el controllador para la busqueda por filtro
     * @param busca
     * @param param
     * @return 
     */
    
    public ResultSet SearchParam(String busca, String param){
        return modeloBusqueda.BuscarPerfilParam(busca, param, con);
    }
    
}
