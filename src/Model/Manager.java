package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Thread {
    private static boolean awake;
    private int minTime, maxTime, daysForDelivery;
    private static int phones;
    private Semaphore mutex;

    public Manager(int daysForDelivery, int minTime, int maxTime, Semaphore mutex) {
        this.mutex = mutex;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.daysForDelivery = daysForDelivery;
        this.awake = true;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                // Tiempo que estrá dormido
                int random = this.minTime + ((int) (Math.random() * (this.maxTime-this.minTime)) + 1);
                this.awake = true;
                Thread.sleep(this.minTime * 4 - random);
                this.mutex.acquire();
                if(Timer.getDaysLeft() == 0){
                    this.phones = 0;
                    Timer.resetDaysLeft(this.daysForDelivery);
                }
                this.awake = false;
                this.mutex.release();
                Thread.sleep(random);
            } catch (InterruptedException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String isAwake() {
        if(Manager.awake){
            return "Awake";
        }
        return "Asleep";
    }

    public static int getPhones() {
        return Manager.phones;
    }

    public static void addPhone() {
        Manager.phones++;
    }
    
    
    
    
    
}
