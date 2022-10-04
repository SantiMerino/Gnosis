/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MBiblioteca;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 * Controller of Methods of creating, deleting, modifying and reading data on Library. This class contains everything from the resource Library.
 * @author Usuario
 */
public class CBiblioteca {

    protected int ID;
    private String nombrerecurso;
    private int idtiporecurso;
    private int idclasificacion;
    private String link;
    private String pdf;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombrerecurso() {
        return nombrerecurso;
    }
    
    public void setNombrerecurso(String nombrerecurso) {
        this.nombrerecurso = nombrerecurso;
    }

    public int getIdtiporecurso() {
        return idtiporecurso;
    }

    public void setIdtiporecurso(int idtiporecurso) {
        this.idtiporecurso = idtiporecurso;
    }

    public int getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(int idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    /**
     * Data insertion controller.
     *
     * @param nombrerecurso
     * @param idtiporecurso
     * @param idclasificacion
     * @param link
     * @param pdf
     */
    public CBiblioteca(String nombrerecurso, int idtiporecurso, int idclasificacion, String link, String pdf) {
        this.nombrerecurso = nombrerecurso;
        this.idtiporecurso = idtiporecurso;
        this.idclasificacion = idclasificacion;
        this.link = link;
        this.pdf = pdf;
    }

    /**
     * Controller for data update.
     *
     * @param ID
     * @param nombrerecurso
     * @param idtiporecurso
     * @param idclasificacion
     * @param link
     * @param pdf
     */
    public CBiblioteca(int ID, String nombrerecurso, int idtiporecurso, int idclasificacion, String link, String pdf) {
        this.ID = ID;
        this.nombrerecurso = nombrerecurso;
        this.idtiporecurso = idtiporecurso;
        this.idclasificacion = idclasificacion;
        this.link = link;
        this.pdf = pdf;
    }

    /**
     * Controller for data deletion.
     *
     * @param ID
     */
    public CBiblioteca(int ID) {
        this.ID = ID;
    }

    /**
     * Library Controller
     */
    public CBiblioteca() {
    }

    MBiblioteca mdlBibli = new MBiblioteca();
    private Connection con = CConnection.getConnectionControllerWithoutParameters();

    /**
     * Library controller for data search.
     *
     * @param letra
     * @return
     */
    public ResultSet Search(String letra) {
        return mdlBibli.Search(letra, con);
    }

    public ResultSet CargarTipoRecursoResultSet() {
        return mdlBibli.CargaCmbTipoRecurso();
    }

    public ResultSet CargarTipoClasificacionResultSet() {
        return mdlBibli.CargaCmbTipoClasificacion();
    }

    public ResultSet CargarBibliotecaResultSet() {
        return mdlBibli.mostrarBibliotecas(con);
    }

    /**
     * Library controller for resource insertion.
     *
     * @return
     */
    public boolean BibliotecaNuevaResultSet() {
        return mdlBibli.SubirBibliotecaModel(nombrerecurso, idtiporecurso, idclasificacion, link, pdf, con);
    }

    /**
     * Library Controller for updating the library resource.
     *
     * @return
     */
    public boolean ActualizarBiblioteca() {
        return mdlBibli.ActualizarBibliotecasModel(ID, nombrerecurso, idtiporecurso, idclasificacion, link, pdf, con);
    }

    /**
     * Library Controller for the removal of the resource in the library.
     *
     * @return
     */
    public boolean EliminarBibliotecaController() {
        return mdlBibli.EliminarBibliotecasModel(ID, con);
    }

    public ResultSet CargarRecursosVista(int id) {
        return mdlBibli.CargarRecursosVista(id, con);
    }
    
    public ResultSet CargarBusquedaFiltro(String categoria, int Id){
        return mdlBibli.BuscarRecursos(categoria, Id, con);
    }
    
    public ResultSet CargarBusquedaFiltroClas(String clasificacion, int Id){
        return mdlBibli.BuscarRecursosClas(clasificacion, Id,con);
    }
    
}
