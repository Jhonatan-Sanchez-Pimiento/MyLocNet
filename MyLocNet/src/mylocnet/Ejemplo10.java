/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates 
   Ejemplo10
 * and open the template in the editor.
 */
package mylocnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java. net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;


/**
 *
 * @author nicol
 */
public class Ejemplo10 {
    
   public static final int PORT = 3500;
   public static final String SERVER_LOCATION = "localhost";
   
   private DatagramSocket clientSocket;
   
   private InetAddress serverIPAddress;
   private int         serverPort;
   
   private DatagramPacket  packetToSend;
   private DatagramPacket  packetToReceive;
   
   private byte []         bufferToReceive;
   
   //Método constructor.
   public Ejemplo10 () {
       
       //Espacio de memoria utilizado para recibir datos.
       bufferToReceive = new byte [1024];
       
       System.out.print("UDP Client: ");
       
       try {
           
           //Creación del socket de datagrama en el lado cliente. Observe que en este caso
           //no es necesario identificar el servidor en el momento de crear el socket.
           clientSocket = new DatagramSocket();
           
           //Identificación del servidor
           serverIPAddress = InetAddress.getByName(SERVER_LOCATION);
           
           String message = JOptionPane.showInputDialog
                   (null, "Ingrese un mensaje: ");
           
           System.out.print("Enviado: " + message);
           
           //Envío del mensaje al servidor.
           send(message);
           
           //Recepción del mensaje al servidor.
           String response = (String) receive();
           
           System.out.print("Recibido: " + response);
           
           clientSocket.close();
       }
       //Puede lanzar una excepción de socket.
       catch(SocketException e )
       {
           e.printStackTrace();
       }
       //Puede lanzar una excepción de host desconocido.
       catch(UnknownHostException e )
       {
           e.printStackTrace();
       } 
       //Puede lanzar una excepción de entrada y salida.
       catch(IOException e)
       {
           e.printStackTrace();
       }    
   }
   
   /**
    * Este método permite enviar un mensaje al servidor.
    * @param messageToSend Recibe por parámetro el mensaje que desea enviar
    * @throws IOException
    */
    private void send (String messageToSend ) throws IOException {
        
        //Convierte el String en un byte []
        byte [] ba = messageToSend.getBytes();
        
        //Crea el paquete a enviar con el mensaje en forma de byte [], la
        //dirección IP del servidor y el número de puerto.
        packetToSend = new DatagramPacket (ba, ba.length, serverIPAddress, PORT);
        
        //Envía el paquete por el socket.
        clientSocket.send(packetToSend);
     
    } 
    
    /**
     * Este método permite recibir en mensaje enviado por el servidor
     * @throws IOException
     */
    private String receive () throws IOException {
        
        //Crea el paquete para recibir el mensaje de respuesta del servidor.
        //Observe que solo tiene el buffer para recibir.
        packetToReceive = new DatagramPacket
                (bufferToReceive, bufferToReceive.length);
        
        //Recibe el paquete enviado por el servidor.
        clientSocket.receive (packetToReceive);
        
        //Convierte a String el contenido del campo de datos del paquete recibido.
        String receivedMessage = new String
                (packetToReceive.getData(), 0, packetToReceive.getLength() );
        
        return receivedMessage;
        }
    /**
     * Método principal utilizado para lanzar el programa cliente.
     */
    public static void main (String args []) {
        
        new Ejemplo10();
        
    }
}
