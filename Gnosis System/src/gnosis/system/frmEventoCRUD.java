/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnosis.system;


import Controller.CCalendar;
import Controller.CConnection;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devro
 */
public class frmEventoCRUD extends javax.swing.JFrame {

    /**
     * Creates new form FrmCalendario
     */
    public frmEventoCRUD() {
        initComponents();
        CargarTipoEvento();
        CargarGrado();
        CargarSeccion();
        String[] Libros = {"ID", "NombreEvento", "FechaEvento", "HoraInicioEvento", "FechaFinEvento", "HoraFinalizarEvento", "idtipoevento", "idgrado", "idseccion"};
        modelo = new DefaultTableModel(null, Libros);
        TablaEventos.setModel(modelo);
        Cargartabla();
    }

    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnConectar = new javax.swing.JButton();
        TxtNombreEvento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtHoraFin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtHoraInicio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CmbTipo = new javax.swing.JComboBox<>();
        CmbGrado = new javax.swing.JComboBox<>();
        CmbSeccion = new javax.swing.JComboBox<>();
        CfechaInicio = new com.toedter.calendar.JDateChooser();
        CfechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEventos = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        BtnActualizar = new javax.swing.JButton();
        BtnElimionar = new javax.swing.JButton();
        Txtidtipo = new javax.swing.JTextField();
        TxtGrado = new javax.swing.JTextField();
        Txtseccion = new javax.swing.JTextField();
        BtnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        BtnConectar.setText("Conectar");
        BtnConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnConectarMouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre de evento");

        jLabel2.setText("Fecha de inicio");

        jLabel3.setText("Hora");

        jLabel4.setText("Hora");

        jLabel5.setText("FechaVencimiento");

        jLabel6.setText("Tipo");

        jLabel7.setText("Grado");

