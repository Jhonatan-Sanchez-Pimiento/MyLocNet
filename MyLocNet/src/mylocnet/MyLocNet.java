
package mylocnet;

/**
 * @JhonatanSanchez @KatianaTordecilla @NicolasSutachan
 */
public class MyLocNet {

    
    public static void main(String[] args) {
        
        Interfaces_Red_Local interfaz = new Interfaces_Red_Local();
        interfaz.setVisible(true);
        Operacion opr = new Operacion();
        int bin = 257;
        String valor = opr.DecimalABinario(bin);
        Subneteo subnet = new Subneteo();
        subnet.setVisible(true);
    }
    
}
