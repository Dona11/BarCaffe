/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barordinazionicaffè;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Utente
 */
public class BufferBar {
    
    protected Semaphore semVuoto = new Semaphore(1);
    protected Semaphore semPieno = new Semaphore(0);
    protected int bufferCaffe;
    protected int totale = 0;
    
    public void deposita(int numOrd){
    
        try{
        
            semVuoto.acquire();
        }catch(InterruptedException e){
        
        }
        bufferCaffe = numOrd;
        totale += bufferCaffe;
        System.out.println("N° di caffè ordinati: " + bufferCaffe);
        semPieno.release();
        
    }
    
    public int preleva(){
    
        try{
        
            semPieno.acquire();
        }catch(InterruptedException e){
        
        }
        System.out.println("I caffè sono stati serviti");
        semVuoto.release();
        return bufferCaffe;
    }
    
    public int incassoTotale(){
    
        return totale;
    }
}
