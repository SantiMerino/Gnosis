/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.*;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author PC
 */
public class frmStudentsCRUD extends javax.swing.JFrame {

    /*Variables a utilizar*/
    DefaultComboBoxModel<String> modeloGenero;
    DefaultComboBoxModel<String> modeloGrados;
    DefaultComboBoxModel<String> modeloUsuario;
    
     ArrayList generoArrayList;
     ArrayList gradoArrayList;
     ArrayList usuarioArrayList; 
     
     DefaultTableModel tablaModel;
     
    private int idGenero = 0;
    private int idGrado = 0;
    private int idUsuario = 0;
     
    private Calendar c;
    
    private String nacimiento;
    
    CPortfolios portafolio = new CPortfolios();
    
    /**
     * Creates new form FrmEstudiantes
     */
    public frmStudentsCRUD() {
        initComponents();
        dtNacimiento.setBackground(new Color (217,217,217));
        txtId.setEditable(false);
        txtIdGenero.setVisible(false);
        txtIdGrado.setVisible(false);
        
        txtDui.setEditable(false);
        
//        txtIdUsuario.setVisible(false);
        for(Component c : dtNacimiento.getComponents()){
            ((JComponent)c).setBackground(new Color (217,217,217));
        }
        
        CargarDatos();
        
        String [] TitulosDocentes = {"ID", "Apellidos", "Nombres", "Genero", "Grado", "Correo",  "Direccion", "Contacto", "DUI", "Nacimiento", "Carnet"};
        tablaModel = new DefaultTableModel(null, TitulosDocentes);
        tbEstudiantes.setModel(tablaModel);
        CargarTabla();
        
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    /**
     * Metodo para limpiar los campos en la vista
     */
    
    void LimpiarCampos(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        dtNacimiento.setDate(null);
        txtDui.setText("");
        txtCorreo.setText("");
        txtCodigo.setText("");
        txtId.setText("");
        txtIdGenero.setText("");
        txtIdGrado.setText("");
//        txtIdUsuario.setText("");
        CargarDatos();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    /**
     * Metodo para el llenado de la tabla con registros de la base de datos
     */
    
     final void CargarTabla(){
        CComboboxEstudiantes docent = new CComboboxEstudiantes();
        while (tablaModel.getRowCount() > 0) {
            tablaModel.removeRow(0);           
        }
        try {
            ResultSet rs = docent.CCargarEstudiantes();
            while (rs.next()) {                
                Object[] oValores = {rs.getInt("idalumno"), rs.getString("apellidos_alumno"), rs.getString("nombres_alumno"), rs.getInt("idgenero"),
                    rs.getInt("idgrado"), rs.getString("correo"), rs.getString("direccion"), rs.getString("contacto"),
                    rs.getString("dui"),
                    rs.getString("fecha_nac"), rs.getString("codigocarnet")};
                tablaModel.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla" + e.toString());
        }
    }
    
    void CargarDatos(){
        CargarGeneros();
        CargarGrados();
    }
    
    
    /**
     * Metodos para llenar combobox con registros de la base de datos
     */
    
    final void CargarGeneros(){
        CComboboxEstudiantes estudiantesObj = new CComboboxEstudiantes();
        generoArrayList = new ArrayList();
        
        try {
            ResultSet rs = estudiantesObj.CCargarGeneros();
            if (rs.next()) {
                modeloGenero = new DefaultComboBoxModel<>();
                modeloGenero.addElement("Elige una opcion");
                do {                    
                    generoArrayList.add(rs.getInt("idgenero"));
                    modeloGenero.addElement(rs.getString("genero"));
                    cmbGenero.setModel(modeloGenero);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los generos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    
    final void CargarGrados(){
        CComboboxEstudiantes alumnosObj = new CComboboxEstudiantes();
        gradoArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarGrados();
            if (rs.next()) {
                modeloGrados = new DefaultComboBoxModel<>();
                modeloGrados.addElement("Elige una opcion");
                do {                    
                    gradoArrayList.add(rs.getInt("idgrado"));
                    modeloGrados.addElement(rs.getString("grado"));
                    cmbGrado.setModel(modeloGrados);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los grados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    
    final void CargarUsuarios(){
        CComboboxEstudiantes alumnosObj = new CComboboxEstudiantes();
        usuarioArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarUsuarios();
            if (rs.next()) {
                modeloUsuario = new DefaultComboBoxModel<>();
                modeloUsuario.addElement("Elige una opcion");
                do {                    
                    usuarioArrayList.add(rs.getInt("idusuario"));
                    modeloUsuario.addElement(rs.getString("username"));
//                    cmbUsuario.setModel(modeloUsuario);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los usuarios ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dtNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        cmbGrado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtIdGenero = new javax.swing.JTextField();
        txtIdGrado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new customizeObjects.ButtonRound();
        btnActualizar = new customizeObjects.ButtonRound();
        btnEliminar = new customizeObjects.ButtonRound();
        buttonRound4 = new customizeObjects.ButtonRound();
        btnReporte = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.white);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 697));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Nombres del estudiantes:");

        txtNombres.setBackground(new java.awt.Color(217, 217, 217));
        txtNombres.setForeground(new java.awt.Color(50, 50, 50));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Apellidos del estudiante:");

        txtApellidos.setBackground(new java.awt.Color(217, 217, 217));
        txtApellidos.setForeground(new java.awt.Color(50, 50, 50));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Direccion del estudiante:");

        txtDireccion.setBackground(new java.awt.Color(217, 217, 217));
        txtDireccion.setForeground(new java.awt.Color(50, 50, 50));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 32, 32));
        jLabel4.setText("Telefono del estudiante:");

        txtTelefono.setBackground(new java.awt.Color(217, 217, 217));
        txtTelefono.setForeground(new java.awt.Color(50, 50, 50));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Fecha de nacimiento:");

        dtNacimiento.setBackground(new java.awt.Color(217, 217, 217));
        dtNacimiento.setForeground(new java.awt.Color(218, 217, 217));
        dtNacimiento.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Documento del estudiante:");

        txtDui.setBackground(new java.awt.Color(217, 217, 217));
        txtDui.setForeground(new java.awt.Color(50, 50, 50));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 32, 32));
        jLabel7.setText("Correo del alumno:");

        txtCorreo.setBackground(new java.awt.Color(217, 217, 217));
        txtCorreo.setForeground(new java.awt.Color(50, 50, 50));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setText("Codigo de carnet:");

        txtCodigo.setBackground(new java.awt.Color(217, 217, 217));
        txtCodigo.setForeground(new java.awt.Color(50, 50, 50));
        txtCodigo.setText("20220009");
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(32, 32, 32));
        jLabel9.setText("Genero:");

        cmbGenero.setBackground(new java.awt.Color(217, 217, 217));
        cmbGenero.setForeground(new java.awt.Color(50, 50, 50));
        cmbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGeneroItemStateChanged(evt);
            }
        });

        cmbGrado.setBackground(new java.awt.Color(217, 217, 217));
        cmbGrado.setForeground(new java.awt.Color(50, 50, 50));
        cmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGradoItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Grado");

        jLabel11.setText("Buscar registro:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres)
                    .addComponent(txtApellidos)
                    .addComponent(txtDireccion)
                    .addComponent(txtTelefono)
                    .addComponent(dtNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDui)
                    .addComponent(txtCorreo)
                    .addComponent(txtCodigo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(93, 93, 93)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel11)
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdGrado)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        dtNacimiento.setForeground(java.awt.Color.white);

        jPanel3.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new java.awt.BorderLayout());

        tbEstudiantes.setBackground(new java.awt.Color(217, 217, 217));
        tbEstudiantes.setForeground(new java.awt.Color(32, 32, 32));
        tbEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEstudiantes.setGridColor(new java.awt.Color(32, 32, 32));
        tbEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEstudiantes);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(java.awt.Color.white);

