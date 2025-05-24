package parrot;

public class Parrot {

    private static final double MAX_NORWEGIAN_BLUE_SPEED = 24.0;
    private static final double BASE_SPEED = 12.0;
    private static final double AFRICAN_LOAD_FACTOR = 9.0;

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public static class Builder {
        private ParrotTypeEnum type;
        private int numberOfCoconuts = 0;
        private double voltage = 0.0;
        private boolean isNailed = false;

        public Builder type(ParrotTypeEnum type) {
            this.type = type;
            return this;
        }

        public Builder numberOfCoconuts(int numberOfCoconuts) {
            this.numberOfCoconuts = numberOfCoconuts;
            return this;
        }

        public Builder voltage(double voltage) {
            this.voltage = voltage;
            return this;
        }

        public Builder isNailed(boolean isNailed) {
            this.isNailed = isNailed;
            return this;
        }

        public Parrot build() {
            return new Parrot(type, numberOfCoconuts, voltage, isNailed);
        }
    }

    private Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
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

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> calculateNorwegianBlueCry();
        };
    }

    private double calculateEuropeanSpeed() {
        return BASE_SPEED;
    }

    private double calculateAfricanSpeed() {
        double loadPenalty = AFRICAN_LOAD_FACTOR * numberOfCoconuts;
        double adjustedSpeed = BASE_SPEED - loadPenalty;
        return Math.max(0, adjustedSpeed);
    }

    private double calculateNorwegianBlueSpeed() {
        if (isNailed) {
            return 0;
        }
        double speed = getBaseSpeed(voltage);
        return speed < 0 ? 0 : speed;
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(MAX_NORWEGIAN_BLUE_SPEED, BASE_SPEED * voltage);
    }

    private String calculateNorwegianBlueCry() {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}
