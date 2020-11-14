package paterns.prototype;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс Human
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Human implements Copyable {
    private final String name;
    private final int age;
    private final Country country;
    private final String[] pets;

    @Override
    public Human copy() {
        return new Human(name, age, country, pets.clone());
    }

    public Human(String name, int age, Country country, String[] pets) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.pets = pets;
    }

    public String[] getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country=" + country +
                ", pets=" + Arrays.toString(pets) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name) &&
                country == human.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, country);
    }
}
