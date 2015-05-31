package bowling;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ScoreCalculatorShould {

    public static final String NOT_A_SINGLE_PIN_KNOCKED_LINE = "--------------------";
    public static final String REGULAR_LINE = "--23----------------";
    private static final String ONLY_SPARES_LINE = "5/5/5/5/5/5/5/5/5/5/5";

    @Test
    public void should_have_zero_points_when_not_a_single_pin_is_knocked_down() {
        ScoreCalculator scoreCalculator = new ScoreCalculator(new Line(NOT_A_SINGLE_PIN_KNOCKED_LINE));
        assertThat(scoreCalculator.totalScore(), is(0));
    }

    @Test
    public void should_have_five_points_when_only_there_are_pins_in_the_second_frame() {
        ScoreCalculator scoreCalculator = new ScoreCalculator(new Line(REGULAR_LINE));
        assertThat(scoreCalculator.totalScore(), is(5));
    }

    @Test
    public void should_have_fifty_hundred_points_when_there_are_only_spare_frames() {
        ScoreCalculator scoreCalculator = new ScoreCalculator(new Line(ONLY_SPARES_LINE));
        assertThat(scoreCalculator.totalScore(), is(150));
    }

}
