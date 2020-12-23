package paterns.structural.adapter;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Class TimeAdapter demonstrates adapting interface Time to interface TotalTime.
 * Classical example - InputStreamReader.
 *
 * @author Kamila Meshcheryakova
 * created by 26.10.2020
 */
public class TimeAdapter implements TotalTime {

    Time time;

    public TimeAdapter(Time time) {
        this.time = time;
    }

    @Override
    public int getTotalSeconds() {
        return time.getHours() * 3600 + time.getMinutes() * 60 + time.getSeconds();
    }

    public static void main(String[] args) {
        Time time = new Time() {
            @Override
            public int getSeconds() {
                LocalTime time = LocalTime.now(ZoneId.systemDefault());
                return time.getSecond();
            }

            @Override
            public int getMinutes() {
                LocalTime time = LocalTime.now(ZoneId.systemDefault());
                return time.getMinute();
            }

            @Override
            public int getHours() {
                LocalTime time = LocalTime.now(ZoneId.systemDefault());
                return time.getHour();
            }
        };
        TotalTime totalTime = new TimeAdapter(time);
        System.out.println("getTotalSeconds = " + totalTime.getTotalSeconds());
    }
}
