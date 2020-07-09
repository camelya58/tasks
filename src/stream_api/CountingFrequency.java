package stream_api;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Class CountingFrequency represents the way of using stream to count how often a word is used.
 *
 * @author Kamila Meshcheryakova
 * created by 09.07.2020
 */
public class CountingFrequency {
    public static void main(String[] args) {
        String phrase = "Налей же, налей, налей мне чашу влаги живящей,\n" +
                "Возьми же, возьми, возьми свой чанг, в сто ладов звенящий.\n" +
                "\n" +
                "Отдам я, отдам, отдам всю жизнь ради милой сердцу,\n" +
                "Прильну я, прильну, прильну к устам, что нектара слаще.\n" +
                "\n" +
                "От уст твоих, дивных уст в стыде потускнеет яхонт,\n" +
                "А зубкам, зубкам твоим - не ровня и перл блестящий.\n" +
                "\n" +
                "А слово, слово твое вкуснее, чем мед и сахар,\n" +
                "А лик твой, прекрасный лик - как солнце с луной всходящей.\n" +
                "\n" +
                "А косы, косы твои - померкнет пред ними мускус,\n" +
                "А брови, брови - как лук, ресницами стрел разящий.\n" +
                "\n" +
                "Меня ты, меня, меня коварной стрелой сгубила,\n" +
                "Тобой, тобой я сражен, очей красотой томящей.\n" +
                "\n" +
                "Терпи, Насими, терпи, тебе любимая скажет,\n" +
                "Кто люб ей, кто люб, кто люб, кто сердцу друг настоящий.";

        String[] words = phrase.replaceAll("\\p{Punct}", "")
            .replaceAll("\\n", " ")
                .replaceAll(" {2}", " ")
                .toLowerCase().split(" ");

        for (String w: words) {
            System.out.println(w);
        }

        //the method allows you to calculate how often a word occurs in an array
        // put the word as a key and the counter as a value
        Map<String, Long> collect = Arrays.stream(words)
                .collect(groupingBy(Function.identity(), counting()));

        for (Map.Entry<String, Long> map : collect.entrySet()) {
            System.out.println(map);
        }
    }

}
