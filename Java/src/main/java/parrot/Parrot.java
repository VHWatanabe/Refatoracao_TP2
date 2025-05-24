package parrot;

public class Parrot {

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> calculateEuropeanSpeed();
            case AFRICAN -> calculateAfricanSpeed();
            case NORWEGIAN_BLUE -> calculateNorwegianBlueSpeed();
        };
    }

    private double calculateEuropeanSpeed() {
        return getBaseSpeed();
    }

    private double calculateAfricanSpeed() {
        double loadFactor = getLoadFactor();
        double speed = getBaseSpeed() - loadFactor * numberOfCoconuts;
        return Math.max(0, speed);
    }

    private double calculateNorwegianBlueSpeed() {
        if (isNailed) {
            return 0;
        }
        return getBaseSpeed(voltage);
    }

    private double getBaseSpeed(double voltage) {
        double speed = voltage * getBaseSpeed();
        return Math.min(24.0, Math.max(0.0, speed));
    }

    private double getLoadFactor() {
        return 9.0;
    }

    private double getBaseSpeed() {
        return 12.0;
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }
}