package paterns.abstract_factory;

/**
 * Класс PhpDeveloper
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class PhpDeveloper implements Programmer {
    @Override
    public void writeCode() {
        System.out.println("Write code");
    }
}
