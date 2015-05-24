package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Integer> pins;

    public Frame(char... rolls) {
        pins = new ArrayList<>();
        for (char roll : rolls) pins.add(parseToInt(roll));
    }

    private int parseToInt(char roll) {
        if (roll == 'X') return 10;
        else if (roll == '/') return 10 - pins.get(0);
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
