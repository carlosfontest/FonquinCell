package Model;

import java.util.concurrent.Semaphore;

public class Factory {
    // Storage for parts (Buffer)
    private Storage screens, batteries, cables;
    // Count trackers for display in the UI
    private static int screensCount, batteriesCount, cablesCount;
    // Producer's and assembler's count 
    private int prodBCount, prodSCount, prodCCount, assemblerCount;
    // How much seconds is a day
    private int dayTime;
    // How much time between deliveries
    private int daysForDelivery;
    // How much days for next delivery
    private int daysLeft;
    // Different type of producers and assemblers count
    private Producer[] screensProd, batteriesProd, cablesProd;
    // Assembler's array
    private Assembler[] assemblers;
    // Semaphores
    private Semaphore prodS, prodB, prodC, mutexPS, mutexPB, mutexPC, mutexAS, mutexAB, mutexAC, assS, assB, assC, timerManager;
    // Buffer pointers (Critical section)
    private int nextPosPS, nextPosPB, nextPosPC, nextPosAS, nextPosAB, nextPosAC;
    // Manager
    private Manager manager;
    // Timer
    private Timer timer;

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
        this.daysLeft = this.daysForDelivery;
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
        // Initialize timer
        this.timer = new Timer(this.daysForDelivery, this.getHours(3/2), this.timerManager);
        // Initialize manager with min and max time in hours (MIN = 6 hours | MAX = 18 hours)
        this.manager = new Manager(this.daysForDelivery, this.daysLeft, this.getHours(6), this.getHours(18), this.timerManager);
        // Initializing producers counters
        for (int i = 0; i < batteriesInitProd; i++) {
            this.hireBatteriesProd();
        }
        for (int i = 0; i < screensInitProd; i++) {
            this.hireScreensProd();
        }
        for (int i = 0; i < cablesInitProd; i++) {
            this.hireCablesProd();
        }
        // Initializing assemblers
        for (int i = 0; i < initAss; i++) {
            this.hireAssembler();
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
                this.batteriesProd[i] = new Producer(this.batteries,this.mutexPB,this.prodB, this.assB, this.dayTime, this.nextPosPB, 0);
                this.prodBCount++;
                System.out.println("Batteries prod: " + this.prodBCount);
                return true;
            }
        }
        return false;
    }
    public boolean hireScreensProd(){
        for (int i = 0; i < this.screensProd.length; i++) {
            if(this.screensProd[i] == null){
                this.screensProd[i] = new Producer(this.screens,this.mutexPS,this.prodS, this.assS, this.dayTime*2, this.nextPosPS, 1);
                this.prodSCount++;
                System.out.println("Screens prod: " + this.prodSCount);
                return true;
            }
        }
        return false;
    }
    public boolean hireCablesProd(){
        for (int i = 0; i < this.cablesProd.length; i++) {
            if(this.cablesProd[i] == null){
                this.cablesProd[i] = new Producer(this.cables,this.mutexPC,this.prodC, this.assC, this.dayTime, this.nextPosPC, 2);
                this.prodCCount++;
                System.out.println("Cables prod: " + this.prodCCount);
                return true;
            }
        }
        return false;
    }
    public boolean hireAssembler(){
        for (int i = 0; i < this.assemblers.length; i++) {
            if(this.assemblers[i] == null){
                this.assemblers[i] = new Assembler(this.cables, this.screens, this.batteries, this.mutexAB,this.mutexAS, this.mutexAC, this.assB, this.assS, this.assC, this.prodB, this.prodS, this.prodC, this.dayTime*2, this.nextPosAS, this.nextPosAB, this.nextPosAC); 
                this.assemblerCount++;
                System.out.println("Assembler prod: " + this.assemblerCount);
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

    public static int getScreensCount() {
        return screensCount;
    }

    public static int getBatteriesCount() {
        return batteriesCount;
    }

    public static int getCablesCount() {
        return cablesCount;
    }

    public static void addScreensCount() {
        Factory.screensCount++;
    }

    public static void addBatteriesCount() {
        Factory.batteriesCount++;
    }

    public static void addCablesCount() {
        Factory.cablesCount++;
    }
    
    public static void substractScreensCount() {
        Factory.screensCount--;
    }

    public static void substractBatteriesCount() {
        Factory.batteriesCount--;
    }

    public static void substractCablesCount() {
        Factory.cablesCount = Factory.cablesCount - 2;
    }
    
}
