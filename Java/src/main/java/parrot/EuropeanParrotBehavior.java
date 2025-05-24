package parrot;

public class EuropeanParrotBehavior implements ParrotBehavior {

    private static final double BASE_SPEED = 12.0;

    @Override
    public double getSpeed() {
        return BASE_SPEED;
    }

    @Override
    public String getCry() {
        return "Sqoork!";
    }
}