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
                // Consume 2 cables
                System.out.println("Consumidor C antes: " + this.getId() + ", valor: " + Factory.getBatteriesCount());
                this.assC.acquire(2);
                this.semMEC.acquire();
                for (int i = 0; i < 2; i++) {
                    this.storC.setVec(posC, 0);
                    this.posC = (this.posC+1)%this.storC.getSize();
                }
                this.prodC.release(2);
                this.semMEC.release();
                System.out.println("Consumidor C después: " + this.getId() + ", valor: " + Factory.getBatteriesCount());
                // Consume 1 screen
                System.out.println("Consumidor S antes: " + this.getId() + ", valor: " + Factory.getScreensCount());
                this.assS.acquire();
                this.semMES.acquire();
                this.storS.setVec(posS, 0);
                this.posS = (this.posS+1)%this.storS.getSize();
                this.prodS.release();
                this.semMES.release();
                System.out.println("Consumidor S despues: " + this.getId() + ", valor: " + Factory.getScreensCount());
                // Consume 1 battery
                System.out.println("Consumidor B antes: " + this.getId() + ", valor: " + Factory.getBatteriesCount());
                this.assB.acquire();
                this.semMEB.acquire();
                this.storB.setVec(posB, 0);
                this.posB = (this.posB+1)%this.storB.getSize();
                this.prodB.release();
                this.semMEB.release();
                System.out.println("Consumidor B después: " + this.getId() + ", valor: " + Factory.getBatteriesCount());
                // Build a phone
                System.out.println("Manager T antes: " + this.getId() + ", valor: " + Manager.getPhones());
                this.buildPhone();
                System.out.println("Manager T después: " + this.getId() + ", valor: " + Manager.getPhones());
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buildPhone(){
        try{
            Thread.sleep(this.time);
            System.out.println("Producir teléfonos antes: " + this.getId() + ", valor C, S, B: " + Factory.getCablesCount() + Factory.getScreensCount() + Factory.getBatteriesCount());
            Manager.addPhone();
            Factory.substractBatteriesCount();
            Factory.substractCablesCount();
            Factory.substractScreensCount();
            System.out.println("Producir teléfonos después: " + this.getId() + ", valor C, S, B: " + Factory.getCablesCount() + Factory.getScreensCount() + Factory.getBatteriesCount());
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }
    
    public void fire(){
        this.hired = false;
    }
}
