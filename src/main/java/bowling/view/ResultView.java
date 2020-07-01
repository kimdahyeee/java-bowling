package bowling.view;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void printHeader() {
        String header
                = "| NAME |" +
                IntStream.range(1, 11)
                        .boxed()
                        .map(index -> "  " + String.format("%02d", index) + "  |")
                        .collect(Collectors.joining());

        System.out.println(header);
    }
}
