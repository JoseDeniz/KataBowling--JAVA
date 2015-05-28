package bowling;

public class FrameBuilder {

    public static Frame build(char... rolls) {
        return new Frame(rolls);
    }

}
