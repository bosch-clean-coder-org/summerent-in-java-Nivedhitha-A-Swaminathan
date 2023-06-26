package TypewiseAlert;

public enum BreachTypeEnum {

    NORMAL("normal"),
    TOO_LOW("too low"),
    TOO_HIGH("too high");

    public final String label;

    private BreachTypeEnum(String typeLabel) {
        this.label = typeLabel;
    }

}
