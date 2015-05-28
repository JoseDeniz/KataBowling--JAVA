package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LineShould {

    public static final String ANY_PIN_KNOCKED_LINE = "--------------------";
    public static final String REGULAR_LINE = "--23----------------";
    public static final String STRIKE_LINE = "--2/----------------";

    @Test
    public void have_all_frames_to_zero_when_any_pins_are_knocked_down() {
        Frame[] frames = new Line(ANY_PIN_KNOCKED_LINE).frames();
        for (Frame frame : frames)
            assertThat(frame.rolls(), is(0));
    }

    @Test
    public void have_the_second_frame_to_five_only_when_there_are_two_pins_knocked_down_in_the_second_roll() {
        Frame[] frames = new Line(REGULAR_LINE).frames();
        assertThat(frames[0].rolls(), is(0));
        assertThat(frames[1].rolls(), is(5));
        for (int i = 2; i < frames.length; i++)
            assertThat(frames[i].rolls(), is(0));
    }

    @Test
    public void have_the_second_frame_with_a_strike_when_there_is_a_strike_in_the_second_roll() {
        Frame[] frames = new Line(STRIKE_LINE).frames();
        assertThat(frames[0].rolls(), is(0));
        assertThat(frames[1].rolls(), is(10));
        for (int i = 2; i < frames.length; i++)
            assertThat(frames[i].rolls(), is(0));
    }

}
