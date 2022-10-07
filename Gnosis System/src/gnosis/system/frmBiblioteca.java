/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CBiblioteca;
import Controller.CConnection;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.Desktop;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author josec
 */
public class frmBiblioteca extends javax.swing.JFrame {

    Connection conn = CConnection.getConnectionControllerWithoutParameters();
    CBiblioteca obj = new CBiblioteca();
    DefaultTableModel TablaBiBliotecamodelo;
    DefaultComboBoxModel<String> TipoClasificacioncombo;
    DefaultComboBoxModel<String> TipoRecursocombo;
    private List TipoClasificacionList;
    private List TipoRecursoList;
    private int idclasificacion = 0;
    private int idTipoRecurso = 0;
    private Calendar Cal1;
    private Calendar Cal2;
//    private String ruta_archivo = " ";
    int yMouse;
    int xMouse;
    
    String link;
    String pdf;
    
    /**
     * Creates new form frmBiblioteca
     */
    public frmBiblioteca() {
        customization.mainUtilitiesWhite();
        initComponents();
        CargarCmbClasificacion();
        CargarCmbTipoRecurso();
        txtId.setVisible(false);
        txtTipoClasificacion.setVisible(false);
        txtTipoRecurso.setVisible(false);
        //Tabla
        String [] TitulosBiblioteca = {"ID", "Nombre recurso", "Tipo recurso", "Clasificacion", "link", "PDF", "Alumno"};
        TablaBiBliotecamodelo = new DefaultTableModel(null, TitulosBiblioteca);
        JTBiblioteca.setModel(TablaBiBliotecamodelo);
        CargarTabla(); 
//        customization.centrarFrame(this);
//        jLabel7.setVisible(false);
        lblLink.setVisible(false);
        jLabel8.setVisible(false);
    }
    
    void LimpiarCampos(){
        txtNombreRecurso.setText("");
        lblLink.setText("");
    }
    
