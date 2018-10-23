package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

 
public class JSONReadFromFile {

    public JSONReadFromFile() {
        JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(new FileReader("config.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            int dayInSeconds = Integer.parseInt((String) jsonObject.get("dayInSeconds"));
            int daysBeforeDelivery = Integer.parseInt((String) jsonObject.get("daysBeforeDelivery"));
            int screensStorageMax = Integer.parseInt((String) jsonObject.get("screensStorageMax"));
            int batteriesStorageMax = Integer.parseInt((String) jsonObject.get("batteriesStorageMax"));
            int cablesStorageMax = Integer.parseInt((String) jsonObject.get("cablesStorageMax"));
            int screensInitProd = Integer.parseInt((String) jsonObject.get("screensInitProd"));
            int cablesInitProd = Integer.parseInt((String) jsonObject.get("cablesInitProd"));
            int batteriesInitProd = Integer.parseInt((String) jsonObject.get("batteriesInitProd"));
            int cablesMaxProd = Integer.parseInt((String) jsonObject.get("cablesMaxProd"));
            int screensMaxProd = Integer.parseInt((String) jsonObject.get("screensMaxProd"));
            int batteriesMaxProd = Integer.parseInt((String) jsonObject.get("batteriesMaxProd"));
            int initAss = Integer.parseInt((String) jsonObject.get("initAss"));
            int maxAss = Integer.parseInt((String) jsonObject.get("maxAss"));
            
            if(dayInSeconds <= 0 || 
                daysBeforeDelivery <= 0 ||
                screensStorageMax <= 0 ||
                batteriesStorageMax <= 0 ||
                cablesStorageMax <= 0 ||
                screensInitProd < 0 ||
                cablesInitProd < 0 ||
                batteriesInitProd < 0 ||
                cablesMaxProd <= 0 ||
                screensMaxProd <= 0 ||
                batteriesMaxProd <= 0 ||
                initAss < 0 ||
                maxAss <= 0){
                throw new Exception("Hay una o más propiedades en config.json que no pueden ser menores o iguales a 0."); 
            }
            
            if(batteriesInitProd > batteriesMaxProd || screensInitProd > screensMaxProd || cablesInitProd > cablesMaxProd || initAss > maxAss){
                throw new Exception("Una cantidad inicial no puede ser mayor que una cantidad máxima");
            }
            
            Controller controller = new Controller();
            controller.initCompany(dayInSeconds, daysBeforeDelivery, screensStorageMax, batteriesStorageMax, cablesStorageMax, screensInitProd, cablesInitProd, batteriesInitProd, cablesMaxProd, screensMaxProd, batteriesMaxProd, initAss, maxAss);
            
            
            
        } catch (Exception e) {
            if(e instanceof FileNotFoundException){
                JOptionPane.showMessageDialog(null, "Archivo config.json no encontrado.");
            }else if (e instanceof NumberFormatException){
                JOptionPane.showMessageDialog(null, "El config.json tiene una propiedad que no es un int o está vacía.");
            }
            else{
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
