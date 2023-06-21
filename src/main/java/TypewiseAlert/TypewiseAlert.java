package TypewiseAlert;



public class TypewiseAlert {

    public static BreachTypeEnum inferBreach(double value, CoolingType coolingType) {
        if(value < coolingType.coolingTypeLowerLimit) {
            return BreachTypeEnum.TOO_LOW;
        }
        if(value > coolingType.coolingTypeUpperLimit) {
            return BreachTypeEnum.TOO_HIGH;
        }
        return BreachTypeEnum.NORMAL;
    }

    public void checkAndAlert(
        CoolingType coolingType, double temperatureInC) {
        BreachTypeEnum breachTypeEnum = inferBreach(temperatureInC, coolingType);

        ControllerAlert controllerAlert = new ControllerAlert();
        controllerAlert.send(breachTypeEnum);
        MailAlert mailAlert = new MailAlert();
        mailAlert.send(breachTypeEnum);


    }


    public static void main(String[] args) {
        Configuration.getInstance().setControllerConnected(false);
        TypewiseAlert alert = new TypewiseAlert();
        alert.checkAndAlert(CoolingType.HI_ACTIVE_COOLING, 50.1);
    }

}
