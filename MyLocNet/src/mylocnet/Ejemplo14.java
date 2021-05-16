/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylocnet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
/**
 *
 * @author nicol
 */
public class Ejemplo14 {
  
    public static void main ( String args []) throws UnknownHostException, IOException
    { 
       System.out.print("Multicast Receiver. Waiting messages..."); 
       try
    {
        //Identificación del grupo multicast. Observe que corresponde a una
        //dirección IPv4 clase D, la cual puede estar en el rango 224.x.x.x
        // hasta 239.x.x.x.
        InetAddress group;
        group = InetAddress.getByName ("239.1.2.3");
        
        //Número de puerto del grupo.
        int puerto = 7200;
        
        //Creación del socket multicast.
        MulticastSocket socket = new MulticastSocket (puerto);
        
        //Unión al grupo.
        socket.joinGroup ( group );
        
        byte [ ] buffer = new byte [ 1000 ];
        
        //Creación del paquete que va a ser utilizado para recibir datos.
        DatagramPacket packet =
                new DatagramPacket (buffer, buffer.length );
        
        //Recepción de datos enviados por usuarios del grupo.
        socket.receive (packet);
        
        //Creación de un mensaje a partir de los datos recibidos.
        String message = new String
                (packet.getData (), 0, packet.getLength ());
        
        System.out.print("Received: " + message);
        
        //Salida del grupo.
        socket.leaveGroup (group);
    }
    //Puede lanzar una excepción de host desconocido.
    catch (UnknownHostException e )
            {
            e.printStackTrace ( ) ;
            }
    //Puede lanzar una excepción entrada y salida.
    catch(IOException e )
            {
            e.printStackTrace();
            }
    
    }
}
