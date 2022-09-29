/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CConnection;
import Controller.CEvento;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author josec
 */
public class frmEvento extends javax.swing.JFrame {

    DefaultComboBoxModel<String> modeloTipoEvento;
    DefaultComboBoxModel<String> modeloGrado;
    ArrayList TipoEventoArrayList;
    ArrayList GradoArrayList;
    DefaultTableModel tablaEventoModel;
    private int idTipoEvento = 0;
    private int idGrado = 0;
    private Calendar Cal1;
    private Calendar Cal2;
    
    /**
     * Creates new form frmEvento
     */
    public frmEvento() {
        initComponents();
        CargarCombobox();
        
        txtId.setVisible(false);
        txtTipoEvento.setVisible(false);
        txtGrado.setVisible(false);
        
        //Titulos de la tabla 
        String [] TitulosEventos = {"ID", "Nombre evento", "Fecha de evento", "Hora de inicio", "Fecha final evento", "Hora final",  "Tipo Evento", "Grado"};
        tablaEventoModel = new DefaultTableModel(null, TitulosEventos);
        JTEventos.setModel(tablaEventoModel);
        CargarTabla();
    }
    
    void LimpiarCampos() {
        txtNombreEvento.setText("");
        txtHoraInicio.setText("");
        txtHoraFinal.setText("");
        dtInicio.setDate(null);
        dtVencimiento.setDate(null);
        txtId.setText("");
        CargarCombobox();
    }
    
    final void CargarCombobox() {
        CargarCmbTipoEvento();
        CargarCmbGrado();
    }
    
