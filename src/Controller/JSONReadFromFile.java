package Controller;

import java.io.FileReader;
import static java.lang.Integer.parseInt;
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
            
            
            Controller controller = new Controller();
            controller.initCompany(dayInSeconds, daysBeforeDelivery, screensStorageMax, batteriesStorageMax, cablesStorageMax, screensInitProd, cablesInitProd, batteriesInitProd, cablesMaxProd, screensMaxProd, batteriesMaxProd, initAss, maxAss);
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
