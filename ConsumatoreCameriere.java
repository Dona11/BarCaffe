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
public class ConsumatoreCameriere extends Thread{
    
    BufferBar b;
    int numeroClienti;
    int caffeOrdinati;

    public ConsumatoreCameriere(BufferBar bar, int numeroClienti) {
        this.b = bar;
        this.numeroClienti = numeroClienti;
    }
    
    public void run(){
    
        for(int i = numeroClienti; i > 0; i--){
        
            caffeOrdinati = b.preleva();
            
            try{
            
                sleep((long)(Math.random() * 2000));
            }catch(InterruptedException e){
            
            }
        }
    }
}
