
package mylocnet;

/**
 * @JhonatanSanchez @KatianaTordecilla @NicolasSutachan
 */
public class MyLocNet {

    
    public static void main(String[] args) {
        Operacion opr = new Operacion();
        int bin = 257;
        String valor = opr.DecimalABinario(bin);
        Interfaces_Red_Local redlocal = new Interfaces_Red_Local();
        redlocal.setVisible(true);
        Subneteo subnet = new Subneteo();
        subnet.setVisible(true);
    }
    
}
