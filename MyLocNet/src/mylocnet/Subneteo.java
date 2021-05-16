
package mylocnet;

import com.sun.glass.events.KeyEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @JhonatanSánchez @KatianaTordecilla @NicolásSutachan
 */
public class Subneteo extends javax.swing.JFrame {

    String []arreglo;
    String clasepriv;
    String clasepub;
    String [] dir_ip;
    int [] grupos = new int[4];
    String [] gruposbin = new String [4];
    String [] dir_mas;
    String [] gruposmascara;
    String [] mascarabin = new String [4];
    String [] gruposmas = new String[4];
    Operacion oper = new Operacion();
    /*Variables locales para el calculo de Subnetting*/
    int subredes;
    int host;
    int []cont = new int [4];
    int [] saltos = new int [4];
    int subred;
    int [] id;
    String [] SubnetAddress;
    String [] RangoHost;
    String [] Broadcast;
    String [][] datos;
    int newgroup [] = new int [4];
    DefaultTableModel modelo;
    
    public Subneteo() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
        modelo = new DefaultTableModel();
        modelo.addColumn("ID Subred");
        modelo.addColumn("Dirección de Subred");
        modelo.addColumn("Rango de direcciones/Host");
        modelo.addColumn("Dirección Broadcast");
        this.tabla.setModel(modelo);
        ProcesosIP();
        AggMascHostSub();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtip = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        boxmas = new javax.swing.JComboBox<>();
        boxsub = new javax.swing.JComboBox<>();
        binmas = new javax.swing.JLabel();
        binip = new javax.swing.JLabel();
        binsub = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtprivada = new javax.swing.JTextField();
        txtpublica = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btncalcular = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        binsub1 = new javax.swing.JLabel();
        boxhost = new javax.swing.JComboBox<>();
        btnexportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Dirección IPv4:");

        txtip.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtip.setText("10.0.0.0/8");
        txtip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtipKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtipKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Máscara de Subred:");

