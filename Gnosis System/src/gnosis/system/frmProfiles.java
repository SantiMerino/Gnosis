/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CProfiles;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
    private List SeccionesPerfilList;
    private Calendar Cal1;
    private Calendar Cal2;
    private String ruta_archivo = " ";
    
    /**
     * Creates new form frmProfiles
     */
    public frmProfiles() {
        initComponents();
        CargarCmbTipoPerfil();
        CargarCmbGradoPerfil();
        CargarCmbSeccionPerfil();
        
        //Tabla
        String [] TitulosPerfil = {"ID", "Nombre", "Rubrica de evaluacion", "Fecha de inicio", "Fecha de vencimiento", "Porcentaje de valoracion",  "Descripcion", "Tipo Perfil", "Grado", "Seccione"};
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
        CmbGrado.setSelectedIndex(0);
        CmbSecciones.setSelectedIndex(0);
    }
    
    final void CargarTabla(){
        CProfiles Perfil = new CProfiles();
        while (TablaPerfilmodelo.getRowCount() > 0) {
            TablaPerfilmodelo.removeRow(0);           
        }
        try {
            ResultSet rs = Perfil.CargarPerfilResultSet();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idtperfil"), rs.getString("nombre"), rs.getString("rubricadeevaluacion"), rs.getString("fechadeinicio"), rs.getString("fechadevencimiento"), rs.getString("porcentajedevaloracion"), rs.getString("descripcion"), rs.getInt("idtipoperfil"), rs.getInt("idgrado"), rs.getInt("idseccion")};
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
                JOptionPane.showMessageDialog(BtnEliminar, "No existen grados por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
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
                    CmbGrado.setModel(GradoPerfilcombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen grados por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(BtnEliminar, "No se ha podido cargar datos, favor consulta con el adminstrador del sistema.", "Error crítico", JOptionPane.ERROR_MESSAGE);
        }//End catch
    }//End method
    
    final void CargarCmbSeccionPerfil() {
        //Crear objetos de la clase ControllerBiblioteca
        CProfiles objCargarSeccionPerfil;
        objCargarSeccionPerfil = new CProfiles();
        //Lista donde se guardarán los IDs
        SeccionesPerfilList = new ArrayList();
        try {
            //Guardar en la variable rs los valores retornados por el modelo
            ResultSet rs;
            rs = objCargarSeccionPerfil.CargarSeccionesPefilResultSet();
            //Verificamos si el resultset tiene datos
            if (rs.next()) {
                //Instanaciamos modelo combo para el combobox
                SeccionesPerfilcombo = new DefaultComboBoxModel<>();
                //Se agrega opción por defecto
                SeccionesPerfilcombo.addElement("Elija una opción");
                do {
                    //Se guarda en la lista el id tipo de archivo
                    SeccionesPerfilList.add(rs.getInt("idseccion"));
                    //Se agrega en el combobox el valor del campo tipo de archivo
                    SeccionesPerfilcombo.addElement(rs.getString("seccion"));
                    //Se asigna el modelo combo al combobox
                    CmbSecciones.setModel(SeccionesPerfilcombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(BtnEliminar, "No existen grados por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
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
        BtnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CmbTipoPerfil = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dtVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtPonderacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CmbGrado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        CmbSecciones = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        BtnVaciarCampos = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnSubir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTPerfil = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTipoPerfil = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtSecciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Perfil:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 37, -1, -1));

        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 11, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 33, 242, -1));

        jLabel3.setText("Rubrica o instrumento de evaluacion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 11, -1, -1));

        BtnBuscar.setText("Buscar archivo");
        jPanel1.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 33, 210, -1));

        jLabel4.setText("Tipo perfil:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 83, -1, -1));

        CmbTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CmbTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 105, 257, -1));

        jLabel5.setText("Fecha de inicio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 155, -1, -1));
        jPanel1.add(dtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 177, 292, -1));

        jLabel6.setText("Fecha de vencimiento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 232, -1, -1));
        jPanel1.add(dtVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 262, 292, -1));

        jLabel7.setText("Ponderacion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 352, -1, -1));
        jPanel1.add(txtPonderacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 374, 165, -1));

        jLabel8.setText("Grado:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 83, -1, -1));

        CmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CmbGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 108, 221, -1));

        jLabel9.setText("Secciones:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 155, -1, -1));

        CmbSecciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(CmbSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 177, 221, -1));

        jLabel10.setText("Descripcion o indicaciones:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 232, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 262, -1, 136));

        BtnVaciarCampos.setText("Vaciar campos");
        jPanel1.add(BtnVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 33, -1, -1));

        BtnModificar.setText("Modificar");
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 105, 110, -1));

        BtnEliminar.setText("Eliminar");
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 155, 110, -1));

        BtnSubir.setText("Subir");
        BtnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 224, 110, -1));

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
        jScrollPane2.setViewportView(JTPerfil);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 857, 264));

        jLabel11.setText("Id perfil:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 50, -1));
        jPanel1.add(txtTipoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 20, -1));
        jPanel1.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 20, -1));
        jPanel1.add(txtSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 20, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubirActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BtnSubirActionPerformed

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
            java.util.logging.Logger.getLogger(frmProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProfiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProfiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnSubir;
    private javax.swing.JButton BtnVaciarCampos;
    private javax.swing.JComboBox<String> CmbGrado;
    private javax.swing.JComboBox<String> CmbSecciones;
    private javax.swing.JComboBox<String> CmbTipoPerfil;
    private javax.swing.JTable JTPerfil;
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
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPonderacion;
    private javax.swing.JTextField txtSecciones;
    private javax.swing.JTextField txtTipoPerfil;
    // End of variables declaration//GEN-END:variables
}
