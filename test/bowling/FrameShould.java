package bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FrameShould {

    public static final char ZERO = '-';
    public static final char TWO = '2';
    public static final char SPARE = '/';
    public static final char STRIKE = 'X';

    @Test
    public void have_zero_pins_when_any_pins_are_knocked_down() {
        Frame frame = new Frame(ZERO, ZERO);
        assertThat(frame.getRoll(0), is(0));
        assertThat(frame.getRoll(1), is(0));
        assertThat(frame.rolls(), is(0));
    }

    @Test
    public void have_two_pins_when_two_pins_are_knocked_down_on_the_first_roll() {
        Frame frame = new Frame(TWO, ZERO);
        assertThat(frame.getRoll(0), is(2));
        assertThat(frame.getRoll(1), is(0));
        assertThat(frame.rolls(), is(2));
    }

    @Test
    public void have_four_pins_when_two_pins_are_knocked_down_in_both_rolls() {
        Frame frame = new Frame(TWO, TWO);
        assertThat(frame.getRoll(0), is(2));
        assertThat(frame.getRoll(1), is(2));
        assertThat(frame.rolls(), is(4));
    }

    @Test
    public void have_ten_pins_when_there_is_a_spare() {
        Frame frame = new Frame(TWO, SPARE);
        assertThat(frame.rolls(), is(10));
        assertThat(frame.getRoll(0), is(2));
        assertThat(frame.getRoll(1), is(8));
        assertThat(frame.type(), is(FrameType.SPARE));
    }

    @Test
    public void have_ten_pins_when_there_is_a_strike() {
        Frame frame = new Frame(STRIKE);
        assertThat(frame.rolls(), is(10));
        assertThat(frame.type(), is(FrameType.STRIKE));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void have_only_one_roll_when_there_is_a_Strike() {
        Frame frame = new Frame(STRIKE);
        assertThat(frame.getRoll(0), is(10));
        assertThat(frame.getRoll(1), is(0));
    }

}