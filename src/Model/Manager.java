/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class Manager extends Thread {
    private boolean awake;
    private int minTime, maxTime, daysForDelivery;
    private static int phones;
    private Semaphore mutex;

    public Manager(int daysForDelivery, int minTime, int maxTime, Semaphore mutex) {
        this.mutex = mutex;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.daysForDelivery = daysForDelivery;
        this.awake = false;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.mutex.acquire();
                this.awake = true;
                if(Timer.getDaysLeft() == 0){
                    this.phones = 0;
                    Timer.resetDaysLeft(this.daysForDelivery);
                }
                this.awake = false;
                this.mutex.release();
                Thread.sleep(this.minTime + ((int) (Math.random() * (this.maxTime-this.minTime)) + 1));
            } catch (InterruptedException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isAwake() {
        return awake;
    }

    public static int getPhones() {
        return phones;
    }

    public static void addPhone() {
        Manager.phones++;
    }
    
    
    
    
    
}
