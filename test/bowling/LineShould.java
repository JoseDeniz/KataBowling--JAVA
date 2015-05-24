package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LineShould {

    @Test
    public void have_all_frames_to_zero_when_any_pins_are_knocked_down () {
        Frame[] frames = new Line("--------------------").frames();
        for (Frame frame : frames)
            assertThat(frame.rolls(), is(0));
    }

}
