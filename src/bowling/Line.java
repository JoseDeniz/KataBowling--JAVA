package bowling;

public class Line {

    private Frame[] frames;

    public Line(String input) {
        frames = new Frame[10];
        createFrames(input);
    }

    private void createFrames(String input) {
        createFirstNineFrames(input);
        createLastFrame(input);
    }

    private void createFirstNineFrames(String input) {
        for (int i = 0; i < frames.length - 1; i++)
            frames[i] = new Frame(input.charAt(i));
    }

    private void createLastFrame(String input) {
        char[] lastRoll = input.substring(frames.length - 1).toCharArray();
        frames[9] = new Frame(lastRoll);
    }

    public Frame[] frames() {
        return frames;
    }
}
