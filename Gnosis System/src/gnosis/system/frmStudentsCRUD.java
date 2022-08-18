/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import Controller.CComboboxEstudiantes;
import Controller.CEstudents;
import java.awt.Color;
import java.awt.event.ItemEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    /**
     * Creates new form FrmEstudiantes
     */
    public frmStudentsCRUD() {
        initComponents();
        dtNacimiento.setBackground(new Color (217,217,217));
        txtId.setEditable(false);
        txtIdGenero.setVisible(false);
        txtIdGrado.setVisible(false);
        txtIdUsuario.setVisible(false);
        
        
        CargarDatos();
        
        String [] TitulosDocentes = {"ID", "Apellidos", "Nombres", "Genero", "Grado", "Correo",  "Direccion", "Contacto", "DUI", "Nacimiento", "Carnet"};
        tablaModel = new DefaultTableModel(null, TitulosDocentes);
        tbEstudiantes.setModel(tablaModel);
        CargarTabla();
        
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
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
        txtIdUsuario.setText("");
        CargarDatos();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
     final void CargarTabla(){
        CComboboxEstudiantes docent = new CComboboxEstudiantes();
        while (tablaModel.getRowCount() > 0) {
            tablaModel.removeRow(0);           
        }
        try {
            ResultSet rs = docent.CCargarEstudiantes();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idalumno"), rs.getString("apellidos_alumno"), rs.getString("nombres_alumno"), rs.getInt("idgenero"), 
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
        CargarUsuarios();
    }
    
    /*Llenado de combobox*/
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
                JOptionPane.showMessageDialog(null, "No se pudo cargar los usuarios");
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
                    usuarioArrayList.add(rs.getInt("idUsuario"));
                    modeloUsuario.addElement(rs.getString("Username"));
                    cmbUsuario.setModel(modeloUsuario);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los usuarios");
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
        cmbUsuario = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantes = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtIdGenero = new javax.swing.JTextField();
        txtIdGrado = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Nombres del estudiantes:");

        txtNombres.setBackground(new java.awt.Color(217, 217, 217));
        txtNombres.setForeground(java.awt.Color.white);
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Apellidos del estudiante:");

        txtApellidos.setBackground(new java.awt.Color(217, 217, 217));
        txtApellidos.setForeground(java.awt.Color.white);
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Direccion del estudiante:");

        txtDireccion.setBackground(new java.awt.Color(217, 217, 217));
        txtDireccion.setForeground(java.awt.Color.white);

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 32, 32));
        jLabel4.setText("Telefono del estudiante:");

        txtTelefono.setBackground(new java.awt.Color(217, 217, 217));
        txtTelefono.setForeground(java.awt.Color.white);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Fecha de nacimiento:");

        dtNacimiento.setBackground(new java.awt.Color(217, 217, 217));
        dtNacimiento.setForeground(java.awt.Color.white);

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Documento del estudiante:");

        txtDui.setBackground(new java.awt.Color(217, 217, 217));
        txtDui.setForeground(java.awt.Color.white);

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 32, 32));
        jLabel7.setText("Correo del alumno:");

        txtCorreo.setBackground(new java.awt.Color(217, 217, 217));
        txtCorreo.setForeground(java.awt.Color.white);

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setText("Codigo de carnet:");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(217, 217, 217));
        txtCodigo.setForeground(java.awt.Color.white);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(32, 32, 32));
        jLabel9.setText("Genero:");

        cmbGenero.setBackground(new java.awt.Color(217, 217, 217));
        cmbGenero.setForeground(java.awt.Color.white);
        cmbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGeneroItemStateChanged(evt);
            }
        });

        cmbGrado.setBackground(new java.awt.Color(217, 217, 217));
        cmbGrado.setForeground(java.awt.Color.white);
        cmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGradoItemStateChanged(evt);
            }
        });

        cmbUsuario.setBackground(new java.awt.Color(217, 217, 217));
        cmbUsuario.setForeground(java.awt.Color.white);
        cmbUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUsuarioItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Grado");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(32, 32, 32));
        jLabel12.setText("Usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addGap(0, 201, Short.MAX_VALUE)))
                        .addContainerGap())
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
                                .addGap(45, 45, 45)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(15, 15, 15))))
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
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        jPanel2.setBackground(java.awt.Color.white);

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
        tbEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEstudiantes);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Campos");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(108, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        Date date = dtNacimiento.getDate();
            c = new GregorianCalendar();
            c.setTime(date);
            String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH));
            CEstudents objEstu = new CEstudents(txtApellidos.getText(), txtNombres.getText(), idGenero, idGrado, txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(), txtDui.getText(), nacimiento, idUsuario, 
                    txtCodigo.getText());
            boolean respuesta = objEstu.AlumnoNuevoController();
            if (respuesta == true) {
            JOptionPane.showMessageDialog(this, "Estudiante ingresado correctamente");
            boolean usuariores = false;
                CargarTabla();
                ResultSet idalumno = objEstu.idAlumnoforUsuario();
                try {
                    if (idalumno.next()) {
                        CEstudents.idalumno = idalumno.getInt("idalumno");
                        JOptionPane.showMessageDialog(null, CEstudents.idalumno);
                        usuariores = objEstu.CrearUsuarioAlumnoController();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "adios id" + ex.toString());
                }           
                if ( usuariores == true ) {
                    JOptionPane.showMessageDialog(null, "No se pudo ingresar el usuario");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Usuario ingresado");
                }
        }  else {
                JOptionPane.showMessageDialog(this, "Estudiante no pudo ser ingresado");
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

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

    private void cmbUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUsuarioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbUsuario.getSelectedIndex();
            if (pos == 0) {
                idUsuario = 0;
            } else {
                int dim = usuarioArrayList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idUsuario = (int) usuarioArrayList.get(i);
                    }
                }
            }   
        }
    }//GEN-LAST:event_cmbUsuarioItemStateChanged

    
    /*Llenar campos al sleccionar un registro*/
    
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
    
    final int BuscarUsuarioSeleccionado(int Usuario){
        int size = usuarioArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) usuarioArrayList.get(i);
            if (valor == Usuario) {
                retorno = i;
            }
        }
        return retorno;
    }
    
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
            txtCodigo.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            
            txtIdGenero.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            txtIdGrado.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            txtIdUsuario.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 10).toString());
            
            
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtNacimiento.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 9).toString()));
            } catch (Exception e) {
                
            }
            
            int idGenero = Integer.parseInt(txtIdGenero.getText());
            int idGrado = Integer.parseInt(txtIdGrado.getText());
            int idUsuario = Integer.parseInt(txtIdUsuario.getText());
            
            int respuesta = BuscarGeneroSeleccionado(idGenero);
            int respuesta2 = BuscarGradoSeleccionado(idGrado);
            int respuesta4 = BuscarUsuarioSeleccionado(idUsuario);
//            
            cmbGenero.setSelectedIndex(respuesta + 1);
            cmbGrado.setSelectedIndex(respuesta2 + 1);
            cmbUsuario.setSelectedIndex(respuesta4 + 1);
        }
        
    }//GEN-LAST:event_tbEstudiantesMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Date date = dtNacimiento.getDate();
        c = new GregorianCalendar();
        c.setTime(date);
        String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1)+ "/" + c.get(Calendar.DAY_OF_MONTH));
        CEstudents objControllerEstudiantes = new CEstudents(Integer.parseInt(txtId.getText()), txtApellidos.getText(), txtNombres.getText(), idGenero, idGrado, txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(), txtDui.getText(), nacimiento, idUsuario, 
                    txtCodigo.getText());
        boolean valor = objControllerEstudiantes.ActualizarEstudiante();
        if (valor == true) {
            JOptionPane.showMessageDialog(this, "Estudiante actualizado correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
                if ( valor == true) {
                    JOptionPane.showMessageDialog(this, "Estudiante eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        customization.mainUtilities();
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmStudentsCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JComboBox<String> cmbUsuario;
    private com.toedter.calendar.JDateChooser dtNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEstudiantes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdGenero;
    private javax.swing.JTextField txtIdGrado;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
