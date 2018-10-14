package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
    private Storage storage;
    private Semaphore semaMutex, semaProd, semaAss;
    private int time, nextPos, tracker;
    boolean hired;

    public Producer(Storage storage, Semaphore semaMutex, Semaphore semaProd, Semaphore semaAss, int time, int nextPos, int tracker) {
        this.hired = true;
        this.storage = storage;
        this.semaMutex = semaMutex;
        this.semaProd = semaProd;
        this.semaAss = semaAss;
        this.time = time;
        this.nextPos = nextPos;
        this.tracker = tracker;
    }
    
    @Override
    public void run(){
        while(this.hired){
        try {
            this.semaProd.acquire();
            Thread.sleep(this.time);
            this.semaMutex.acquire();
            this.storage.setVec(nextPos, 1);
            this.nextPos=(nextPos+1)%this.storage.getSize();
            this.semaAss.release();
            this.semaMutex.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public void fire(){
        this.hired = false;
    }
}
