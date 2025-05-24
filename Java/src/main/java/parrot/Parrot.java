package parrot;

public class Parrot {

    private final ParrotBehavior behavior;

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
            ParrotBehavior behavior = switch(type) {
                case EUROPEAN -> new EuropeanParrotBehavior();
                case AFRICAN -> new AfricanParrotBehavior(numberOfCoconuts);
                case NORWEGIAN_BLUE -> new NorwegianBlueParrotBehavior(voltage, isNailed);
            };
            return new Parrot(behavior);
        }
    }

    private Parrot(ParrotBehavior behavior) {
        this.behavior = behavior;
    }

    public double getSpeed() {
        return behavior.getSpeed();
    }

    public String getCry() {
        return behavior.getCry();
    }
}
