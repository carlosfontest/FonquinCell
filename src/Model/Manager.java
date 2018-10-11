/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.concurrent.Semaphore;

/**
 *
 * @author rafae
 */
public class Manager {
    private boolean awake;
    private int minTime, maxTime;
    Semaphore mutex;

    public Manager(boolean awake, Semaphore mutex) {
        this.awake = awake;
        this.mutex = mutex;
        this.minTime = 6;
        this.maxTime = 18;
    }
    
    
}
