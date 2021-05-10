/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barordinazionicaffè;

/**
 *
 * @author Utente
 */
public class ProduttoreCliente extends Thread{
    
    BufferBar b;

    public ProduttoreCliente(BufferBar bar) {
        this.b = bar;
    }
    
    public void run(){
    
        try{
        
            sleep((long) Math.random() * 2000);
        }catch(InterruptedException e){
        
        }
        
        b.deposita((int) (Math.random() * 4) + 1);
    }
}
