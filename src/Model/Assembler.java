package Model;

import java.util.concurrent.Semaphore;

public class Assembler {
    Semaphore semMEB, semMES, semMEC, semB, semS, semC;
    int[] screens, batteries, cables;
    int time, posS, posB, posC;

    public Assembler(Semaphore semMEB, Semaphore semMES, Semaphore semMEC, Semaphore semB, Semaphore semS, Semaphore semC, int posS, int posB, int posC) {
        this.semMEB = semMEB;
        this.semMES = semMES;
        this.semMEC = semMEC;
        this.semB = semB;
        this.semS = semS;
        this.semC = semC;
        this.posS = posS;
        this.posB = posB;
        this.posC = posC;
        screens = new int[1];
        batteries = new int[1];
        cables = new int[2];
    }
    
    

    
    
    
}
