package bowling;

public class Line {

    private Frame[] frames;

    public Line(String input) {
        frames = new Frame[10];
        createFrames(input);
    }

    private void createFrames(String input) {
        int frameIndex = 0;
        for (int i = 0; i < input.length(); i += 2) {
            frames[frameIndex] = new Frame(input.charAt(i), input.charAt(i + 1));
            frameIndex++;
        }
    }

    public Frame[] frames() {
        return frames;
    }
}
