package parrot;

public class NorwegianBlueParrotBehavior implements ParrotBehavior {

    private static final double MAX_SPEED = 24.0;

    private final double voltage;
    private final boolean isNailed;

    public NorwegianBlueParrotBehavior(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        if (isNailed) {
            return 0.0;
        }
        double speed = voltage * 12.0;
        if (speed < 0) return 0.0;
        return Math.min(speed, MAX_SPEED);
    }

    @Override
    public String getCry() {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}
