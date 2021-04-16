
package mylocnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  @KatianaTordecilla @NicolasSutachan @JhonatanSanchez 
 */
public class Transmision_Objetos extends javax.swing.JFrame {

    private DatagramSocket clientSocket;
    private InetAddress    serverIPAddress;
    private int            serverPort;
    private DatagramPacket packetToSend;
    private DatagramPacket packetToReceive;
    private byte []        bufferToReceive;
            
            
    public Transmision_Objetos(String address, int serverPort) {
        initComponents();
            //Inicializa el buffer de recepción.
    bufferToReceive = new byte[1024];
    System.out.println ("Cliente: ");
    try {
    //Crea el socket en el lado cliente.
    clientSocket = new DatagramSocket();
    //Localización al número de puerto en el servidor.
    this.serverPort = serverPort;
    //Crea el objeto que se desea enviar.
    Vector <String> nombres = new Vector < String >();
    
    nombres.add("Sofia");
    nombres.add("Andres");
    nombres.add("Juliana");
    nombres.add("Duvan");
    nombres.add("Angie");
  
    System.out.println (nombres);
    //Envío del objeto.
    send (nombres);  
    //Recepción de la respuesta que viene del servidor.
    String respuesta = (String) receive();
    System.out.println (respuesta);
    clientSocket.close();
}
catch ( ClassNotFoundException | IOException ex) {
            Logger.getLogger(Transmision_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void send (Object o) throws IOException {
        //Serializa el objeto en un byte array.
        byte[] ba;
        ba =Utilidad.objectToByteArray(o);
        
        //Crea el paquete para enviar, usando el byte array que acaba de crear.
        packetToSend = new DatagramPacket
                (ba, ba.length, serverIPAddress, serverPort);
        
            //Envia el paquete a través del socket.
        clientSocket.send(packetToSend);
    }
    /**
     * Método que permite recibir un objeto enviado por el servidor.
     * @param args 
     */
    private Object receive () throws IOException, ClassNotFoundException {
        //Crea el paquete para recibir un objeto.
        packetToReceive = new DatagramPacket
                (bufferToReceive, bufferToReceive.length);
        
        //Recibe un paquete que llega por el socket-
        clientSocket.receive(packetToReceive);
        
        //Deserializa el byte array en un objeto.
        Object o =Utilidad.byteArrayToObject(bufferToReceive);
        
        //Retorna el objeto ya deserializado.
        return o;
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

    }                   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

