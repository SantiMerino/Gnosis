/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gnosis.system;

import Controller.CComboboxDocentes;
import Controller.CEvento;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

        panelRound1 = new roundObjects.PanelRound();
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
        BtnVaciarCampos = new roundObjects.ButtonRound();
        BtnEliminar = new roundObjects.ButtonRound();
        BtnModificar = new roundObjects.ButtonRound();
        BtnAgregar = new roundObjects.ButtonRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTEventos = new javax.swing.JTable();
        txtTipoEvento = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Evento:");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setText("Nombre del evento:");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));
        panelRound1.add(txtNombreEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 260, -1));

        jLabel3.setText("Fecha de inicio:");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        panelRound1.add(dtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, -1));

        jLabel4.setText("Fecha de vencimiento:");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        panelRound1.add(dtVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 270, -1));

        jLabel5.setText("Hora:");
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));
        panelRound1.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 60, -1));

        jLabel6.setText("Hora:");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));
        panelRound1.add(txtHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 60, -1));

        jLabel7.setText("Tipo evento:");
        panelRound1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        CmbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbTipoEvento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoEventoItemStateChanged(evt);
            }
        });
        panelRound1.add(CmbTipoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 200, -1));

        jLabel8.setText("Grado:");
        panelRound1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        CmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbGrado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbGradoItemStateChanged(evt);
            }
        });
        panelRound1.add(CmbGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 200, -1));

        BtnVaciarCampos.setText("Vaciar Campos");
        BtnVaciarCampos.setStyle(roundObjects.ButtonRound.ButtonStyle.GRIS_OSCURO);
        panelRound1.add(BtnVaciarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        BtnEliminar.setText("Eliminar evento");
        BtnEliminar.setStyle(roundObjects.ButtonRound.ButtonStyle.ROJO);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        panelRound1.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        BtnModificar.setText("Modificar evento");
        BtnModificar.setStyle(roundObjects.ButtonRound.ButtonStyle.AMARILLO);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        panelRound1.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        BtnAgregar.setText("Agregar evento");
        BtnAgregar.setStyle(roundObjects.ButtonRound.ButtonStyle.VERDE);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        panelRound1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

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

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 870, 170));
        panelRound1.add(txtTipoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));
        panelRound1.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));
        panelRound1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 20, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
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
            JOptionPane.showMessageDialog(null, respuesta);
            int respuesta2 = BuscarGradoSeleccionado(idGrado);
            JOptionPane.showMessageDialog(null, respuesta2);
            
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
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private roundObjects.ButtonRound BtnAgregar;
    private roundObjects.ButtonRound BtnEliminar;
    private roundObjects.ButtonRound BtnModificar;
    private roundObjects.ButtonRound BtnVaciarCampos;
    private javax.swing.JComboBox<String> CmbGrado;
    private javax.swing.JComboBox<String> CmbTipoEvento;
    private javax.swing.JTable JTEventos;
    private com.toedter.calendar.JDateChooser dtInicio;
    private com.toedter.calendar.JDateChooser dtVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private roundObjects.PanelRound panelRound1;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreEvento;
    private javax.swing.JTextField txtTipoEvento;
    // End of variables declaration//GEN-END:variables
}
