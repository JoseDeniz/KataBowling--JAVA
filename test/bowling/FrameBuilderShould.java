package bowling;

import org.junit.Test;

import static bowling.FrameType.SPARE;
import static bowling.FrameType.STRIKE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FrameBuilderShould {

    private static final Frame ZERO_PINS_FRAME = new Frame('-', '-');
    private static final Frame REGULAR_FRAME = new Frame('2', '3');
    private static final Frame SPARE_FRAME = new Frame('2', '/');
    private static final Frame STRIKE_FRAME = new Frame('X');
    private static final Frame THREE_STRIKES_FRAME = new Frame('X', 'X', 'X');

    @Test
    public void build_a_frame_with_zero_rolls() {
        Frame frame = FrameBuilder.build('-', '-');
        assertThat(frame, is(ZERO_PINS_FRAME));
    }

    @Test
    public void build_a_frame_with_a_regular_rolls() {
        Frame frame = FrameBuilder.build('2', '3');
        assertThat(frame, is(REGULAR_FRAME));
    }

    @Test
    public void build_a_frame_with_a_spare() {
        Frame frame = FrameBuilder.build('2', '/');
        assertThat(frame, is(SPARE_FRAME));
        assertThat(frame.type(), is(SPARE));
    }

    @Test
    public void build_a_frame_with_a_strike() {
        Frame frame = FrameBuilder.build('X');
        assertThat(frame, is(STRIKE_FRAME));
        assertThat(frame.type(), is(STRIKE));
    }

    @Test
    public void build_a_frame_with_three_strikes() {
        Frame frame = FrameBuilder.build('X', 'X', 'X');
        assertThat(frame, is(THREE_STRIKES_FRAME));
        assertThat(frame.type(), is(STRIKE));
    }

}
