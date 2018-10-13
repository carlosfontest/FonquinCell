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
    private Semaphore prodS, prodB, prodC, mutexPS, mutexPB, mutexPC, mutexAS, mutexAB, mutexAC, mutexA, assS, assB, assC, timerManager;
    // Buffer pointers (Critical section)
    private int nextPosPS, nextPosPB, nextPosPC, nextPosAS, nextPosAB, nextPosAC;

    public Factory(int dayTime, int daysForDelivery, int screensStorageMax, int batteriesStorageMax, int cablesStorageMax, int batteriesInitProd, int screensInitProd, int cablesInitProd, int cablesMaxProd, int screensMaxProd, int batteriesMaxProd, int initAss, int maxAss) {
        // Initializing production semaphores
        this.prodS = new Semaphore(screensInitProd);
        this.prodB = new Semaphore(batteriesInitProd);
        this.prodC = new Semaphore(cablesInitProd);
        // Initializing mutex semaphores
        this.mutexPS = new Semaphore(1);
        this.mutexPC = new Semaphore(1);
        this.mutexPB = new Semaphore(1);
        this.mutexAS = new Semaphore(1);
        this.mutexAB = new Semaphore(1);
        this.mutexAC = new Semaphore(1);
        this.mutexA = new Semaphore(1);
        // Initializing assembler semaphores
        this.assS = new Semaphore(0);
        this.assB = new Semaphore(0);
        this.assC = new Semaphore(0);
        // Initializing next positions
        this.nextPosPS = 0;
        this.nextPosPB = 0;
        this.nextPosPC = 0;
        this.nextPosAS = 0;
        this.nextPosAC = 0;
        this.nextPosAB = 0;
        // Initializing counters
        this.assemblerCount = 0;
        this.batteriesCount = 0;
        this.screensCount = 0;
        this.cablesCount = 0;
        // Assigning JSON Values
        this.dayTime = dayTime;
        this.daysForDelivery = daysForDelivery;
        this.screens = new Storage(screensStorageMax);
        this.batteries = new Storage(batteriesStorageMax);
        this.cables = new Storage(cablesStorageMax);
        this.batteriesProd = new Producer[batteriesMaxProd];
        this.screensProd = new Producer[screensMaxProd];
        this.cablesProd = new Producer[cablesMaxProd];
        // Initializing producers
        for (int i = 0; i < batteriesInitProd; i++) {
            this.batteriesProd[i] = this.newBatteriesProd();
        }
        for (int i = 0; i < screensInitProd; i++) {
            this.screensProd[i] = this.newScreensProd();
        }
        for (int i = 0; i < cablesInitProd; i++) {
            this.cablesProd[i] = this.newCablesProd();
        }
        // Initializing assemblers
        for (int i = 0; i < initAss; i++) {
            this.assemblers[i] = this.newAssembler();
        }
    }
    
    
    
    public int getHours(int hours){
        return (hours * getDayTime())/24;
    }

    public int getDayTime() {
        return dayTime;
    }
    
    public Producer newBatteriesProd(){
        this.batteriesCount++;
        return new Producer(this.batteries,this.mutexPB,this.prodB, this.assB, this.dayTime, this.nextPosPB);
    }
    public Producer newScreensProd(){
        this.screensCount++;
        return new Producer(this.screens,this.mutexPS,this.prodS, this.assS, this.dayTime*2, this.nextPosPS);
    }
    public Producer newCablesProd(){
        this.cablesCount++;
        return new Producer(this.cables,this.mutexPC,this.prodC, this.assC, this.dayTime, this.nextPosPC);
    }
    public Assembler newAssembler(){
        this.assemblerCount++;
        return new Assembler(this.cables, this.screens, this.batteries, this.mutexAB,this.mutexAS, this.mutexAC, this.assB, this.assS, this.assC, this.prodB, this.prodS, this.prodC, this.mutexA, this.dayTime*2, this.nextPosAS, this.nextPosAB, this.nextPosAC, this.phonesCount); 
    }
}
