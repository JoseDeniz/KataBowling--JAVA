package bowling;

import static bowling.FrameType.SPARE;

public class ScoreCalculator {

    private int score;

    public ScoreCalculator(Line line) {
        calculateScoreFrom(line);
    }

    private void calculateScoreFrom(Line line) {
        Frame[] frames = line.frames();
        calculateFirstNineFrames(frames);
        calculateLastFrame(frames[frames.length - 1]);
    }

    private void calculateFirstNineFrames(Frame[] frames) {
        for (int i = 0; i < frames.length - 1; i++) {
            Frame actualFrame = frames[i];
            score += isSpare(actualFrame) ?
                actualFrame.rolls() + frames[i + 1].getRoll(0) :
                actualFrame.rolls();
        }
    }

    private void calculateLastFrame(Frame lastFrame) {
        score += lastFrame.rolls();
    }

    private boolean isSpare(Frame frame) {
        return frame.type() == SPARE;
    }

    public int totalScore() {
        return score;
    }

}
