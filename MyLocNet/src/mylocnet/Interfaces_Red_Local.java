
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

    
    public Interfaces_Red_Local() {
        initComponents();
        direccionIP();
    }
    
    private void direccionIP(){
        try{
            //Se obtiene la lista de interfaces de red (NIC) del host local
            Enumeration <NetworkInterface> hostNics = NetworkInterface.getNetworkInterfaces();
            
            //Por cada una de las interfaces de red del host
            while(hostNics.hasMoreElements()){
                //Se obtiene su nombre y se imprime en la consola
                NetworkInterface nic = hostNics.nextElement();
                //Imprime el nombre de la Interfaz
                System.out.println("Interfaz " + nic.getName() + ":");
                //Se obtiene las direcciones IP asociadas a la interfaz de red
                Enumeration <InetAddress> nicdir = nic.getInetAddresses();
                //Cada dirección IP se clasifica como dirección V4 o V6 y se imprime
                
                while(nicdir.hasMoreElements()){
                    InetAddress direccion = nicdir.nextElement();
                    
                    if(direccion instanceof Inet4Address){
                        System.out.println("( IPv4 ) : " + direccion.getHostAddress());
                    } else {
                        if (direccion instanceof Inet6Address){
                            System.out.println("( IPv6 ) : "+ direccion.getHostAddress());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
    // End of variables declaration//GEN-END:variables
}
