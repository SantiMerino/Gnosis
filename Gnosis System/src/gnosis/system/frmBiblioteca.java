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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josec
 */
public class frmBiblioteca extends javax.swing.JFrame {

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
        customization.mainUtilitiesWhite();
//        customization.centrarFrame(this);
//        jLabel7.setVisible(false);
//        lblLink.setVisible(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Recurso:");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Nombre del recurso:");

        txtNombreRecurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRecursoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Archivo:");

        fileChooser.setText("Buscar archivo");
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Links:");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de clasificacion:");

        CmbClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbClasificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbClasificacionItemStateChanged(evt);
            }
        });

        CmbTipoRecurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoRecurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoRecursoItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Tipo de recurso:");

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

        BtnModificar.setText("Modificar");
        BtnModificar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnModificar.setRound(20);
        BtnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnSubir.setText("Subir");
        BtnSubir.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnSubir.setRound(20);
        BtnSubir.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        BtnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubirActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnEliminar.setRound(20);
        BtnEliminar.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnVaciarCampos.setText("Vaciar campos");
        BtnVaciarCampos.setPreferredSize(new java.awt.Dimension(130, 30));
        BtnVaciarCampos.setRound(20);
        BtnVaciarCampos.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setText("Buscar Registro:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search-normal-black.png"))); // NOI18N

        btnAbrirLink.setBackground(new java.awt.Color(204, 204, 204));
        btnAbrirLink.setText("Abrir Link");
        btnAbrirLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirLinkActionPerformed(evt);
            }
        });

        lblLink.setText("jLabel10");

        buttonRound1.setText("buttonRound1");
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(txtNombreRecurso)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAbrirLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(283, 283, 283)))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLink)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(181, 181, 181))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CmbClasificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BtnVaciarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(CmbTipoRecurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileChooser)
                            .addComponent(CmbClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAbrirLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLink)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnVaciarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

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
                    JOptionPane.showMessageDialog(this, "Docente eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Cagaste");
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
        /* Set the Nimbus look and feel */
             try {
            UIManager.setLookAndFeel(new FlatArcIJTheme());           
        } catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.put( "Component.focusWidth", 0 );
        UIManager.put( "Component.innerFocusWidth",0 );
        UIManager.put( "TextComponent.arc", 15);
        UIManager.put( "Component.arc", 15);
        UIManager.put( "ProgressBar.arc", 20);
        UIManager.put( "ScrollBar.trackArc", 999 );
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        UIManager.put( "Component.arrowType", "chevron" );
        

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
