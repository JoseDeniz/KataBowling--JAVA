package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnAcceptedGame {
    
    @Test
    public void should_have_three_hundred_points_when_all_frames_in_the_line_are_strikes () {
        ScoreCalculator scoreCalculator = new ScoreCalculator(new Line("XXXXXXXXXXXX"));
        assertThat(scoreCalculator.score(), is(300));
    }
}
