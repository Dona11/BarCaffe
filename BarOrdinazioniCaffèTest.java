/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barordinazionicaffè;

import static java.lang.Thread.sleep;

/**
 *
 * @author Utente
 */
public class BarOrdinazioniCaffèTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        BufferBar bar = new BufferBar();
        ConsumatoreCameriere cc = new ConsumatoreCameriere(bar, 10);
        
        
        System.out.println("Il bar apre\n");
        
        sleep((long)(Math.random() * 2000));
        
        cc.start();
        
        for(int i = 0; i < 10; i++){
        
            ProduttoreCliente pc = new ProduttoreCliente(bar);
            pc.start();
        }
        
        for(int i = 0; i < 10; i++){
        
            ProduttoreCliente pc = new ProduttoreCliente(bar);
            cc.join();
        }
        
        cc.join();
        
        System.out.println("l'incasso totale è: " + bar.incassoTotale());
        System.out.println("Il bar chiude");
    }
    
}
