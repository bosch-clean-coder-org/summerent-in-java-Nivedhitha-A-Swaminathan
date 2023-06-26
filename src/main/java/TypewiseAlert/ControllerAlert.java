package TypewiseAlert;

public class ControllerAlert implements IAction{

    @Override
    public void send(BreachTypeEnum breachTypeEnum) {
        if(Configuration.getInstance().isControllerConnected()) {
            String header = "0xfeed";
            System.out.printf(header + " - " + breachTypeEnum);
        }
    }
}
