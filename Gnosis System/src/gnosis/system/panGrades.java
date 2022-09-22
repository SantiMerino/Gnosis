/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CComboboxNotas;
import Controller.CConnection;
import Controller.CNotas;
import Controller.CProfiles;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class panGrades extends javax.swing.JPanel {

    DefaultTableModel TablaPerfilmodelo;
    
    ArrayList tipoPerfilArrayList;
    ArrayList GradoArrayList;
    ArrayList PeriodoArrayList;
    
    DefaultComboBoxModel<String> modeloTipoPerfil;
    DefaultComboBoxModel<String> modeloGrado;
    DefaultComboBoxModel<String> modeloPeriodo;
    
    private int idTipoPerfil = 0;
    private int idGrado = 0;
    private int idPeriodo = 0;
    
    CComboboxNotas buscar = new CComboboxNotas();
    Connection conn = CConnection.getConnectionControllerWithoutParameters();
    
    /**
     * Creates new form panNotas
     */
    public panGrades() {
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
        initComponents();

        String [] TitulosPerfil = {"ID", "Nombre", "Descripcion", "Nota", "Porcentaje de valoracion", "Fecha de inicio", "Fecha de vencimiento", "estado perfil", "Tipo Perfil", "Grados"};
        TablaPerfilmodelo = new DefaultTableModel(null, TitulosPerfil);
        tbPerfil.setModel(TablaPerfilmodelo);
        CargarTabla();
        txtDescripcion.setEditable(false);
        
//        CargarCmb();
        
    }
    
    
    final void CargarTabla(){
        CProfiles Perfil = new CProfiles();
        while (TablaPerfilmodelo.getRowCount() > 0) {
            TablaPerfilmodelo.removeRow(0);           
        }
        try {
            ResultSet rs = Perfil.CargarPerfilResultSet();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idperfil"), rs.getString("nombreperfil"), rs.getString("descripcion"), rs.getString("nota"),rs.getString("porcentajeValoracion"), 
                    rs.getString("fechainicio"), rs.getString("fechavencimiento"), rs.getString("estadoperfil"),rs.getString("tipoperfil"), rs.getString("grado")};
                TablaPerfilmodelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    void CargarCmb(){
        CargarTipoPerfil();
        CargarGrado();
//        CargarFases();
    }
    
    final void CargarTipoPerfil(){
        CComboboxNotas alumnosObj = new CComboboxNotas();
        tipoPerfilArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarTipoPerfil();
            if (rs.next()) {
                modeloTipoPerfil = new DefaultComboBoxModel<>();
                modeloTipoPerfil.addElement("Elige una opcion");
                do {                    
                    tipoPerfilArrayList.add(rs.getInt("idtipoperfil"));
                    modeloTipoPerfil.addElement(rs.getString("tipoperfil"));
                    cmbTipoPerfil.setModel(modeloTipoPerfil);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los tipos de perfiles");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    
    final void CargarGrado(){
        CComboboxNotas alumnosObj = new CComboboxNotas();
        GradoArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarGrado();
            if (rs.next()) {
                modeloGrado = new DefaultComboBoxModel<>();
                modeloGrado.addElement("Elige una opcion");
                do {                    
                    GradoArrayList.add(rs.getInt("idgrado"));
                    modeloGrado.addElement(rs.getString("grado"));
                    cmbGrado.setModel(modeloGrado);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los grados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    
//    final void CargarFases(){
//        CComboboxNotas alumnosObj = new CComboboxNotas();
//        PeriodoArrayList = new ArrayList();
//        
//        try {
//            ResultSet rs = alumnosObj.CCargarFases();
//            if (rs.next()) {
//                modeloPeriodo = new DefaultComboBoxModel<>();
//                modeloPeriodo.addElement("Elige una opcion");
//                do {                    
//                    PeriodoArrayList.add(rs.getInt("idfase"));
//                    modeloPeriodo.addElement(rs.getString("fase"));
//                    cmbPeriodo.setModel(modeloPeriodo);
//                } while (rs.next());
//            } else{
//                JOptionPane.showMessageDialog(null, "No se pudo cargar las fases");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
//        }
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPerfil = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cmbTipoPerfil = new javax.swing.JComboBox<>();
        cmbGrado = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtIdPerfil = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelRound1 = new customizeObjects.PanelRound();
        lblTipoPerfil = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblGrado = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblEstado = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelNota = new customizeObjects.PanelRound();
        panelRound3 = new customizeObjects.PanelRound();
        lblNota = new javax.swing.JLabel();
        dtInicio = new com.toedter.calendar.JDateChooser();
        dtCierre = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout(10, 0));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setLayout(new java.awt.BorderLayout());

        tbPerfil.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPerfilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPerfil);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(32, 32, 32));
        jLabel17.setText("Tipo de perfil:");

        cmbTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cotidianas", "Proyecto Formativo", "Recuperacion", " " }));
        cmbTipoPerfil.setMinimumSize(new java.awt.Dimension(100, 30));
        cmbTipoPerfil.setPreferredSize(new java.awt.Dimension(100, 30));
        cmbTipoPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoPerfilItemStateChanged(evt);
            }
        });

        cmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Septimo", "Octavo", "Noveno", "Primer Año", "Segundo Año", "Tercer Año", " " }));
        cmbGrado.setPreferredSize(new java.awt.Dimension(100, 30));
        cmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGradoItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(32, 32, 32));
        jLabel15.setText("Grado:");

        txtIdPerfil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdPerfilKeyReleased(evt);
            }
        });

        jButton1.setText("Buscar por filtro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cmbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 111, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(txtIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Grado:");

        panelRound1.setBackground(new java.awt.Color(204, 204, 204));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        lblTipoPerfil.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblTipoPerfil.setForeground(new java.awt.Color(32, 32, 32));
        lblTipoPerfil.setText("Tipo Perfil |");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTipoPerfil)
                .addGap(15, 15, 15))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Descrpción:");

        lblGrado.setBackground(new java.awt.Color(255, 255, 255));
        lblGrado.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblGrado.setForeground(new java.awt.Color(32, 32, 32));
        lblGrado.setText("grado asignado");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setText("Fechas de inicio:");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Estado:");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(32, 32, 32));
        jLabel13.setText("Fecha de cierre:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        lblEstado.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(32, 32, 32));
        lblEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/check.png"))); // NOI18N

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(32, 32, 32));
        lblNombre.setText("Nombre del perfil.");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Perfil:");

        panelNota.setBackground(new java.awt.Color(127, 211, 106));
        panelNota.setPreferredSize(new java.awt.Dimension(40, 40));
        panelNota.setRoundBottomLeft(20);
        panelNota.setRoundBottomRight(20);
        panelNota.setRoundTopLeft(20);
        panelNota.setRoundTopRight(20);
        panelNota.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 7));

        panelRound3.setPreferredSize(new java.awt.Dimension(35, 35));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);
        panelRound3.setLayout(new java.awt.BorderLayout());

        lblNota.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        lblNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNota.setText("10");
        panelRound3.add(lblNota, java.awt.BorderLayout.CENTER);

        panelNota.add(panelRound3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelNota, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(29, 29, 29)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(lblEstado))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5))))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblGrado)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(76, 76, 76)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dtCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelNota, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblNombre))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGrado)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.EAST);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(767, 50));

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Calificaciones.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 737, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdPerfilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPerfilKeyReleased
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_txtIdPerfilKeyReleased

    final int BuscarTipoPerfilSeleccionado(int TipoPerfil){
        int size = tipoPerfilArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) tipoPerfilArrayList.get(i);
            if (valor == TipoPerfil) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarGradoSeleccionado(int Grado){
        int size = GradoArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) GradoArrayList.get(i);
            if (valor == Grado) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    private void tbPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPerfilMouseClicked
        // TODO add your handling code here:
        
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            
            txtIdPerfil.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            lblNombre.setText("Nombre: " + rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            txtDescripcion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            lblNota.setText("" + rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            lblTipoPerfil.setText("Tipo Perfil | : " + rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            lblGrado.setText("Grado asignado: " + rcp.getModel().getValueAt(rcp.getSelectedRow(), 9).toString());
            
            String notas = ("" + rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            String Estado = ("" + rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            
            double Notas = Double.parseDouble(notas);
            
            if (Notas == 10.00) {
                panelNota.setBackground(Color.GREEN);
            }else if(Notas <= 6.00) {
                panelNota.setBackground(Color.YELLOW);
            }else if(Notas <= 4.00) {
               panelNota.setBackground(Color.RED);
            }
            
            
            
            customization custom = new customization();
            
           switch (Estado) {
                case "Completado":
                    custom.changeIconlbl(lblEstado, "/resources/check.png");
                    break;
                case "Calificado":
                    custom.changeIconlbl(lblEstado, "/resources/medal-black.png");
                    break;
                case "No entregado":
                    custom.changeIconlbl(lblEstado, "/resources/close-square-state.png");
                    break;
                case "En proceso":
                    custom.changeIconlbl(lblEstado, "/resources/arrow-right.png");
                    break;
                case "Urgente":
                    custom.changeIconlbl(lblEstado, "/resources/danger-state.png");
                    break;
                case "No disponible":
                    custom.changeIconlbl(lblEstado, "/resources/key.png");
                    break;
                default:
                    custom.changeIconlbl(lblEstado, "/resources/check.png");
            }
            
            
           
           
//            txtIdTipoPerfil.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
//            txtGrado.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
//            txtFase.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtInicio.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString()));
            } catch (Exception e) {
                
            }
            
            try {
                dtCierre.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString()));
            } catch (Exception e) {
                
            }
            
        }
        
        
        
    }//GEN-LAST:event_tbPerfilMouseClicked

    private void cmbTipoPerfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoPerfilItemStateChanged
        // TODO add your handling code here:
        
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            int pos = cmbTipoPerfil.getSelectedIndex();
//            if (pos == 0) {
//                idTipoPerfil = 0;
//            } else {
//                int dim = tipoPerfilArrayList.size();
//                for (int i = 0; i < dim; i++) {
//                    if (i == pos - 1) {
//                        idTipoPerfil = (int) tipoPerfilArrayList.get(i);
//                    }
//                }
//            }
//            
//        }
        
    }//GEN-LAST:event_cmbTipoPerfilItemStateChanged

    private void cmbGradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGradoItemStateChanged
        // TODO add your handling code here:
        
