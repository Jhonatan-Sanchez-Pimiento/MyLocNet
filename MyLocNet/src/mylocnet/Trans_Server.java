
package mylocnet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *  @JhonatanSanchez @KatianaTordecilla @NicolasSutachan
 */
public class Trans_Server extends javax.swing.JFrame {

    public Trans_Server() {
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
        
        public static final int PORT = 20000;
        
        private ServerSocket        welcomeSocket;
        private Socket              connectionSocket;
        private ObjectOutputStream  outToClient;
        private ObjectInputStream   inFromClient;
        
        
        //Método constructor.
        public void Trans_Server() throws IOException {
            System.out.println("Server");
            
            try {
                welcomeSocket = new ServerSocket ( PORT);
                while (true) {
                    connectionSocket = welcomeSocket.accept ();
                    CrearFlujos();
                    
                    //Lectura del objetivo enviado por el cliente. Obsereve que se  debe
                    //recibir haiendo cast al tipo de dato que el cliente esta enviando.
                    Person person =(Person) receive();
                    
                    System.out.println(person);
                    
                    //Procesamiento de la información que el cliente ha enviado al
                    //servidor. En este caso, la respuesta es el String OK.
                    String answer = "OK";
                    
                   //Envío de la respuesta del servidor al cliente.
                   send (answer);
                }
            }
            //Puede lanzar excepción de entrada y salida.
            catch (IOException e){
                e.printStackTrace();
            }
            //Puede lanzar la excepción por clase no encontrada.
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Al terminar se cierran los socket y los flujos.
            finally
            {
                try{
                    if (outToClient         !=null) outToClient.close();
                    if (inFromClient        !=null) inFromClient.close();
                    if (connectionSocket    !=null) connectionSocket.close();
                    if (welcomeSocket       !=null) welcomeSocket.close();        
                }
                //Puede lanzar una excepción de entrad y salida.
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        /**
         * Este método permite crear los flujos de entrada y saida necesarios 
         * para comunicar el cliente y el servidor.
         * @throws IOException
         */
        private void send (Object o) throws IOException {
            outToClient.writeObject( o );
            outToClient.flush();
        }
        /**
         * Este método permite recibir un objeto enviado por el cliente
         * @throws IOException
         * @throws ClassNotFoundException
         */
        private Object receive () throws IOException, ClassNotFoundException {
            return inFromClient.readObject();
        }
        /**
         * Método principal utilizando para lanzar el programa servidor.
         * @param args
         * @throws java.lang.Exception
         */
        public static void main (String args []) throws Exception {
            new Trans_Server();
        }

    private void CrearFlujos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        }
    
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

