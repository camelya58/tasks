package paterns.decorator;

import java.util.Date;

/**
 * Class MixinDecorator allows to use class Mixin and pattern Decorator.
 * Mixin - mixing functionality of several classes to get a total class.
 *
 * @author Kamila Meshcheryakova
 * created by 24.08.2020
 */
class Basic {

    private String value;
    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

class Decorator extends Basic {

    protected Basic basic;
    public Decorator(Basic basic) {
        this.basic = basic;
    }
    public void set(String val) {
        basic.set(val);
    }

    public String get() {
        return basic.get();
    }
}

class TimeStamped extends Decorator {

    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumbered extends Decorator {

    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

public class MixinDecorator {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        // ! t2.getSerialNumber(); not available
        System.out.println(t2.getStamp());

        SerialNumbered s = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        // ! s2.getStamp(); not available
        System.out.println(s2.getSerialNumber());
    }
}