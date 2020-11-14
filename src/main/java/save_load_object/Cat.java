package save_load_object;

import java.awt.*;
import java.io.Serializable;

/**
 * Class Cat
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private Color color;

    public Cat(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                '}';
    }
}
