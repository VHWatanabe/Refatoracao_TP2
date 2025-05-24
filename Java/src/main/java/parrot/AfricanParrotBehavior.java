package parrot;

public class AfricanParrotBehavior implements ParrotBehavior {

    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;

    private final int numberOfCoconuts;

    public AfricanParrotBehavior(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        double loadPenalty = LOAD_FACTOR * numberOfCoconuts;
        double adjustedSpeed = BASE_SPEED - loadPenalty;
        return Math.max(0, adjustedSpeed);
    }

    @Override
    public String getCry() {
        return "Sqaark!";
    }
}