        tabla.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tabla);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("# de Súbredes:");

        boxmas.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        boxmas.setBorder(null);
        boxmas.setPreferredSize(new java.awt.Dimension(71, 30));
        boxmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxmasMouseClicked(evt);
            }
        });
        boxmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxmasActionPerformed(evt);
            }
        });

        boxsub.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        boxsub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxsub.setPreferredSize(new java.awt.Dimension(71, 30));
        boxsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxsubActionPerformed(evt);
            }
        });

        binmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/codigo-binario (1).png"))); // NOI18N

        binip.setBackground(new java.awt.Color(255, 255, 255));
        binip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/codigo-binario (1).png"))); // NOI18N
        binip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                binipMouseClicked(evt);
            }
        });

        binsub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/codigo-binario (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo de clase Privada:");

        txtprivada.setEditable(false);
        txtprivada.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtprivada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprivada.setToolTipText("");

        txtpublica.setEditable(false);
        txtpublica.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtpublica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpublica.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de clase Pública:");

        btncalcular.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btncalcular.setText("Calcular");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnlimpiar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("# de Hosts/Subred:");

        binsub1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/codigo-binario (1).png"))); // NOI18N

        boxhost.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        boxhost.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxhost.setPreferredSize(new java.awt.Dimension(71, 30));
        boxhost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxhostActionPerformed(evt);
            }
        });

        btnexportar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnexportar.setText("Exportar");
        btnexportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxmas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtip)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(boxsub, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(binmas)
                                    .addComponent(binip)
                                    .addComponent(binsub)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(boxhost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(binsub1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpublica, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprivada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btncalcular)
                                .addGap(18, 18, 18)
                                .addComponent(btnlimpiar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnexportar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(binip, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtprivada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(binmas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boxmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpublica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxsub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(binsub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boxhost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(binsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnlimpiar)
                                .addComponent(btncalcular)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnexportar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
    CalcSubredes();
    }//GEN-LAST:event_btncalcularActionPerformed

    private void txtipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtipKeyTyped
        //variable que almacena la tecla presionada por el usuario
        char validar = evt.getKeyChar();
        //condición que valida si la tecla presionada es una letra
        if(Character.isLetter(validar)){
           //getToolkit proporciona los servicios de impresión de la clase, y permite imprimir un audio (beep)
           getToolkit().beep();
           //se rechaza la tecla y hace que el valor no se tome en la caja de texto
           evt.consume();
        }
    }//GEN-LAST:event_txtipKeyTyped

    private void txtipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtipKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
         boxmas.requestFocus();
         ProcesosIP(); 
         AggMascHostSub();
        }
        
    }//GEN-LAST:event_txtipKeyReleased

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        //invoca el método de limpiar.
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void binipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binipMouseClicked
        
    }//GEN-LAST:event_binipMouseClicked

    private void btnexportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportarActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                int contador = tabla.getRowCount()/65536;
                int posfila=0;
                int cont=0;
                int cantfilas = tabla.getRowCount();
                
                if(contador <255){
                for(int n=0; n<=contador; n++){
                Sheet hoja = libro.createSheet("Calculos Subnetting"+n);
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < 65536; f++) {
                    if(cantfilas!=0){
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < tabla.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(tabla.getColumnName(c));
                        }
                    }
                    cantfilas = cantfilas - 1;
                    }
                }
                
                int filaInicio = 1;
                for (int f = 0; f < 65535; f++) {
                    posfila= (n*65535) + f;
                    if(posfila<tabla.getRowCount()){
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < 4; c++) {
                        Cell celda = fila.createCell(c);
                        if (tabla.getValueAt(posfila, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(tabla.getValueAt(posfila, c).toString()));
                        } else if (tabla.getValueAt(posfila, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) tabla.getValueAt(posfila, c)));
                        } else {
                            celda.setCellValue(String.valueOf(tabla.getValueAt(posfila, c)));
                        }
                    } 
                    }
                }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            }else{
                    JOptionPane.showMessageDialog(null,"Error con la cantidad maxima de filas, supera el limite de 16711680","Error al Exportar Excel",0);
                           
                } 
            }catch (IOException | NumberFormatException e) {
                try {
                    throw e;
                } catch (IOException ex) {
                    Logger.getLogger(Subneteo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NumberFormatException ex) {
                    Logger.getLogger(Subneteo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
    }//GEN-LAST:event_btnexportarActionPerformed

    private void boxmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxmasMouseClicked
        
    }//GEN-LAST:event_boxmasMouseClicked

    private void boxmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxmasActionPerformed
        //método que valida la posición seleccionada en la lista, y asigna las nuevas posiciones
        //a las demás listas
        try{
        boxsub.setSelectedIndex(boxmas.getSelectedIndex());
        int posicion = boxmas.getItemCount() - (boxmas.getSelectedIndex() + 1);
        boxhost.setSelectedIndex(posicion);
        
        DirMascSubred();
        
        } catch(Exception e){
        }
    }//GEN-LAST:event_boxmasActionPerformed

    private void boxsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxsubActionPerformed
        try{
        boxmas.setSelectedIndex(boxsub.getSelectedIndex());
        int posicion = boxmas.getItemCount() - (boxsub.getSelectedIndex() + 1);
        boxhost.setSelectedIndex(posicion);
        
        DirMascSubred();
        
        }catch(Exception e){
        }
    }//GEN-LAST:event_boxsubActionPerformed

    private void boxhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxhostActionPerformed
        try{
        int posicion = boxhost.getItemCount() - (boxhost.getSelectedIndex() + 1);
        boxsub.setSelectedIndex(posicion);
        boxmas.setSelectedIndex(posicion);
        
        DirMascSubred();
        
        } catch(Exception e){
        }
    }//GEN-LAST:event_boxhostActionPerformed

    private int cifras(int num) {
        int cif = 0;

        for (int i = 1; num > 0; i++) {
            num = num / 10;
            cif = i;
        }
        if (cif <= 3 && cif > 0) {
            return cif;
        } else {
            if (cif == 0) {
                cif = 1;
                return cif;
            } else {
                return cif;
            }
        }
    }
    
    //Método que obtiene los valores de la dirección Ip ingresada por el usuario.
    private void DirIP() {
        
        try{
        //obtiene el valor que esta dentro de la caja de texto txtip
        dir_ip = txtip.getText().split("/");

        if (!dir_ip[0].isEmpty()) {
            //separa los grupos en el Array arreglo
            arreglo = null;
            arreglo = dir_ip[0].split("\\.");
            //Condicional que valida si el arreglo tiene 4 grupos
            if (arreglo.length == 4) {
                //condicional que valida si la máscara en la dirección IP esta en el rango de 0 a 32
                if(Integer.parseInt(dir_ip[1]) >= 0 && Integer.parseInt(dir_ip[1])<=32){
                //ciclo que le asigna los valores enteros a los grupos de la dirección IP
                for (int i = 0; i < 4; i++) {
                    if (!arreglo[i].equals("") || !arreglo[i].equals("0")) {
                        grupos[i] = Integer.parseInt(arreglo[i]);
                    } else {
                        if(arreglo[i].equals(null) || arreglo[i].equals("0")||arreglo[i].equals("")){
                        grupos[i] = 0;
                        }
                    }
                }
                }else{
                    //sino cumple con el rango de 0 a 32, entences le asigna el valor de 24 a este
                    //Invoca el método NuevaDir ( Nueva Dirección)
                    dir_ip[1] = "24";
                    NuevaDir();
                }
            }
        }
    }catch(Exception e){
        //proceso que realiza una Excepción si hay un error en el Try.
        JOptionPane.showMessageDialog(null,"Error en la dirección IPv4, por favor validar IP","Error",0);
        txtip.requestFocus();
    }
    }
    
    private void ProcesosIP() {
     /*El método ProcesosIP, calcula algunas validaciones de datos y los campos
     principales de la dirección IPv4 y asigna valores a la máscara por defecto*/
        DirIP();
        gruposBytes();
        ValGrupoIp();
        ClaseIpPrivada();
        ClaseIpPublica();
        ConvgruposDecBin();
        NuevaDir();
    }

    private void AggMascHostSub(){
    //método que agg los valores a las caja de máscara de subred, hosts y # de subredes.
    AggDirMascaras();
    Subred();
    }
    
    private void CalcSubredes(){
     //Método que realizo el proceso de subredes, basandose en los valores seleccionados.
     ProcesosIP();
     //Asignación de valores a las variables y arrays para el proceso de subredes.
     subred = Integer.parseInt((String) boxsub.getSelectedItem());
     id = new int[subred];
     SubnetAddress = new String[subred];
     RangoHost = new String[subred];
     Broadcast = new String[subred];
     datos = new String [subred][4];
     host = Integer.parseInt(String.valueOf(boxhost.getSelectedItem()));
     subredes = Integer.parseInt(String.valueOf (boxsub.getSelectedItem()));
     
     
             //Copia los valores del Array grupos en new Grupos
             System.arraycopy(grupos, 0, newgroup, 0, grupos.length);
             
             //Asigna el valor de la nueva direccion, basandose en la suma
             //binario entre la dirección ingresada por el usuario y la dir. de la máscara
               for (int i = 0; i < 4; i++) {
                   //Condicional donde valida si el valor del grupo i de mascara es menor que el grupo n de la IPv4.
                 if (Integer.parseInt(gruposmas[i]) < grupos[i]) {
                     //Asignación de variables de binario
                     String binary = String.valueOf(gruposbin[i]);
                     String newbinary="";
                     for(int j=0; j<8;j++){
                       if(binary.charAt(j) == mascarabin[i].charAt(j) && binary.charAt(j) == '1'){
                          newbinary=newbinary + "1";
                     }else{
                          newbinary=newbinary + "0"; 
                       }
                     }
                    newgroup[i]= (oper.BinarioADecimal(Long.parseLong(newbinary)));
                 }
             }
     
     //Operación que calcula los saltos de una subred a otra
     Subnetting();
    }
    
    private void eliminarTabla() {
        //método que calcula la cantidad de filas y las elimina.
        int fila = tabla.getRowCount();

        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void DirMascSubred(){
        dir_mas = String.valueOf(boxmas.getSelectedItem()).split("/");
        EnteroaDireccion(Integer.parseInt(dir_mas[1]));
    }
    
    private void gruposBytes() {
        //Se valida si el arreglo cumple con las 4 grupos que debe tener la dirección IPv4
        if (arreglo.length == 4) {
            for (int i = 0; i < 4; i++) {
                //Condición que valida si el valor del arreglo en i, es superior a (-1)
                if (grupos[i] >= 0) {
//                    Invoca al metodo Cifras y envía de parametro el valor del arreglo en entero
//                    Valida si el valor en el arreglo tiene entre 1 y 3 cifras
                    if (!(cifras(grupos[i]) <= 3) && !(cifras(grupos[i]) >= 1)) {
                        JOptionPane.showMessageDialog(null, "La dirección en el grupo #" + (i + 1) + " de Bytes, tiene más de 3 cifras.", "Error en la dirección IPv4", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La dirección en el grupo #" + (i + 1) + " de Bytes, tiene un valor negativo!.", "Error en la dirección IPv4", 0);
                }
            }
        } else {
            //valida si el tamaño es superior a los 4 grupos de la dirección IPv4
            if (arreglo.length > 4) {
                JOptionPane.showMessageDialog(null, "La dirección IPv4 tiene más de 5 grupos!", "Error en la dirección IPv4", 0);
            } else {
                //al no cumplirse ninguna de las condiciones la dirección IPv4 tiene menos de 4 grupos
                JOptionPane.showMessageDialog(null, "La dirección IPv4 tiene menos de 4 grupos!", "Error en la dirección IPv4", 0);
            }
        }
    }
    
    private void ClaseIpPrivada() {
        try{
        clasepriv = null;

        if (arreglo.length == 4) {
            //condicional que valida si el grupo 3 y 4 esta entre 0 y 255   
            if (grupos[2] >= 0 && grupos[2] <= 255 && grupos[3] >= 0 && grupos[3] <= 255) {
                //condicionales que valida si cumple con los parametros de cada clase.
                if (grupos[0] == 10 && grupos[1] >= 0 && grupos[1] <= 255) {
                    clasepriv = "A";
                } else {
                    if (grupos[0] == 172 && grupos[1] >= 16 && grupos[1] <= 31) {
                        clasepriv = "B";
                    } else {
                        if (grupos[0] == 192 && grupos[1] == 168) {
                            clasepriv = "C";
                        }
                    }
                }
            }
        }
        txtprivada.setText(clasepriv);
    }catch(Exception e){
    }
    }
    
    private void ClaseIpPublica() {
        try {
            clasepub = null;

            if (arreglo.length == 4) {
                //condicional que valida si el grupo 3 y 4 esta entre 0 y 255   
                if (grupos[1] >= 0 && grupos[1] <= 255 && grupos[2] >= 0 && grupos[2] <= 255 && grupos[3] >= 0 && grupos[3] <= 255) {
                    //condicionales que valida si cumple con los parametros de cada clase.
                    if (grupos[0] >= 0 && grupos[0] <= 127) {
                        clasepub = "A";
                        if (Integer.parseInt(dir_ip[1]) < 8) {
                            dir_ip[1] = "8";
                        }
                    } else {
                        if (grupos[0] >= 128 && grupos[0] <= 191) {
                            clasepub = "B";
                            if (Integer.parseInt(dir_ip[1]) < 16) {
                                dir_ip[1] = "16";
                            }
                        } else {
                            if (grupos[0] >= 192 && grupos[0] <= 223) {
                                clasepub = "C";
                                if (Integer.parseInt(dir_ip[1]) < 24) {
                                    dir_ip[1] = "24";
                                }
                            } else {
                                if (grupos[0] >= 224 && grupos[0] <= 239) {
                                    clasepub = "D";
                                } else {
                                    if (grupos[0] >= 240 && grupos[0] <= 255) {
                                        clasepub = "E";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            NuevaDir();
            txtpublica.setText(clasepub);

        } catch (Exception e) {
        }
    }
    
    private void limpiar() {
        //metodo que limpia los campos del Frame y la tabla.
        txtip.setText("10.0.0.0/8");
        ProcesosIP();
        AggMascHostSub();
        txtprivada.setText("");
        txtpublica.setText("");
        eliminarTabla();
    }
    
    private void AggDirMascaras() {
        try{
        boxmas.removeAllItems();
        int cantidad = Integer.parseInt(dir_ip[1]);
        
        while (cantidad <= 32) {
            EnteroaDireccion(cantidad);
            boxmas.addItem(gruposmas[0] + "." + gruposmas[1] + "." + gruposmas[2] + "." + gruposmas[3] + "/" + cantidad);
            cantidad++;
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la dirección IPv4, Por favor validar Ip y máscara","Error en dirección IPv4",0);
            txtip.requestFocus();
            int posicion = txtip.getText().indexOf('/');
            StringBuffer texto = new StringBuffer(txtip.getText()) ;
            texto.insert(posicion+1,"0");
            txtip.setText(String.valueOf(texto));
            this.dir_ip = null;
            this.dir_ip = txtip.getText().split("/");
            ProcesosIP();
            AggMascHostSub();
        }
    }
 
    private void EnteroaDireccion(int cantidad) {
        host = 32 - cantidad;
        String bitsmasc = "";

        for (int i = 0; i < cantidad; i++) {
            bitsmasc = bitsmasc + "1";
        }

        for (int j = 0; j < host; j++) {
            bitsmasc = bitsmasc + "0";
        }

        for (int n = 0; n < 4; n++) {
            gruposmas[n] = String.valueOf(oper.BinarioADecimal(Long.parseLong(bitsmasc.substring(0, 8))));
            if (gruposmas[n] == null) {
                gruposmas[n] = "0";
            }
            if (bitsmasc.length() >= 8) {
                mascarabin[n] = bitsmasc.substring(0, 8);
                bitsmasc = bitsmasc.substring(8, bitsmasc.length());
            }
        }
    }
    
    private void ConvgruposDecBin() {
        try{
        if (arreglo.length == 4) {
            for (int k = 0; k < 4; k++) {
                if(grupos[k]>=0 && grupos[k]<=255){
                String binar = oper.DecimalABinario(grupos[k]);
                gruposbin[k] = "00000000".substring(binar.length()) + binar;
                System.out.println(gruposbin[k]);
                }
                }
        }
        }catch(Exception e){
        }
    }
    
    private void NuevaDir() {
        try{
            if (arreglo.length == 4) {
            txtip.setText(dir_ip[0] + "/" + dir_ip[1]);
        }
        }catch(Exception e){
        }
    }
    
    private void ValGrupoIp() {
        if (arreglo.length == 4) {
            for (int j = 0; j < 4; j++) {
                if ((grupos[j] < 0) || (grupos[j] > 255)) {
                    JOptionPane.showMessageDialog(null, "El grupo No. " + (j + 1) + " de Octeto, no cumple con el tamaño entre 0 y 255 bits.", "Error en tamaño de octetos", 0);
                    txtip.requestFocus();
                }
            }
        }
    }
    
    private void Subred(){
        try{
        String dirmascara = (String) boxmas.getSelectedItem();
        dir_mas = dirmascara.split("/");
        this.subredes = Integer.parseInt(dir_mas[1]) - Integer.parseInt(this.dir_ip[1]);
        System.out.println(subredes);
        
    try{
        if (!dir_mas[0].isEmpty()) {
            gruposmascara = null;
            gruposmascara = dir_mas[0].split("\\.");
            for(int i = 0; i<4; i++){
                String binario = oper.DecimalABinario(Integer.parseInt(gruposmascara[i]));
                mascarabin[i] = "00000000".substring(binario.length())+binario;
                System.out.println(mascarabin[i]);
            }
        }
        
        AggSubredesHost();
        
        } catch (Exception e) {
        }
    }catch(Exception e){
    }
    }
    
    private void AggSubredesHost(){
       try{
       boxsub.removeAllItems();
       boxhost.removeAllItems();
       int cant = 32 - Integer.parseInt(dir_ip[1]);
       
       for(int i=0; i<=cant; i++){
           boxsub.addItem(String.valueOf(Math.round(Math.pow(2, i))));
           boxhost.addItem(String.valueOf(Math.round(Math.pow(2, i))));
       }
       boxhost.setSelectedIndex(boxhost.getItemCount()-1);
       }catch(Exception e){
       }
    }

    private void Subnetting() {

        if (host >= 4) {
            eliminarTabla();
            saltos[0] = host;
            
            //asignar valores 0 a los contadores
            for(int s=0; s<4; s++){
            cont[s] = 0;
            }
            
            for (int i = 0; i < subred; i++) {
                id[i] = i + 1;

                //condición que valida si la máscara seleccionada esta entre 24 y 32 bits encendidos
                if (Integer.parseInt(dir_ip[1])>=24 && Integer.parseInt(dir_ip[1])<= 32) {
                    saltos4(i);

                } else {
                    

                    if (Integer.parseInt(dir_ip[1])>16 && Integer.parseInt(dir_ip[1])<24) {
                        saltos[1]= subred / 256; // 2^8;
                        saltos3(i);
                    } else {
                        saltos[2] = subred/ 65536; /*2^16*/

                        if (Integer.parseInt(dir_ip[1])>8 && Integer.parseInt(dir_ip[1])<= 16) {
                            saltos2(i);
                        } else {
                            saltos[3] = subred / 16777216 /*2^24*/;
                            saltos1(i);
                        }
                    }
                }
            }

            for (int m = 0; m < subred; m++) {
                for (int n = 0; n < 4; n++) {
                    if (n == 0) {
                        datos[m][n] = String.valueOf(id[m]);
                    } else {
                        if (n == 1) {
                            datos[m][n] = SubnetAddress[m];
                        } else {
                            if (n == 2) {
                                datos[m][n] = RangoHost[m];
                            } else {
                                datos[m][n] = Broadcast[m];
                            }
                        }
                    }
                }
            }

            modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(subred);

            for (int i = 0; i < subred; i++) {
                for (int j = 0; j < 4; j++) {
                    tabla.setValueAt(datos[i][j], i, j);
                }
            }
            
        } else {
            eliminarTabla();
        }
    }
    
    private void saltos4(int i) {
         cont[0] = cont[0] + saltos[0];

        if (cont[0] == 256) {
            cont[0] = 0;
            Broadcast[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + "255";
        }

        //Proceso donde calcula la dirección de Subred, los Rangos, Broadcast
        SubnetAddress[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + newgroup[3];
        RangoHost[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + (newgroup[3] + 1) + " - "
                + newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + ((newgroup[3] + saltos[0]) - 2);
        
        newgroup[3]=cont[0];
        
        if (cont[0] != 0) {
            Broadcast[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + (cont[0] - 1);
        }else{
            newgroup[2] = newgroup[2] + 1;
        }

    }
    
    private void saltos3(int i){
        //condición que valida los bits encendidos por el usuario y realiza el calculo de subredes
        if(Integer.parseInt(dir_mas[1])>24 && Integer.parseInt(dir_mas[1])<=32){
            saltos4(i);
            
            if (newgroup[2] == 256) {
            cont[1] = 0;
            Broadcast[i] = newgroup[0] + "." + newgroup[1] + "." + 255 + "." + 255;
            newgroup[1] = newgroup[1] + 1;
            newgroup[2] = cont[1];
            }
            
        }else{
        saltos[1] = host /256;
        cont[1] = cont[1] + saltos[1];
            
        if (newgroup[2] == 256) {
            cont[1] = 0;
            Broadcast[i] = newgroup[0] + "." + newgroup[1] + "." + 255 + "." + 255;
            newgroup[1] = newgroup[1] + 1;
        }
        
        newgroup[3]=255;
        
        //Proceso donde calcula la dirección de Subred, los Rangos, Broadcast
        SubnetAddress[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + 0;
        RangoHost[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + 1 + " - "
                + newgroup[0] + "." + newgroup[1] + "." + ((cont[1])-1) + "." + (newgroup[3]-1);
        

        if (cont[1] != 0) {
            Broadcast[i] = newgroup[0] + "." + newgroup[1] + "." + (cont[1]-1) + "." + newgroup[3];
        }
        newgroup[2] = cont[1];
    }
        
    }
    
    private void saltos2(int i){
      
        //condición que valida los bits encendidos por el usuario y realiza el calculo de subredes
        if(Integer.parseInt(dir_mas[1])>16){
            //Si los bits es igual o mayor a 16, invoca el metodo saltos 3
            saltos3(i);
            
            
            if (newgroup[1] == 256) {
            cont[2] = 0;   
            Broadcast[i] = newgroup[0] + "." + 255 + "." + 255 + "." + 255;
            newgroup[0] = newgroup[0] + 1;
            newgroup[1] = cont[2];
            }
            
        }else{
          saltos[2]= host / 65536; //2^16
        cont[2] = cont[2] + saltos[2];   
            
        if (newgroup[1] == 256) {
            cont[2] = 0;
            Broadcast[i] = newgroup[0] + "." + 255 + "." + 255 + "." + 255;
            newgroup[0] = newgroup[0] + 1;
        }
        
        newgroup[3]=255;
        newgroup[2] = 255;
        
        //Proceso donde calcula la dirección de Subred, los Rangos, Broadcast
        SubnetAddress[i] = newgroup[0] + "." + newgroup[1] + "." + 0 + "." + 0;
        RangoHost[i] = newgroup[0] + "." + newgroup[1] + "." + 0 + "." + 1 + " - "
                + newgroup[0] + "." + ((cont[2])-1) + "." + newgroup[2]+ "." + (newgroup[3]-1);
       
        if (cont[2] != 0) {
            Broadcast[i] = newgroup[0] + "." + ((cont[2])-1) + "." + newgroup[2] + "." + newgroup[3];
        }
        
        newgroup[1] = cont[2];
    } 
        
    }
    
    private void saltos1(int i) {
        //condición que valida los bits encendidos por el usuario y realiza el calculo de subredes
        if (Integer.parseInt(dir_mas[1]) >= 8) {
            //Si los bits es igual o mayor a 8, invoca el metodo saltos 2
            saltos2(i);
        
        }else {
            //Si la condición no se cumple, realiza el calculo de las subredes.
            saltos[3] = host / 16777216; //2^24
            cont[3] = newgroup[0] + saltos[3];
            newgroup[3] = 255;
            newgroup[2] = 255;
            newgroup[1] = 255;

            //Proceso donde calcula la dirección de Subred, los Rangos, Broadcast
            SubnetAddress[i] = newgroup[0] + "." + 0 + "." + 0 + "." + 0;
            RangoHost[i] = newgroup[0] + "." + 0 + "." + 0 + "." + 1 + " - "
                    + ((cont[3]) - 1) + "." + newgroup[1] + "." + newgroup[2] + "." + (newgroup[3] - 1);
            
            //si el contador es diferente de 0, asigna el valor de la Broadcast.
            if (cont[3] != 0) {
                Broadcast[i] = newgroup[0] + "." + newgroup[1] + "." + newgroup[2] + "." + newgroup[3];
            }
            
            //asignación del nuevo valor del grupo 1 de octetos.
            newgroup[0] = cont[3];
        }
        
        //Valida si el grupo 1 es igual a 256bits y asigna la dirección Broadcast.
        if (newgroup[0] == 256) {
            Broadcast[i] = 255 + "." + 255 + "." + 255 + "." + 255;
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(Subneteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Subneteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Subneteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Subneteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subneteo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel binip;
    private javax.swing.JLabel binmas;
    private javax.swing.JLabel binsub;
    private javax.swing.JLabel binsub1;
    private javax.swing.JComboBox<String> boxhost;
    private javax.swing.JComboBox<String> boxmas;
    private javax.swing.JComboBox<String> boxsub;
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnexportar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtip;
    private javax.swing.JTextField txtprivada;
    private javax.swing.JTextField txtpublica;
    // End of variables declaration//GEN-END:variables

}