    final void CargarTabla(){
        CEvento Evento = new CEvento();
        while (tablaEventoModel.getRowCount() > 0) {
            tablaEventoModel.removeRow(0);           
        }
        try {
            ResultSet rs = Evento.CargarEventos();
            while (rs.next()) {                
                Object [] oValores = {rs.getInt("idevento"), rs.getString("nombreevento"), rs.getString("fechaevento"), rs.getString("horainicioevento"), rs.getString("fechafinalevento"), rs.getString("horafinalizarevento"), rs.getInt("idtipoevento"), rs.getInt("idgrado")};
                tablaEventoModel.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    final void CargarCmbTipoEvento(){
        CEvento eventoCmb = new CEvento();
        TipoEventoArrayList = new ArrayList();       
        try {
            ResultSet rs = eventoCmb.CargarTipoEventoResultSet();
            if (rs.next()) {
                modeloTipoEvento = new DefaultComboBoxModel<>();
                modeloTipoEvento.addElement("Elige una opcion");
                do {                    
                    TipoEventoArrayList.add(rs.getInt("idtipoevento"));
                    modeloTipoEvento.addElement(rs.getString("tipoevento"));
                    CmbTipoEvento.setModel(modeloTipoEvento);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los tipos de eventos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
        }
    }
    
    final void CargarCmbGrado(){
        CEvento eventoGrado = new CEvento();
        GradoArrayList = new ArrayList();       
        try {
            ResultSet rs = eventoGrado.CargarGradoResultSet();
            if (rs.next()) {
                modeloGrado = new DefaultComboBoxModel<>();
                modeloGrado.addElement("Elige una opcion");
                do {                    
                    GradoArrayList.add(rs.getInt("idgrado"));
                    modeloGrado.addElement(rs.getString("grado"));
                    CmbGrado.setModel(modeloGrado);
                } while (rs.next());
            } else{
                JOptionPane.showMessageDialog(null, "No se pudo cargar los grados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error critico, consultar al administrador");
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

        panelRound1 = new customizeObjects.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEventos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreEvento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dtInicio = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dtVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHoraFinal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CmbTipoEvento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CmbGrado = new javax.swing.JComboBox<>();
        BtnVaciarCampos = new customizeObjects.ButtonRound();
        BtnEliminar = new customizeObjects.ButtonRound();
        BtnModificar = new customizeObjects.ButtonRound();
        BtnAgregar = new customizeObjects.ButtonRound();
        txtId = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtTipoEvento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        panelRound1.setBackground(java.awt.Color.white);
        panelRound1.setLayout(new java.awt.BorderLayout());

        JTEventos.setModel(new javax.swing.table.DefaultTableModel(
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
        JTEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTEventos);

        panelRound1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 304));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 32, 32));
        jLabel1.setText("Evento:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 32, 32));
        jLabel2.setText("Nombre del evento:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));
        jPanel1.add(txtNombreEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 260, -1));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 32, 32));
        jLabel3.setText("Fecha de inicio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        jPanel1.add(dtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 32, 32));
        jLabel4.setText("Fecha de vencimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel1.add(dtVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 210, -1));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 32, 32));
        jLabel5.setText("Hora:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));
        jPanel1.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 100, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 32, 32));
        jLabel6.setText("Hora:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        txtHoraFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraFinalActionPerformed(evt);
            }
        });
        jPanel1.add(txtHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 100, -1));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 32, 32));
        jLabel7.setText("Tipo evento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        CmbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoEvento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoEventoItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbTipoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, -1));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 32, 32));
        jLabel8.setText("Grado:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        CmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbGradoItemStateChanged(evt);
            }
        });
        jPanel1.add(CmbGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 200, -1));

        BtnVaciarCampos.setText("Vaciar Campos");
        BtnVaciarCampos.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        BtnVaciarCampos.setPreferredSize(new java.awt.Dimension(140, 30));
        BtnVaciarCampos.setRound(20);
        BtnVaciarCampos.setStyle(customizeObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        jPanel1.add(BtnVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, -1, -1));

        BtnEliminar.setText("Eliminar evento");
        BtnEliminar.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        BtnEliminar.setPreferredSize(new java.awt.Dimension(140, 30));
        BtnEliminar.setRound(20);
        BtnEliminar.setStyle(customizeObjects.ButtonRound.ButtonStyle.ROJO);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        BtnModificar.setText("Modificar evento");
        BtnModificar.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        BtnModificar.setPreferredSize(new java.awt.Dimension(140, 30));
        BtnModificar.setRound(20);
        BtnModificar.setStyle(customizeObjects.ButtonRound.ButtonStyle.AMARILLO);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, -1));

        BtnAgregar.setText("Agregar evento");
        BtnAgregar.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        BtnAgregar.setPreferredSize(new java.awt.Dimension(140, 30));
        BtnAgregar.setRound(20);
        BtnAgregar.setStyle(customizeObjects.ButtonRound.ButtonStyle.VERDE);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 20, -1));
        jPanel1.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));
        jPanel1.add(txtTipoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        jLabel9.setText("Buscar Registro:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 200, -1));

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));

        panelRound1.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(20, 519));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        panelRound1.add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(853, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        panelRound1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtNombreEvento.getText().trim().isEmpty() || txtHoraInicio.getText().trim().isEmpty() || txtHoraFinal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbTipoEvento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo evento", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if(CmbGrado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un grado", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            //primera fecha.
            Date date = dtInicio.getDate();
            Cal1 = new GregorianCalendar();
            Cal1.setTime(date);
            String inicio = String.valueOf(Cal1.get(Calendar.YEAR) + "/" + Cal1.get(Calendar.MONTH) + "/" + Cal1.get(Calendar.DAY_OF_MONTH));
            //Segunda fecha.
            Date date2 = dtInicio.getDate();
            Cal2 = new GregorianCalendar();
            Cal2.setTime(date2);
            String vencimiento = String.valueOf(Cal2.get(Calendar.YEAR) + "/" + Cal2.get(Calendar.MONTH) + "/" + Cal2.get(Calendar.DAY_OF_MONTH));
            CEvento objAdd = new CEvento(txtNombreEvento.getText(), inicio, txtHoraInicio.getText(), vencimiento, txtHoraFinal.getText(), idTipoEvento, idGrado);
            boolean respuesta = objAdd.EventoNuevoResultSet();
            if (respuesta == true) {
                JOptionPane.showMessageDialog(this, "Evento ingresado correctamente");
                CargarTabla();
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Evento no pudo ser ingresado");
            }
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void CmbTipoEventoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoEventoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoEvento.getSelectedIndex();
            if (pos == 0) {
                idTipoEvento = 0;
            } else {
                int dim = TipoEventoArrayList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idTipoEvento = (int) TipoEventoArrayList.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbTipoEventoItemStateChanged

    private void CmbGradoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbGradoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbGrado.getSelectedIndex();
            if (pos == 0) {
                idGrado = 0;
            } else {
                int dim = GradoArrayList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idGrado = (int) GradoArrayList.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbGradoItemStateChanged

    final int BuscarTipoEventoSeleccionado(int Evento){
        int size = TipoEventoArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) TipoEventoArrayList.get(i);
            if (valor == Evento) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarGradoSeleccionado(int Grado){
        int size = GradoArrayList.size();
        int retorno = -1;
        for(int i = 0; i < size; i++) {
            int valor = (Integer) GradoArrayList.get(i);
            if (valor == Grado) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    private void JTEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTEventosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            txtId.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0).toString());
            txtNombreEvento.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            txtHoraInicio.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            txtHoraFinal.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            
            txtGrado.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            txtTipoEvento.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
           
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtInicio.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString()));
            } catch (Exception e) {
                
            }
            
            DateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dtVencimiento.setDate((Date) simpleDateFormat2.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString()));
            } catch (Exception e) {
                
            }
            
            int idTipoEvento = Integer.parseInt(txtTipoEvento.getText());
            int idGrado = Integer.parseInt(txtGrado.getText());
            
            int respuesta = BuscarTipoEventoSeleccionado(idTipoEvento);
