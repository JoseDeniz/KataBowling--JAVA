package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FrameBuilderShould {

    private static final Frame ZERO_PINS_FRAME = new Frame('-', '-');

    @Test
    public void build_a_frame_with_zero_rolls() {
        Frame frame = FrameBuilder.build('-', '-');
        assertThat(frame.rolls(), is(ZERO_PINS_FRAME.rolls()));
    }

}
