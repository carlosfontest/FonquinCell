package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Timer extends Thread{
    private static int daysLeft;
    private int workTime, restTime;
    private Semaphore mutex;
    private boolean awake;

    public Timer(int daysLeft, int workTime, int restTime, Semaphore mutex) {
        this.daysLeft = daysLeft;
        this.workTime = workTime;
        this.restTime = restTime;
        this.mutex = mutex;
    }
    
    @Override
    public void run(){
        while(true){
        try {
            this.mutex.acquire();
            Thread.sleep(workTime);
            this.daysLeft--;
            this.mutex.release();
            Thread.sleep(restTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public static int getDaysLeft() {
        return daysLeft;
    }

    public static void resetDaysLeft(int daysForDelivery) {
        Timer.daysLeft = daysForDelivery;
    }
    
    

    public boolean isAwake() {
        return awake;
    }
}
