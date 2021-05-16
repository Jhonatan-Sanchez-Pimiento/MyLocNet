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
public class FileTCPClient {
 
    public static final int PORT = 20000;
    public static final String SERVER_LOCATION = "localhost";
    
    private Socket             clientSocket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream  inFromServer;
    private FileOutputStream   out;
    private File               file;
    
    //Método constructor.
    public FileTCPClient( ) { 
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
            file = new File("Download" + File.separator + filename);
            out = new FileOutputStream(file);
            
            //El cliente recibe el número de bloques que compone el archivo.
            int numberOfBlocks = ((Integer) receive());
            
            //Se reciben uno a uno los bloques que conforman el archivo y se 
            //almacenan en el erchivo.
            for(int i = 0; i< numberOfBlocks; i++)
            {
                byte[] buffer = (byte[])receive();
                out.write(buffer, 0, buffer.length);
            }
        }
        //Puede lanzar una excepción por clase no encontrada.
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //Puede lanzar una excepción por un archivo no encontrado.
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        //Puede lanzar una excepción de entrada y salida.
        catch(IOException e)
        {
            e.printStackTrace();
        }    
        //Finalmente se cierra el archivo.
        finally
        {
            if(out !=null)out.close();
        }    
    }
    
    /**
     * Este método permite crear los flujos de entrada y salida necesarios para
     * comunicar el cliente y el servidor.
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        
        //Creación del flujo de entrada desde el servidor.
        inFromServer = new ObjectInputStream(clientSocket.getInputStream());
        
        //Creación del flujo de salida hacia el servidor.
        outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    }
    
    /**Este método permite enviar un objeto al servidor.
     * @param o Recibe por parámetro el objeto que desea enviar.
     * @throws IOException
     */
    private void send(Object o) throws IOException {
        
        outToServer.writeObject(o);
        outToServer.flush();
    }
    
/**
 * Este método permite recibir un objeto enviado por el servidor.
 * @throws IOException
 * @throws ClassNotFoundException
 */
 private Object receive() throws IOException, ClassNotFoundException {
     return inFromServer.readObject();
 }
 
/**
 * Método principal utilizado para lanzar el programa cliente.
 */
 public static void main (String args []) throws Exception {
     
     new FileTCPClient();
 }
}   
