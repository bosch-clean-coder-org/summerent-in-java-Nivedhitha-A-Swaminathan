package TypewiseAlert;

public enum BreachType {

    NORMAL("normal"),
    TOO_LOW("too low"),
    TOO_HIGH("too high");

    public final String label;

    private BreachType(String typeLabel) {
        this.label = typeLabel;
    }

}
