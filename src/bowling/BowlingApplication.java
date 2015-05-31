package bowling;

public class BowlingApplication {

    private final static String PERFECT_GAME = "XXXXXXXXXXXX";
    private final static String SEMI_PERFECT_GAME = "5/5/5/5/5/5/5/5/5/5/5";
    private final static String REGULAR_GAME = "9-9-9-9-9-9-9-9-9-9-";

    public static void main(String[] args) {

        int perfectGameScore = new ScoreCalculator(new Line(PERFECT_GAME)).totalScore();
        int semiPerfectGameScore = new ScoreCalculator(new Line(SEMI_PERFECT_GAME)).totalScore();
        int regularGameScore = new ScoreCalculator(new Line(REGULAR_GAME)).totalScore();

        System.out.printf("Perfect Game Score is %d\n" +
                          "Semi-perfect Game Score is %d\n" +
                          "Regular Game Score is %d",
                            perfectGameScore,
                            semiPerfectGameScore,
                            regularGameScore);

    }

}
