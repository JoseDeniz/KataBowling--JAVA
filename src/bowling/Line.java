package bowling;

import static bowling.FrameBuilder.build;

public class Line {

    private final Frame[] frames;

    public Line(String input) {
        frames = new Frame[10];
        buildFrames(input);
    }

    private void buildFrames(String input) {
        char[] rolls = input.toCharArray();
        int lastRollIndex = buildFirstNineFramesAndGetLastIndex(rolls);
        buildLastFrame(input, lastRollIndex);
    }

    private int buildFirstNineFramesAndGetLastIndex(char[] rolls) {
        int index = 0, currentRollPosition = 0;
        while (index < 9) frames[index++] =
                rolls[currentRollPosition] == 'X' ?
                        build(rolls[currentRollPosition++]) :
                        build(rolls[currentRollPosition++], rolls[currentRollPosition++]);
        return currentRollPosition;
    }

    private void buildLastFrame(String input, int currentRollPosition) {
        char[] lastFrameRolls = input.substring(currentRollPosition).toCharArray();
        frames[9] = build(lastFrameRolls);
    }

    public Frame[] frames() {
        return frames;
    }

}
