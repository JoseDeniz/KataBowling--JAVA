package bowling;

import static bowling.FrameType.*;

public class ScoreCalculator {

    private int score;

    public ScoreCalculator(Line line) {
        calculateScoreFrom(line);
    }

    private void calculateScoreFrom(Line line) {
        Frame[] frames = line.frames();
        for (Frame frame : frames)
            score += frame.rolls();
    }

    private boolean isStrike(Frame frame) {
        return frame.type() == STRIKE;
    }

    public int totalScore() {
        return score;
    }

}
