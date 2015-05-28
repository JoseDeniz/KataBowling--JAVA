package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FrameBuilderShould {

    private static final Frame ZERO_PINS_FRAME = new Frame('-', '-');
    private static final Frame REGULAR_FRAME = new Frame('2', '3');

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

}
