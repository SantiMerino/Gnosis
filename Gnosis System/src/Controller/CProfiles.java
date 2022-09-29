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
 *
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


    public CProfiles(String nombre, String rubricadeevaluacion, String fechadeinicio, String fechadevencimiento, String porcentajedevaloracion, String descripcion, int idperfil, int idgrado) {
        this.nombre = nombre;
        this.rubricadeevaluacion = rubricadeevaluacion;
        this.fechadeinicio = fechadeinicio;
        this.fechadevencimiento = fechadevencimiento;
        this.porcentajedevaloracion = porcentajedevaloracion;
        this.descripcion = descripcion;
        this.idperfil = idperfil;
        this.idgrado = idgrado;
    }

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

    public CProfiles(int ID) {
        this.ID = ID;
    }
    
    public CProfiles() {
    }
    
    MProfiles mdlPerfil = new MProfiles();
    private Connection con = MConnection.getConnectionWithoutParameters();
    
    public ResultSet CargarDatosDocente(){
        return mdlPerfil.DatosDocente(ID);
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
    
    public boolean PerfilNuevaResultSet() {
        return mdlPerfil.SubirPerfilesModel(nombre, descripcion, porcentajedevaloracion, fechadeinicio, fechadevencimiento, idperfil, con);
    }

    public boolean ActualizarPerfil() {
        return mdlPerfil.ActualizarProfilesModel(ID, nombre, descripcion, porcentajedevaloracion, fechadeinicio, fechadevencimiento, idperfil, idgrado, con);
    }

    public boolean EliminarTareaController() {
        return mdlPerfil.EliminarProfileModel(ID, con);
    }
}
