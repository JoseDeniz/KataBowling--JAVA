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

    @Test
    public void have_four_pins_when_two_pins_are_knocked_down_in_both_rolls() {
        Frame frame = new Frame('2', '2');
        assertThat(frame.firstRoll(), is(2));
        assertThat(frame.secondRoll(), is(2));
        assertThat(frame.rolls(), is(4));
    }

    @Test
    public void have_ten_pins_when_there_is_a_spare () {
        Frame frame = new Frame('2', '/');
        assertThat(frame.firstRoll(), is(2));
        assertThat(frame.secondRoll(), is(8));
        assertThat(frame.rolls(), is(10));
    }

    @Test
    public void have_ten_pins_when_there_is_a_strike () {
        Frame frame = new Frame('X');
        assertThat(frame.firstRoll(), is(10));
        assertThat(frame.rolls(), is(10));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void have_not_second_roll_when_there_is_a_strike () {
        assertThat(new Frame('X').secondRoll(), is(10));
    }


}
