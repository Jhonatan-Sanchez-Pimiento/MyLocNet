package mylocnet;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 *  @JhonatanSanchez @KatianaTordecilla @NicolasSutachan
 */
public class Trans_Cliente extends javax.swing.JFrame {

    private static Object Cliente() {
        return null;
    }

    public Trans_Cliente() throws IOException, IOException {
        initComponents();
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

        public static final String SERVER_LOCATION = "Local host";
        public static final int  PORT = 20000;

        private Socket              clientSocket;
        private ObjectOutputStream  outToServer;
        private ObjectInputStream   inFromServer;

        //Método constructor.
        
    public void Trans_Cliente()
    {
            System.out.println("Cliente");
            
            try {
                clientSocket = new Socket ( SERVER_LOCATION, PORT);
                crearFlujos ( );
                
                //Creación del objeto Person.
                Person person =new Person ("Martin", 7, 1.32);
                
                System.out.println(person);
                //Envio del objeto al servidor.
                send (person);
                
                //Lectura del mensaje de resppuesta enviado por el servidor.
                String answer = (String) receive ();
                
                System.out.println(answer);
            }
            
        //Puede lanzar la excepción de entrada y salida.
        catch (IOException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trans_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Finalmente se cierran los flujos y el socket.
        finally {
                try {
                
                    if ( inFromServer !=null ) inFromServer.close();
                    if ( outToServer  !=null ) outToServer.close();
                    if ( clientSocket !=null ) clientSocket.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        /**
         * Este metodo permit crear los flujos de entrada y salida ecesario para
         * comunicar el cliente y el servidor.
         */
        private void crearFlujos ( ) throws IOException {
            //Creación del fujo de salida hacia el servidor.
            outToServer = new ObjectOutputStream (clientSocket.getOutputStream());
            
            //Creación del flujo de entrada desde el servidor.
            outToServer = new ObjectOutputStream (clientSocket.getOutputStream());
        }
        /**
         * Este método permite enviar un objeto al servidor.
         * @param o recibe por parámetro el objeto que desea enviar.
         * @throws IOException
         */
        
    private void send ( Object o ) throws IOException {
        
        outToServer.writeObject(0);
        outToServer.flush();
    }
    
    /**
     * Este método permite recibir un objeto enviado por el servidor.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private Object receive ( ) throws IOException, ClassNotFoundException {
        
        return inFromServer.readObject();
    }
        
    /**
     * Método principal utilizado para lanzar el programa cliente
     * @param args
     * @throws java.lang.Exception
     */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

