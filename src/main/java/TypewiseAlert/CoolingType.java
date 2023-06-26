package TypewiseAlert;

public enum CoolingType {

    PASSIVE_COOLING(0, 35),
    HI_ACTIVE_COOLING(0, 45),
    MED_ACTIVE_COOLING(0, 40);

    public final int coolingTypeLowerLimit;
    public final int coolingTypeUpperLimit;

    private CoolingType(int lowerLimit, int upperLimit) {
        this.coolingTypeLowerLimit = lowerLimit;
        this.coolingTypeUpperLimit = upperLimit;

    }

    public  int getLowerLimit(CoolingType type) {
        return type.coolingTypeLowerLimit;
    }

    public  int getUpperLimit(CoolingType type) {
        return type.coolingTypeUpperLimit;
    }
}