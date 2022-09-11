/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CConnection;
import Controller.CTasks;
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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
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
public class frmTasks extends javax.swing.JFrame {

    CTasks obj = new CTasks();
    DefaultTableModel Tablamodelo;
    DefaultComboBoxModel<String> TipoPerfilcombo;
    DefaultComboBoxModel<String> TipoTareacombo;
    private List TipoPerfilList;
    private List TipoTareaList;
    private int idTipoPerfil = 0;
    private int idTipoTarea = 0;
    private Calendar Cal1;
    private Calendar Cal2;
    private String ruta_archivo = " ";
    
    /**
     * Creates new form frmTasks
     */
    public frmTasks() {
        initComponents();
        CargarCmbTipoTarea();
        CargarCmbTipoPerfil();
//        customization.centrarFrame(this); 
   
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        //Tabla
        String [] TitulosTarea = {"ID", "Nombre", "Fecha de inicio", "Fecha de vencimiento", "Perfil", "Rubrica", "Tipo Tarea"};
        Tablamodelo = new DefaultTableModel(null, TitulosTarea);
        JTTask.setModel(Tablamodelo);
        CargarTabla();
        
        txtId.setVisible(false);
        txtTipoPerfil.setVisible(false);
        txtTipoTarea.setVisible(false);
        for(Component c : dtInicio.getComponents()){
            ((JComponent)c).setBackground(new Color (217,217,217));
        }
        for(Component c : dtVencimiento.getComponents()){
            ((JComponent)c).setBackground(new Color (217,217,217));
        }
    }
    
    void LimpiarCampos() {
        txtNombre.setText("");
        txtId.setText("");
        dtInicio.setDate(null);
        dtVencimiento.setDate(null);
        CmbTipoPerfil.setSelectedIndex(0);
        CmbTipoTarea.setSelectedIndex(0);
        btnSubir.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    
    }
    
    final void CargarTabla(){
        CTasks Task = new CTasks();
        while (Tablamodelo.getRowCount() > 0) {
            Tablamodelo.removeRow(0);           
        }
        try {
            ResultSet rs = Task.CCargarTareas();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idtarea"), rs.getString("nombretarea"), rs.getString("fechadeinicio"), rs.getString("fechavencimiento"), rs.getInt("idperfil"), rs.getString("rubrica"), rs.getInt("idtipotarea")};
                Tablamodelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    public void seleccionar_pdf(){
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf","pdf"); 
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.BtnSeleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
        }
    }
    
    final void CargarCmbTipoPerfil(){
        //Crear objetos de la clase ControllerBiblioteca
        CTasks objCargarTipoPerfil;
        objCargarTipoPerfil = new CTasks();
        //Lista donde se guardarán los IDs
        TipoPerfilList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarTipoPerfil.CargarTipoPerfilResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                TipoPerfilcombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                TipoPerfilcombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    TipoPerfilList.add(rs.getInt("idperfil"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    TipoPerfilcombo.addElement(rs.getString("nombreperfil"));
                    //Se asigna el modelo combo al combobox
                    CmbTipoPerfil.setModel(TipoPerfilcombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen tipos de perfil por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(btnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbTipoTarea() {
        //Crear objetos de la clase ControllerBiblioteca
        CTasks objCargarTipoTaraes;
        objCargarTipoTaraes = new CTasks();
        //Lista donde se guardarán los IDs
        TipoTareaList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarTipoTaraes.CargarTipoTaraeResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                TipoTareacombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                TipoTareacombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    TipoTareaList.add(rs.getInt("idtipotarea"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    TipoTareacombo.addElement(rs.getString("tipotarea"));
                    //Se asigna el modelo combo al combobox
                    CmbTipoTarea.setModel(TipoTareacombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen tipos de tarea por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtVencimiento = new com.toedter.calendar.JDateChooser();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CmbTipoPerfil = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        CmbTipoTarea = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTTask = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtTipoPerfil = new javax.swing.JTextField();
        txtTipoTarea = new javax.swing.JTextField();
        btnModificar = new customizeObjects.ButtonRound();
        btnSubir = new customizeObjects.ButtonRound();
        btnEliminar = new customizeObjects.ButtonRound();
        BtnSeleccionar = new customizeObjects.ButtonRound();
        buttonRound1 = new customizeObjects.ButtonRound();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(130, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Tareas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtNombre.setBackground(new java.awt.Color(210, 210, 210));
        txtNombre.setForeground(new java.awt.Color(32, 32, 32));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 252, 30));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 32, 32));
        jLabel4.setText("Fecha de inicio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 92, -1, -1));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Fecha de vencimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel1.add(dtVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 183, 268, 30));
        jPanel1.add(dtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 120, 268, 30));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setText("Intrumento de evualcion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(32, 32, 32));
        jLabel9.setText("Perfil vinculado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        CmbTipoPerfil.setBackground(new java.awt.Color(210, 210, 210));
        CmbTipoPerfil.setForeground(new java.awt.Color(32, 32, 32));
        CmbTipoPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoPerfilItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 200, 30));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Tipo Tarea:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        CmbTipoTarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoTarea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoTareaItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 180, 30));

        JTTask.setForeground(new java.awt.Color(32, 32, 32));
        JTTask.setModel(new javax.swing.table.DefaultTableModel(
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
        JTTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTTaskMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTTask);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 690, 200));

        txtId.setBackground(new java.awt.Color(210, 210, 210));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 70, -1));
        jPanel1.add(txtTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));
        jPanel1.add(txtTipoTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.setPreferredSize(new java.awt.Dimension(130, 40));
        btnModificar.setRound(20);
        btnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 120, 35));
        btnModificar.getAccessibleContext().setAccessibleName("");

