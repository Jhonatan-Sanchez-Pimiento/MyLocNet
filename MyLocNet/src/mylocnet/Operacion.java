
package mylocnet;

import javax.swing.SwingConstants;

/**
 * @JhonatanSánchez @KatianaTordecilla @NicolasSutachan
 */

public class Operacion {

 String binario, decim, hexadec;
 int num;
 
   public String DecimalABinario(int dec){
     binario = "";
     String [] bina;
     int numero,cantdiv=0;
     numero = dec;
     
     for (int k = 1 ; numero > 0; k++){
       numero = numero/2;
       cantdiv= cantdiv +1;
     }
     System.out.println(cantdiv);
     bina = new String[cantdiv];
     
     for(int i=0; i<cantdiv ;i++){
      if(dec%2==1){
        bina [i] = "1";
      }else{
        bina [i] = "0";
      }
      dec = dec/2;
     }
     
     for(int j = cantdiv -1 ; j >= 0  ; j--){
        binario = binario + bina[j]; 
     }
          
     System.out.println(binario);
     return binario;
   }
   
   public void FormBinario(int numero){
       String formato = String.format("%%0%dd", 8);
       binario = String.format(formato,numero);
   }
   
   public long BinarioADecimal(long bin){
     binario = String.valueOf(bin);
     System.out.println(binario);
     System.out.println(binario.length());
     long decimal=0,valor;
     int cont=0;
     int binar [] = new int[binario.length()];
     
     for (int i = binario.length() - 1 ; i >= 0; i--){
         binar[cont]= Integer.parseInt(String.valueOf(binario.charAt(i)));
         cont=cont+1;
     }
     
     for (int j = 0 ; j < binario.length() ;  j++){
         System.out.println(binar[j]);
         valor = (long)(binar[j] * (Math.pow(2, j)));
         decimal = decimal + valor;
 } 
   return decimal;
   }
   
     
   
   
}
