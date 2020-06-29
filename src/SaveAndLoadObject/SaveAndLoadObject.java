package SaveAndLoadObject;

import java.awt.*;
import java.io.*;

/**
 * Class SaveAndLoadObject represents the way to  write an object to a file and read an object from a file.
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
public class SaveAndLoadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat cat = new Cat("Tom", 4, Color.DARK_GRAY);
        // save cat in the file
        FileOutputStream fileOutputStream = new FileOutputStream("cat.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(cat);
        System.out.println(cat);

        fileOutputStream.close();
        objectOutputStream.close();

        // load cat from the file
        FileInputStream fileInputStream = new FileInputStream("cat.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();

        Cat newCat = (Cat) object;
        System.out.println(newCat);
    }
}
