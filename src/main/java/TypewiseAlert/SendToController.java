package TypewiseAlert;

public class SendToController implements IAction{



    @Override
    public void send(BreachType breachType) {
        if(Configuration.getInstance().isControllerConnected()) {
            String header = "0xfeed";
            System.out.printf(header + " - " + breachType);
        }
    }
}
