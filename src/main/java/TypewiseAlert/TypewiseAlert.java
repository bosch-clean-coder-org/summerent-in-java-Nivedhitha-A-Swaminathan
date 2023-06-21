package TypewiseAlert;


public class TypewiseAlert {

    public enum BreachType {
        NORMAL("normal"),
        TOO_LOW ("too low"),
        TOO_HIGH ("too high");

        private final String label;

        private BreachType (String typeLabel){
            this.label = typeLabel;
        }
    }

    public enum CoolingType {

        PASSIVE_COOLING(0, 35),
        HI_ACTIVE_COOLING(0, 45),
        MED_ACTIVE_COOLING(0, 40);

        private final int coolingTypeLowerLimit;
        private final int coolingTypeUpperLimit;

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
        System.out.printf("To: %s\n", recepient);
        String message = breachType.label;
        System.out.println("Hi, the temperature is " + message +"\n");
     }

    public static void main(String[] args) {
        TypewiseAlert alert = new TypewiseAlert();
        alert.checkAndAlert(AlertTarget.TO_EMAIL, CoolingType.HI_ACTIVE_COOLING, 50.1);
    }

}
