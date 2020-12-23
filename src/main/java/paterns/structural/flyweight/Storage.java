package paterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс Storage
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public class Storage {

    Map<String, Mercedes> carMap = new HashMap<>();

    Mercedes getCar(String color) {
        Mercedes mercedes = carMap.get(color);
        if (mercedes == null) {
            mercedes = new Mercedes();
            mercedes.color = color;
            carMap.put(color, mercedes);
        }
        return mercedes;
    }

}

class Mercedes {
    String color;
}

