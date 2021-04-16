/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylocnet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Ejemplo8 {
 
    public static final int PORT = 20000;
    public static final String SERVER_LOCATION = "localhost";
    
    private Socket             clientSocket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream  inFromServer;
    private FileOutputStream   out;
    private File               file;
    
    //Método constructor.
    public Ejemplo8( ) { 
        System.out.print("File Transfer Client");
        
        try {
            clientSocket = new Socket(SERVER_LOCATION, PORT);
            
            crearFlujos();
            
            //Solicita al usuario el nombre del archivo.
            String fileName = JOptionPane.showInputDialog
                    (null, "Nombre del archivo:" );
            
            //Envía el nombre del archivo al servidor.
            send(fileName);
            
            //Recibe archivo.
            receiveFile(fileName);
        }
        //Puede lanzar una excepción de entrada y salida.
        catch(IOException e )
        {
            e.printStackTrace();
        }
        //Finalmente se cierran los flujos y el socket.
        finally {
        
            try {
                if(inFromServer !=null) inFromServer.close();
                if(outToServer  !=null) outToServer.close();
                if(clientSocket !=null) clientSocket.close();
            }
            catch(IOException e )
            {
                e.printStackTrace();
            }    
        }
        System.out.print("OK");
    }
    
    /**
     * Este método recibe un archivo enviado por el servidor.
     * @throws IOException
     */
    private void receiveFile (String filename) throws IOException {
        
        try {
            //Se crea el archivo con el nombre especificado en la carpeta Download.
            //Obserbe que esta carpeta debe existir en el host del cliente.
            file = new File("Download" + File.separator + fileName);
            out = new FileOutputStream(file);
            
            //El cliente recibe el número de bloques que compone el archivo.
            int numberOfBlocks = ((Integer) receive()).intValue();{
        }
    }
    }
