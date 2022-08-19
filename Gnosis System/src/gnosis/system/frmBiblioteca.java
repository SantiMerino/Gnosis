/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CBiblioteca;
import Controller.CTeacher;
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
    private String ruta_archivo = " ";
    
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
    }
    
    void LimpiarCampos(){
        txtNombreRecurso.setText("");
        txtLink.setText("");
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
    
    public void seleccionar_pdf(){
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf","pdf"); 
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.BtnBuscar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
        }
    }
    
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
        BtnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtLink = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CmbClasificacion = new javax.swing.JComboBox<>();
        CmbTipoRecurso = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBiblioteca = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTipoClasificacion = new javax.swing.JTextField();
        txtTipoRecurso = new javax.swing.JTextField();
        BtnModificar = new roundObjects.ButtonRound();
        BtnSubir = new roundObjects.ButtonRound();
        BtnEliminar = new roundObjects.ButtonRound();
        BtnVaciarCampos = new roundObjects.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Recurso:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 55, -1, -1));

        jLabel2.setText("Nombre del recurso:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 23, -1, -1));

        txtNombreRecurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreRecursoKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 51, 207, -1));

        jLabel3.setText("Archivo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 108, -1, -1));

        BtnBuscar.setText("Buscar archivo");
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 131, 182, -1));

        jLabel4.setText("Links:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 184, -1, -1));
        jPanel1.add(txtLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 207, 205, -1));

        jLabel5.setText("Tipo de clasificacion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 108, -1, -1));

        CmbClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbClasificacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbClasificacionItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 158, -1));

        CmbTipoRecurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoRecurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoRecursoItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 206, 158, -1));

        jLabel6.setText("Tipo de recurso:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 184, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 650, 150));

        jLabel7.setText("Id Biblioteca:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));
        jPanel1.add(txtTipoClasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, -1, -1));
        jPanel1.add(txtTipoRecurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, -1, -1));

        BtnModificar.setText("Modificar");
        BtnModificar.setStyle(roundObjects.ButtonRound.ButtonStyle.AMARILLO);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 90, -1));

        BtnSubir.setText("Subir");
        BtnSubir.setStyle(roundObjects.ButtonRound.ButtonStyle.VERDE);
        BtnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 100, -1));

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setStyle(roundObjects.ButtonRound.ButtonStyle.ROJO);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 110, -1));

        BtnVaciarCampos.setText("Vaciar campos");
        BtnVaciarCampos.setStyle(roundObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        jPanel1.add(BtnVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

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
            txtLink.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
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
        if (txtNombreRecurso.getText().trim().isEmpty() || txtLink.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbClasificacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una clasificacion", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbTipoRecurso.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo recurso", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            CBiblioteca objBiblioteca = new CBiblioteca(txtNombreRecurso.getText(), idTipoRecurso, idclasificacion, txtLink.getText(), ruta_archivo);
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
        CBiblioteca objUpdate = new CBiblioteca(Integer.parseInt(txtId.getText()), txtNombreRecurso.getText(), idTipoRecurso, idclasificacion, txtLink.getText(), ruta_archivo);
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
            java.util.logging.Logger.getLogger(frmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private roundObjects.ButtonRound BtnEliminar;
    private roundObjects.ButtonRound BtnModificar;
    private roundObjects.ButtonRound BtnSubir;
    private roundObjects.ButtonRound BtnVaciarCampos;
    private javax.swing.JComboBox<String> CmbClasificacion;
    private javax.swing.JComboBox<String> CmbTipoRecurso;
    private javax.swing.JTable JTBiblioteca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLink;
    private javax.swing.JTextField txtNombreRecurso;
    private javax.swing.JTextField txtTipoClasificacion;
    private javax.swing.JTextField txtTipoRecurso;
    // End of variables declaration//GEN-END:variables
}
