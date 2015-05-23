package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FrameShould {

    @Test
    public void have_zero_pins_when_any_pins_are_knocked_down () {
        Frame frame = new Frame('-', '-');
        assertThat(frame.rolls(), is(0));
    }

}