//            JOptionPane.showMessageDialog(null, respuesta);
            int respuesta2 = BuscarGradoSeleccionado(idGrado);
//            JOptionPane.showMessageDialog(null, respuesta2);
            
            CmbTipoEvento.setSelectedIndex(respuesta + 1);
            CmbGrado.setSelectedIndex(respuesta2 + 1);
        }
    }//GEN-LAST:event_JTEventosMouseClicked

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        // TODO add your handling code here:
        //primera fecha.
        Date date = dtInicio.getDate();
        Cal1 = new GregorianCalendar();
        Cal1.setTime(date);
        String inicio = String.valueOf(Cal1.get(Calendar.YEAR) + "/" + Cal1.get(Calendar.MONTH) + "/" + Cal1.get(Calendar.DAY_OF_MONTH));
        //Segunda fecha.
        Date date2 = dtVencimiento.getDate();
        Cal2 = new GregorianCalendar();
        Cal2.setTime(date2);
        String vencimiento = String.valueOf(Cal2.get(Calendar.YEAR) + "/" + Cal2.get(Calendar.MONTH) + "/" + Cal2.get(Calendar.DAY_OF_MONTH));
        CEvento objUpdate = new CEvento(Integer.parseInt(txtId.getText()), txtNombreEvento.getText(), inicio, txtHoraInicio.getText(), vencimiento, txtHoraFinal.getText(), idTipoEvento, idGrado);
        boolean valor = objUpdate.ActualizarEventoResultSet();
        if (valor == true) {
            JOptionPane.showMessageDialog(this, "Evento actualizado correctamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            CargarTabla();
            LimpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Evento no pudo ser ingresado");
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
                CEvento objDell = new CEvento(Integer.parseInt(txtId.getText()));              
                boolean valor = objDell.EliminarEventoResultSet();
                if ( valor == true) {
                    JOptionPane.showMessageDialog(this, "Evento eliminado exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    CargarTabla();
                    LimpiarCampos();
                }
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtHoraFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraFinalActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        
         Connection conn = CConnection.getConnectionControllerWithoutParameters();
        CEvento bjCar = new CEvento();    
        
          while (tablaEventoModel.getRowCount() > 0) {
                    tablaEventoModel.removeRow(0);
                }
                try {
                    ResultSet rs = bjCar.Search(txtBuscar.getText() + "%");
                    while (rs.next()) {
                        Object[] oValores = {rs.getInt("idevento"), rs.getString("nombreevento"), rs.getString("fechaevento"), rs.getString("horainicioevento"), 
                    rs.getString("fechafinalevento"), rs.getString("horafinalizarevento"), rs.getInt("idtipoevento"), rs.getInt("idgrado"), true, conn};
                        tablaEventoModel.addRow(oValores);
                    }
                } catch (Exception e) {
                }
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    Connection conn = CConnection.getConnectionControllerWithoutParameters();
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteEvento.jasper";
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer (jprint , false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(frmStudentsCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customizeObjects.ButtonRound BtnAgregar;
    private customizeObjects.ButtonRound BtnEliminar;
    private customizeObjects.ButtonRound BtnModificar;
    private customizeObjects.ButtonRound BtnVaciarCampos;
    private javax.swing.JComboBox<String> CmbGrado;
    private javax.swing.JComboBox<String> CmbTipoEvento;
    private javax.swing.JTable JTEventos;
    private com.toedter.calendar.JDateChooser dtInicio;
    private com.toedter.calendar.JDateChooser dtVencimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private customizeObjects.PanelRound panelRound1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreEvento;
    private javax.swing.JTextField txtTipoEvento;
    // End of variables declaration//GEN-END:variables
}
