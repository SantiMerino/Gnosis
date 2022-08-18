/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CConnection;
import Controller.CTasks;
import java.awt.event.ItemEvent;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    private int idTipoPerfil;
    private int idTipoTarea;
    private List TipoPerfilList;
    private List TipoTareaList;
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
     
        //Tabla
        String [] TitulosTarea = {"ID", "Nombre", "Fecha de inicio", "Fecha de vencimiento", "Instrumento de evaluacion", "Perfil", "Grado", "Especialidad"};
        Tablamodelo = new DefaultTableModel(null, TitulosTarea);
        JTTask.setModel(Tablamodelo);
        CargarTabla();
    }
    
    void LimpiarCampos() {
        txtNombre.setText("");
        txtId.setText("");
        dtInicio.setDate(null);
        dtVencimiento.setDate(null);
        CmbTipoPerfil.setSelectedIndex(0);
        CmbTipoTarea.setSelectedIndex(0);
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
                JOptionPane.showMessageDialog(BtnEliminar, "No existen tipos de perfil por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(BtnEliminar, "No existen tipos de tarea por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
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
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtVencimiento = new com.toedter.calendar.JDateChooser();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        BtnSeleccionar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        CmbTipoPerfil = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        CmbTipoTarea = new javax.swing.JComboBox<>();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnSubir = new javax.swing.JButton();
        BtnVaciarCampos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTTask = new javax.swing.JTable();
        BtnConectare = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTipoPerfil = new javax.swing.JTextField();
        txtTipoTarea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tareas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 37, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 14, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 33, 252, -1));

        jLabel4.setText("fecha de inicio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 92, -1, -1));

        jLabel5.setText("fecha de vencimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 161, -1, -1));
        jPanel1.add(dtVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 183, 268, -1));
        jPanel1.add(dtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 120, 268, -1));

        jLabel8.setText("Intrumento de evualcion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        BtnSeleccionar.setText("Seleccionar rubrica");
        BtnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 240, -1));

        jLabel9.setText("Tipo perfil:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        CmbTipoPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoPerfilItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 200, -1));

        jLabel10.setText("Tipo Tarea:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        CmbTipoTarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoTarea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoTareaItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 180, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 140, -1));

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 140, -1));

        BtnSubir.setText("Subir");
        BtnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 140, -1));

        BtnVaciarCampos.setText("Vaciar campos");
        BtnVaciarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVaciarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(BtnVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 140, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 880, 200));

        BtnConectare.setText("Conexion");
        BtnConectare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConectareActionPerformed(evt);
            }
        });
        jPanel1.add(BtnConectare, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 70, -1));

        jLabel12.setText("Id tarea");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));
        jPanel1.add(txtTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));
        jPanel1.add(txtTipoTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_pdf();
    }//GEN-LAST:event_BtnSeleccionarActionPerformed

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
                    }
                }
            }           
        }
    }//GEN-LAST:event_CmbTipoTareaItemStateChanged

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
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
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
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
        CTasks objTaskUpd = new CTasks(Integer.parseInt(txtId.getText()), txtNombre.getText(), inicio, vencimiento, idTipoPerfil, ruta_archivo, idTipoTarea);
        if (obj.ActualizarTarea() == true) {
            JOptionPane.showMessageDialog(this, "Tarea actualizada correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubirActionPerformed
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
            CTasks objTaskAdd = new CTasks(txtNombre.getText(), inicio, vencimiento, idTipoPerfil, ruta_archivo, idTipoTarea);
            boolean respuesta = objTaskAdd.TareaNuevaResultSet();
            if (respuesta == true) {
                JOptionPane.showMessageDialog(this, "Tarea ingresado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Tarea no pudo ser ingresado");
            }
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_BtnSubirActionPerformed

    private void BtnVaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVaciarCamposActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_BtnVaciarCamposActionPerformed

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

    private void BtnConectareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConectareActionPerformed
        // TODO add your handling code here:
        if (CConnection.getConnectionControllerWithoutParameters()!= null) {
            JOptionPane.showMessageDialog(null, "Conexión establecida con éxito uwu");
        }
    }//GEN-LAST:event_BtnConectareActionPerformed

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
            java.util.logging.Logger.getLogger(frmTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTasks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTasks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConectare;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnSeleccionar;
    private javax.swing.JButton BtnSubir;
    private javax.swing.JButton BtnVaciarCampos;
    private javax.swing.JComboBox<String> CmbTipoPerfil;
    private javax.swing.JComboBox<String> CmbTipoTarea;
    private javax.swing.JTable JTTask;
    private com.toedter.calendar.JDateChooser dtInicio;
    private com.toedter.calendar.JDateChooser dtVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipoPerfil;
    private javax.swing.JTextField txtTipoTarea;
    // End of variables declaration//GEN-END:variables
}
