
package mylocnet;

import javax.swing.SwingConstants;
import sun.security.pkcs11.wrapper.Functions;

/**
 * @JhonatanSánchez @KatianaTordecilla @NicolasSutachan
 */

public class Operacion {

 String binario, decim, hexadec;
 int num;
 
   public String DecimalABinario(int dec){
     binario = Integer.toBinaryString(dec);
     return binario;
   }
   
   public int BinarioADecimal(long bin) {
        int decimal = 0;
        int potencia = 0;
        //ciclo infinito hasta que sea 0
        while (true) {
            if (bin != 0) {
                long residuo = bin % 10;
                decimal += residuo * Math.pow(2, potencia);
                bin = bin / 10;
                potencia++;
            } else {
                break;
            }
        }
        return decimal;
    }
   
     
   
   
}
