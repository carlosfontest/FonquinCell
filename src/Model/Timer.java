package Model;

import java.util.concurrent.Semaphore;

public class Timer {
    private int daysLeft, time;
    private Semaphore mutExc;

    public Timer(Semaphore mutExc) {
        this.mutExc = mutExc;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}
