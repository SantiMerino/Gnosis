/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CConnection;
import Controller.CTasks;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import customizeObjects.ButtonRound;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class frmUploadTaskStudents extends javax.swing.JFrame {

    /**
     * Creates new form frmUploadTaskStudents
     */
    ResultSet datosCargar;
    ResultSet datosAlumno;
    CTasks controlador = new CTasks();
    int idtareaSelec;
    int idalumnolog;
    String link;
    String pdf;
    String rutadescarga;
    customization custo = new customization();
    
    public frmUploadTaskStudents() {
        initComponents();
        lblArchivo64.setVisible(false);
        lblRubrica64.setVisible(false);    
    }

    public frmUploadTaskStudents(int idtarea, int idalumno) {
        initComponents();
        customization.mainUtilitiesWhite();
        idalumnolog = idalumno;
        idtareaSelec = idtarea;
        lblArchivo64.setVisible(false);
        lblLinkStore.setVisible(false);
        lblRubrica64.setVisible(false);
        CargarDatos(idtarea, idalumno);
        CargarDatosAlumno(idtarea, idalumno);
        btnSubirPDF.setStyle(ButtonRound.ButtonStyle.GRIS_CLARO);
        btnLink.setStyle(ButtonRound.ButtonStyle.GRIS_CLARO);
    }
    
    final void CargarDatos(int id, int idalumno){
        datosCargar = controlador.CargarTareasFull(id);
        try {
            String materiamodulo;
            String cadena = datosCargar.getString(4);
            String[] palabras = cadena.split(" ", 2);
            if (palabras[0].equals("Ninguno")) {
                materiamodulo = "Módulo: " + palabras[1];
            } else {
                materiamodulo = "Materia: " + cadena.substring(0, cadena.lastIndexOf(" "));
            }
            lblnombreTarea.setText(datosCargar.getString(1));
            lblFechaVencimiento.setText("Fecha de Cierre: " + datosCargar.getString(3));
            lblMateriaModulo.setText(materiamodulo);
            lblDocente.setText("Docente: " + datosCargar.getString(5));
            lblEstado.setText(datosCargar.getString(6));
            IconoEstado(datosCargar.getString(6));
            lblRubrica64.setText(datosCargar.getString(7));
            lblPorcentaje.setText(datosCargar.getString(8) + "%");
            lblTipoPerfil.setText(datosCargar.getString(9));
        } catch (SQLException ex) {
            customization.notificacion("Hubo un error al abrir la tarea", 2, "Advertencia");
//            JOptionPane.showMessageDialog(null, "No has entregado la tarea aun" + ex.toString());
        }
    }
    
    final void CargarDatosAlumno(int idtarea, int idalumno){
        datosAlumno = controlador.CargarDatosAlumnoTarea(idtarea, idalumno);
        try {
            while (datosAlumno.next()) {
                lblArchivo64.setText(datosAlumno.getString(4));
                lblLinkStore.setText(datosAlumno.getString(5));
                txtNota.setText(String.valueOf(datosAlumno.getDouble(6)));
                System.out.println(datosAlumno.getString(6));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de consulta " + e.toString());
            customization.notificacion("La tarea no ha sido subida, compartela con tu profesor", 2, "Advertencia");
        }
    }
    
    
    void IconoEstado(String estado){
        switch (estado) {
            case "Completado":
                custo.changeIconlbl(lblEstado, "/resources/check.png");
                break;
                
            case "Calificado":
                custo.changeIconlbl(lblEstado, "/resources/medal-estateprofile.png");
                break;
                
            case "No entregado":
                custo.changeIconlbl(lblEstado, "/resources/close-square-state.png");
                break;
                
            case "En proceso":
                custo.changeIconlbl(lblEstado, "/resources/more-square-state.png");
                break;
                
            case "Urgente":
                custo.changeIconlbl(lblEstado, "/resources/danger-state.png");
                break;
                
            case "No disponible":
                custo.changeIconlbl(lblEstado, "/resources/slash.png");
                break;
                
            default:
                throw new AssertionError();
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

        panelPrincipal = new customizeObjects.PanelRound();
        lblEstado = new javax.swing.JLabel();
        btnSubirPDF = new customizeObjects.ButtonRound();
        btnLink = new customizeObjects.ButtonRound();
        txtNota = new javax.swing.JTextField();
        panelRound2 = new customizeObjects.PanelRound();
        lblTipoPerfil = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblMateriaModulo = new javax.swing.JLabel();
        lblDocente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblnombreTarea = new javax.swing.JLabel();
        lblFechaVencimiento = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnDescargarRubrica = new customizeObjects.ButtonRound();
        btnEliminarTarea = new customizeObjects.ButtonRound();
        btnModificar = new customizeObjects.ButtonRound();
        btnSubirTarea = new customizeObjects.ButtonRound();
        lblArchivo64 = new javax.swing.JLabel();
        lblLinkStore = new javax.swing.JLabel();
        lblRubrica64 = new javax.swing.JLabel();
        buttonRound1 = new customizeObjects.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setRoundBottomLeft(20);
        panelPrincipal.setRoundBottomRight(20);
        panelPrincipal.setRoundTopLeft(20);
        panelPrincipal.setRoundTopRight(20);
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEstado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(32, 32, 32));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/medal-estateprofile.png"))); // NOI18N
        lblEstado.setText("Estado :");
        panelPrincipal.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 186, -1, -1));

        btnSubirPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/send-square.png"))); // NOI18N
        btnSubirPDF.setRound(20);
        btnSubirPDF.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnSubirPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirPDFActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnSubirPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 282, 283, 40));

        btnLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/link.png"))); // NOI18N
        btnLink.setRound(20);
        btnLink.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 396, 283, 40));

        txtNota.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        txtNota.setForeground(new java.awt.Color(32, 32, 32));
        txtNota.setEnabled(false);
        panelPrincipal.add(txtNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 118, 82, 40));

        panelRound2.setBackground(new java.awt.Color(32, 32, 32));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        lblTipoPerfil.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lblTipoPerfil.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoPerfil.setText("Actividad de cotidiana ");

        lblPorcentaje.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        lblPorcentaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentaje.setText("10%");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTipoPerfil)
                .addGap(44, 44, 44)
                .addComponent(lblPorcentaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoPerfil)
                    .addComponent(lblPorcentaje))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 29, 290, -1));

        lblMateriaModulo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblMateriaModulo.setForeground(new java.awt.Color(32, 32, 32));
        lblMateriaModulo.setText("Materia / Modulo ");
        panelPrincipal.add(lblMateriaModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 78, -1, -1));

        lblDocente.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblDocente.setForeground(new java.awt.Color(32, 32, 32));
        lblDocente.setText("Docentes :");
        panelPrincipal.add(lblDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 128, -1, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Archivo :");
        panelPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 254, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 32, 32));
        jLabel7.setText("Link :");
        panelPrincipal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 368, -1, -1));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Calificación:");
        panelPrincipal.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 127, -1, -1));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setText("/ 10");
        panelPrincipal.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 127, -1, -1));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Tarea:");
        panelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 23, -1, -1));

        lblnombreTarea.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblnombreTarea.setForeground(new java.awt.Color(32, 32, 32));
        lblnombreTarea.setText("Actividad de grupos ");
        panelPrincipal.add(lblnombreTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 34, -1, -1));

        lblFechaVencimiento.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblFechaVencimiento.setForeground(new java.awt.Color(32, 32, 32));
        lblFechaVencimiento.setText("Fecha de vencimiento:");
        panelPrincipal.add(lblFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 191, 280, -1));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(32, 32, 32));
        jLabel13.setText("Instrumento de evaluacion:");
        panelPrincipal.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 254, -1, -1));

        btnDescargarRubrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/receive-square.png"))); // NOI18N
        btnDescargarRubrica.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnDescargarRubrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarRubricaActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnDescargarRubrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 282, 270, 40));

        btnEliminarTarea.setText("Eliminar");
        btnEliminarTarea.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnEliminarTarea.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        btnEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTareaActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnEliminarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 131, -1));

        btnModificar.setText("Modificar ");
        btnModificar.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);
        panelPrincipal.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 120, -1));

        btnSubirTarea.setText("Subir ");
        btnSubirTarea.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnSubirTarea.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        btnSubirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirTareaActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnSubirTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 131, -1));

        lblArchivo64.setForeground(java.awt.Color.white);
        lblArchivo64.setText("jLabel14");
        panelPrincipal.add(lblArchivo64, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 340, 283, -1));

        lblLinkStore.setForeground(new java.awt.Color(32, 32, 32));
        panelPrincipal.add(lblLinkStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 442, 283, 21));

        lblRubrica64.setForeground(new java.awt.Color(32, 32, 32));
        panelPrincipal.add(lblRubrica64, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 323, 330, 20));

        buttonRound1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-text-black.png"))); // NOI18N
        buttonRound1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        buttonRound1.setRound(20);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });
        panelPrincipal.add(buttonRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 120, 38));

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarTareaActionPerformed

    private void btnSubirPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirPDFActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter(".PDF", ".pdf");
        browseImageFile.addChoosableFileFilter(fnef);
        int num = browseImageFile.showOpenDialog(null);

        if (num == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            byte[] inFileBytes;
            try {
                inFileBytes = Files.readAllBytes(Paths.get(selectedImagePath));
                byte[] encoded = java.util.Base64.getEncoder().encode(inFileBytes);
                pdf = Base64.getEncoder().encodeToString(inFileBytes);
//                decodePdf();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Cagaste");
            }

            lblArchivo64.setText(pdf);
            btnSubirPDF.setStyle(ButtonRound.ButtonStyle.ROJO);
        }
    }//GEN-LAST:event_btnSubirPDFActionPerformed

    
    private void btnLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkActionPerformed
        // TODO add your handling code here:
        link = JOptionPane.showInputDialog("Ingresa el link: ", "www.link.com");
        lblLinkStore.setText(link);
        btnLink.setStyle(ButtonRound.ButtonStyle.SOCIALES);
    }//GEN-LAST:event_btnLinkActionPerformed

    private void btnSubirTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirTareaActionPerformed
        // TODO add your handling code here:
        boolean respuesta = controlador.UploadTaskStudents(idtareaSelec, idalumnolog, pdf, link);
