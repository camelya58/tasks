package class_methods;

/**
 * Class Pet is supporting class of different kinds of pets.
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
@SuppressWarnings("unused")
public class Pet {
    String name;
    public Pet(String name) {
        this.name = name;
    }
    public Pet() {}
}

class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
    }
}
@SuppressWarnings("unused")
class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
    }
}
@SuppressWarnings("unused")
class Pug extends Dog {
    public Pug (String name) {
        super(name);
    }

    public Pug() {
    }
}
class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }
}
@SuppressWarnings("unused")
class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
    }
}
class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }

    public Manx() {
    }
}
@SuppressWarnings("unused")
class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
    }
}
class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
    }
}
@SuppressWarnings("unused")
class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
    }
}
@SuppressWarnings("unused")
class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
    }
}
@SuppressWarnings("unused")
class Hamster extends Rodent {
    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
    }
}