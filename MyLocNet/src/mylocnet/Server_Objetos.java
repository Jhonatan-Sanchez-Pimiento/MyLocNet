package mylocnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @KatianaTordecilla @NicolasSatuchan@author @JhonatanSanchez 
 */
public class Server_Objetos extends javax.swing.JFrame {

        private DatagramSocket   serverSocket;
        private InetAddress      clientIPAddress;
        private int              clientPort;
        private DatagramPacket   packetToSend;
        private DatagramPacket   packetToReceive;
        private byte []          bufferToReceive;
        
    public Server_Objetos() {
        initComponents();
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
        /**
         * Este método permite enviar un objeto al cliente.
         */
        private void send (Object o) throws IOException
        {
            //Serializa el objeto en un byte array.
            byte [] ba = Utilidad.objectToByteArray(o);
            
            //Creación el paquete para enviar, usando el byte array que acaba de crear.
            packetToSend = new DatagramPacket
                    (ba, ba.length, clientIPAddress, clientPort);
            
            //envía el paquete a través del socket.
            serverSocket.send (packetToSend);
            
                }
        /**
         * Este método permite recibir un objeto enviado por el cliente.
         */
        private Object receive () throws IOException, ClassNotFoundException
                {
                    //Crea el paquete para recibir
                    packetToReceive = new DatagramPacket
                            (bufferToReceive, bufferToReceive.length);
                    
                    //Recibe un paquete que llega por el socket.
                    serverSocket.receive(packetToReceive);
                    
                    //Obtiene la dirección IP del cliente
                    clientIPAddress = packetToReceive.getAddress();
                    
                    //Obtiene el número de puerto del cliente
                    clientPort = packetToReceive.getPort();
                    
                    //Deserializa el byte array en un objeto.
                    Object o = Utilidad.byteArrayToObject (bufferToReceive);
                    
                    //Retorna el objeto ya deserializado.
                    return o;       
            }
            
        public static void main (String args []){
            Server_Objetos server_Objetos = new Server_Objetos();
        }
        
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