//        System.out.println(idalumnolog);
        if (respuesta == true) {
            customization.notificacion("La tarea fue subida exitosamente", 1, "Confirmación");
        }else{
            JOptionPane.showInternalMessageDialog(null, "La tarea no pudo ser subida correctamente, intentalo de nuevo");
        }
    }//GEN-LAST:event_btnSubirTareaActionPerformed

    private void btnDescargarRubricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarRubricaActionPerformed
        // TODO add your handling code here:
//        System.out.println(lblRubrica64.getText());
        pdf = lblRubrica64.getText();
        try {
            DescargarRubrica();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo descargar la rubrica");
        }
    }//GEN-LAST:event_btnDescargarRubricaActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        
         Connection conn = CConnection.getConnectionControllerWithoutParameters();
          
          try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteTareaAlumno.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer (jprint , false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmStudentsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonRound1ActionPerformed
    
    private void DescargarRubrica() throws IOException {
        byte[] decoded = java.util.Base64.getDecoder().decode(pdf);
        String home = System.getProperty("user.home");
        String fileName = "Rubrica " + lblnombreTarea.getText() + ".pdf";
        File rutaFile = new File(home + "/Downloads/" + fileName);
        FileOutputStream fos = new FileOutputStream(rutaFile);
        fos.write(decoded);
        fos.flush();
        fos.close();
    }
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
        UIManager.put( "ProgressBar.arc", 15);
        UIManager.put( "ScrollBar.trackArc", 999 );
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        UIManager.put( "Component.arrowType", "chevron" );
        customization.setUIFont(new javax.swing.plaf.FontUIResource("Poppins",Font.PLAIN,12));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUploadTaskStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound btnDescargarRubrica;
    private customizeObjects.ButtonRound btnEliminarTarea;
    private customizeObjects.ButtonRound btnLink;
    private customizeObjects.ButtonRound btnModificar;
    private customizeObjects.ButtonRound btnSubirPDF;
    private customizeObjects.ButtonRound btnSubirTarea;
    private customizeObjects.ButtonRound buttonRound1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblArchivo64;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblLinkStore;
    private javax.swing.JLabel lblMateriaModulo;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblRubrica64;
    private javax.swing.JLabel lblTipoPerfil;
    private javax.swing.JLabel lblnombreTarea;
    private customizeObjects.PanelRound panelPrincipal;
    private customizeObjects.PanelRound panelRound2;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
