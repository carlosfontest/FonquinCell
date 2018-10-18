package Model;

import View.ControlPanel;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assembler extends Thread {
    Storage storC, storS, storB;
    Semaphore semMEB, semMES, semMEC, assB, assS, assC, prodB, prodS, prodC;
    int time, posS, posB, posC;
    boolean hired;

    public Assembler(Storage storC, Storage storS, Storage storB, Semaphore semMEB, Semaphore semMES, Semaphore semMEC, Semaphore assB, Semaphore assS, Semaphore assC, Semaphore prodB, Semaphore prodS, Semaphore prodC, int time, int posS, int posB, int posC) {
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
        this.time = time;
        this.posS = posS;
        this.posB = posB;
        this.posC = posC;
        this.hired = true;
    }

    

    
    
    @Override
    public void run(){
        while(this.hired){
            try{
                this.assC.acquire(2);
                this.assS.acquire();
                this.assB.acquire();
                this.semMEC.acquire();
                for (int i = 0; i < 2; i++) {
                    this.storC.setVec(posC, 0);
                    this.posC = (this.posC+1)%this.storC.getSize();
                }
                this.semMEC.release();
                this.semMES.acquire();
                this.storS.setVec(posS, 0);
                this.posS = (this.posS+1)%this.storS.getSize();
                this.semMES.release();
                this.semMEB.acquire();
                this.storB.setVec(posB, 0);
                this.posB = (this.posB+1)%this.storB.getSize();
                this.semMEB.release();
                this.prodC.release(2);
                this.prodS.release();
                this.prodB.release();
                this.buildPhone();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buildPhone(){
        try{
            Factory.substractBatteriesCount();
            Factory.substractCablesCount();
            Factory.substractScreensCount();
            Thread.sleep(this.time);
            Manager.addPhone();
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }
    
    public void fire(){
        this.hired = false;
    }
}
