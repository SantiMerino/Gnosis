/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CConnection;
import Controller.CTasks;
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
    DefaultComboBoxModel<String> TipoArchivocombo;
    DefaultComboBoxModel<String> Categoriacombo;
    DefaultComboBoxModel<String> Gradocombo;
    DefaultComboBoxModel<String> Especialidadcombo;
    private List TipoArchivoList;
    private List CategoriaList;
    private List GradoList;
    private List EspecialidadList;
    private Calendar Cal1;
    private Calendar Cal2;
    private String ruta_archivo = " ";
    
    /**
     * Creates new form frmTasks
     */
    public frmTasks() {
        initComponents();
        CargarCmbCategoria();
        CargarCmbEspecialidades();
        CargarCmbGrados();
        CargarCmbTipoArchivo();
        
        //Tabla
        String [] TitulosTarea = {"ID", "Nombre", "Etapa", "Fecha de inicio", "Fecha de vencimiento", "Ponderacion",  "Instrumento de evaluacion", "Tipo Archivo", "Categoria", "Grado", "Especialidad"};
        Tablamodelo = new DefaultTableModel(null, TitulosTarea);
        JTTask.setModel(Tablamodelo);
        CargarTabla();
    }
    
    void LimpiarCampos() {
        txtNombre.setText("");
        txtEtapa.setText("");
        txtPonderacion.setText("");
        txtId.setText("");
        dtInicio.setDate(null);
        dtVencimiento.setDate(null);
        CmbTipoArchivo.setSelectedIndex(0);
        CmbCategoria.setSelectedIndex(0);
        CmbGrado.setSelectedIndex(0);
        CmbEspecialidad.setSelectedIndex(0);
    }
    
    final void CargarTabla(){
        CTasks Task = new CTasks();
        while (Tablamodelo.getRowCount() > 0) {
            Tablamodelo.removeRow(0);           
        }
        try {
            ResultSet rs = Task.CCargarTareas();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idtarea"), rs.getString("nombre"), rs.getString("etapa"), rs.getString("fechadeinicio"), rs.getString("fechadevencimiento"), rs.getString("ponderacion"), rs.getString("instrumentodeevaluacion"), rs.getInt("idtipoarchivo"), rs.getInt("idcategoria"), rs.getInt("idgrado"), rs.getInt("idespecialidad")};
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
    
    final void CargarCmbTipoArchivo() {
        //Crear objetos de la clase ControllerBiblioteca
        CTasks objCargarTipoArchivo;
        objCargarTipoArchivo = new CTasks();
        //Lista donde se guardarán los IDs
        TipoArchivoList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarTipoArchivo.CargarTipoArchivoResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                TipoArchivocombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                TipoArchivocombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    TipoArchivoList.add(rs.getInt("idtipoarchivo"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    TipoArchivocombo.addElement(rs.getString("tipoarchivo"));
                    //Se asigna el modelo combo al combobox
                    CmbTipoArchivo.setModel(TipoArchivocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen grados por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbCategoria() {
        //Crear objetos de la clase ControllerBiblioteca
        CTasks objCargarCategoria;
        objCargarCategoria = new CTasks();
        //Lista donde se guardarán los IDs
        CategoriaList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarCategoria.CargarCatergoriaResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                Categoriacombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                Categoriacombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    CategoriaList.add(rs.getInt("idcategoria"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    Categoriacombo.addElement(rs.getString("categoria"));
                    //Se asigna el modelo combo al combobox
                    CmbCategoria.setModel(Categoriacombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen categorias por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbGrados() {
        //Crear objetos de la clase ControllerBiblioteca
        CTasks objCargarGrados;
        objCargarGrados = new CTasks();
        //Lista donde se guardarán los IDs
        GradoList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarGrados.CargarGradosResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                Gradocombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                Gradocombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    GradoList.add(rs.getInt("idgrado"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    Gradocombo.addElement(rs.getString("grado"));
                    //Se asigna el modelo combo al combobox
                    CmbGrado.setModel(Gradocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen grados por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbEspecialidades() {
        //Crear objetos de la clase ControllerBiblioteca
        CTasks objCargarEspecialidades;
        objCargarEspecialidades = new CTasks();
        //Lista donde se guardarán los IDs
        EspecialidadList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarEspecialidades.CargarEspecialidadesResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                Especialidadcombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                Especialidadcombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    EspecialidadList.add(rs.getInt("idespecialidad"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    Especialidadcombo.addElement(rs.getString("especialidad"));
                    //Se asigna el modelo combo al combobox
                    CmbEspecialidad.setModel(Especialidadcombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen especialidades por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
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
        jLabel3 = new javax.swing.JLabel();
        txtEtapa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtVencimiento = new com.toedter.calendar.JDateChooser();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        CmbTipoArchivo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPonderacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BtnSeleccionar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        CmbCategoria = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        CmbGrado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        CmbEspecialidad = new javax.swing.JComboBox<>();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnSubir = new javax.swing.JButton();
        BtnVaciarCampos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTTask = new javax.swing.JTable();
        BtnConectare = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTipoArchvo = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tareas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 37, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 14, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 33, 252, -1));

        jLabel3.setText("etapa:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));
        jPanel1.add(txtEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 33, 274, -1));

        jLabel4.setText("fecha de inicio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 92, -1, -1));

        jLabel5.setText("fecha de vencimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 161, -1, -1));
        jPanel1.add(dtVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 183, 268, -1));
        jPanel1.add(dtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 120, 268, -1));

        jLabel6.setText("Tipo de archivo admitido:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 92, -1, -1));

        CmbTipoArchivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoArchivoItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 120, 141, -1));

        jLabel7.setText("Ponderacion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 92, -1, -1));
        jPanel1.add(txtPonderacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 121, 75, -1));

        jLabel8.setText("Intrumento de evualcion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        BtnSeleccionar.setText("Seleccionar rubrica");
        BtnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 240, -1));

        jLabel9.setText("Categoria:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        CmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbCategoriaItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 200, -1));

        jLabel10.setText("Grado:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        CmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbGradoItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 180, -1));

        jLabel11.setText("Especialidad:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        CmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbEspecialidadItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 200, -1));

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
        jPanel1.add(BtnConectare, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 70, -1));

        jLabel12.setText("Id tarea");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));
        jPanel1.add(txtTipoArchvo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));
        jPanel1.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, -1, -1));
        jPanel1.add(txtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, -1, -1));
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 260, -1));

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

    private void CmbTipoArchivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoArchivoItemStateChanged
        // TODO add your handling code here:
        //        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //            int pos = CmbTipoArchivo.getSelectedIndex();
            //            if (pos == 0) {
                //                TipoArchivo = 0;
                //            } else {
                //                int dim = TipoArchivoList.size();
                //                for (int i = 0; i < dim; i++) {
                    //                    TipoArchivo = (int) TipoArchivoList.get(i);
                    //                }
                //            }
            //        }
    }//GEN-LAST:event_CmbTipoArchivoItemStateChanged

    private void BtnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_pdf();
    }//GEN-LAST:event_BtnSeleccionarActionPerformed

    private void CmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbCategoriaItemStateChanged
        // TODO add your handling code here:
        //        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //            int pos = CmbCategoria.getSelectedIndex();
            //            if (pos == 0) {
                //                Categoria = 0;
                //            } else {
                //                int dim = CategoriaList.size();
                //                for (int i = 0; i < dim; i++) {
                    //                    Categoria = (int) CategoriaList.get(i);
                    //                }
                //            }
            //        }
    }//GEN-LAST:event_CmbCategoriaItemStateChanged

    private void CmbGradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbGradoItemStateChanged
        // TODO add your handling code here:
        //        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //            int pos = CmbGrado.getSelectedIndex();
            //            if (pos == 0) {
                //                Grado = 0;
                //            } else {
                //                int dim = GradoList.size();
                //                for (int i = 0; i < dim; i++) {
                    //                    Grado = (int) GradoList.get(i);
                    //                }
                //            }
            //        }
    }//GEN-LAST:event_CmbGradoItemStateChanged

    private void CmbEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbEspecialidadItemStateChanged
        // TODO add your handling code here:
        //        if (evt.getStateChange() == ItemEvent.SELECTED) {
            //            int pos = CmbEspecialidad.getSelectedIndex();
            //            if (pos == 0) {
                //                Especialidad = 0;
                //            } else {
                //                int dim = EspecialidadList.size();
                //                for (int i = 0; i < dim; i++) {
                    //                    Especialidad = (int) EspecialidadList.get(i);
                    //                }
                //            }
            //        }
    }//GEN-LAST:event_CmbEspecialidadItemStateChanged

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
                    JOptionPane.showMessageDialog(this, "Docente eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
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
        obj.ID = Integer.parseInt(txtId.getText());
        obj.nombre = txtNombre.getText();
        obj.etapa = txtEtapa.getText();
        obj.fechadeinicio = inicio;
        obj.fechadevencimiento = vencimiento;
        obj.ponderacion = txtPonderacion.getText();
        obj.instrumentodeevaluacion = ruta_archivo;
        obj.idtipoarchivo = CmbTipoArchivo.getSelectedIndex();
        obj.idcategoria = CmbCategoria.getSelectedIndex();
        obj.idgrado = CmbGrado.getSelectedIndex();
        obj.idespecialidad = CmbEspecialidad.getSelectedIndex();
        if (obj.ActualizarTarea() == true) {
            JOptionPane.showMessageDialog(this, "Tarea actualizada correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubirActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().trim().isEmpty() || txtEtapa.getText().trim().isEmpty() || txtPonderacion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbTipoArchivo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo archivo", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoria", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else if(CmbGrado.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Seleccione un grado", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else if(CmbEspecialidad.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Seleccione una especialidad", "Campos vacios", JOptionPane.WARNING_MESSAGE);
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
            obj.nombre = txtNombre.getText();
            obj.etapa = txtEtapa.getText();
            obj.fechadeinicio = inicio;
            obj.fechadevencimiento = vencimiento;
            obj.ponderacion = txtPonderacion.getText();
            obj.instrumentodeevaluacion = ruta_archivo;
            obj.idtipoarchivo = CmbTipoArchivo.getSelectedIndex();
            obj.idcategoria = CmbCategoria.getSelectedIndex();
            obj.idgrado = CmbGrado.getSelectedIndex();
            obj.idespecialidad = CmbEspecialidad.getSelectedIndex();
            if (obj.TareaNuevaResultSet() == true) {
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

    final int BuscarTipoArchvoSeleccionado(int TipoArch){
        int size = TipoArchivoList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) TipoArchivoList.get(i);
            if (valor == TipoArch) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarCategoriaSeleccionado(int Categoria){
        int size = CategoriaList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) CategoriaList.get(i);
            if (valor == Categoria) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarGradoSeleccionado(int Grado){
        int size = GradoList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) GradoList.get(i);
            if (valor == Grado) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarEspecialidadSeleccionado(int Grado){
        int size = EspecialidadList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) EspecialidadList.get(i);
            if (valor == Grado) {
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
            txtEtapa.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            txtPonderacion.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            txtTipoArchvo.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            txtCategoria.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            txtGrado.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 9).toString());
            txtEspecialidad.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 10).toString());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtInicio.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString()));
            } catch (Exception e) {

            }

            DateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtVencimiento.setDate((Date) simpleDateFormat2.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString()));
            } catch (Exception e) {

            }

            int idTipoArchivo = Integer.parseInt(txtTipoArchvo.getText());
            int idCategoria = Integer.parseInt(txtCategoria.getText());
            int idGrado = Integer.parseInt(txtGrado.getText());
            int idEspecialidad = Integer.parseInt(txtEspecialidad.getText());

            int respuesta = BuscarTipoArchvoSeleccionado(idTipoArchivo);
            int respuesta2 = BuscarCategoriaSeleccionado(idCategoria);
            int respuesta3 = BuscarGradoSeleccionado(idGrado);
            int respuesta4 = BuscarEspecialidadSeleccionado(idEspecialidad);

            CmbTipoArchivo.setSelectedIndex(respuesta + 1);
            CmbCategoria.setSelectedIndex(respuesta2 + 1);
            CmbGrado.setSelectedIndex(respuesta3 + 1);
            CmbEspecialidad.setSelectedIndex(respuesta4 + 1);
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
    private javax.swing.JComboBox<String> CmbCategoria;
    private javax.swing.JComboBox<String> CmbEspecialidad;
    private javax.swing.JComboBox<String> CmbGrado;
    private javax.swing.JComboBox<String> CmbTipoArchivo;
    private javax.swing.JTable JTTask;
    private com.toedter.calendar.JDateChooser dtInicio;
    private com.toedter.calendar.JDateChooser dtVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtEtapa;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPonderacion;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtTipoArchvo;
    // End of variables declaration//GEN-END:variables
}
