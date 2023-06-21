package TypewiseAlert;



public class TypewiseAlert {


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
        CoolingType coolingType, double temperatureInC) {
        BreachType breachType = inferBreach(temperatureInC, coolingType);

        SendToController sendToController = new SendToController();
        sendToController.send(breachType);
        SendToMail sendToMail = new SendToMail();
        sendToMail.send(breachType);


    }


    public static void main(String[] args) {
        Configuration.getInstance().setControllerConnected(false);
        TypewiseAlert alert = new TypewiseAlert();
        alert.checkAndAlert(CoolingType.HI_ACTIVE_COOLING, 50.1);
    }

}
