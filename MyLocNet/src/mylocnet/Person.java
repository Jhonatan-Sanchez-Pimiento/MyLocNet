
package mylocnet;

/**
 *
 * 
 */

public class Person extends javax.swing.JFrame {
    
    String nombre;
     int age;
     double height;
     //Método constructor. Recibe el nommbre, la edad y la estatura de la persona.
    public Person(String nombre, int age,double height) {
        initComponents();
        this.nombre = nombre;
        this.age = age;
        this.height = height;
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
    //Este tipo de clases permiten crear objetos que seran
    //transportados por la red, deben implementar la interface Serializable.
    
    
    /**
     * Este método retorna el nombre de la persona.
         * @return 
     */
    public String getNamme() {
        return nombre;
    }
    /*
     * Este método retorna la edad de la persona.
     */
    public int getAge() {
        return age;
    }
    /**
     * Este método especifica la forma de imprimir el valor del objeto.
     */
    public String toString() {
        return nombre + ":\t" + " - " + height;
    }
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

