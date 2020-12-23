package paterns.structural.adapter;

/**
 * Interface Time
 *
 * @author Kamila Meshcheryakova
 * created by 26.10.2020
 */
public interface Time {

    // methods allows to get current time
    int getSeconds();
    int getMinutes();
    int getHours();
}

interface TotalTime {

    // method allows to get quantity of seconds after midnight
    int getTotalSeconds();
}