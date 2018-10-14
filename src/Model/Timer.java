package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Timer extends Thread{
    private int daysLeft, time;
    private Semaphore mutex;
    private boolean awake;

    public Timer(int daysLeft, int time, Semaphore mutex) {
        this.daysLeft = daysLeft;
        this.time = time;
        this.mutex = mutex;
    }
    
    @Override
    public void run(){
        while(true){
        try {
            this.mutex.acquire();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    

    public int getDaysLeft() {
        return daysLeft;
    }

    public boolean isAwake() {
        return awake;
    }
}
