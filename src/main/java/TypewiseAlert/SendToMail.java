package TypewiseAlert;

public class SendToMail implements IAction {


    @Override
    public void send(BreachType breachType) {
        if (!Configuration.getInstance().isControllerConnected()) {
            String recepient = "a.b@c.com";
            System.out.printf("To: %s\n", recepient);
            String message = breachType.label;
            System.out.println("Hi, the temperature is " + message + "\n");
        }
    }
}
