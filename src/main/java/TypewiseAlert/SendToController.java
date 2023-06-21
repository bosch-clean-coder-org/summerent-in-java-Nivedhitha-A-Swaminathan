package TypewiseAlert;

public class SendToController implements IAction{



    @Override
    public void send(BreachTypeEnum breachTypeEnum) {
        if(Configuration.getInstance().isControllerConnected()) {
            String header = "0xfeed";
            System.out.printf(header + " - " + breachTypeEnum);
        }
    }
}
