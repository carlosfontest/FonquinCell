package Model;

import java.util.concurrent.Semaphore;

public class Producer {
    private Storage storage;
    private Semaphore semaMutex, semaProd, semaAss;
    private int time, tracker;

    public Producer(Storage storage, Semaphore semaMutex, Semaphore semaProd, Semaphore semaAss, int time, int tracker) {
        this.storage = storage;
        this.semaMutex = semaMutex;
        this.semaProd = semaProd;
        this.semaAss = semaAss;
        this.time = time;
        this.tracker = tracker;
    }
}
