package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assembler extends Thread {
    Storage storC, storS, storB;
    Semaphore semMEB, semMES, semMEC, assB, assS, assC, prodB, prodS, prodC, mutexAss;
    int time, posS, posB, posC, phones;
    boolean hired;

    public Assembler(Storage storC, Storage storS, Storage storB, Semaphore semMEB, Semaphore semMES, Semaphore semMEC, Semaphore assB, Semaphore assS, Semaphore assC, Semaphore prodB, Semaphore prodS, Semaphore prodC, Semaphore mutexAss, int time, int posS, int posB, int posC, int phones) {
        this.storC = storC;
        this.storS = storS;
        this.storB = storB;
        this.semMEB = semMEB;
        this.semMES = semMES;
        this.semMEC = semMEC;
        this.assB = assB;
        this.assS = assS;
        this.assC = assC;
        this.prodB = prodB;
        this.prodS = prodS;
        this.prodC = prodC;
        this.mutexAss = mutexAss;
        this.time = time;
        this.posS = posS;
        this.posB = posB;
        this.posC = posC;
        this.phones = phones;
        this.hired = true;
    }

    

    
    
    @Override
    public void run(){
        while(this.hired){
            try{
                // Consume 2 cables
                this.assC.acquire(2);
                this.semMEC.acquire();
                for (int i = 0; i < 2; i++) {
                    this.storC.setVec(posC, 0);
                    this.posC = (this.posC+1)%this.storC.getSize();
                }
                this.prodC.release(2);
                this.semMEC.release();
                // Consume 1 screen
                this.assS.acquire();
                this.semMES.acquire();
                this.storS.setVec(posS, 0);
                this.posS = (this.posS+1)%this.storS.getSize();
                this.prodS.release();
                this.semMES.release();
                // Consume 1 battery
                this.assB.acquire();
                this.semMEB.acquire();
                this.storB.setVec(posB, 0);
                this.posB = (this.posB+1)%this.storB.getSize();
                this.prodB.release();
                this.semMEB.release();
                // Build a phone
                this.buildPhone();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buildPhone(){
        try{
            Thread.sleep(this.time);
            this.mutexAss.acquire();
            this.phones++;
            this.mutexAss.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }
    
    public void fire(){
        this.hired = false;
    }
}
