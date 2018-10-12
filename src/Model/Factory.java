package Model;

import java.util.concurrent.Semaphore;

public class Factory {
    // Storage for parts (Buffer)
    private Storage screens, batteries, cables;
    // Count trackers for display in the UI
    private int screensCount, batteriesCount, cablesCount, assemblerCount, phonesCount;
    // Producer's count
    private int prodBCount, prodSCount, prodCCount;
    // How much seconds is a day
    private int dayTime;
    // How much time before delivery
    private int daysForDelivery;
    // Different type of producers
    private Producer[] screensProd, batteriesProd, cablesProd;
    // Assembler's array
    private Assembler[] assemblers;
    // Semaphores
    private Semaphore prodS, prodB, prodC, mutexS, mutexB, mutexC, mutexA, assS, assB, assC, timerManager;
    // Buffer pointers (Critical section)
    private int nextPosPS, nextPosPB, nextPosPC, nextPosAS, nextPosAB, nextPosAC;
    
    public int getHours(int hours){
        return (hours * getDayTime())/24;
    }

    public int getDayTime() {
        return dayTime;
    }
}
