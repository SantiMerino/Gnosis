/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MBiblioteca;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author josec
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

    public CBiblioteca(String nombrerecurso, int idtiporecurso, int idclasificacion, String link, String pdf) {
        this.nombrerecurso = nombrerecurso;
        this.idtiporecurso = idtiporecurso;
        this.idclasificacion = idclasificacion;
        this.link = link;
        this.pdf = pdf;
    }

    public CBiblioteca(int ID, String nombrerecurso, int idtiporecurso, int idclasificacion, String link, String pdf) {
        this.ID = ID;
        this.nombrerecurso = nombrerecurso;
        this.idtiporecurso = idtiporecurso;
        this.idclasificacion = idclasificacion;
        this.link = link;
        this.pdf = pdf;
    }

    public CBiblioteca(int ID) {
        this.ID = ID;
    }

    public CBiblioteca() {
    }
    
    MBiblioteca mdlBibli = new MBiblioteca();
    private Connection con = CConnection.getConnectionControllerWithoutParameters();
    
    public ResultSet Search(String letra){
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
    
    public boolean BibliotecaNuevaResultSet(){
        return mdlBibli.SubirBibliotecaModel(nombrerecurso, idtiporecurso, idclasificacion, link, pdf, con);
    }
    
    public boolean ActualizarBiblioteca() {
       return mdlBibli.ActualizarBibliotecasModel(ID, nombrerecurso, idtiporecurso, idclasificacion, link, pdf, con);
    }
    
    public boolean EliminarBibliotecaController() {
        return mdlBibli.EliminarBibliotecasModel(ID, con);
    }
}
