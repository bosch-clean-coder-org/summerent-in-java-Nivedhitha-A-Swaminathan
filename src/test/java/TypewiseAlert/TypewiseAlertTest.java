package TypewiseAlert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{


    @Test
    public void testinfersHighBreachAsPerLimits()
    {
        TypewiseAlert alert = new TypewiseAlert();
        assertTrue(alert.inferBreach(45, CoolingType.MED_ACTIVE_COOLING) ==
               BreachTypeEnum.TOO_HIGH);
    }

    @Test
    public void testinfersNormalBreachAsPerLimits()
    {
        TypewiseAlert alert = new TypewiseAlert();
        assertTrue(alert.inferBreach(25, CoolingType.PASSIVE_COOLING) ==
               BreachTypeEnum.NORMAL);
    }


}
