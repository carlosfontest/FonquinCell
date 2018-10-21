package Model;

import View.ControlPanel;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assembler extends Thread {
    Storage storC, storS, storB;
    Semaphore semMEB, semMES, semMEC, assB, assS, assC, prodB, prodS, prodC;
    int time;
    boolean hired;

    public Assembler(Storage storC, Storage storS, Storage storB, Semaphore semMEB, Semaphore semMES, Semaphore semMEC, Semaphore assB, Semaphore assS, Semaphore assC, Semaphore prodB, Semaphore prodS, Semaphore prodC, int time) {
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
                    this.storC.setVec(Factory.nextPosAC, 0);
                    Factory.nextPosAC = (Factory.nextPosAC+1)%this.storC.getSize();
                }
                Factory.substractCablesCount();
                this.semMEC.release();
                this.semMES.acquire();
                this.storS.setVec(Factory.nextPosAS, 0);
                Factory.nextPosAS = (Factory.nextPosAS+1)%this.storS.getSize();
                Factory.substractScreensCount();
                this.semMES.release();
                this.semMEB.acquire();
                this.storB.setVec(Factory.nextPosAB, 0);
                Factory.nextPosAB = (Factory.nextPosAB+1)%this.storB.getSize();
                Factory.substractBatteriesCount();
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
