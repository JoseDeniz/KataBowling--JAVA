package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LineShould {

    @Test
    public void have_all_frames_to_zero_when_any_pins_are_knocked_down() {
        Frame[] frames = new Line("--------------------").frames();
        for (Frame frame : frames)
            assertThat(frame.rolls(), is(0));
    }

    @Test
    public void have_first_nine_frames_to_ten_and_the_last_frame_to_thirty_when_all_rolls_are_strikes() {
        Frame[] frames = new Line("XXXXXXXXXXXX").frames();
        for (int i = 0; i < frames.length - 1; i++)
            assertThat(frames[i].rolls(), is(10));
        assertThat(frames[9].rolls(), is(30));
    }

}
