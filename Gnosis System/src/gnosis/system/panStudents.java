/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gnosis.system;

import Controller.CComboboxEstudiantes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author santi
 */
public class panStudents extends javax.swing.JPanel {

    /**
     * Creates new form panStudents
     */
    String carnetal;
    
    DefaultTableModel tablaModel;
    public panStudents() {
        initComponents();
        
        String [] TitulosDocentes = {"ID", "Apellidos", "Nombres", "Genero", "Grado", "Correo",  "Direccion", "Contacto", "DUI", "Nacimiento", "Carnet"};
        tablaModel = new DefaultTableModel(null, TitulosDocentes);
        tbEstudiantes.setModel(tablaModel);
        CargarTabla();
        
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtCarnet = new javax.swing.JTextField();
        btnAgregar = new roundObjects.ButtonRound();
        btnModificar = new roundObjects.ButtonRound();
        btnEliminar = new roundObjects.ButtonRound();
        btnReporteEsc = new roundObjects.ButtonRound();
        btnNomina = new roundObjects.ButtonRound();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        tbEstudiantes.setBackground(java.awt.Color.white);
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
        tbEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEstudiantes);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(726, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        txtCarnet.setEditable(false);
        txtCarnet.setBackground(new java.awt.Color(255, 255, 255));
        txtCarnet.setForeground(new java.awt.Color(0, 0, 0));
        txtCarnet.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel1.add(txtCarnet);

        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAgregar.setRound(20);
        btnAgregar.setStyle(roundObjects.ButtonRound.ButtonStyle.VERDE);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);

        btnModificar.setText("Modificar");
        btnModificar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnModificar.setRound(20);
        btnModificar.setStyle(roundObjects.ButtonRound.ButtonStyle.AMARILLO);
        jPanel1.add(btnModificar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnEliminar.setRound(20);
        btnEliminar.setStyle(roundObjects.ButtonRound.ButtonStyle.ROJO);
        jPanel1.add(btnEliminar);

        btnReporteEsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user-square.png"))); // NOI18N
        btnReporteEsc.setPreferredSize(new java.awt.Dimension(40, 40));
        btnReporteEsc.setStyle(roundObjects.ButtonRound.ButtonStyle.GRIS_ROJO);
        btnReporteEsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteEscActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporteEsc);

        btnNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-text.png"))); // NOI18N
        btnNomina.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNomina.setRound(20);
        btnNomina.setStyle(roundObjects.ButtonRound.ButtonStyle.GRIS_ROJO);
        btnNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNominaActionPerformed(evt);
            }
        });
        jPanel1.add(btnNomina);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setPreferredSize(new java.awt.Dimension(726, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        new frmStudentsCRUD().setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tbEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEstudiantesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            txtCarnet.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 10).toString());
            carnetal = txtCarnet.getText();
//            btnModificar.setEnabled(true);
//            btnEliminar.setEnabled(true);
//            btnAgregar.setEnabled(false);
        }
    }//GEN-LAST:event_tbEstudiantesMouseClicked

    private void btnNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNominaActionPerformed
        // TODO add your handling code here:
        Connection conexion = Controller.CConnection.getConnectionControllerWithoutParameters();
        try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteAlumnos.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); 
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conexion);         
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
        } catch (JRException ex) {
           JOptionPane.showMessageDialog(null, "cagaste");
        }
        
        
    }//GEN-LAST:event_btnNominaActionPerformed

    private void btnReporteEscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteEscActionPerformed
        // TODO add your handling code here:
        Connection conexion = Controller.CConnection.getConnectionControllerWithoutParameters();       
        try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteDeAlumno.jasper";
            Map param = new HashMap();
            param.put("codigocarnet", txtCarnet.getText());
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); 
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, param, conexion);         
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
        } catch (JRException ex) {
           JOptionPane.showMessageDialog(null, "cagaste");
        }
        
    }//GEN-LAST:event_btnReporteEscActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private roundObjects.ButtonRound btnAgregar;
    private roundObjects.ButtonRound btnEliminar;
    private roundObjects.ButtonRound btnModificar;
    private roundObjects.ButtonRound btnNomina;
    private roundObjects.ButtonRound btnReporteEsc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEstudiantes;
    private javax.swing.JTextField txtCarnet;
    // End of variables declaration//GEN-END:variables
}
