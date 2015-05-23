package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FrameShould {

    @Test
    public void have_zero_pins_when_any_pins_are_knocked_down() {
        Frame frame = new Frame('-', '-');
        assertThat(frame.firstRoll(), is(0));
        assertThat(frame.secondRoll(), is(0));
        assertThat(frame.rolls(), is(0));
    }

    @Test
    public void have_two_pins_when_two_pins_are_knocked_down_on_the_first_roll() {
        Frame frame = new Frame('2', '-');
        assertThat(frame.firstRoll(), is(2));
        assertThat(frame.secondRoll(), is(0));
        assertThat(frame.rolls(), is(2));
    }

}