    final void CargarTabla(){
        CBiblioteca Biblioteca = new CBiblioteca();
        while (TablaBiBliotecamodelo.getRowCount() > 0) {
            TablaBiBliotecamodelo.removeRow(0);           
        }
        try {
            ResultSet rs = Biblioteca.CargarBibliotecaResultSet();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idbiblioteca"), rs.getString("nombrerecurso"), rs.getString("idtiporecurso"), rs.getInt("idclasificacion"), rs.getString("Link"), rs.getString("pdf"), rs.getInt("idalumno")};
                TablaBiBliotecamodelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
//    public void seleccionar_pdf(){
//        JFileChooser j = new JFileChooser();
//        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf","pdf"); 
//        j.setFileFilter(fi);
//        int se = j.showOpenDialog(this);
//        if (se == 0) {
//            this.fileChooser.setText("" + j.getSelectedFile().getName());
//            ruta_archivo = j.getSelectedFile().getAbsolutePath();
//        }
//    }
    
    final void CargarCmbTipoRecurso(){
        //Crear objetos de la clase ControllerBiblioteca
        CBiblioteca objUpTipoRecurso;
        objUpTipoRecurso = new CBiblioteca();
        //Lista donde se guardarán los IDs
        TipoRecursoList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objUpTipoRecurso.CargarTipoRecursoResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                TipoRecursocombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                TipoRecursocombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    TipoRecursoList.add(rs.getInt("idtiporecurso"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    TipoRecursocombo.addElement(rs.getString("tiporecurso"));
                    //Se asigna el modelo combo al combobox
                    CmbTipoRecurso.setModel(TipoRecursocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen tipos de recurso por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbClasificacion() {
        //Crear objetos de la clase ControllerBiblioteca
        CBiblioteca objUpClasificacion;
        objUpClasificacion = new CBiblioteca();
        //Lista donde se guardarán los IDs
        TipoClasificacionList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objUpClasificacion.CargarTipoClasificacionResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                TipoClasificacioncombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                TipoClasificacioncombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    TipoClasificacionList.add(rs.getInt("idclasificacion"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    TipoClasificacioncombo.addElement(rs.getString("clasificacion"));
                    //Se asigna el modelo combo al combobox
                    CmbClasificacion.setModel(TipoClasificacioncombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen clasificaciones por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreRecurso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fileChooser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CmbClasificacion = new javax.swing.JComboBox<>();
        CmbTipoRecurso = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBiblioteca = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtTipoClasificacion = new javax.swing.JTextField();
        txtTipoRecurso = new javax.swing.JTextField();
        BtnModificar = new customizeObjects.ButtonRound();
        BtnSubir = new customizeObjects.ButtonRound();
        BtnEliminar = new customizeObjects.ButtonRound();
        BtnVaciarCampos = new customizeObjects.ButtonRound();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAbrirLink = new customizeObjects.ButtonRound();
        lblLink = new javax.swing.JLabel();
        buttonRound1 = new customizeObjects.ButtonRound();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(668, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFocusable(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 555));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Recurso:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 52, -1, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Nombre del recurso:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        txtNombreRecurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRecursoKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 52, 451, -1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Archivo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 92, -1, -1));

        fileChooser.setText("Buscar archivo");
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });
        jPanel1.add(fileChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 117, 237, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Links:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 192, -1, -1));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de clasificacion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 92, -1, -1));

        CmbClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbClasificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbClasificacionItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 120, 201, -1));

        CmbTipoRecurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoRecurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoRecursoItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 215, 201, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Tipo de recurso:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 192, 66, -1));

        JTBiblioteca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTBibliotecaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTBiblioteca);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 366, 618, 174));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, -1));
        jPanel1.add(txtTipoClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 10, -1, -1));
        jPanel1.add(txtTipoRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 10, -1, -1));

        BtnModificar.setText("Modificar");
        BtnModificar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnModificar.setRound(20);
        BtnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 268, 113, -1));

        BtnSubir.setText("Subir");
        BtnSubir.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnSubir.setRound(20);
        BtnSubir.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        BtnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 314, 116, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnEliminar.setRound(20);
        BtnEliminar.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 269, 116, -1));

        BtnVaciarCampos.setText("Vaciar campos");
        BtnVaciarCampos.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnVaciarCampos.setRound(20);
        BtnVaciarCampos.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        jPanel1.add(BtnVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 314, 113, -1));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setText("Buscar Registro:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 289, 180, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 318, 217, -1));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, 210, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search-normal-black.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 314, -1, -1));

        btnAbrirLink.setBackground(new java.awt.Color(204, 204, 204));
        btnAbrirLink.setText("Abrir Link");
        btnAbrirLink.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnAbrirLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirLinkActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrirLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 90, -1));

        lblLink.setText("jLabel10");
        jPanel1.add(lblLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        buttonRound1.setText("Ingresar Link");
        buttonRound1.setStyle(customizeObjects.ButtonRound.ButtonStyle.SOCIALES);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 212, 237, -1));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-text-black.png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 50, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmbClasificacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbClasificacionItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbClasificacion.getSelectedIndex();
            if (pos == 0) {
                idclasificacion = 0;
            } else {
                int dim = TipoClasificacionList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idclasificacion = (int) TipoClasificacionList.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbClasificacionItemStateChanged

    final int BuscarClasificacionSeleccionado(int Clasificacion){
        int size = TipoClasificacionList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) TipoClasificacionList.get(i);
            if (valor == Clasificacion) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarTipoRecursoSeleccionado(int Clasificacion){
        int size = TipoRecursoList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) TipoRecursoList.get(i);
            if (valor == Clasificacion) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    private void CmbTipoRecursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoRecursoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoRecurso.getSelectedIndex();
            if (pos == 0) {
                idTipoRecurso = 0;
            } else {
                int dim = TipoRecursoList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idTipoRecurso = (int) TipoRecursoList.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbTipoRecursoItemStateChanged

    private void JTBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBibliotecaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            BtnModificar.setEnabled(true);
            BtnEliminar.setEnabled(true);
//            BtnSubir.setEnabled(false);
            txtId.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            txtNombreRecurso.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            lblLink.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            lblLink.setText("" + rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            txtTipoRecurso.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            txtTipoClasificacion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            
            int idClasificacion = Integer.parseInt(txtTipoRecurso.getText());
            int idTipoRecurso = Integer.parseInt(txtTipoClasificacion.getText());
            
            int respuesta = BuscarClasificacionSeleccionado(idClasificacion);
            int respuesta2 = BuscarTipoRecursoSeleccionado(idTipoRecurso);
            
            CmbClasificacion.setSelectedIndex(respuesta + 1);
            CmbTipoRecurso.setSelectedIndex(respuesta2 + 1);
        }
    }//GEN-LAST:event_JTBibliotecaMouseClicked

    private void BtnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubirActionPerformed
        // TODO add your handling code here:
        if (txtNombreRecurso.getText().trim().isEmpty() || lblLink.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbClasificacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una clasificacion", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbTipoRecurso.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo recurso", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            CBiblioteca objBiblioteca = new CBiblioteca(txtNombreRecurso.getText(), idTipoRecurso, idclasificacion, lblLink.getText(), pdf);
            boolean respuesta = objBiblioteca.BibliotecaNuevaResultSet();
            if (respuesta == true) {
                JOptionPane.showMessageDialog(this, "Biblioteca ingresada correctamente");
                CargarTabla();
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Biblioteca no pudo ser ingresada");
            }
        }
    }//GEN-LAST:event_BtnSubirActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
        CBiblioteca objUpdate = new CBiblioteca(Integer.parseInt(txtId.getText()), txtNombreRecurso.getText(), idTipoRecurso, idclasificacion, lblLink.getText(), pdf);
        boolean valor = objUpdate.ActualizarBiblioteca();
        if (valor == true) {
            JOptionPane.showMessageDialog(this, "Biblioteca actualizada correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro", "Informacion incompleta", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirmacion = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(this, "Esta seguro de eliminar este registro?", "Confirmar Accion", confirmacion);
            if (confirmacion == JOptionPane.YES_OPTION) {
                CBiblioteca objcontrolDelete = new CBiblioteca(Integer.parseInt(txtId.getText()));
                
                boolean valor = objcontrolDelete.EliminarBibliotecaController();
                if ( valor == true) {
                    JOptionPane.showMessageDialog(this, "Recurso eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtNombreRecursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRecursoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
     if (!(minusculas || mayusculas || espacio))
    {
        evt.consume();
    }
    }//GEN-LAST:event_txtNombreRecursoKeyTyped

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        // TODO add your handling code here:
       
        JFileChooser browseImageFile = new JFileChooser();        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter(".PDF", ".pdf");
        browseImageFile.addChoosableFileFilter(fnef);
        int num = browseImageFile.showOpenDialog(null);

        if (num == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            byte[] inFileBytes;
            try {
                inFileBytes = Files.readAllBytes(Paths.get(selectedImagePath));
                byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
                pdf = Base64.getEncoder().encodeToString(inFileBytes);
                decodePdf();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo seleccionar el archivo");
            }

            jLabel8.setText(pdf);
        }
    }//GEN-LAST:event_fileChooserActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        
        Connection conn = CConnection.getConnectionControllerWithoutParameters();
        CBiblioteca bjCar = new CBiblioteca();    
        
          while (TablaBiBliotecamodelo.getRowCount() > 0) {
                    TablaBiBliotecamodelo.removeRow(0);
                }
                try {
                    ResultSet rs = bjCar.Search(txtBuscar.getText() + "%");
                    while (rs.next()) {
                        Object[] oValores = {rs.getInt("idbiblioteca"), rs.getString("nombrerecurso"), rs.getString("idtiporecurso"), rs.getInt("idclasificacion"), rs.getString("Link"), 
                    rs.getString("pdf"), rs.getInt("idalumno"), true, conn};
                        TablaBiBliotecamodelo.addRow(oValores);
                    }
                } catch (Exception e) {
                }
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAbrirLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirLinkActionPerformed
        // TODO add your handling code here:
        try {
        Desktop desktop = java.awt.Desktop.getDesktop();
        URI oURL = new URI(lblLink.getText());
        desktop.browse(oURL);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }//GEN-LAST:event_btnAbrirLinkActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        link = JOptionPane.showInputDialog("Ingresa el link: ", "www.link.com");
        lblLink.setText(link);
    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteBiblioteca.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer (jprint , false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmStudentsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void decodePdf() throws IOException {
        byte[] decoded = java.util.Base64.getDecoder().decode(pdf);

        FileOutputStream fos = new FileOutputStream("Archivo.pdf");
        fos.write(decoded);
        fos.flush();
        fos.close();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        customization.mainUtilitiesWhite();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound BtnEliminar;
    private customizeObjects.ButtonRound BtnModificar;
    private customizeObjects.ButtonRound BtnSubir;
    private customizeObjects.ButtonRound BtnVaciarCampos;
    private javax.swing.JComboBox<String> CmbClasificacion;
    private javax.swing.JComboBox<String> CmbTipoRecurso;
    private javax.swing.JTable JTBiblioteca;
    private customizeObjects.ButtonRound btnAbrirLink;
    private javax.swing.JButton btnReporte;
    private customizeObjects.ButtonRound buttonRound1;
    private javax.swing.JButton fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLink;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreRecurso;
    private javax.swing.JTextField txtTipoClasificacion;
    private javax.swing.JTextField txtTipoRecurso;
    // End of variables declaration//GEN-END:variables
}
