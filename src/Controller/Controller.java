package Controller;

import Model.Factory;
import View.ControlPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controller {
    public Factory factory;
    private ControlPanel cPanel;
    private GUIUpdater guiThread;

    public Controller() {
        this.cPanel = new ControlPanel(this);
    }
    
    
    public void initCompany(int dayInSeconds, int daysBeforeDelivery, int screensStorageMax, int batteriesStorageMax, int cablesStorageMax, int screensInitProd, int cablesInitProd, int batteriesInitProd, int cablesMaxProd, int screensMaxProd, int batteriesMaxProd, int initAss, int maxAss) {     
        this.factory = new Factory(dayInSeconds, daysBeforeDelivery, screensStorageMax, batteriesStorageMax, cablesStorageMax, batteriesInitProd, screensInitProd, cablesInitProd, cablesMaxProd, screensMaxProd, batteriesMaxProd, initAss, maxAss);
        this.cPanel.setVisible(true);
        
        // Establecer valores iniciales en la interfaz
        this.cPanel.cantScreenProd.setText(String.valueOf(screensInitProd));
        this.cPanel.cantCableProd.setText(String.valueOf(cablesInitProd));
        this.cPanel.cantBatteryProd.setText(String.valueOf(batteriesInitProd));
        
        this.cPanel.cantBatteries.setText("0");
        this.cPanel.cantCables.setText("0");
        this.cPanel.cantScreens.setText("0");
        
        this.cPanel.cantAssamblers.setText(String.valueOf(initAss));
        
        this.cPanel.phonesToDeliver.setText("0");
        this.cPanel.timerState.setText("Asleep");
        this.cPanel.managerState.setText("Asleep");
        this.cPanel.daysToDelivery.setText(String.valueOf(daysBeforeDelivery));
        
        this.guiThread = new GUIUpdater(this.cPanel, this.factory);
        this.guiThread.start();
    }
    
    public void minimize(JFrame frame) {
        frame.setState(frame.ICONIFIED);
    }
    
    public void close(JFrame frame) {
        //Cerramos el programa
        try {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el sistema?", "Salir", dialogButton);
            if(result == 0){
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e);
        }
    }
    
    public void addPart(int type) {
        
    }
}

