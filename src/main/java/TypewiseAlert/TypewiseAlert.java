package TypewiseAlert;


public class TypewiseAlert {
    public enum BreachType {
        NORMAL,
        TOO_LOW,
        TOO_HIGH
    }

    public enum CoolingType {

        PASSIVE_COOLING(0, 35),
        HI_ACTIVE_COOLING(0, 45),
        MED_ACTIVE_COOLING(0, 40);

        private int coolingTypeLowerLimit;
        private int coolingTypeUpperLimit;

        private CoolingType(int lowerLimit, int upperLimit) {
            this.coolingTypeLowerLimit = lowerLimit;
            this.coolingTypeUpperLimit = upperLimit;

        }

        public  int getLowerLimit(CoolingType type) {
            return type.coolingTypeLowerLimit;
        }

        public  int getUpperLimit(CoolingType type) {
            return type.coolingTypeUpperLimit;
        }
    }

    public enum AlertTarget {
        TO_CONTROLLER,
        TO_EMAIL
    }

    public BreachType inferBreach(double value, CoolingType coolingType) {

        if (value > coolingType.coolingTypeLowerLimit && value < coolingType.coolingTypeUpperLimit) {
            return BreachType.NORMAL;
        } else {
            if (value > coolingType.coolingTypeUpperLimit) {
                return BreachType.TOO_HIGH;
            }
            return BreachType.TOO_LOW;
        }


    }

    public void checkAndAlert(
            AlertTarget alertTarget, CoolingType coolingType, double temperatureInC) {
        BreachType breachType = inferBreach(temperatureInC, coolingType);

        switch (alertTarget) {
            case TO_CONTROLLER:
                sendToController(breachType);
                break;
            case TO_EMAIL:
                sendToEmail(breachType);
                break;
        }
    }
    public  void sendToController(BreachType breachType) {
      String header = "0xfeed";
      System.out.printf( header + " - " + breachType);
    }

    public void sendToEmail(BreachType breachType) {
        String recepient = "a.b@c.com";
        switch (breachType) {
            case TOO_LOW:
                System.out.printf("To: %s\n", recepient);
                System.out.println("Hi, the temperature is too low\n");
                break;
            case TOO_HIGH:
                System.out.printf("To: %s\n", recepient);
                System.out.println("Hi, the temperature is too high\n");
                break;

        }
    }

    public static void main(String[] args) {
        TypewiseAlert alert = new TypewiseAlert();
        alert.checkAndAlert(AlertTarget.TO_CONTROLLER, CoolingType.HI_ACTIVE_COOLING, 50.1);
    }

}
