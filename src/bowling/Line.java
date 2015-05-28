package bowling;

public class Line {

    private final Frame[] frames;

    public Line(String input) {
        frames = new Frame[10];
        createFrames(input);
    }

    private void createFrames(String input) {
        char[] pins = input.toCharArray();
        int index = 0;
        for (int i = 0; i < pins.length; i += 2) {
            frames[index] = new Frame(input.substring(i, i + 2).toCharArray());
            index++;
        }
    }

    public Frame[] frames() {
        return frames;
    }
}
