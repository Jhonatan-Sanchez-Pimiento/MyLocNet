/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylocnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author nicol
 */
public class Ejemplo12 {
    private DatagramSocket clientSocket;
    
    private InetAddress serverIPAddress;
    private int serverPort;
    
    private DatagramPacket packetToSend;
    private DatagramPacket packetToReceive;
    
    private byte []   bufferToReceive;
    
    //Método constructor.
    public Ejemplo12(String address, int serverPort)
    {
        //Inicializa el buffer de recepción.
        bufferToReceive = new byte [1024];
        
        System.out.print("UDP Client: ");
        
        try
        {
            //Crea el socket en el lado cliente.
            clientSocket = new DatagramSocket();
            
            //Inicializa la dirección IP del servidor.
            serverIPAddress = InetAddress.getByName(address);
            
            //Inicializa el número de puerto en el servidor.
            this.serverPort = serverPort;
            
            //Crea el objeto que se desea enviar.
            Person person = new Person("Martin", 7, 1, 32);
            
            System.out.print(person);
            
            //Envía el objeto.
            send(person);
            
            //Recibe la respuesta que viene del servidor.
            String answer = (String) receive();
            
            System.out.print(answer);
            
            //Cierra el socket.
            clientSocket.close();
        }
    //Puede lanzar una excepción de socket.
    catch( SocketException e )
    {
        e.printStackTrace( );
    }
    //Puede lanzar una excepción de host desconocido.
    catch(UnknownHostException e)
    {
        e.printStackTrace();
    }
    //Puede lanzar una excepción de entrada y salida.
    catch(IOException e)
    {
        e.printStackTrace();
    }
    //Puede lanzar una excepción por una clase no encontrada.
    catch(ClassNotFoundException e)
    {
        e.printStackTrace();
    }
    }
    
    /**
     * Este método permite enviar un objeto al servidor.
     * @param o Recibe por parámetro el objeto que desea enviar
     * @throws IOException
     */
    private void send(Object o)throws IOException
    {
        //Serializa el objeto en un byte array.
        byte[] ba;
        ba = Util.objectToByteArray(o);
        
        //Crea el paquete para enviar, usando el byte array que acaba de crear.
        packetToSend = new DatagramPacket
                (ba, ba.length, serverIPAddress, serverPort);
        
        //Envía el paquete a través del socket.
        clientSocket.send(packetToSend);
    }
    
    /**
     * Este método permite recibir un objeto enviado por el servidor.
     * @throws IOException
     * @throws ClassNotFoundException
     */
     private Object receive () throws IOException, ClassNotFoundException
     {
         //Crea el paquete para recibir un objeto.
         packetToReceive = new DatagramPacket
                 (bufferToReceive, bufferToReceive.length);
         
         //Recibe un paquete que llega por el socket.
         clientSocket.receive(packetToReceive);
         
         //Deserializa el byte array en un objeto.
         Object o = Util.byteArrayToObject(bufferToReceive);
         
         //Retorna el objeto ya deserializado.
         return o;
     }
     
     /**
      * Metodo principal utilizado para lanzar el programa cliente.
      */
     public static void main(String args[])
     {
         new Ejemplo12("localhost", 3500);
     }
}    
    
    

