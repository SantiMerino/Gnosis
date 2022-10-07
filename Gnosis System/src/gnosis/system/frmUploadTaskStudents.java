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

        lblEstado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(32, 32, 32));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/medal-estateprofile.png"))); // NOI18N
        lblEstado.setText("Estado :");

        btnSubirPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/send-square.png"))); // NOI18N
        btnSubirPDF.setRound(20);
        btnSubirPDF.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnSubirPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirPDFActionPerformed(evt);
            }
        });

        btnLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/link.png"))); // NOI18N
        btnLink.setRound(20);
        btnLink.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkActionPerformed(evt);
            }
        });

        txtNota.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        txtNota.setForeground(new java.awt.Color(32, 32, 32));
        txtNota.setEnabled(false);

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
                .addContainerGap(50, Short.MAX_VALUE))
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

        lblMateriaModulo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblMateriaModulo.setForeground(new java.awt.Color(32, 32, 32));
        lblMateriaModulo.setText("Materia / Modulo ");

        lblDocente.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblDocente.setForeground(new java.awt.Color(32, 32, 32));
        lblDocente.setText("Docentes :");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Archivo :");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 32, 32));
        jLabel7.setText("Link :");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 32, 32));
        jLabel10.setText("Calificación:");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 32, 32));
        jLabel11.setText("/ 10");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Tarea:");

        lblnombreTarea.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblnombreTarea.setForeground(new java.awt.Color(32, 32, 32));
        lblnombreTarea.setText("Actividad de grupos ");

        lblFechaVencimiento.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblFechaVencimiento.setForeground(new java.awt.Color(32, 32, 32));
        lblFechaVencimiento.setText("Fecha de vencimiento:");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(32, 32, 32));
        jLabel13.setText("Instrumento de evaluacion:");

        btnDescargarRubrica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/receive-square.png"))); // NOI18N
        btnDescargarRubrica.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_CLARO);
        btnDescargarRubrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarRubricaActionPerformed(evt);
            }
        });

        btnEliminarTarea.setText("Eliminar");
        btnEliminarTarea.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnEliminarTarea.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        btnEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTareaActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar ");
        btnModificar.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);

        btnSubirTarea.setText("Subir ");
        btnSubirTarea.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnSubirTarea.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        btnSubirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirTareaActionPerformed(evt);
            }
        });

        lblArchivo64.setForeground(java.awt.Color.white);
        lblArchivo64.setText("jLabel14");

        lblLinkStore.setForeground(new java.awt.Color(32, 32, 32));

        lblRubrica64.setForeground(new java.awt.Color(32, 32, 32));

        buttonRound1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-text-black.png"))); // NOI18N
        buttonRound1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        buttonRound1.setRound(20);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblnombreTarea))
                    .addComponent(btnLink, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(btnSubirPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMateriaModulo)
                    .addComponent(lblEstado)
                    .addComponent(lblDocente)
                    .addComponent(lblArchivo64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLinkStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblRubrica64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnDescargarRubrica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblFechaVencimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(1, 1, 1))
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnSubirTarea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnEliminarTarea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(buttonRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(67, Short.MAX_VALUE))))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblnombreTarea))
                        .addGap(18, 18, 18)
                        .addComponent(lblMateriaModulo)
                        .addGap(28, 28, 28)
                        .addComponent(lblDocente))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaVencimiento)
                            .addComponent(lblEstado))))
                .addGap(36, 36, 36)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescargarRubrica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblRubrica64, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubirTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubirPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblArchivo64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLink, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLinkStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );

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