//        if (evt.getStateChange() == ItemEvent.SELECTED) {
//            int pos = cmbGrado.getSelectedIndex();
//            if (pos == 0) {
//                idGrado = 0;
//            } else {
//                int dim = GradoArrayList.size();
//                for (int i = 0; i < dim; i++) {
//                    if (i == pos - 1) {
//                        idGrado = (int) GradoArrayList.get(i);
//                    }
//                }
//            }
//            
//        }
        
    }//GEN-LAST:event_cmbGradoItemStateChanged

    void buscarPerfil(){
        String Item = (String) cmbTipoPerfil.getSelectedItem();
        String param = (String) cmbGrado.getSelectedItem();
        while (TablaPerfilmodelo.getRowCount() > 0) {
            TablaPerfilmodelo.removeRow(0);
        }
        try {
            ResultSet rs = buscar.SearchParam(Item, param);
            while (rs.next()) {
                Object [] oValores = {rs.getInt("idperfil"), rs.getString("nombreperfil"), rs.getString("descripcion"), rs.getString("nota"),rs.getString("porcentajeValoracion"), 
                    rs.getString("fechainicio"), rs.getString("fechavencimiento"), rs.getString("estadoperfil"), rs.getString("tipoperfil"), rs.getString("grado")};
                TablaPerfilmodelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el perfil, verifique su conexión de internet");
        }
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       buscarPerfil();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JComboBox<String> cmbTipoPerfil;
    private com.toedter.calendar.JDateChooser dtCierre;
    private com.toedter.calendar.JDateChooser dtInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblGrado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblTipoPerfil;
    private customizeObjects.PanelRound panelNota;
    private customizeObjects.PanelRound panelRound1;
    private customizeObjects.PanelRound panelRound3;
    private javax.swing.JTable tbPerfil;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdPerfil;
    // End of variables declaration//GEN-END:variables
}
