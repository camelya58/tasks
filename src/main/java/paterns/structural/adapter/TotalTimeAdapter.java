package paterns.structural.adapter;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Class TotalTimeAdapter demonstrates adapting interface TotalTime to interface Time.
 *
 * @author Kamila Meshcheryakova
 * created by 26.10.2020
 */
public class TotalTimeAdapter implements Time {

    TotalTime totalTime;

    public TotalTimeAdapter(TotalTime totalTime) {
        this.totalTime = totalTime;
    }


    @Override
    public int getSeconds() {
        return totalTime.getTotalSeconds() % 60;
    }

    @Override
    public int getMinutes() {
        return totalTime.getTotalSeconds()/60 - getHours() * 60 ;
    }

    @Override
    public int getHours() {
        return totalTime.getTotalSeconds()/(60 * 60);
    }

    public static void main(String[] args) {
        TotalTime totalTime = () -> {
            LocalTime time = LocalTime.now(ZoneId.systemDefault());
            return time.toSecondOfDay();
        };
        Time time = new TotalTimeAdapter(totalTime);
        System.out.println("getSeconds = " + time.getSeconds() + ", " +
                "getMinutes = " + time.getMinutes() + ", getHours = " + time.getHours());
        System.out.println(totalTime.getTotalSeconds());
    }
}
