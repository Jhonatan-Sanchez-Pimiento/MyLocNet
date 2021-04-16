package mylocnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @KatianaTordecilla @NicolasSutachan @JhonatanSanchez 
 */
public class Multihilo_Chat extends javax.swing.JFrame {

    public Multihilo_Chat() throws SocketException, UnknownHostException, IOException {
        initComponents();
        //Espacio d ememoria utilizado para recibir datos.
        bufferToReceive = new byte [1024];
        
        System.out.println("Cliente: ");
        
        try {
            clientSocket = new DatagramSocket();
            
            //Identificación de servidor.
            serverIPAddress = InetAddress.getByName(SERVER_LOCATION);
            String userName = JOptionPane.showInputDialog
                    (null, "Digite su nombre: ");
            //Envío de mensaje al servidor.
            send ("Nombre: "+userName);
            
            Thread thread = new Thread ((Runnable) this);
            thread.start();
            
            while (true){
                String message = JOptionPane.showInputDialog
                        (null, "Digite el mensaje: ");
                
                //Envio del mensaje al servidor.
                send ("Mensaje: "+userName + " Dice " + message);
            }
        }
        //Puede lanzar  una excepcion al socket.
        catch (SocketException e){
            e.printStackTrace();
        }
        //Puede lanar una excepción de host desconocido.
        catch (UnknownHostException e){
            e.printStackTrace(); 
        }
    }
 
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

    public static final int    PORT = 6800;
    public static final String SERVER_LOCATION = "local host";
    private DatagramSocket  clientSocket;
    private InetAddress     serverIPAddress;
    private DatagramPacket  packetToSend;
    private DatagramPacket  packetToReceive;
    
    private byte[]          bufferToReceive;
    
    public void run () throws IOException{
        while (true) {
            //Recepción del mensaje de respuesta enviado por el servidor.
            String response;
            
            response = (String) receive (); //Puede lanzar una excepcion de entrada y salida.
            System.out.println(response);
        }
    }
    private void send (String messageToSend) throws IOException {
        //Convierte el String en un byte 
        byte[] ba = messageToSend.getBytes();
        
        packetToSend = new DatagramPacket (ba, ba.length, serverIPAddress, PORT);
        
        //Envia el paquete por el socket.
        clientSocket.send(packetToSend);
    }
    private String receive()throws IOException {
        packetToReceive = new DatagramPacket
                (bufferToReceive, bufferToReceive.length);
        
        //Recibe el paquete enviado ppor el servidor.
        clientSocket.receive (packetToReceive);
        
        //Convierte en String el contenido del campo de datos el paquete recibido-
        String receivedMessage = new String
                (packetToReceive.getData(),0, packetToReceive.getLength());
        return receivedMessage;
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
            java.util.logging.Logger.getLogger(Multihilo_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Multihilo_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Multihilo_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Multihilo_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Multihilo_Chat().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Multihilo_Chat.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Multihilo_Chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
