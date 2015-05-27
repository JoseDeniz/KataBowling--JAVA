package bowling;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getNumericValue;

public class Frame {

    private List<Integer> pins;

    public Frame(char... rolls) {
        pins = new ArrayList<>();
        for (char roll : rolls) pins.add(parseToInt(roll));
    }

    private int parseToInt(char roll) {
        if (roll == 'X') return 10;
        else if (roll == '/') return 10 - pins.get(0);
        return roll == '-' ? 0 : getNumericValue(roll);
    }

    public int rolls() {
        return pins.stream()
                   .reduce(Integer::sum)
                   .get();
    }
}
