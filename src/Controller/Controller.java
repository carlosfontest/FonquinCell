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
        
        this.guiThread = new GUIUpdater(this.cPanel, this.factory);
        this.guiThread.start();
        
        this.cPanel.setVisible(true);
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