        btnGuardar.setText("Guardar");
        btnGuardar.setRound(20);
        btnGuardar.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setRound(20);
        btnActualizar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setRound(20);
        btnEliminar.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        buttonRound4.setText("Vaciar Campos");
        buttonRound4.setRound(20);
        buttonRound4.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        buttonRound4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound4ActionPerformed(evt);
            }
        });

        btnReporte.setBackground(new java.awt.Color(204, 204, 204));
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(btnReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnReporte)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setPreferredSize(new java.awt.Dimension(20, 100));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Eventos para recoger id´s de los registros en los combobox
     * @param evt 
     */
    
    private void cmbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGeneroItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbGenero.getSelectedIndex();
            if (pos == 0) {
                idGenero = 0;
            } else {
                int dim = generoArrayList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idGenero = (int) generoArrayList.get(i);
                    }
                }
            }          
        }
    }//GEN-LAST:event_cmbGeneroItemStateChanged

    private void cmbGradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGradoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbGrado.getSelectedIndex();
            if (pos == 0) {
                idGrado = 0;
            } else {
                int dim = gradoArrayList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idGrado = (int) gradoArrayList.get(i);
                    }
                }
            }
            
        }
    }//GEN-LAST:event_cmbGradoItemStateChanged

    
    /*Llenar campos al sleccionar un registro*/
    /**
     * Metodo para buscar el id del registros seleccionado en el combobox
     * @param Genero
     * @return 
     */
    
    final int BuscarGeneroSeleccionado(int Genero){
        int size = generoArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) generoArrayList.get(i);
            if (valor == Genero) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    /**
     * Metodo para buscar el id del registros seleccionado en el combobox
     * @param Estado
     * @return 
     */
    
    final int BuscarGradoSeleccionado(int Estado){
        int size = gradoArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) gradoArrayList.get(i);
            if (valor == Estado) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    /**
     * Metodo para buscar el id del registros seleccionado en el combobox
     * @param Usuario
     * @return 
     */
    
    final int BuscarUsuarioSeleccionado(int Usuario) {
        int size = usuarioArrayList.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) usuarioArrayList.get(i);
            if (valor == Usuario) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    /**
     * evento para el llenado de campos con los datos del registro seleciconado al realizar doble click
     * @param evt 
     */
    
    private void tbEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEstudiantesMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 1) {

            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnGuardar.setEnabled(false);

            JTable rcp = (JTable) evt.getSource();
            txtId.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            txtApellidos.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            txtNombres.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            txtCorreo.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            txtDireccion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            txtTelefono.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            txtDui.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            txtCodigo.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 10).toString());

            txtIdGenero.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            txtIdGrado.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtNacimiento.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 9).toString()));
            } catch (Exception e) {

            }

            int idGenero = Integer.parseInt(txtIdGenero.getText());
            int idGrado = Integer.parseInt(txtIdGrado.getText());
