package bowling;

import java.util.ArrayList;
import java.util.List;

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

    public int firstRoll() {
        return pins.get(0);
    }

    public int secondRoll() {
        return pins.get(1);
    }

    public int rolls() {
        return pins.stream()
                .reduce(Integer::sum)
                .get();
    }
}