        jLabel8.setText("Seccion");

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        TablaEventos.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEventos);

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnElimionar.setText("Eliminar");
        BtnElimionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnElimionarActionPerformed(evt);
            }
        });

        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CmbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNombreEvento, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CfechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CfechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(TxtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BtnLimpiar))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(TxtHoraInicio)
                                                        .addComponent(CmbGrado, 0, 227, Short.MAX_VALUE))
                                                    .addComponent(jLabel7))
                                                .addGap(57, 57, 57)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(CmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtID))
                                        .addGap(259, 259, 259)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(BtnElimionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(233, 233, 233)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(BtnConectar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Txtidtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txtseccion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(CfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnElimionar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CfechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnLimpiar)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CmbGrado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(CmbSeccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnConectar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txtidtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txtseccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConectarMouseClicked
        // TODO add your handling code here:
        if (CConnection.getConnectionControllerWithoutParameters()!=null) {
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }
    }//GEN-LAST:event_BtnConectarMouseClicked

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        // TODO add your handling code here:
        if (TxtNombreEvento.getText().trim().isEmpty() || TxtHoraInicio.getText().trim().isEmpty() || TxtHoraFin.getText().trim().isEmpty()) {
           JOptionPane.showMessageDialog(this,"Cerote llena todos los campos ","campos vacios", JOptionPane.WARNING_MESSAGE);
        }else if (CmbTipo.getSelectedIndex() == 0) {
           JOptionPane.showMessageDialog(this,"Selecciona un tipo de tipo caca negro ","Dato faltante ",JOptionPane.WARNING_MESSAGE);
        }else if (CmbGrado.getSelectedIndex() == 0) {
           JOptionPane.showMessageDialog(this,"Selecciona un tipo de tipo pene negro ","Dato faltante ",JOptionPane.WARNING_MESSAGE);
        }else if (CmbSeccion.getSelectedIndex() == 0) {
           JOptionPane.showMessageDialog(this,"Selecciona un tipo de tipo seccion negro ","Dato faltante ",JOptionPane.WARNING_MESSAGE);
        }else {
            //fecha de inicio
            Date date = CfechaInicio.getDate();
            cl1 = new GregorianCalendar();
            cl1.setTime(date);
            String inicio = String.valueOf(cl1.get(Calendar.YEAR) + "/" + cl1.get(Calendar.MONTH) + "/" + cl1.get(Calendar.DAY_OF_MONTH));
            //fecha de vencimiento
            Date date2 = CfechaVencimiento.getDate();
            cl2 = new GregorianCalendar();
            cl2.setTime(date);
            String vencimiento = String.valueOf(cl2.get(Calendar.YEAR) + "/" + cl2.get(Calendar.MONTH) + "/" + cl2.get(Calendar.DAY_OF_MONTH));
            //Envio
            obj.NombreEvento = TxtNombreEvento.getText();
            obj.FechaEvento = inicio;
            obj.HoraInicioEvento = TxtHoraInicio.getText();
            obj.FechaFinalEvento = vencimiento;
            obj.HoraFinalizarEvento = TxtHoraFin.getText();
            obj.idtipoevento = CmbTipo.getSelectedIndex();
            obj.idgrado = CmbGrado.getSelectedIndex();
            obj.idseccion = CmbSeccion.getSelectedIndex();
            if (obj.EventoNuevoControladorResultset() == true) {
                JOptionPane.showMessageDialog(this, "Evento Agregado correctamente");
            } else{
                JOptionPane.showMessageDialog(this, "Evento no pudo ser ingresada");
            }
            Cargartabla();
            LimpiarCampos();
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed
    
    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        // TODO add your handling code here:
        
        //modificar fecha1
        Date date = CfechaInicio.getDate();
        cl1 = new GregorianCalendar();
        cl1.setTime(date);
        String inicio = String.valueOf(cl1.get(Calendar.YEAR) + "/" + (cl1.get(Calendar.MONTH) + 1)+ "/" + cl1.get(Calendar.DAY_OF_MONTH));
        
        //modificar fecha2
        Date date2 = CfechaVencimiento.getDate();
        cl2 = new GregorianCalendar();
        cl2.setTime(date2);
        String vencimiento = String.valueOf(cl2.get(Calendar.YEAR) + "/" + (cl2.get(Calendar.MONTH) + 1)+ "/" + cl2.get(Calendar.DAY_OF_MONTH));
        
        //UPDATE
        obj.ID  = Integer.parseInt(txtID.getText());
        obj.NombreEvento = TxtNombreEvento.getText();
        obj.FechaEvento = inicio;
        obj.HoraInicioEvento = TxtHoraInicio.getText();
        obj.FechaEvento = vencimiento;
        obj.HoraFinalizarEvento = TxtHoraFin.getText();
        obj.idtipoevento = CmbTipo.getSelectedIndex();
        obj.idgrado = CmbGrado.getSelectedIndex();
        obj.idseccion = CmbSeccion.getSelectedIndex();
        if (obj.ActualizarEvento() == true) {
            JOptionPane.showMessageDialog(this, "Tarea Actualizada exitosamente", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
            Cargartabla();
            LimpiarCampos();
        }
        
    }//GEN-LAST:event_BtnActualizarActionPerformed

    void LimpiarCampos(){
        txtID.setText("");
        TxtNombreEvento.setText("");
        TxtHoraInicio.setText("");
        TxtHoraFin.setText("");
        CfechaInicio.setDate(null);
        CfechaVencimiento.setDate(null);
        CmbTipo.setSelectedIndex(0);
        CmbGrado.setSelectedIndex(0);
        CmbSeccion.setSelectedIndex(0);   
    }
    
    private void BtnElimionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnElimionarActionPerformed
        if (txtID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro.", "informacion incompleta",JOptionPane.WARNING_MESSAGE);
        }else{
            int Confirmacion = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(this, "Estas seguro que quieres eliminar este registro", "confirmar accion", Confirmacion);
            if (Confirmacion == JOptionPane.YES_OPTION) {
                CCalendar objCEliminarEvento = new CCalendar(Integer.parseInt(txtID.getText()));
                
                boolean valor = objCEliminarEvento.EliminarEventoController();
                if (valor == true) {
                    JOptionPane.showMessageDialog(this, "Evento Eliminado exitosamente.", "Proceso completado", JOptionPane.INFORMATION_MESSAGE);
                    Cargartabla();
                }
            }
        }
    }//GEN-LAST:event_BtnElimionarActionPerformed

    private void TablaEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEventosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            txtID.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 0) .toString());
            TxtNombreEvento.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1) .toString());
            TxtHoraInicio.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3) .toString());
            TxtHoraFin.setText(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5) .toString());
            
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            try {
                CfechaInicio.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString()));
            } catch (Exception e) {
                        
            }
            
            DateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-mm-dd");
            try {
                CfechaVencimiento.setDate((Date) simpleDateFormat.parse(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString()));
            } catch (Exception e) {
                        
            }
            int idevento = Integer.parseInt(Txtidtipo.getText());
            int idGrado = Integer.parseInt(TxtGrado.getText());
            int idSeccion = Integer.parseInt(Txtseccion.getText());
            
            
            int respuesta = BuscarTipoEveSeleccionado(idevento);
            int respuesta2 = BuscarGradoSeleccionado(idGrado);
            int respuesta3 = BuscarSeccionSeleccionado(idSeccion);
            
            CmbTipo.setSelectedIndex(respuesta + 1);
            CmbGrado.setSelectedIndex(respuesta2 + 1);
            CmbSeccion.setSelectedIndex(respuesta3 + 1);
        }
    }//GEN-LAST:event_TablaEventosMouseClicked

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_BtnLimpiarActionPerformed
    
    final int BuscarTipoEveSeleccionado(int idtipoevento){
        int size = eventos.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) eventos.get(i);
            if (valor == idtipoevento) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarGradoSeleccionado(int idgrado){
        int size = grado.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) grado.get(i);
            if (valor == idgrado) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    final int BuscarSeccionSeleccionado(int idseccion){
        int size = seccion.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) seccion.get(i);
            if (valor == idseccion) {
                retorno = i;
            }
        }
        return retorno;
    }
    
    CCalendar obj = new CCalendar();
    private int idtipoevento = 0;
    private List eventos;
    private int idgrado = 0;
    private List grado;
    private int idseccion = 0;
    private List seccion;
    private Calendar cl1;
    private Calendar cl2;
 
    
    
    
    DefaultTableModel modelo;
    
    final void CargarTipoEvento(){
        DefaultComboBoxModel<String>modelotiponivelBoxModel;
        CCalendar objnotas = new CCalendar();
        eventos = new ArrayList();
        try {
            ResultSet rs = objnotas.CargarTipoEventoResultSet();
            if (rs.next()) {
                modelotiponivelBoxModel = new DefaultComboBoxModel<>();
                CmbTipo.addItem("Elija un evento");
                do {
                    eventos.add(rs.getInt("idtipoevento"));
                    CmbTipo.addItem(rs.getString("idtipoevento"));
                } while (rs.next());           
            }else{
                JOptionPane.showMessageDialog(CmbTipo, "no existen perfiles", "error de carga",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CmbTipo, "No se ah podido cargar los datos, consulta con el damin","error crinico",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    final void CargarGrado(){
        DefaultComboBoxModel<String>modelotiponivelBoxModel;
        CCalendar objnotas = new CCalendar();
        grado = new ArrayList();
        try {
            ResultSet rs = objnotas.CargarGradoResultSet();
            if (rs.next()) {
                modelotiponivelBoxModel = new DefaultComboBoxModel<>();
                CmbGrado.addItem("Elija un grado");
                do {
                    grado.add(rs.getInt("idgrado"));
                    CmbGrado.addItem(rs.getString("Grado"));
                } while (rs.next());           
            }else{
                JOptionPane.showMessageDialog(CmbGrado, "no existen perfiles", "error de carga",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CmbGrado, "No se ah podido cargar los datos, consulta con el damin","error crinico",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    final void CargarSeccion(){
        DefaultComboBoxModel<String>modelotiponivelBoxModel;
        CCalendar objnotas = new CCalendar();
        seccion = new ArrayList();
        try {
            ResultSet rs = objnotas.CargarSeccionResultSet();
            if (rs.next()) {
                modelotiponivelBoxModel = new DefaultComboBoxModel<>();
                CmbSeccion.addItem("Elija una seccion");
                do {
                    seccion.add(rs.getInt("idseccion"));
                    CmbSeccion.addItem(rs.getString("Seccion"));
                } while (rs.next());           
            }else{
                JOptionPane.showMessageDialog(CmbSeccion, "no existen perfiles", "error de carga",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(CmbSeccion, "No se ah podido cargar los datos, consulta con el damin","error crinico",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void CmbtipoeventosItemStateChanged(java.awt.event.ItemEvent evt) {                                          
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipo.getSelectedIndex();
            if (pos == 0) {
                idtipoevento = 0;
            }else{
                int dim = eventos.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idtipoevento = (int) eventos.get(i);
                    }
                }
            }
            System.out.println("item" + idtipoevento);
        }
    }
    
    private void CmbSeccionItemStateChanged(java.awt.event.ItemEvent evt) {                                          
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbSeccion.getSelectedIndex();
            if (pos == 0) {
                idseccion = 0;
            }else{
                int dim = eventos.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idseccion = (int) eventos.get(i);
                    }
                }
            }
            System.out.println("item" + idseccion);
        }
    } 
    
    private void CmbGradosItemStateChanged(java.awt.event.ItemEvent evt) {                                          
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbGrado.getSelectedIndex();
            if (pos == 0) {
                idgrado = 0;
            }else{
                int dim = eventos.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idgrado = (int) eventos.get(i);
                    }
                }
            }
            System.out.println("item" + idgrado);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(frmEventoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEventoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEventoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEventoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEventoCRUD().setVisible(true);
            }
        });
    }
   
    final void Cargartabla(){
        CCalendar Task = new CCalendar();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);       
        }
        try {
            ResultSet rs = Task.CargarCalendarioResultSet();
            while (rs.next()){
                Object[] oValores = {rs.getInt("idevento"), rs.getString("NombreEvento"), rs.getString("FechaEvento"), rs.getString("HoraInicioEvento"), rs.getString("FechaFinEvento"), rs.getString("HoraFinalizarEvento"), rs.getInt("idtipoevento"), rs.getInt("idgrado"), rs.getInt("idseccion")};
                modelo.addRow(oValores);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargo la tabla");
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnConectar;
    private javax.swing.JButton BtnElimionar;
    private javax.swing.JButton BtnLimpiar;
    private com.toedter.calendar.JDateChooser CfechaInicio;
    private com.toedter.calendar.JDateChooser CfechaVencimiento;
    private javax.swing.JComboBox<String> CmbGrado;
    private javax.swing.JComboBox<String> CmbSeccion;
    private javax.swing.JComboBox<String> CmbTipo;
    private javax.swing.JTable TablaEventos;
    private javax.swing.JTextField TxtGrado;
    private javax.swing.JTextField TxtHoraFin;
    private javax.swing.JTextField TxtHoraInicio;
    private javax.swing.JTextField TxtNombreEvento;
    private javax.swing.JTextField Txtidtipo;
    private javax.swing.JTextField Txtseccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}