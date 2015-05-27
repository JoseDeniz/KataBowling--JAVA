package bowling;

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

    public int score() {
        return score;
    }
}
