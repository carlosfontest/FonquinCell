/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Factory;
import Model.Timer;
import Model.Manager;
import View.ControlPanel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class GUIUpdater extends Thread {
    private boolean running;
    private ControlPanel cPanel;
    private Factory factory;

    public GUIUpdater(ControlPanel cPanel, Factory factory) {
        this.running = true;
        this.cPanel = cPanel;
        this.factory = factory;
    }
    
    @Override
    public void run() {
        while (this.running) {
            this.cPanel.cantBatteryProd.setText(String.valueOf(this.factory.getProdBCount()));
            this.cPanel.cantCableProd.setText(String.valueOf(this.factory.getProdCCount()));
            this.cPanel.cantScreenProd.setText(String.valueOf(this.factory.getProdSCount()));
            this.cPanel.daysToDelivery.setText(String.valueOf(Timer.getDaysLeft()));
            this.cPanel.timerState.setText(Timer.isAwake());
            this.cPanel.managerState.setText(Manager.isAwake());
            this.cPanel.cantScreens.setText(String.valueOf(Factory.getScreensCount()));
            this.cPanel.cantBatteries.setText(String.valueOf(Factory.getBatteriesCount()));
            this.cPanel.cantCables.setText(String.valueOf(Factory.getCablesCount()));
            this.cPanel.phonesToDeliver.setText(String.valueOf(Manager.getPhones()));
            this.cPanel.cantAssamblers.setText(String.valueOf(this.factory.getAssemblerCount()));
            this.cPanel.barCantBatteryProd.setValue((this.factory.getProdBCount()*100 / this.factory.getBatteriesProdSize()));
            this.cPanel.barCantCableProd.setValue((this.factory.getProdCCount()*100 / this.factory.getCablesProdSize()));
            this.cPanel.barCantScreenProd.setValue((this.factory.getProdSCount()*100 / this.factory.getScreensProdSize()));
            
        }
    }
    
    
    public void stopRunning() {
        this.running = false;
    }
    
    
}
