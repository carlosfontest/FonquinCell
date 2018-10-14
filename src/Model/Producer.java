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
    // GUI Property
    private ControlPanel cpanel;

    public Producer(ControlPanel cpanel, Storage storage, Semaphore semaMutex, Semaphore semaProd, Semaphore semaAss, int time, int nextPos, int type) {
        this.hired = true;
        this.storage = storage;
        this.semaMutex = semaMutex;
        this.semaProd = semaProd;
        this.semaAss = semaAss;
        this.time = time;
        this.nextPos = nextPos;
        this.type = type;
        this.cpanel = cpanel;
    }

    @Override
    public void run() {
        while (this.hired) {
            try {
                this.semaProd.acquire();
                Thread.sleep(this.time);
                this.semaMutex.acquire();
                this.storage.setVec(nextPos, 1);
                this.nextPos = (nextPos + 1) % this.storage.getSize();
                System.out.println(this.type);
                switch (this.type) {
                    case 0:
                        Factory.addBatteriesCount();
                        cpanel.cantBatteries.setText( String.valueOf((Integer.parseInt(cpanel.cantBatteries.getText())) + 1) );
                        break;
                    case 1:
                        Factory.addScreensCount();
                        cpanel.cantScreens.setText( String.valueOf((Integer.parseInt(cpanel.cantScreens.getText())) + 1) );
                        break;
                    case 2:
                        Factory.addCablesCount();
                        cpanel.cantCables.setText( String.valueOf((Integer.parseInt(cpanel.cantCables.getText())) + 1) );
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
    }

    public void fire() {
        this.hired = false;
    }
}
