package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Frame {

    List<Integer> pins;

    public Frame(char... rolls) {
        pins = new ArrayList<>();
        pins.add(parseToInt(rolls[0]));
        pins.add(parseToInt(rolls[1]));
    }

    private int parseToInt(char roll) {
        return roll == '-' ? 0 : Character.getNumericValue(roll);
    }

    public int rolls() {
        return pins.stream()
                .reduce(Integer::sum)
                .get();
    }
}
