package TypewiseAlert;

public class SendToMail implements IAction {


    @Override
    public void send(BreachTypeEnum breachTypeEnum) {
        if (!Configuration.getInstance().isControllerConnected()) {
            String recepient = "a.b@c.com";
            System.out.printf("To: %s\n", recepient);
            String message = breachTypeEnum.label;
            System.out.println("Hi, the temperature is " + message + "\n");
        }
    }
}