//            int idUsuario = Integer.parseInt(txtIdUsuario.getText());

            int respuesta = BuscarGeneroSeleccionado(idGenero);
            int respuesta2 = BuscarGradoSeleccionado(idGrado);
//            int respuesta4 = BuscarUsuarioSeleccionado(idUsuario);

//            JOptionPane.showMessageDialog(null, respuesta);
//            JOptionPane.showMessageDialog(null, respuesta2);
            cmbGenero.setSelectedIndex(respuesta + 1);
            cmbGrado.setSelectedIndex(respuesta2 + 1);
//            cmbUsuario.setSelectedIndex(respuesta4 + 1);
        }
    }//GEN-LAST:event_tbEstudiantesMouseClicked

    /**
     * Validaciones en los campos
     * @param evt 
     */
    
    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
         int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
     if (!(minusculas || mayusculas || espacio))
    {
        evt.consume();
    }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
         int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
     if (!(minusculas || mayusculas || espacio))
    {
        evt.consume();
    }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

    boolean numeros = key >= 48 && key <= 57;
        
    if (!numeros)
    {
        evt.consume();
    }

    if (txtTelefono.getText().trim().length() == 10) {
        evt.consume();
    }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

    boolean numeros = key >= 48 && key <= 57;
        
    if (!numeros)
    {
        evt.consume();
    }

    if (txtCodigo.getText().trim().length() == 10) {
        evt.consume();
    }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    /**
     * Metodo para validar que no se pueda ingresar una fecha mayor a la de hoy
     */
    
    void validacionfecha(){
        Date date = dtNacimiento.getDate();
                c = new GregorianCalendar();
                c.setTime(date);
                int Anio1 = c.get(Calendar.YEAR);
                int mes1 = c.get(Calendar.MONTH) + 1;
                int dia1 = c.get(Calendar.DAY_OF_MONTH);
                
        //fecha de hoy//
         Calendar hoy = Calendar.getInstance();
                int Anio = hoy.get(Calendar.YEAR);
                int mes = hoy.get(Calendar.MONTH) + 1;
                int dia = hoy.get(Calendar.DAY_OF_MONTH);
                
                System.out.println(hoy.getTime());
                
        //Comparacion//                 
                if (Anio1 > Anio || mes1 > mes || dia1 > dia) {
                    JOptionPane.showMessageDialog(null, "Error, no se puede ingresar una fecha mayor o igual a la de hoy");
                    dtNacimiento.setDate(null);
        }
    }
    
        
    public int  mayoriadeedad (){
        Date  date = dtNacimiento.getDate();
        c = new GregorianCalendar();
        c.setTime(date);
        Calendar hoy = Calendar.getInstance();
        int difAnio = hoy.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        int difMes = hoy.get(Calendar.MONTH) - c.get(Calendar.MONTH);
        int difDia = hoy.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
        if (difMes < 0 || (difMes == 0 && difDia < 0)) {
            difAnio = difAnio - 1;
        }
        return difAnio;
    }
    
    /**
     * Guardado de datos en la base de datos
     * @param evt 
     */
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        int años = mayoriadeedad();
        if (txtNombres.getText().trim().isEmpty() || txtApellidos.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty() || 
                txtCorreo.getText().trim().isEmpty() || txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if (cmbGenero.getSelectedIndex() == 0 || cmbGrado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else if (años < 18) {
            JOptionPane.showMessageDialog(null, "El estudiante es menor de edad, no es necesario agregar un numero de documento");
            String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH));
            CEstudents objEstu = new CEstudents(txtApellidos.getText(), txtNombres.getText(), idGenero, idGrado, txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(), txtDui.getText(), nacimiento, idUsuario,
                    txtCodigo.getText());
            boolean respuesta = objEstu.AlumnoNuevoController();
            if (respuesta == true) {
                JOptionPane.showMessageDialog(this, "Estudiante ingresado correctamente");
                txtDui.setEditable(false);
                boolean usuariores = false;
                try {
                    ResultSet idalumno = objEstu.idAlumnoforUsuario();
                    if (idalumno.next()) {
                        CEstudents.idalumno = idalumno.getInt("idalumno");
                        usuariores = objEstu.CrearUsuarioAlumnoController();
                        ResultSet materiasDocente = portafolio.MateriaDocenteResult(idGrado);
                        while (materiasDocente.next()) {
                            portafolio.CrearPortafoliosEXEC(materiasDocente.getInt(1));
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
                if (usuariores == true) {
                    JOptionPane.showMessageDialog(null, "Usuario ingresado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar el usuario");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no pudo ser ingresado");
            }      
        }else{
            txtDui.setEditable(true);
            if (txtDui.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor llene el campo de dui");
            }else{
                 String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH));
            CEstudents objEstu = new CEstudents(txtApellidos.getText(), txtNombres.getText(), idGenero, idGrado, txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(), txtDui.getText(), nacimiento, idUsuario, 
                    txtCodigo.getText());
            boolean respuesta = objEstu.AlumnoNuevoController();
            if (respuesta == true) {
            JOptionPane.showMessageDialog(this, "Estudiante ingresado correctamente");
            txtDui.setEditable(false);
            boolean usuariores = false;
                CargarTabla();
                ResultSet idalumno = objEstu.idAlumnoforUsuario();
                try {
                    if (idalumno.next()) {
                        CEstudents.idalumno = idalumno.getInt("idalumno");
                        usuariores = objEstu.CrearUsuarioAlumnoController();
                        ResultSet materiasDocente = portafolio.MateriaDocenteResult(idGrado);
                        while (materiasDocente.next()) {
                            portafolio.CrearPortafoliosEXEC(materiasDocente.getInt(1));
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error" + ex.toString());
                }           
                if ( usuariores == true ) {
                    JOptionPane.showMessageDialog(null, "Usuario Ingresado");
                }
                else{
                    JOptionPane.showMessageDialog(null, "El usuario no pudo ser ingresado");
                }
        }  else {
                JOptionPane.showMessageDialog(this, "Estudiante no pudo ser ingresado");
            }        
            }
        }
                             
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Eliminacion de registro en la base de datos
     * @param evt 
     */
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro", "Informacion incompleta", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirmacion = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(this, "Esta seguro de eliminar este registro?", "Confirmar Accion", confirmacion);
            if (confirmacion == JOptionPane.YES_OPTION) {
                CEstudents objcontrolalumdell = new CEstudents(Integer.parseInt(txtId.getText()));

                boolean valor = objcontrolalumdell.EliminarEstudiante();
                if (valor == true) {
                    JOptionPane.showMessageDialog(this, "Estudiante eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Boton para limpiar campos
     * @param evt 
     */
    
    private void buttonRound4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound4ActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_buttonRound4ActionPerformed

    /**
     * Actualizacion de datos de registros
     * @param evt 
     */
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Date date = dtNacimiento.getDate();
        c = new GregorianCalendar();
        c.setTime(date);
        String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH));
        
        
        CEstudents objControllerEstudiantes = new CEstudents(Integer.parseInt(txtId.getText()), txtApellidos.getText(), txtNombres.getText(), idGenero, idGrado, txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(), txtDui.getText(), nacimiento, idUsuario, txtCodigo.getText());
        boolean valor = objControllerEstudiantes.ActualizarEstudiante();
        if (valor == true) {
            JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    Connection conn = CConnection.getConnectionControllerWithoutParameters();
    
    /**
     * Busqueda de registros por buscador
     * @param evt 
     */
    
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        
        CComboboxEstudiantes bjCar = new CComboboxEstudiantes();    
        
          while (tablaModel.getRowCount() > 0) {
                    tablaModel.removeRow(0);
                }
                try {
                    ResultSet rs = bjCar.SearchCrnt(txtBuscar.getText() + "%");
                    while (rs.next()) {
                        Object[] oValores = {rs.getInt("idalumno"), rs.getString("apellidos_alumno"), rs.getString("nombres_alumno"), rs.getInt("idgenero"), 
                    rs.getInt("idgrado"), rs.getString("correo"), rs.getString("direccion"), rs.getString("contacto"), 
                    rs.getString("dui"), 
                    rs.getString("fecha_nac"), rs.getString("codigocarnet"), true, conn};
                        tablaModel.addRow(oValores);
                    }
                } catch (Exception e) {
                }
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        
        try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteEstudiantes.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer (jprint , false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmStudentsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnReporteActionPerformed

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
                new frmStudentsCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound btnActualizar;
    private customizeObjects.ButtonRound btnEliminar;
    private customizeObjects.ButtonRound btnGuardar;
    private javax.swing.JButton btnReporte;
    private customizeObjects.ButtonRound buttonRound4;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbGrado;
    private com.toedter.calendar.JDateChooser dtNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEstudiantes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdGenero;
    private javax.swing.JTextField txtIdGrado;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
