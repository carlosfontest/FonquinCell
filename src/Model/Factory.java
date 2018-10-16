package Model;
import java.util.concurrent.Semaphore;

public class Factory {
    // Storage for parts (Buffer)
    private Storage screens, batteries, cables;
    // Count trackers for display in the UI
    private static int screensCount, batteriesCount, cablesCount;
    // Producer's and assembler's count 
    private static int prodBCount, prodSCount, prodCCount, assemblerCount;
    // How much seconds is a day
    private int dayTime;
    // How much time between deliveries
    private int daysForDelivery;
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
        this.prodS = new Semaphore(screensStorageMax);
        this.prodB = new Semaphore(batteriesStorageMax);
        this.prodC = new Semaphore(cablesStorageMax);
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
        // Initializing timer and manager semaphore
        this.timerManager = new Semaphore(1);
        // Initializing next positions
        this.nextPosPS = 0;
        this.nextPosPB = 0;
        this.nextPosPC = 0;
        this.nextPosAS = 0;
        this.nextPosAC = 0;
        this.nextPosAB = 0;
        // Initializing counters
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
        this.assemblers = new Assembler[maxAss];
        // Initializing producers and assemblers count
        this.prodBCount = 0;
        this.prodSCount = 0;
        this.prodCCount = 0;
        this.assemblerCount = 0;
        // Parts count
        this.screensCount = 0;
        this.batteriesCount = 0;
        this.cablesCount = 0;
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
        // Initialize timer
        this.timer = new Timer(this.daysForDelivery, this.getHours(3/2), this.getHours(24-3/2), this.timerManager);
        this.timer.start();
        // Initialize manager with min and max time in hours (MIN = 6 hours | MAX = 18 hours)
        this.manager = new Manager(this.daysForDelivery, this.getHours(6), this.getHours(18), this.timerManager);
        this.manager.start();
        
    }
    
    
    // Returns miliseconds of an hour in the simulation
    public int getHours(int hours){
        return (hours * this.dayTime * 1000)/24;
    }
    // Returns miliseconds of a day in the simulation
    public int getDayTime(){
        return (1000 * this.dayTime);
    }
    
    // Methods for hiring producers and assemblers;
    public boolean hireBatteriesProd(){
        if(this.prodBCount == this.batteries.getSize()){
            System.out.println("Batteries producers are full");
            return false;
        }
        for (int i = 0; i < this.batteriesProd.length; i++) {
            if(this.batteriesProd[i] == null){
                this.batteriesProd[i] = new Producer(this.batteries,this.mutexPB,this.prodB, this.assB, this.getDayTime(), this.nextPosPB, 0);
                this.batteriesProd[i].start();
                this.prodBCount++;
                return true;
            }
        }
        return false;
    }
    
    public boolean hireScreensProd(){
        if(this.prodSCount == this.screens.getSize()){
            System.out.println("Screen producers are full");
            return false;
        }
        for (int i = 0; i < this.screensProd.length; i++) {
            if(this.screensProd[i] == null){
                this.screensProd[i] = new Producer(this.screens,this.mutexPS,this.prodS, this.assS, this.getDayTime()*2, this.nextPosPS, 1);
                this.screensProd[i].start();
                this.prodSCount++;
                return true;
            }
        }
        return false;
    }
    public boolean hireCablesProd(){
        if(this.prodCCount == this.cables.getSize()){
            System.out.println("Cable producers are full");
            return false;
        }
        for (int i = 0; i < this.cablesProd.length; i++) {
            if(this.cablesProd[i] == null){
                this.cablesProd[i] = new Producer(this.cables,this.mutexPC,this.prodC, this.assC, this.getDayTime(), this.nextPosPC, 2);
                this.cablesProd[i].start();
                this.prodCCount++;
                return true;
            }
        }
        return false;
    }
    public boolean hireAssembler(){
        if(this.assemblerCount == this.assemblers.length){
            System.out.println("Assemblers are full");
            return false;
        }
        for (int i = 0; i < this.assemblers.length; i++) {
            if(this.assemblers[i] == null){
                this.assemblers[i] = new Assembler(this.cables, this.screens, this.batteries, this.mutexAB,this.mutexAS, this.mutexAC, this.assB, this.assS, this.assC, this.prodB, this.prodS, this.prodC, this.getDayTime()*2, this.nextPosAS, this.nextPosAB, this.nextPosAC); 
                this.assemblers[i].start();
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
                return true;
            }
        }
        return false;
    }

    public int getProdBCount() {
        return prodBCount;
    }

    public int getProdSCount() {
        return prodSCount;
    }

    public int getProdCCount() {
        return prodCCount;
    }

    public int getAssemblerCount() {
        return assemblerCount;
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

    public int getScreensProdSize() {
        return screensProd.length;
    }

    public int getBatteriesProdSize() {
        return batteriesProd.length;
    }

    public int getCablesProdSize() {
        return cablesProd.length;
    }
    
    public int getAssemblersSize() {
        return assemblers.length;
    }
    
    public static void removeBatteryProducer(){
        Factory.prodBCount--;
    }
    public static void removeScreenProducer(){
        Factory.prodSCount--;
    }
    public static void removeCableProducer(){
        Factory.prodCCount--;
    }
    public static void removeAssembler(){
        Factory.assemblerCount--;
    }
}
