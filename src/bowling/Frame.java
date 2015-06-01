package bowling;

import java.util.ArrayList;
import java.util.List;

import static bowling.FrameType.SPARE;
import static bowling.FrameType.STRIKE;
import static java.lang.Character.getNumericValue;

public class Frame {

    private List<Integer> pins;
    private FrameType type;

    public Frame(char... rolls) {
        pins = new ArrayList<>();
        for (char roll : rolls)
            pins.add(parseRoll(roll));
    }

    public int getRoll(int index) {
        return pins.get(index);
    }

    public int rolls() {
        return pins.stream()
                   .reduce(Integer::sum)
                   .get();
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object otherFrame) {
        return pins.equals(((Frame) otherFrame).pins);
    }

    public FrameType type() {
        return type;
    }

    private int parseRoll(char roll) {
        if (roll == 'X') return strike();
        else if (roll == '/') return spare();
        return parseToInt(roll);
    }

    private int strike() {
        type = STRIKE;
        return 10;
    }

    private int spare() {
        type = SPARE;
        return 10 - pins.get(0);
    }

    private int parseToInt(char roll) {
        return roll == '-' ? 0 : getNumericValue(roll);
    }

}