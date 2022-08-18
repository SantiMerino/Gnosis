/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controller.CComboboxDocentes;
import Controller.CTeacher;
import java.awt.event.ItemEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JTable;

/**
 *
 * @author Estudiante_PC10
 */
public class frmTeachersCRUD extends javax.swing.JFrame {

    /*Variable a utilizar para el llenado de los combobox*/
    DefaultComboBoxModel<String> modeloGenero;
    DefaultComboBoxModel<String> modeloUsuario;
    DefaultComboBoxModel<String> modeloGrado;
    
    ArrayList generoArrayList;
    ArrayList usuarioArrayList;
    ArrayList gradoArrayList;
    
    DefaultTableModel tablaModel;
    
    private int idGenero = 0;
    private int idUsuario = 0;
    private int idGrado = 0;
    
    private Calendar c;
    
    private String nacimiento;
    /**
     * Creates new form FrmDocentes
     */
    public frmTeachersCRUD() {
        initComponents();
        
        CargarCombobox();
        
        txtId.setEditable(false);
        txtIdGenero.setVisible(false);
        txtIdUsuario.setVisible(false);
        
        
        //Titulos de la tabla 
        String [] TitulosDocentes = {"ID", "Apellidos", "Nombres", "Direccion", "Dui", "Correo",  "Nacimiento", "Grado", "Genero", "Contacto", "Usuario"};
        tablaModel = new DefaultTableModel(null, TitulosDocentes);
        tbDocentes.setModel(tablaModel);
        CargarTabla();
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    /*Limpiar campos*/
    void LimpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        dtNacimiento.setDate(null);
        txtDui.setText("");
        txtCorreo.setText("");
        txtId.setText("");
        txtIdGenero.setText("");
        txtIdUsuario.setText("");
        CargarCombobox();
        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    
    /*Metodo que almacena todos los metodos para al momento de cargar el formulario se llenen automaticamente*/
    final void CargarCombobox() {
        CargarGeneros();
        CargarUsuarios();
        CargarGrados();
    }
    
    /*Cargar tabla de registros de los docentes*/
    final void CargarTabla(){
        CComboboxDocentes docent = new CComboboxDocentes();
        while (tablaModel.getRowCount() > 0) {
            tablaModel.removeRow(0);           
        }
        try {
            ResultSet rs = docent.CCargarDocentes();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("iddocente"), rs.getString("apellidos_docente"), rs.getString("nombres_docente"), 
                    rs.getString("direccion"), rs.getString("dui"), rs.getString("correo"), rs.getString("fecha_nac"), rs.getInt("idgrado"), 
                    rs.getInt("idgenero"), rs.getString("idusuario")};
                tablaModel.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    
    /*Metodos para el llenado de los combobos*/
    final void CargarGeneros(){
        CComboboxDocentes alumnosObj = new CComboboxDocentes();
        generoArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarGeneros();
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
    
    final void CargarUsuarios(){
        CComboboxDocentes alumnosObj = new CComboboxDocentes();
        usuarioArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarUsuarios();
            if (rs.next()) {
                modeloUsuario = new DefaultComboBoxModel<>();
                modeloUsuario.addElement("Elige una opcion");
                do {                    
                    usuarioArrayList.add(rs.getInt("idusuario"));
                    modeloUsuario.addElement(rs.getString("username"));
                    cmbUsuario.setModel(modeloUsuario);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los usuarios");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    
    final void CargarGrados(){
        CComboboxDocentes alumnosObj = new CComboboxDocentes();
        gradoArrayList = new ArrayList();
        
        try {
            ResultSet rs = alumnosObj.CCargarGrados();
            if (rs.next()) {
                modeloGrado = new DefaultComboBoxModel<>();
                modeloGrado.addElement("Elige una opcion");
                do {                    
                    gradoArrayList.add(rs.getInt("idgrado"));
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
    
    /*Insercion de datos*/
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorprincipal = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dtNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        cmbUsuario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtIdGenero = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbGrado = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        rightPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        centerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDocentes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contenedorprincipal.setBackground(new java.awt.Color(204, 204, 204));
        contenedorprincipal.setPreferredSize(new java.awt.Dimension(1000, 640));
        contenedorprincipal.setLayout(new java.awt.BorderLayout());

        leftPanel.setBackground(java.awt.Color.white);
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 100));
        leftPanel.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Nombres del docente:");

        txtNombres.setForeground(new java.awt.Color(250, 250, 250));
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Apellidos del docente:");

        txtApellidos.setForeground(new java.awt.Color(250, 250, 250));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Direccion del docente:");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 32, 32));
        jLabel4.setText("Telefono del docente:");

        txtTelefono.setForeground(new java.awt.Color(250, 250, 250));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Fecha de nacimiento del docente:");

        dtNacimiento.setForeground(new java.awt.Color(250, 250, 250));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Numero de DUI del docente:");

        txtDui.setForeground(new java.awt.Color(250, 250, 250));
        txtDui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuiKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 32, 32));
        jLabel7.setText("Correo del docente:");

        txtCorreo.setForeground(new java.awt.Color(250, 250, 250));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setText("Elegir genero");

        cmbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGeneroItemStateChanged(evt);
            }
        });

        cmbUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUsuarioItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(32, 32, 32));
        jLabel9.setText("Usuario");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("ID:");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setText("Grado:");

        cmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGradoItemStateChanged(evt);
            }
        });

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane2.setViewportView(txtDireccion);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(leftPanelLayout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leftPanelLayout.createSequentialGroup()
                                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))))
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(leftPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leftPanelLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(19, 48, Short.MAX_VALUE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres)
                            .addComponent(txtApellidos)
                            .addComponent(dtNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDui)
                            .addComponent(txtCorreo)
                            .addComponent(txtTelefono)
                            .addComponent(jScrollPane2))
                        .addGap(12, 12, 12))))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contenedorprincipal.add(leftPanel, java.awt.BorderLayout.WEST);

        rightPanel.setBackground(java.awt.Color.white);
        rightPanel.setPreferredSize(new java.awt.Dimension(20, 640));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        contenedorprincipal.add(rightPanel, java.awt.BorderLayout.EAST);

        topPanel.setBackground(java.awt.Color.white);
        topPanel.setPreferredSize(new java.awt.Dimension(1000, 10));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        contenedorprincipal.add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(java.awt.Color.white);
        centerPanel.setPreferredSize(new java.awt.Dimension(500, 1115));
        centerPanel.setLayout(new java.awt.BorderLayout());

        tbDocentes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDocentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDocentes);

        centerPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnLimpiar))
                .addGap(17, 17, 17))
        );

        centerPanel.add(jPanel2, java.awt.BorderLayout.SOUTH);

        contenedorprincipal.add(centerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contenedorprincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro", "Informacion incompleta", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirmacion = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(this, "Esta seguro de eliminar este registro?", "Confirmar Accion", confirmacion);
            if (confirmacion == JOptionPane.YES_OPTION) {
                CTeacher objcontrolalumdell = new CTeacher(Integer.parseInt(txtId.getText()));
                
                boolean valor = objcontrolalumdell.EliminarDocenteController();
                if ( valor == true) {
                    JOptionPane.showMessageDialog(this, "Docente eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtNombres.getText().trim().isEmpty() || txtApellidos.getText().trim().isEmpty() || txtDireccion.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty() || txtDui.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(cmbGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un genero", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(cmbUsuario.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            Date date = dtNacimiento.getDate();
            c = new GregorianCalendar();
            c.setTime(date);
            String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DAY_OF_MONTH));
            CTeacher objDocente = new CTeacher(txtApellidos.getText(), txtNombres.getText(), txtDireccion.getText(), txtDui.getText(), txtCorreo.getText(), nacimiento, idGrado, idGenero, txtTelefono.getText(), idUsuario);
            boolean respuesta = objDocente.DocenteNuevoController();
            if (respuesta == true) {
                JOptionPane.showMessageDialog(this, "Docente ingresado correctamente");
                CargarTabla();
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Docente no pudo ser ingresado");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    
    private void tbDocentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDocentesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnGuardar.setEnabled(false);
            txtId.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            txtNombres.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            txtApellidos.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            txtDireccion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            txtTelefono.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            txtDui.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            txtCorreo.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            txtIdGenero.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            txtIdUsuario.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 9).toString());
            
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtNacimiento.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString()));
            } catch (Exception e) {
                
            }
            
            int idGenero = Integer.parseInt(txtIdGenero.getText());
            int idUsuario = Integer.parseInt(txtIdUsuario.getText());
            
            int respuesta = BuscarGeneroSeleccionado(idGenero);
            int respuesta2 = BuscarUsuarioSeleccionado(idUsuario);
            
            cmbGenero.setSelectedIndex(respuesta + 1);
            cmbUsuario.setSelectedIndex(respuesta2 + 1);
        }
    }//GEN-LAST:event_tbDocentesMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Date date = dtNacimiento.getDate();
        c = new GregorianCalendar();
        c.setTime(date);
        String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1)+ "/" + c.get(Calendar.DAY_OF_MONTH));
        CTeacher objcontrollerDocentes = new CTeacher(Integer.parseInt(txtId.getText()), txtNombres.getText(), txtApellidos.getText(), txtDireccion.getText(), txtTelefono.getText(), nacimiento, txtDui.getText(), 
                txtCorreo.getText(), idGenero, idUsuario);
        boolean valor = objcontrollerDocentes.ActualizarDocente();
        if (valor == true) {
            JOptionPane.showMessageDialog(this, "Docente actualizado correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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

    private void txtDuiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuiKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtDuiKeyTyped

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        customization.mainUtilities();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTeachersCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JComboBox<String> cmbUsuario;
    private javax.swing.JPanel contenedorprincipal;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTable tbDocentes;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdGenero;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
