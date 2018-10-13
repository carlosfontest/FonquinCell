package Controller;

import Model.Factory;
import View.ControlPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controller {
    Factory factory;

    public Controller() {
    }
    
    
    public void initCompany(int dayInSeconds, int daysBeforeDelivery, int screensStorageMax, int batteriesStorageMax, int cablesStorageMax, int screensInitProd, int cablesInitProd, int batteriesInitProd, int cablesMaxProd, int screensMaxProd, int batteriesMaxProd, int initAss, int maxAss) {
        ControlPanel cpanel = new ControlPanel(this);
        this.factory = new Factory(dayInSeconds, daysBeforeDelivery, screensStorageMax, batteriesStorageMax, cablesStorageMax, batteriesInitProd, screensInitProd, cablesInitProd, cablesMaxProd, screensMaxProd, batteriesMaxProd, initAss, maxAss);
        cpanel.setVisible(true);
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
}

