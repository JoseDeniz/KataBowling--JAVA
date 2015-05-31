package bowling;

import static bowling.FrameType.SPARE;
import static bowling.FrameType.STRIKE;

public class ScoreCalculator {

    private int score;
    private Frame[] frames;

    public ScoreCalculator(Line line) {
        frames = line.frames();
        calculate();
    }

    private void calculate() {
        calculateFirstNineFrames();
        calculateLastFrame();
    }

    private void calculateFirstNineFrames() {
        for (int i = 0; i < frames.length - 1; i++) {
            Frame actualFrame = frames[i];
            score += actualFrame.rolls();
            if (isStrike(actualFrame)) calculateStrikeAt(i);
            else if (isSpare(actualFrame)) score += frames[i + 1].getRoll(0);
        }
    }

    private void calculateStrikeAt(int index) {
        Frame nextFrame = frames[index + 1];
        score += nextFrame.getRoll(0);
        try {
            score += nextFrame.getRoll(1);
        } catch (IndexOutOfBoundsException e) {
            score += frames[index + 2].getRoll(0);
        }
    }

    private void calculateLastFrame() {
        score += frames[frames.length - 1].rolls();
    }

    private boolean isStrike(Frame frame) {
        return frame.type() == STRIKE;
    }

    private boolean isSpare(Frame frame) {
        return frame.type() == SPARE;
    }

    public int totalScore() {
        return score;
    }

}
