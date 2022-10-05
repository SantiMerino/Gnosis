/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CConnection;
import Controller.CTasks;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class frmUploadTaskTeacher extends javax.swing.JFrame {

    /**
     * Creates new form frmUploadTaskTeacher
     */
    CTasks controlador = new CTasks();
    ResultSet datosCargar;
    DefaultTableModel tablaModel;
    int iddocentelog;
    int idtareaSelec;
    String pdf;
    String link;
    String nombreTarea;
    String nombreAlumno;
    
    
    public frmUploadTaskTeacher() {
        initComponents();
    }
    
    public frmUploadTaskTeacher(int idtarea, int iddocente, String materimodulo){
        initComponents();
        lblIDTareaAlumno.setVisible(false);
        iddocentelog = iddocente;
        idtareaSelec = idtarea;
        String [] TitulosDocentes = {"Alumno", "Tarea", "Archivo", "Link", "Nota", "ID"};
        tablaModel = new DefaultTableModel(null, TitulosDocentes);
        tablaTareas.setModel(tablaModel);
        CargarTabla();
        MateriaColor(materimodulo);
        tablaTareas.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaTareas.getColumnModel().getColumn(5).setMinWidth(0);
        lblTarea64.setVisible(false);
        lblTareaLink.setVisible(false);
    }
    
    final void CargarTabla(){
        CTasks docent = new CTasks();
        while (tablaModel.getRowCount() > 0) {
            tablaModel.removeRow(0);           
        }
        try {
            datosCargar = docent.CargarTareasTablaCalificar(iddocentelog, idtareaSelec);
            while (datosCargar.next()) {                
                Object [] oValores = {datosCargar.getString(1), datosCargar.getString(2), datosCargar.getString(3), datosCargar.getString(4), datosCargar.getDouble(5), datosCargar.getInt(6)};
                tablaModel.addRow(oValores);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    void MateriaColor(String materiamodulo){
        Color mainColor;
        Color secondColor;
        Color fontColor;
        
        switch (materiamodulo) {
            case "Sociales":
                mainColor = new Color(98, 148, 244);
                secondColor = new Color(149, 184, 252);
                fontColor = new Color(32,32,32);
                break;
            case "Matemáticas":
                mainColor = new Color(255, 153, 0);
                secondColor = new Color(255, 182, 73);
                fontColor = new Color(32,32,32);
                break;
            case "Ingles":
                mainColor = new Color(255, 189, 62);
                secondColor = new Color(255, 198, 87);
                fontColor = new Color(32,32,32);
                break;
            case "Ciencias":
                mainColor = new Color(127, 211, 106);
                secondColor = new Color(152, 215, 136);
                fontColor = new Color(32,32,32);
                break;
            case "Lenguaje":
                mainColor = new Color(227, 63, 63);
                secondColor = new Color(231, 87, 87);
                fontColor = new Color(255,255,255);
                break;
            default:
                mainColor = new Color(32,32,32);
                secondColor = new Color(90,90,90);
                fontColor = new Color(255,255,255);
                break;
        }
        
        pantareaColor.setBackground(mainColor);
        lblTarea.setForeground(fontColor);
    }
    
    void AbrirLinks(String link) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(link);
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void decodePdf(String pdf) throws IOException {
        byte[] decoded = java.util.Base64.getDecoder().decode(pdf);
        String home = System.getProperty("user.home");
        String fileName = nombreAlumno + " " +nombreTarea  + ".pdf";
        File rutaFile = new File(home + "/Downloads/" + fileName);
        FileOutputStream fos = new FileOutputStream(rutaFile);
        fos.write(decoded);
        fos.flush();
        fos.close();
        customization.notificacion("Recurso descargado exitosamente", 1, "Confirmación de descarga" );
//        AbrirLinks(rutaFile.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        lblEstudiante = new javax.swing.JLabel();
        buttonRound2 = new customizeObjects.ButtonRound();
        buttonRound3 = new customizeObjects.ButtonRound();
        txtGrade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        buttonRound5 = new customizeObjects.ButtonRound();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblTarea64 = new javax.swing.JLabel();
        lblTareaLink = new javax.swing.JLabel();
        lblIDTareaAlumno = new javax.swing.JLabel();
        buttonRound1 = new customizeObjects.ButtonRound();
        jPanel3 = new javax.swing.JPanel();
        pantareaColor = new customizeObjects.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        lblTarea = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(803, 530));

        tablaTareas.setForeground(new java.awt.Color(32, 32, 32));
        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTareasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTareas);

        lblEstudiante.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblEstudiante.setForeground(new java.awt.Color(32, 32, 32));
        lblEstudiante.setText("Estudiante:");

        buttonRound2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/receive-square-white.png"))); // NOI18N
        buttonRound2.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        buttonRound3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/link.png"))); // NOI18N
        buttonRound3.setToolTipText("");
        buttonRound3.setStyle(customizeObjects.ButtonRound.ButtonStyle.SOCIALES);
        buttonRound3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound3ActionPerformed(evt);
            }
        });

        txtGrade.setForeground(new java.awt.Color(32, 32, 32));
        txtGrade.setText("00.0");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Calificación: ");

        buttonRound5.setText("Calificar");
        buttonRound5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        buttonRound5.setRound(20);
        buttonRound5.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        buttonRound5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound5ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search-normal-black.png"))); // NOI18N

        lblTarea64.setForeground(new java.awt.Color(32, 32, 32));
        lblTarea64.setText("jLabel3");

        lblTareaLink.setForeground(new java.awt.Color(32, 32, 32));
        lblTareaLink.setText("jLabel4");

        lblIDTareaAlumno.setForeground(new java.awt.Color(32, 32, 32));
        lblIDTareaAlumno.setText("jLabel3");

        buttonRound1.setText("Generar Reporte");
        buttonRound1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        buttonRound1.setRound(20);
        buttonRound1.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblIDTareaAlumno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRound2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRound3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEstudiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(buttonRound5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblTareaLink, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTarea64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblIDTareaAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblTarea64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTareaLink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(buttonRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(860, 60));

        pantareaColor.setBackground(new java.awt.Color(77, 77, 77));
        pantareaColor.setRoundBottomLeft(30);
        pantareaColor.setRoundBottomRight(30);
        pantareaColor.setRoundTopLeft(30);
        pantareaColor.setRoundTopRight(30);
        pantareaColor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    Tareas >");
        pantareaColor.add(jLabel1);

        lblTarea.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblTarea.setForeground(new java.awt.Color(255, 255, 255));
        lblTarea.setText("Tarea a revisar");
        pantareaColor.add(lblTarea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pantareaColor, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pantareaColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound5ActionPerformed
        // TODO add your handling code here:
        double nota = Double.parseDouble(txtGrade.getText());
        int id = Integer.parseInt(lblIDTareaAlumno.getText());
        boolean respuesta = controlador.CalificarTask(nota, id);
        if (respuesta == true) {
            customization.notificacion("La nota fue ingresada", 1, "Confirmación");
        }
    }//GEN-LAST:event_buttonRound5ActionPerformed

    private void tablaTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTareasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            nombreAlumno =rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString();
            lblEstudiante.setText("<html><center> Estudiante: " + nombreAlumno +"</center></html>");
            txtGrade.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            lblTareaLink.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            lblTarea64.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            pdf = rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString();
            System.out.println(pdf);
            link = rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString();     
            nombreTarea = rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString();
            lblIDTareaAlumno.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_tablaTareasMouseClicked

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        // TODO add your handling code here:
        try {
            decodePdf(pdf);
            System.out.println(pdf);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No fue posible descargar la tarea " + ex.toString());
        }
    }//GEN-LAST:event_buttonRound2ActionPerformed

    private void buttonRound3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound3ActionPerformed
        // TODO add your handling code here:
        AbrirLinks(link);
    }//GEN-LAST:event_buttonRound3ActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
         Connection conn = CConnection.getConnectionControllerWithoutParameters();
          
          try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteTareaDocente.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer (jprint , false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmStudentsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonRound1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmUploadTaskTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUploadTaskTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUploadTaskTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUploadTaskTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUploadTaskTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound buttonRound1;
    private customizeObjects.ButtonRound buttonRound2;
    private customizeObjects.ButtonRound buttonRound3;
    private customizeObjects.ButtonRound buttonRound5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblIDTareaAlumno;
    private javax.swing.JLabel lblTarea;
    private javax.swing.JLabel lblTarea64;
    private javax.swing.JLabel lblTareaLink;
    private customizeObjects.PanelRound pantareaColor;
    private javax.swing.JTable tablaTareas;
    private javax.swing.JTextField txtGrade;
    // End of variables declaration//GEN-END:variables
}
