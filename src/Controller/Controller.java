package Controller;

import View.ControlPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controller {

    public Controller() {
    }
    
    
    public void initCompany() {
        ControlPanel cpanel = new ControlPanel(this);
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

