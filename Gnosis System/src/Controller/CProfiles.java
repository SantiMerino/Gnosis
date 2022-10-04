/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MConnection;
import Model.MProfiles;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Controller of Methods of creating, deleting, modifying and reading data on Profiles. This class contains everything from the resource Profiles.
 * @author santi
 */
public class CProfiles {
    
    public int ID;
    public String nombre;
    public String rubricadeevaluacion;
    public String fechadeinicio;
    public String fechadevencimiento;
    public String porcentajedevaloracion;
    public String descripcion;
    public int idperfil;
    public int idmateriadocente;
    public int idgrado;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubricadeevaluacion() {
        return rubricadeevaluacion;
    }

    public void setRubricadeevaluacion(String rubricadeevaluacion) {
        this.rubricadeevaluacion = rubricadeevaluacion;
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

    public String getPorcentajedevaloracion() {
        return porcentajedevaloracion;
    }

    public void setPorcentajedevaloracion(String porcentajedevaloracion) {
        this.porcentajedevaloracion = porcentajedevaloracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public int getIdmateriadocente() {
        return idmateriadocente;
    }

    public void setIdmateriadocente(int idmateriadocente) {
        this.idmateriadocente = idmateriadocente;
    }

    /**
     * Data insertion controller.
     * @param nombre
     * @param rubricadeevaluacion
     * @param fechadeinicio
     * @param fechadevencimiento
     * @param porcentajedevaloracion
     * @param descripcion
     * @param idperfil
     * @param idmateriadocente
     * @param idgrado 
     */
    public CProfiles(String nombre, String rubricadeevaluacion, String fechadeinicio, String fechadevencimiento, String porcentajedevaloracion, String descripcion, int idperfil, int idmateriadocente, int idgrado) {
        this.nombre = nombre;
        this.rubricadeevaluacion = rubricadeevaluacion;
        this.fechadeinicio = fechadeinicio;
        this.fechadevencimiento = fechadevencimiento;
        this.porcentajedevaloracion = porcentajedevaloracion;
        this.descripcion = descripcion;
        this.idperfil = idperfil;
        this.idmateriadocente = idmateriadocente;
        this.idgrado = idgrado;
    }

    /**
     * Controller for data update.
     * @param ID
     * @param nombre
     * @param rubricadeevaluacion
     * @param fechadeinicio
     * @param fechadevencimiento
     * @param porcentajedevaloracion
     * @param descripcion
     * @param idperfil
     * @param idgrado 
     */
    public CProfiles(int ID, String nombre, String rubricadeevaluacion, String fechadeinicio, String fechadevencimiento, String porcentajedevaloracion, String descripcion, int idperfil, int idgrado) {
        this.ID = ID;
        this.nombre = nombre;
        this.rubricadeevaluacion = rubricadeevaluacion;
        this.fechadeinicio = fechadeinicio;
        this.fechadevencimiento = fechadevencimiento;
        this.porcentajedevaloracion = porcentajedevaloracion;
        this.descripcion = descripcion;
        this.idperfil = idperfil;
        this.idgrado = idgrado;
    }

    /**
     * Controller for data deletion.
     * @param ID 
     */
    public CProfiles(int ID) {
        this.ID = ID;
    }
    
    /**
     * Controller Profiles
     */
    public CProfiles() {
    }
    
    MProfiles mdlPerfil = new MProfiles();
    private Connection con = MConnection.getConnectionWithoutParameters();
    
    public ResultSet CargarDatosDocente(int id){
        return mdlPerfil.DatosDocente(id);
    }
    
    public ResultSet CargarTipoPerfilResultSet() {
        return mdlPerfil.CargaCmbTipoPerfil();
    }
    
    public ResultSet CargarGradoPerfilResultSet() {
        return mdlPerfil.CargaCmbGradoPerfil();
    }
    
    public ResultSet CargarPerfilResultSet() {
        return mdlPerfil.mostrarPerfiles(con);
    }
    
    /**
     * Profiles controller for resource insertion.
     * @return 
     */
    public boolean PerfilNuevaResultSet() {
        return mdlPerfil.SubirPerfilesModel(nombre, descripcion, porcentajedevaloracion, fechadeinicio, fechadevencimiento, idperfil,idmateriadocente, con);
    }

    /**
     * Profiles Controller for updating the profile resource.
     * @return 
     */
    public boolean ActualizarPerfil() {
        return mdlPerfil.ActualizarProfilesModel(ID, nombre, descripcion, porcentajedevaloracion, fechadeinicio, fechadevencimiento, idperfil, con);
    }

    /**
     * Profile Controller for the removal of the resource in the profile.
     * @return 
     */
    public boolean EliminarTareaController() {
        return mdlPerfil.EliminarProfileModel(ID, con);
    }
}
