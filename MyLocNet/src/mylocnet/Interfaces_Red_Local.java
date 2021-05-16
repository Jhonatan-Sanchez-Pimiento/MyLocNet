
package mylocnet;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @JhonatanSanchez @KatianaTordecilla @NicolasSutachan
 */
public class Interfaces_Red_Local extends javax.swing.JFrame {
    
     InetAddress direccion;
    
    public Interfaces_Red_Local() {
        initComponents();
        setLocationRelativeTo(null);
        direccionIP();
    }
    
    private void direccionIP(){
        try{
            //Se obtiene la lista de interfaces de red (NIC) del host local
            Enumeration <NetworkInterface> hostNics = NetworkInterface.getNetworkInterfaces();
            //Por cada una de las interfaces de red del host
            int a = NetworkInterface.getNetworkInterfaces().nextElement().getIndex();
            System.out.println(a);
            while(hostNics.hasMoreElements()){
                //Se obtiene su nombre y se imprime en la consola
                NetworkInterface nic = hostNics.nextElement();
                
                //Imprime el nombre de la Interfaz
                areatxt.setText(areatxt.getText()+ "\nInterfaz " + nic.getDisplayName() + ":\n");
                //Se obtiene las direcciones IP asociadas a la interfaz de red
                Enumeration <InetAddress> nicdir = nic.getInetAddresses();
                //Cada dirección IP se clasifica como dirección V4 o V6 y se imprime
                
                while(nicdir.hasMoreElements()){
                    InetAddress direccion = nicdir.nextElement();
                    
                    if(direccion instanceof Inet4Address){
                        areatxt.setText(areatxt.getText()+ "( IPv4 ) : " + direccion.getHostAddress()+"\n");
                    } else {
                        if (direccion instanceof Inet6Address){
                            areatxt.setText(areatxt.getText()+"( IPv6 ) : "+ direccion.getHostAddress()+"\n");
                        }
                    }
                }
            }
        }
        catch (SocketException e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areatxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbltit.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbltit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltit.setText("INTERFACES DE LA RED LOCAL");

        areatxt.setColumns(20);
        areatxt.setRows(5);
        jScrollPane1.setViewportView(areatxt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lbltit, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

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
            java.util.logging.Logger.getLogger(Interfaces_Red_Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaces_Red_Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaces_Red_Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaces_Red_Local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaces_Red_Local().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areatxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltit;
    // End of variables declaration//GEN-END:variables
}
