package TypewiseAlert;

public class LowBreachType extends BreachType{

    @Override
    BreachTypeEnum calculate(double value, CoolingType coolingType) {
        return BreachTypeEnum.TOO_LOW;
    }
}
