package Model;

import java.util.concurrent.Semaphore;

public class Timer {
    private int daysLeft, time;
    private Semaphore mutex;
    private boolean awake;

    public int getDaysLeft() {
        return daysLeft;
    }
}
