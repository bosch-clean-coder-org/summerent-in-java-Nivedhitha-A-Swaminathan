package TypewiseAlert;

public class Configuration {

    private static Configuration appConfiguration;

    public static synchronized Configuration getInstance()
    {
        if (appConfiguration == null)
            appConfiguration = new Configuration();

        return appConfiguration;
    }

    public boolean isControllerConnected() {
        return isControllerConnected;
    }

    public void setControllerConnected(boolean controllerConnected) {
        isControllerConnected = controllerConnected;
    }

    boolean isControllerConnected;

}
