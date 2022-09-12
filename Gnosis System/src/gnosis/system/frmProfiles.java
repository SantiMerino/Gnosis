/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CProfiles;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.Font;
import java.awt.Insets;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josec
 */
public class frmProfiles extends javax.swing.JFrame {

    CProfiles obj = new CProfiles();
    DefaultTableModel TablaPerfilmodelo;
    DefaultComboBoxModel<String> TipoPerfilcombo;
    DefaultComboBoxModel<String> GradoPerfilcombo;
    DefaultComboBoxModel<String> SeccionesPerfilcombo;
    private List TipoPerfilList;
    private List GradoPerfilList;
    private Calendar Cal1;
    private Calendar Cal2;
    private String ruta_archivo = " ";
    
    /**
     * Creates new form frmProfiles
     */
    public frmProfiles() {
//        setResizable(false);
        initComponents();
        CargarCmbTipoPerfil();
        CargarCmbGradoPerfil();
        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        //Tabla
        String [] TitulosPerfil = {"ID", "Nombre", "Descripcion", "Porcentaje de valoracion", "Fecha de inicio", "Fecha de vencimiento", "Tipo Perfil", "Grados"};
        TablaPerfilmodelo = new DefaultTableModel(null, TitulosPerfil);
        JTPerfil.setModel(TablaPerfilmodelo);
        CargarTabla();
    }
    
