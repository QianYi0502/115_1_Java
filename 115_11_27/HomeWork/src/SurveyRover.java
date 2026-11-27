
public class SurveyRover extends Rover {

    public SurveyRover(int energy, int samples) {
        super(energy, samples);
    }

    @Override
    protected int exploreYield() {
        return 1;
    }
}
