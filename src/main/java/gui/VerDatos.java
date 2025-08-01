package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import logica.ControladoraLogica;
import logica.LogicaPDF;
import logica.Mascota;

public class VerDatos extends javax.swing.JFrame {

    ControladoraLogica controladoraLogi = null;
    
    public VerDatos() {
        controladoraLogi = new ControladoraLogica();
        initComponents();
        
        // repetimos el codigo con el boton volver al menu principa
        ImageIcon iconoVolver = new ImageIcon("C:\\Users\\Estudiante\\Documents\\NetBeansProjects\\5clasepooTrabajoFinal\\assets\\volver.png");
        Image volverEscalada = iconoVolver.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon volverRedimensionado = new ImageIcon(volverEscalada);
        btnVolver.setIcon(volverRedimensionado);
        
        btnExportarPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogicaPDF logica = new LogicaPDF();
                logica.generarPDF();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnExportarPDF = new javax.swing.JButton();
        btnVolver = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(924, 584));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        txtTitulo.setText("Peluquería canina");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablita);

        btnEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Estudiante\\Documents\\NetBeansProjects\\5clasepooTrabajoFinal\\assets\\borrar.png")); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Estudiante\\Documents\\NetBeansProjects\\5clasepooTrabajoFinal\\assets\\editar.png")); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Datos de mascotas");

        btnExportarPDF.setIcon(new javax.swing.ImageIcon("C:\\Users\\Estudiante\\Documents\\NetBeansProjects\\5clasepooTrabajoFinal\\assets\\descargarpdf.png")); // NOI18N
        btnExportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportarPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnVolver.setMaximumSize(new java.awt.Dimension(25, 7));
        btnVolver.setMinimumSize(new java.awt.Dimension(25, 7));
        btnVolver.setPreferredSize(new java.awt.Dimension(25, 7));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(318, 318, 318)
                        .addComponent(txtTitulo)
                        .addGap(0, 346, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitulo)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        // controlo que mi tabla no este vacia
        if (tablita.getRowCount()> -1 ){
            // el usuario elige una fila
            if (tablita.getSelectedRow()!= -1){
                //obtengo el id de la mascota a eliminar
                int num_cliente = Integer.parseInt(String.valueOf(tablita.getValueAt(tablita.getSelectedRow(), 0)));
                //llamo al metodo eliminar
                controladoraLogi.borrarMascota(num_cliente);
                //aviso al usuario que se elimino correctamente
                mostrarMensaje("Mascota eliminada correctamente", "info", "Borrado de mascota");
                
                cargarTabla();
                
            } else {
                mostrarMensaje("No se selecciono ninguna fila", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("No la tabla esta vacia", "vacio", "Tabla vacia");
        }
            
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    // controlo que mi tabla no este vacia
        if (tablita.getRowCount()> -1 ){
            // el usuario elige una fila
            if (tablita.getSelectedRow()!= -1){
                //obtengo el id de la mascota a editar
                int num_cliente = Integer.parseInt(String.valueOf(tablita.getValueAt(tablita.getSelectedRow(), 0)));
                
                // llama a la pantalla modificar y le pasa el id para buscar en la BD
                ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
                
                pantallaModif.setVisible(true);
                pantallaModif.setLocationRelativeTo(null);
                
                this.dispose();
        
            } else {
                mostrarMensaje("No se selecciono ninguna fila", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("No la tabla esta vacia", "vacio", "Tabla vacia");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal pantallaPrincipal = new Principal();
        pantallaPrincipal.setVisible(true);
        pantallaPrincipal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFActionPerformed
        
        
    }//GEN-LAST:event_btnExportarPDFActionPerformed

    public void mostrarMensaje(String mensaje, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equalsIgnoreCase("info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equalsIgnoreCase("error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JToggleButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablita;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables

    public void cargarTabla() {
                
        // definicir el modelo que queremos para la tabla
        DefaultTableModel tabla = new DefaultTableModel(){
            // que filas y columnas no sean editables
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        // establecemos los nombres de las columnas
        String titulos[] = {"Num", "Nombre","color", "Raza", "Alergico", "At. Especial","Observaciones",
            "Nombre del dueño", "Celular"};
        tabla.setColumnIdentifiers(titulos);
        
        // carga de datos desde la base de datos
        List <Mascota> listaMascota = controladoraLogi.traerMascotaList();
                
        // recorrer la lista y mostrar en la tabla
        if (listaMascota!=null){
            for (Mascota masco : listaMascota){
                Object[] objeto = {masco.getIdMascota(), masco.getNombre(), masco.getColor(), masco.getRaza(),
                masco.getAlergico(), masco.getAtencionEspecial(), masco.getObservacion(), masco.getDuenio().getNombreDuenio(),
                masco.getDuenio().getNumCelular()};
                
                tabla.addRow(objeto);
            }
        }
        tablita.setModel(tabla);
        // ajustar ancho de columnas
        TableColumnModel columnModel = tablita.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40); // NUM
        columnModel.getColumn(1).setPreferredWidth(80); //  NOMBRE
        columnModel.getColumn(2).setPreferredWidth(80); //  COLOR
        columnModel.getColumn(3).setPreferredWidth(80); //  RAZA
        columnModel.getColumn(4).setPreferredWidth(45); //  ALERGICO
        columnModel.getColumn(5).setPreferredWidth(80); //  AT. ESPECIAL
        columnModel.getColumn(6).setPreferredWidth(240); //  OBSERVACION
        columnModel.getColumn(7).setPreferredWidth(125); //  NOMBRE DUEÑO
        columnModel.getColumn(8).setPreferredWidth(90); //  CELULAR
    }
}