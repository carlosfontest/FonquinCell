package Controller;

import Model.Factory;
import View.ControlPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controller {
    public Factory factory;
    ControlPanel cpanel;

    public Controller() {
        this.cpanel = new ControlPanel(this);
    }
    
    
    public void initCompany(int dayInSeconds, int daysBeforeDelivery, int screensStorageMax, int batteriesStorageMax, int cablesStorageMax, int screensInitProd, int cablesInitProd, int batteriesInitProd, int cablesMaxProd, int screensMaxProd, int batteriesMaxProd, int initAss, int maxAss) {     
        this.factory = new Factory(this.cpanel, dayInSeconds, daysBeforeDelivery, screensStorageMax, batteriesStorageMax, cablesStorageMax, batteriesInitProd, screensInitProd, cablesInitProd, cablesMaxProd, screensMaxProd, batteriesMaxProd, initAss, maxAss);
        this.cpanel.setVisible(true);
        
        // Establecer valores iniciales en la interfaz
        this.cpanel.cantScreenProd.setText(String.valueOf(screensInitProd));
        this.cpanel.cantCableProd.setText(String.valueOf(cablesInitProd));
        this.cpanel.cantBatteryProd.setText(String.valueOf(batteriesInitProd));
        
        this.cpanel.cantBatteries.setText("0");
        this.cpanel.cantCables.setText("0");
        this.cpanel.cantScreens.setText("0");
        
        this.cpanel.cantAssamblers.setText(String.valueOf(initAss));
        
        this.cpanel.phonesToDeliver.setText("0");
        this.cpanel.timerState.setText("Asleep");
        this.cpanel.managerState.setText("Asleep");
        this.cpanel.daysToDelivery.setText(String.valueOf(daysBeforeDelivery));
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

