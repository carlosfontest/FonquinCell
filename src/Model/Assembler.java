package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assembler extends Thread {
    Storage storC, storS, storB;
    Semaphore semMEB, semMES, semMEC, assB, assS, assC, prodB, prodS, prodC, mutexAss;
    int cables, screens, batteries, time, posS, posB, posC, phones;

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
        this.screens = 0;
        this.batteries = 0;
        this.cables = 0;
    }

    

    
    
    @Override
    public void run(){
        while(true){
            try{
                if(cables != 2){
                    this.assC.acquire();
                    this.semMEC.acquire();
                    this.storC.setVec(posC, 0);
                    this.posC = (this.posC+1)%this.storC.getSize();
                    this.prodC.release();
                    this.semMEC.release();
                }
                this.buildPhone();
                if(screens != 1){
                    this.assS.acquire();
                    this.semMES.acquire();
                    this.storS.setVec(posS, 0);
                    this.posS = (this.posS+1)%this.storS.getSize();
                    this.prodS.release();
                    this.semMES.release();
                }
                if(batteries != 1){
                    this.assB.acquire();
                    this.semMEB.acquire();
                    this.storB.setVec(posB, 0);
                    this.posB = (this.posB+1)%this.storB.getSize();
                    this.prodB.release();
                    this.semMEB.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buildPhone(){
        if(this.cables == 2 && this.batteries == 1 && this.screens == 1){
            try{
                Thread.sleep(this.time);
                this.mutexAss.acquire();
                this.phones++;
                this.mutexAss.release();
                this.cables = 0;
                this.batteries = 0;
                this.screens = 0;
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return;
    }
}
