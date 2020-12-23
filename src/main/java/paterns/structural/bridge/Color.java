package paterns.structural.bridge;

/**
 * Interface Color allows to
 *
 * @author Kamila Meshcheryakova
 * created 06.11.2020
 */
public interface Color {

    void fillColor();
}

class BlackColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Filling in black color");
    }
}

class RedColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Filling in red color");
    }
}

class GreenColor implements Color {

    @Override
    public void fillColor() {
        System.out.println("Filling in green color");
    }
}