        btnSubir.setText("Subir");
        btnSubir.setPreferredSize(new java.awt.Dimension(130, 40));
        btnSubir.setRound(20);
        btnSubir.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 120, 35));
        btnSubir.getAccessibleContext().setAccessibleName("");

        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(130, 40));
        btnEliminar.setRound(20);
        btnEliminar.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 120, 35));
        btnEliminar.getAccessibleContext().setAccessibleName("");

        BtnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/send-square.png"))); // NOI18N
        BtnSeleccionar.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        BtnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 270, 40));

        buttonRound1.setText("buttonRound1");
        buttonRound1.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        jPanel1.add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 60, -1));

        jLabel3.setText("Buscar Registro:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmbTipoPerfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoPerfilItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoPerfil.getSelectedIndex();
            if (pos == 0) {
                idTipoPerfil = 0;
            } else {
                int dim = TipoPerfilList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idTipoPerfil = (int) TipoPerfilList.get(i);
//                        JOptionPane.showMessageDialog(null, idTipoPerfil);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbTipoPerfilItemStateChanged

    private void CmbTipoTareaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoTareaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoTarea.getSelectedIndex();
            if (pos == 0) {
                idTipoTarea = 0;
            } else {
                int dim = TipoTareaList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idTipoTarea = (int) TipoTareaList.get(i);
//                        JOptionPane.showMessageDialog(null, idTipoTarea);

                    }
                }
            }
        }
    }//GEN-LAST:event_CmbTipoTareaItemStateChanged

    final int BuscarTipoTareaSeleccionado(int TipoTarea){
        int size = TipoTareaList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) TipoTareaList.get(i);
            if (valor == TipoTarea) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarTipoPerfilSeleccionado(int TipoPerfil){
        int size = TipoPerfilList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) TipoPerfilList.get(i);
            if (valor == TipoPerfil) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    private void JTTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTTaskMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            txtId.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            txtNombre.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            txtTipoPerfil.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            txtTipoTarea.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtInicio.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString()));
            } catch (Exception e) {

            }

            DateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtVencimiento.setDate((Date) simpleDateFormat2.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString()));
            } catch (Exception e) {

            }

            int idTipoPerfil = Integer.parseInt(txtTipoPerfil.getText());
            int idTipoTarea = Integer.parseInt(txtTipoTarea.getText());

            int respuesta = BuscarTipoPerfilSeleccionado(idTipoPerfil);
            int respuesta2 = BuscarTipoTareaSeleccionado(idTipoTarea);

            CmbTipoPerfil.setSelectedIndex(respuesta + 1);
            CmbTipoTarea.setSelectedIndex(respuesta2 + 1);
        }
    }//GEN-LAST:event_JTTaskMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

    boolean mayusculas = key >= 65 && key <= 90;
    boolean minusculas = key >= 97 && key <= 122;
    boolean espacio = key == 32;
            
     if (!(minusculas || mayusculas || espacio))
    {
        evt.consume();
    }
    }//GEN-LAST:event_txtNombreKeyTyped
    
    void ValidacionFechas(){
        Calendar z;
                Date date = dtInicio.getDate();
                z = new GregorianCalendar();
                z.setTime(date);
                int AnioC = z.get(Calendar.YEAR);
                int mesC = z.get(Calendar.MONTH) + 1;
                int diaC = z.get(Calendar.DAY_OF_MONTH);

                //Segundo dateChooser
                Calendar x;
                Date date2 = dtVencimiento.getDate();
                x = new GregorianCalendar();
                x.setTime(date2);
                int Anio2 = x.get(Calendar.YEAR);
                int mes2 = x.get(Calendar.MONTH) + 1;
                int dia2 = x.get(Calendar.DAY_OF_MONTH);

                //Fecha de hoy
                Calendar hoy = Calendar.getInstance();
                int Anio = hoy.get(Calendar.YEAR);
                int mes = hoy.get(Calendar.MONTH) + 1;
                int dia = hoy.get(Calendar.DAY_OF_MONTH);
                
                if (AnioC > Anio2 || mesC > mes2 || diaC > dia2) {
            JOptionPane.showMessageDialog(null, "Error, la fecha de inicio no puede ser mayor a la echa de finalizacion");
        }
    }
    
    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbTipoPerfil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de perfil", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else if(CmbTipoTarea.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de tarea", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            //fecha de inicio
            Date date = dtInicio.getDate();
            Cal1 = new GregorianCalendar();
            Cal1.setTime(date);
            String inicio = String.valueOf(Cal1.get(Calendar.YEAR) + "/" + Cal1.get(Calendar.MONTH) + "/" + Cal1.get(Calendar.DAY_OF_MONTH));
            //fecha de vencimiento
            Date date2 = dtVencimiento.getDate();
            Cal2 = new GregorianCalendar();
            Cal2.setTime(date2);
            String vencimiento = String.valueOf(Cal2.get(Calendar.YEAR) + "/" + Cal2.get(Calendar.MONTH) + "/" + Cal2.get(Calendar.DAY_OF_MONTH));
            // Envio
            CTasks controller = new CTasks(txtNombre.getText(), inicio, vencimiento, idTipoPerfil, ruta_archivo, idTipoTarea);
            boolean respuesta = controller.TareaNuevaResultSet();
            if ( respuesta = true) {
                JOptionPane.showMessageDialog(this, "Tarea ingresado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Tarea no pudo ser ingresado");
            }
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        //fecha de inicio update
        Date date = dtInicio.getDate();
        Cal1 = new GregorianCalendar();
        Cal1.setTime(date);
        String inicio = String.valueOf(Cal1.get(Calendar.YEAR) + "/" + (Cal1.get(Calendar.MONTH) + 1)+ "/" + Cal1.get(Calendar.DAY_OF_MONTH));
        //fecha de vencimiento update
        Date date2 = dtInicio.getDate();
        Cal2 = new GregorianCalendar();
        Cal2.setTime(date2);
        String vencimiento = String.valueOf(Cal2.get(Calendar.YEAR) + "/" + (Cal2.get(Calendar.MONTH) + 1)+ "/" + Cal2.get(Calendar.DAY_OF_MONTH));

        //Update
        CTasks objupdate =new CTasks(Integer.parseInt(txtId.getText()), txtNombre.getText(), inicio, vencimiento, idTipoPerfil, ruta_archivo, idTipoTarea);
        boolean res = objupdate.ActualizarTareaController();
        if (res == true) {
            JOptionPane.showMessageDialog(this, "Tarea actualizada correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro", "Informacion incompleta", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirmacion = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(this, "Esta seguro de eliminar este registro?", "Confirmar Accion", confirmacion);
            if (confirmacion == JOptionPane.YES_OPTION) {
                CTasks objTaskDel = new CTasks(Integer.parseInt(txtId.getText()));

                boolean valor = objTaskDel.EliminarTareaController();
                if ( valor == true) {
                    JOptionPane.showMessageDialog(this, "Tarea eliminada exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void BtnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_pdf();
    }//GEN-LAST:event_BtnSeleccionarActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        
        Connection conn = CConnection.getConnectionControllerWithoutParameters();
        CTasks bjCar = new CTasks();    
        
          while (Tablamodelo.getRowCount() > 0) {
                    Tablamodelo.removeRow(0);
                }
                try {
                    ResultSet rs = bjCar.Search(txtBuscar.getText() + "%");
                    while (rs.next()) {
                        Object[] oValores = {rs.getInt("idtarea"), rs.getString("nombretarea"), rs.getString("fechadeinicio"), rs.getString("fechavencimiento"), rs.getInt("idperfil"), 
                    rs.getString("rubrica"), rs.getInt("idtipotarea"), true, conn};
                        Tablamodelo.addRow(oValores);
                    }
                } catch (Exception e) {
                }
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        customization.mainUtilities();
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
                new frmTasks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound BtnSeleccionar;
    private javax.swing.JComboBox<String> CmbTipoPerfil;
    private javax.swing.JComboBox<String> CmbTipoTarea;
    private javax.swing.JTable JTTask;
    private customizeObjects.ButtonRound btnEliminar;
    private customizeObjects.ButtonRound btnModificar;
    private customizeObjects.ButtonRound btnSubir;
    private customizeObjects.ButtonRound buttonRound1;
    private com.toedter.calendar.JDateChooser dtInicio;
    private com.toedter.calendar.JDateChooser dtVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipoPerfil;
    private javax.swing.JTextField txtTipoTarea;
    // End of variables declaration//GEN-END:variables
}