    void LimpiarCampos() {
        txtNombre.setText("");
        txtPonderacion.setText("");
        txtPonderacion.setText("");
        txtId.setText("");
        dtInicio.setDate(null);
        dtVencimiento.setDate(null);
        CmbTipoPerfil.setSelectedIndex(0);
//        CmbGrado.setSelectedIndex(0);
        btnSubir.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    final void CargarTabla(){
        CProfiles Perfil = new CProfiles();
        while (TablaPerfilmodelo.getRowCount() > 0) {
            TablaPerfilmodelo.removeRow(0);           
        }
        try {
            ResultSet rs = Perfil.CargarPerfilResultSet();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idperfil"), rs.getString("nombreperfil"), rs.getString("descripcion"), rs.getString("porcentajeValoracion"), rs.getString("fechainicio"), rs.getString("fechavencimiento"), rs.getString("tipoperfil"), rs.getString("grado")};
                TablaPerfilmodelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    final void CargarCmbTipoPerfil() {
        //Crear objetos de la clase ControllerBiblioteca
        CProfiles objCargarTipoPerfil;
        objCargarTipoPerfil = new CProfiles();
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
                    TipoPerfilList.add(rs.getInt("idtipoperfil"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    TipoPerfilcombo.addElement(rs.getString("tipoperfil"));
                    //Se asigna el modelo combo al combobox
                    CmbTipoPerfil.setModel(TipoPerfilcombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen tipos perfil por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(btnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbGradoPerfil() {
        //Crear objetos de la clase ControllerBiblioteca
        CProfiles objCargarGradoPerfil;
        objCargarGradoPerfil = new CProfiles();
        //Lista donde se guardarán los IDs
        GradoPerfilList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarGradoPerfil.CargarGradoPerfilResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                GradoPerfilcombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                GradoPerfilcombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    GradoPerfilList.add(rs.getInt("idgrado"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    GradoPerfilcombo.addElement(rs.getString("grado"));
                    //Se asigna el modelo combo al combobox
//                    CmbGrado.setModel(GradoPerfilcombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(btnEliminar, "No existen grados por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
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
        CmbTipoPerfil = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dtVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtPonderacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPerfil = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btnSubir = new customizeObjects.ButtonRound();
        btnModificar = new customizeObjects.ButtonRound();
        btnEliminar = new customizeObjects.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(875, 604));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("Perfil:");

        jLabel2.setText("Nombre: ");

        jLabel4.setText("Tipo perfil:");

        CmbTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Fecha de inicio:");

        jLabel6.setText("Fecha de vencimiento:");

        jLabel7.setText("Ponderacion:");

        jLabel8.setText("Grado:");

        jLabel10.setText("Descripcion o indicaciones:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        JTPerfil.setModel(new javax.swing.table.DefaultTableModel(
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
        JTPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPerfilMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTPerfil);

        jLabel11.setText("Id perfil:");

        jLabel3.setText("Materia:");

        jLabel9.setText("Docente:");

        jTextField1.setEditable(false);
        jTextField1.setToolTipText("");

        jTextField2.setEditable(false);
        jTextField2.setToolTipText("");

        jTextField3.setEditable(false);
        jTextField3.setToolTipText("");

        btnSubir.setText("Agregar Perfil");
        btnSubir.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);

        btnModificar.setText("Modificar Perfil");
        btnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);

        btnEliminar.setText("Eliminar Perfil");
        btnEliminar.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(dtVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(CmbTipoPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(5, 5, 5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPonderacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(CmbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPonderacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dtVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    final int BuscarGradoSeleccionado(int Grado){
        int size = GradoPerfilList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) GradoPerfilList.get(i);
            if (valor == Grado) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    
    private void JTPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPerfilMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            txtId.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            txtNombre.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            txtPonderacion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            txtDescripcion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            String tipoperfil = (rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            String grado = (rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtInicio.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString()));
            } catch (Exception e) {

            }

            DateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtVencimiento.setDate((Date) simpleDateFormat2.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString()));
            } catch (Exception e) {

            }
            
//            CmbGrado.setSelectedItem(grado);
//            int cmbgrado = CmbGrado.getSelectedIndex();
            CmbTipoPerfil.setSelectedItem(tipoperfil);
            int cmbtipoperfil = CmbTipoPerfil.getSelectedIndex();

        }
    }//GEN-LAST:event_JTPerfilMouseClicked

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().trim().isEmpty() || txtDescripcion.getText().trim().isEmpty() || txtPonderacion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbTipoPerfil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de perfil", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } 
//        else if(CmbGrado.getSelectedIndex() == 0){
//            JOptionPane.showMessageDialog(this, "Seleccione un grado", "Campos vacios", JOptionPane.WARNING_MESSAGE);
//        } 
        
        else {
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
            obj.nombre = txtNombre.getText();
            obj.rubricadeevaluacion = ruta_archivo;
            obj.fechadeinicio = inicio;
            obj.fechadevencimiento = vencimiento;
            obj.porcentajedevaloracion = txtPonderacion.getText();
            obj.descripcion = txtDescripcion.getText();
            obj.idperfil = CmbTipoPerfil.getSelectedIndex();
//            obj.idgrado = CmbGrado.getSelectedIndex();
            if (obj.PerfilNuevaResultSet()== true) {
                JOptionPane.showMessageDialog(this, "Perfil ingresado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Perfil no pudo ser ingresado");
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
        Cal1 = new GregorianCalendar();
        Cal1.setTime(date2);
        String vencimiento = String.valueOf(Cal1.get(Calendar.YEAR) + "/" + (Cal1.get(Calendar.MONTH) + 1)+ "/" + Cal1.get(Calendar.DAY_OF_MONTH));

        //Update
        obj.ID = Integer.parseInt(txtId.getText());
        obj.nombre = txtNombre.getText();
        obj.rubricadeevaluacion = ruta_archivo;
        obj.fechadeinicio = inicio;
        obj.fechadevencimiento = vencimiento;
        obj.porcentajedevaloracion = txtPonderacion.getText();
        obj.descripcion = txtDescripcion.getText();
        obj.idperfil = CmbTipoPerfil.getSelectedIndex();
//        obj.idgrado = CmbGrado.getSelectedIndex();
        if (obj.ActualizarPerfil()== true) {
            JOptionPane.showMessageDialog(this, "Docente actualizado correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
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
                CProfiles objProfDel = new CProfiles(Integer.parseInt(txtId.getText()));

                boolean valor = objProfDel.EliminarTareaController();
                if ( valor == true) {
                    JOptionPane.showMessageDialog(this, "Perfil eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
        
        customization.setUIFont(new javax.swing.plaf.FontUIResource("Poppins",Font.PLAIN,12));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new frmProfiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbTipoPerfil;
    private javax.swing.JTable JTPerfil;
    private customizeObjects.ButtonRound btnEliminar;
    private customizeObjects.ButtonRound btnModificar;
    private customizeObjects.ButtonRound btnSubir;
    private com.toedter.calendar.JDateChooser dtInicio;
    private com.toedter.calendar.JDateChooser dtVencimiento;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPonderacion;
    // End of variables declaration//GEN-END:variables
}
