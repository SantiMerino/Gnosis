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

    public int ID;
    public String nombre;
    public String etapa;
    public String fechadeinicio;
    public String fechadevencimiento;
    public String ponderacion;
    public String instrumentodeevaluacion;
    public int idtipoarchivo;
    public int idcategoria;
    public int idgrado;
    public int idespecialidad;

    public MTasks getMdlTask() {
        return mdlTask;
    }

    public void setMdlTask(MTasks mdlTask) {
        this.mdlTask = mdlTask;
    }
   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getFechadeinicio() {
        return fechadeinicio;
    }

    public void setFechadeinicio(String fechadeinicio) {
        this.fechadeinicio = fechadeinicio;
    }

    public String getFechadevencimiento() {
        return fechadevencimiento;
    }

    public void setFechadevencimiento(String fechadevencimiento) {
        this.fechadevencimiento = fechadevencimiento;
    }

    public String getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(String ponderacion) {
        this.ponderacion = ponderacion;
    }

    public String getInstrumentodeevaluacion() {
        return instrumentodeevaluacion;
    }

    public void setInstrumentodeevaluacion(String instrumentodeevaluacion) {
        this.instrumentodeevaluacion = instrumentodeevaluacion;
    }

    public int getIdtipoarchivo() {
        return idtipoarchivo;
    }

    public void setIdtipoarchivo(int idtipoarchivo) {
        this.idtipoarchivo = idtipoarchivo;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public CTasks() {
    }

    public CTasks(String nombre, String etapa, String fechadeinicio, String fechadevencimiento, String ponderacion, String instrumentodeevaluacion, int idtipoarchivo, int idcategoria, int idgrado, int idespecialidad) {
        this.nombre = nombre;
        this.etapa = etapa;
        this.fechadeinicio = fechadeinicio;
        this.fechadevencimiento = fechadevencimiento;
        this.ponderacion = ponderacion;
        this.instrumentodeevaluacion = instrumentodeevaluacion;
        this.idtipoarchivo = idtipoarchivo;
        this.idcategoria = idcategoria;
        this.idgrado = idgrado;
        this.idespecialidad = idespecialidad;
    }

    public CTasks(int ID, String nombre, String etapa, String fechadeinicio, String fechadevencimiento, String ponderacion, String instrumentodeevaluacion, int idtipoarchivo, int idcategoria, int idgrado, int idespecialidad) {
        this.ID = ID;
        this.nombre = nombre;
        this.etapa = etapa;
        this.fechadeinicio = fechadeinicio;
        this.fechadevencimiento = fechadevencimiento;
        this.ponderacion = ponderacion;
        this.instrumentodeevaluacion = instrumentodeevaluacion;
        this.idtipoarchivo = idtipoarchivo;
        this.idcategoria = idcategoria;
        this.idgrado = idgrado;
        this.idespecialidad = idespecialidad;
    }

    public CTasks(int ID) {
        this.ID = ID;
    }
         
    MTasks mdlTask = new MTasks();
    private Connection con = CConnection.getConnectionControllerWithoutParameters();
    
    public ResultSet CargarCatergoriaResultSet() {
        return mdlTask.CargaCmbCategoria();
    }
    
    public ResultSet CargarEspecialidadesResultSet() {
        return mdlTask.CargaCmbEspecialidad();
    }
    
    public ResultSet CargarGradosResultSet() {
        return mdlTask.CargaCmbGrado();
    }
    
    public ResultSet CargarTipoArchivoResultSet() {
        return mdlTask.CargaCmbTipoArchivo();
    }
    
    public ResultSet CCargarTareas(){
        return mdlTask.mostrarTareas(con);
    }
    
    public boolean TareaNuevaResultSet(){
        return mdlTask.SubirTareasModel(nombre, etapa, fechadeinicio, fechadevencimiento, ponderacion, instrumentodeevaluacion, idtipoarchivo, idcategoria, idgrado, idespecialidad, con);
    }
    
    public boolean ActualizarTarea() {
       return mdlTask.ActualizarTareasModel(ID, nombre, etapa, fechadeinicio, fechadevencimiento, ponderacion, instrumentodeevaluacion, idtipoarchivo, idcategoria, idgrado, idespecialidad, con);
    }
    
    public boolean EliminarTareaController() {
        return mdlTask.EliminarTareaModel(ID, con);
    }
}
