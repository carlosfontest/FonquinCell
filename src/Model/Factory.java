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
        // Initializing producers count
        this.prodBCount = 0;
        this.prodSCount = 0;
        this.prodCCount = 0;
        // Parts count
        this.screensCount = 0;
        this.batteriesCount = 0;
        this.cablesCount = 0;
        // Initializing producers counters
        for (int i = 0; i < batteriesInitProd; i++) {
            if(this.hireBatteriesProd()){
                System.out.println("Battery producer: " + (i+1));
            }
        }
        for (int i = 0; i < screensInitProd; i++) {
            if(this.hireScreensProd()){
                System.out.println("Screen producer: " + (i+1));
            }
        }
        for (int i = 0; i < cablesInitProd; i++) {
            if(this.hireCablesProd()){
                System.out.println("Cable producer: " + (i+1));
            }
        }
        // Initializing assemblers
        for (int i = 0; i < initAss; i++) {
            if(this.hireAssembler()){
                System.out.println("Assembler: " + (i+1));
            }
        }
    }
    
    
    // Returns seconds of an hour in the simulation
    public int getHours(int hours){
        return (hours * this.dayTime)/24;
    }
    
    // Methods for hiring producers and assemblers;
    public boolean hireBatteriesProd(){
        for (int i = 0; i < this.batteriesProd.length; i++) {
            if(this.batteriesProd[i] == null){
                this.batteriesProd[i] = new Producer(this.batteries,this.mutexPB,this.prodB, this.assB, this.dayTime, this.nextPosPB, this.batteriesCount);
                this.prodBCount++;
                return true;
            }
        }
        return false;
    }
    public boolean hireScreensProd(){
        for (int i = 0; i < this.screensProd.length; i++) {
            if(this.screensProd[i] == null){
                this.screensProd[i] = new Producer(this.screens,this.mutexPS,this.prodS, this.assS, this.dayTime*2, this.nextPosPS, this.screensCount);
                this.prodSCount++;
                return true;
            }
        }
        return false;
    }
    public boolean hireCablesProd(){
        for (int i = 0; i < this.cablesProd.length; i++) {
            if(this.cablesProd[i] == null){
                this.cablesProd[i] = new Producer(this.cables,this.mutexPC,this.prodC, this.assC, this.dayTime, this.nextPosPC, this.cablesCount);
                this.prodCCount++;
                return true;
            }
        }
        return false;
    }
    public boolean hireAssembler(){
        for (int i = 0; i < this.assemblers.length; i++) {
            if(this.assemblers[i] == null){
                this.assemblers[i] = new Assembler(this.cables, this.screens, this.batteries, this.mutexAB,this.mutexAS, this.mutexAC, this.assB, this.assS, this.assC, this.prodB, this.prodS, this.prodC, this.mutexA, this.dayTime*2, this.nextPosAS, this.nextPosAB, this.nextPosAC, this.phonesCount); 
                this.assemblerCount++;
                return true;
            }
        }
        return false;
    }
    public boolean fireBatteryProducer(){
        for (int i = batteriesProd.length-1; i > -1; i--) {
            if(batteriesProd[i] != null){
                batteriesProd[i].fire();
                batteriesProd[i] = null;
                this.prodBCount--;
                return true;
            }
        }
        return false;
    }
    public boolean fireScreenProducer(){
        for (int i = screensProd.length-1; i > -1; i--) {
            if(screensProd[i] != null){
                screensProd[i].fire();
                screensProd[i] = null;
                this.prodSCount--;
                return true;
            }
        }
        return false;
    }
    public boolean fireCableProducer(){
        for (int i = cablesProd.length-1; i > -1; i--) {
            if(cablesProd[i] != null){
                cablesProd[i].fire();
                cablesProd[i] = null;
                this.prodCCount--;
                return true;
            }
        }
        return false;
    }
    public boolean fireAssembler(){
        for (int i = assemblers.length-1; i > -1; i--) {
            if(assemblers[i] != null){
                assemblers[i].fire();
                assemblers[i] = null;
                this.assemblerCount--;
                return true;
            }
        }
        return false;
    }
}
