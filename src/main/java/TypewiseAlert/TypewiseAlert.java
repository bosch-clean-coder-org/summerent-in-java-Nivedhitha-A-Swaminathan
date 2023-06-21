package TypewiseAlert;


public class TypewiseAlert
{
    public enum BreachType {
        NORMAL,
        TOO_LOW,
        TOO_HIGH
    }

    public enum CoolingType {
        PASSIVE_COOLING,
        HI_ACTIVE_COOLING,
        MED_ACTIVE_COOLING
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
      int lowerLimit = 0;
      int upperLimit = 0;
      switch(coolingType) {
        case PASSIVE_COOLING:
            upperLimit = 35;
          break;
        case HI_ACTIVE_COOLING:
            upperLimit = 45;
          break;
        case MED_ACTIVE_COOLING:
            upperLimit = 40;
          break;
      }
      return inferBreach(temperatureInC, lowerLimit, upperLimit);
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
