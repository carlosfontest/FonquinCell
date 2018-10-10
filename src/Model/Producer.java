package Model;

import java.util.concurrent.Semaphore;

public class Producer {
    Storage storage;
    Semaphore semaME;
    Semaphore semaPr;
    Semaphore semaAss;
    int time;

    public Producer(Storage storage, Semaphore semaME, Semaphore semaPr, Semaphore semaAss, int time) {
        this.storage = storage;
        this.semaME = semaME;
        this.semaPr = semaPr;
        this.semaAss = semaAss;
        this.time = time;
    }
}
