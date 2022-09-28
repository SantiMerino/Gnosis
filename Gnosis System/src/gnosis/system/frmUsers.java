/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CProfiles;
import Controller.CUsers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josec
 */
public class frmUsers extends javax.swing.JFrame {

    CUsers obj = new CUsers();
    DefaultTableModel TablaUsersModelo;
    DefaultComboBoxModel<String> EstadoUsuariocombo;
    DefaultComboBoxModel<String> NivelUsuariocombo;
    DefaultComboBoxModel<String> Alumnoscombo;
    DefaultComboBoxModel<String> Docentescombo;
    private List EstadoUsuarioList;
    private List NivelUsuarioList;
    private List AlumnosList;
    private List DocentesList;
    
    /**
     * Creates new form frmUsers
     */
    public frmUsers() {
        initComponents();
        CargarCmbEstadoUsuario();
        CargarCmbNivelUsuario();
        CargarCmbDocentes();
        CargarCmbAlumnos();
        
        //Tabla
        String[] TitulosUsuarios = {"ID", "Nivel Usuario", "Usuario", "Clave", "PIN", "Estado Usuario", "Alumno", "Docente"};
        TablaUsersModelo = new DefaultTableModel(null, TitulosUsuarios);
        tbUsers.setModel(TablaUsersModelo);
        //Ocultar columnas
        tbUsers.getColumnModel().getColumn(6).setMaxWidth(0);
        tbUsers.getColumnModel().getColumn(7).setMaxWidth(0);
        CargarTabla();
    }
    
    final void CargarTabla(){
        CUsers Usuario = new CUsers();
        while (TablaUsersModelo.getRowCount() > 0) {
            TablaUsersModelo.removeRow(0);           
        }
        try {
            ResultSet rs = Usuario.CargarUsuariosResultSet();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idusuario"), rs.getString("idnivelusuario"), rs.getString("username"), rs.getString("clave"), rs.getString("pin"), rs.getString("idestadousuario"), rs.getString("idalumno"), rs.getString("iddocente")};
                TablaUsersModelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    final void CargarCmbEstadoUsuario() {
        //Crear objetos de la clase ControllerBiblioteca
        CUsers objCargarEstadoUsuario;
        objCargarEstadoUsuario = new CUsers();
        //Lista donde se guardarán los IDs
        EstadoUsuarioList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarEstadoUsuario.CargarEstadoUsuarioResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                EstadoUsuariocombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                EstadoUsuariocombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    EstadoUsuarioList.add(rs.getInt("idestadousuario"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    EstadoUsuariocombo.addElement(rs.getString("estadousuario"));
                    //Se asigna el modelo combo al combobox
                    cmbEstadoUsuario.setModel(EstadoUsuariocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen estados de usuario por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(btnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbNivelUsuario() {
        //Crear objetos de la clase ControllerBiblioteca
        CUsers objCargarNivelUsuario;
        objCargarNivelUsuario = new CUsers();
        //Lista donde se guardarán los IDs
        NivelUsuarioList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarNivelUsuario.CargarNivelUsuarioResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                NivelUsuariocombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                NivelUsuariocombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    NivelUsuarioList.add(rs.getInt("idnivelusuario"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    NivelUsuariocombo.addElement(rs.getString("nivelusuario"));
                    //Se asigna el modelo combo al combobox
                    cmbNivelUsuario.setModel(NivelUsuariocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen niveles de usuario por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(btnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method

    final void CargarCmbAlumnos() {
        //Crear objetos de la clase ControllerBiblioteca
        CUsers objCargarAlumnos;
        objCargarAlumnos = new CUsers();
        //Lista donde se guardarán los IDs
        AlumnosList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarAlumnos.CargarAlumnoResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                Alumnoscombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                Alumnoscombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    AlumnosList.add(rs.getInt("idalumno"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    Alumnoscombo.addElement(rs.getString("nombres_alumno"));
                    //Se asigna el modelo combo al combobox
                    CmbAlumno.setModel(Alumnoscombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen alumnos por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(btnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbDocentes() {
        //Crear objetos de la clase ControllerBiblioteca
        CUsers objCargarDocentes;
        objCargarDocentes = new CUsers();
        //Lista donde se guardarán los IDs
        DocentesList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarDocentes.CargarDocenteResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                Docentescombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                Docentescombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    DocentesList.add(rs.getInt("iddocente"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    Docentescombo.addElement(rs.getString("nombres_docente"));
                    //Se asigna el modelo combo al combobox
                    CmbDocente.setModel(Docentescombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen docentes por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(btnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbEstadoUsuario = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbNivelUsuario = new javax.swing.JComboBox<>();
        btnGuardar = new customizeObjects.ButtonRound();
        btnActualizar = new customizeObjects.ButtonRound();
        btnEliminar = new customizeObjects.ButtonRound();
        btnLimpiarCampos = new customizeObjects.ButtonRound();
        txtPin = new javax.swing.JTextField();
        CmbAlumno = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CmbDocente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 100));

        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsers);

        jLabel9.setForeground(new java.awt.Color(32, 32, 32));
        jLabel9.setText("Buscar Registro:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 0));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Nombre de usuario:");

        txtUserName.setBackground(new java.awt.Color(217, 217, 217));
        txtUserName.setForeground(new java.awt.Color(32, 32, 32));
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Clave:");

        txtCode.setBackground(new java.awt.Color(217, 217, 217));
        txtCode.setForeground(new java.awt.Color(32, 32, 32));
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Pin:");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setText("Estado usuario:");

        cmbEstadoUsuario.setBackground(new java.awt.Color(217, 217, 217));
        cmbEstadoUsuario.setEditable(true);
        cmbEstadoUsuario.setForeground(new java.awt.Color(32, 32, 32));
        cmbEstadoUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoUsuarioItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setText("Docente:");

        cmbNivelUsuario.setBackground(new java.awt.Color(217, 217, 217));
        cmbNivelUsuario.setEditable(true);
        cmbNivelUsuario.setForeground(new java.awt.Color(32, 32, 32));
        cmbNivelUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNivelUsuarioItemStateChanged(evt);
            }
        });

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

        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.setRound(20);
        btnLimpiarCampos.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        txtPin.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Alumno:");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(32, 32, 32));
        jLabel12.setText("Nivel de usuario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUserName)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(284, 284, 284))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(283, 283, 283))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCode)
                            .addComponent(txtPin))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbEstadoUsuario, 0, 150, Short.MAX_VALUE)
                            .addComponent(cmbNivelUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(CmbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addComponent(CmbDocente, 0, 136, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNivelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );

        jPanel4.add(jPanel1, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyTyped
        // TODO add your handling code here
    }//GEN-LAST:event_txtUserNameKeyTyped

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeKeyTyped

    private void cmbEstadoUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoUsuarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoUsuarioItemStateChanged

    private void cmbNivelUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNivelUsuarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNivelUsuarioItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void tbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbUsersMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbAlumno;
    private javax.swing.JComboBox<String> CmbDocente;
    private customizeObjects.ButtonRound btnActualizar;
    private customizeObjects.ButtonRound btnEliminar;
    private customizeObjects.ButtonRound btnGuardar;
    private customizeObjects.ButtonRound btnLimpiarCampos;
    private javax.swing.JComboBox<String> cmbEstadoUsuario;
    private javax.swing.JComboBox<String> cmbNivelUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsers;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtPin;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
