package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.Controller;
import View.ControlPanel;

public class Producer extends Thread {

    private Storage storage;
    private Semaphore semaMutex, semaProd, semaAss;
    private int time, type;
    private boolean hired;

    public Producer(Storage storage, Semaphore semaMutex, Semaphore semaProd, Semaphore semaAss, int time, int type) {
        this.hired = true;
        this.storage = storage;
        this.semaMutex = semaMutex;
        this.semaProd = semaProd;
        this.semaAss = semaAss;
        this.time = time;
        this.type = type;
    }

    @Override
    public void run() {
        while (this.hired) {
            try {
                this.semaProd.acquire();
                Thread.sleep(this.time);
                this.semaMutex.acquire();
                switch (this.type) {
                    case 0:
                        this.storage.setVec(Factory.nextPosPB, 1);
                        Factory.nextPosPB = (Factory.nextPosPB + 1) % this.storage.getSize();
                        Factory.addBatteriesCount();
                        break;
                    case 1:
                        this.storage.setVec(Factory.nextPosPS, 1);
                        Factory.nextPosPS = (Factory.nextPosPS + 1) % this.storage.getSize();
                        Factory.addScreensCount();
                        break;
                    case 2:
                        this.storage.setVec(Factory.nextPosPC, 1);
                        Factory.nextPosPC = (Factory.nextPosPC + 1) % this.storage.getSize();
                        Factory.addCablesCount();
                        break;
                    default:
                        System.out.println("Bug en producer type");
                        break;
                }
                this.semaAss.release();
                this.semaMutex.release();

            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        switch (this.type) {
            case 0:
                Factory.removeBatteryProducer();
                break;
            case 1:
                Factory.removeScreenProducer();
                break;
            case 2:
                Factory.removeCableProducer();
                break;
            default:
                System.out.println("Bug en producer type");
                break;
        }
    }

    public void fire() {
        this.hired = false;
    }
}
