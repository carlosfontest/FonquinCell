package Model;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.Controller;
import View.ControlPanel;

public class Producer extends Thread {

    private Storage storage;
    private Semaphore semaMutex, semaProd, semaAss;
    private int time, nextPos, type;
    private boolean hired;

    public Producer(Storage storage, Semaphore semaMutex, Semaphore semaProd, Semaphore semaAss, int time, int nextPos, int type) {
        this.hired = true;
        this.storage = storage;
        this.semaMutex = semaMutex;
        this.semaProd = semaProd;
        this.semaAss = semaAss;
        this.time = time;
        this.nextPos = nextPos;
        this.type = type;
    }

    @Override
    public void run() {
        while (this.hired) {
            try {
                switch (this.type) {
                    case 0:
                        System.out.println("Producir B antes: " + this.getId() + ", valor: " + Factory.getBatteriesCount());
                        break;
                    case 1:
                        System.out.println("Producir S antes: " + this.getId() + ", valor: " + Factory.getScreensCount());
                        break;
                    case 2:
                        System.out.println("Producir C antes: " + this.getId() + ", valor: " + Factory.getCablesCount());
                        break;
                    default:
                        System.out.println("Bug en producer type");
                        break;
                }
                this.semaProd.acquire();
                Thread.sleep(this.time);
                this.semaMutex.acquire();
                this.storage.setVec(nextPos, 1);
                this.nextPos = (nextPos + 1) % this.storage.getSize();
                switch (this.type) {
                    case 0:
                        Factory.addBatteriesCount();
                        System.out.println("Producir B después: " + this.getId() + ", valor: " + Factory.getBatteriesCount());
                        break;
                    case 1:
                        Factory.addScreensCount();
                        System.out.println("Producir S después: " + this.getId() + ", valor: " + Factory.getScreensCount());
                        break;
                    case 2:
                        Factory.addCablesCount();
                        System.out.println("Producir C después: " + this.getId() + ", valor: " + Factory.getCablesCount());
                        break;
                    default:
                        System.out.println("Bug en producer type");
                        break;
                }
                System.out.println(this.getId() + " : Hay : " + this.semaAss.getQueueLength() + " threads esperando a entrar");
                this.semaAss.release();
                System.out.println(this.getId() + " : Hay : " + this.semaAss.getQueueLength() + " threads esperando a entrar");
                this.semaMutex.release();

            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fire() {
        this.hired = false;
    }
}
