package TypewiseAlert;


public class TypewiseAlert
{
    public enum BreachType {
        NORMAL,
        TOO_LOW,
        TOO_HIGH
    }

    public enum CoolingType {

        PASSIVE_COOLING(0,35),
        HI_ACTIVE_COOLING(0,45),
        MED_ACTIVE_COOLING(0,40);

        private int upperlimit;
        private int lowerlimit;


        private CoolingType(int lowerLimit, int upperLimit) {
            this.lowerlimit = lowerlimit;
            this.upperlimit = upperlimit;

        }

        public int getLowerlimit() {
            return this.getLowerlimit();
        }
        public int getUpperLimit() {
            return this.upperlimit;
        }
    }

    public enum AlertTarget{
        TO_CONTROLLER,
        TO_EMAIL
    }

    public  BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
      if(value < lowerLimit) {
        return BreachType.TOO_LOW;
      }else {
          if (!(value > upperLimit)) {
              return BreachType.NORMAL;
          }
          return BreachType.TOO_HIGH;
      }
    }


    public  BreachType classifyTemperatureBreach(
        CoolingType coolingType, double temperatureInC) {
       return inferBreach(temperatureInC, coolingType.getLowerlimit(), coolingType.getUpperLimit());
    }


    public  void checkAndAlert(
       AlertTarget alertTarget, CoolingType type, double temperatureInC) {
      BreachType breachType = classifyTemperatureBreach(
       type, temperatureInC
      );

      switch(alertTarget) {
        case TO_CONTROLLER:
          sendToController(breachType);
          break;
        case TO_EMAIL:
          sendToEmail(breachType);
          break;
      }
    }
    public  void sendToController(BreachType breachType) {
      int header = 0xfeed;
      //System.out.printf("%i : %i\n", header, breachType);
    }
    public  void sendToEmail(BreachType breachType) {
      String recepient = "a.b@c.com";
      switch(breachType) {
        case TOO_LOW:
          System.out.printf("To: %s\n", recepient);
          System.out.println("Hi, the temperature is too low\n");
          break;
        case TOO_HIGH:
          System.out.printf("To: %s\n", recepient);
          System.out.println("Hi, the temperature is too high\n");
          break;
        case NORMAL:
          break;
      }
    }

    public static void main (String[] args) {
        TypewiseAlert alert = new TypewiseAlert();
        alert.checkAndAlert(AlertTarget.TO_EMAIL,CoolingType.HI_ACTIVE_COOLING, 50.1);
    }

}
