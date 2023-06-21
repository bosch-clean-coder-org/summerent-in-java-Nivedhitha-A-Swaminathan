package TypewiseAlert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest 
{
    @Test
    public void testinfersLowBreachAsPerLimits()
    {
      TypewiseAlert alert = new TypewiseAlert();
      assertTrue(alert.inferBreach(0, CoolingType.HI_ACTIVE_COOLING) ==
        BreachType.TOO_LOW);
    }

    @Test
    public void testinfersHighBreachAsPerLimits()
    {
        TypewiseAlert alert = new TypewiseAlert();
        assertTrue(alert.inferBreach(45, CoolingType.MED_ACTIVE_COOLING) ==
               BreachType.TOO_HIGH);
    }

    @Test
    public void testinfersNormalBreachAsPerLimits()
    {
        TypewiseAlert alert = new TypewiseAlert();
        assertTrue(alert.inferBreach(25, CoolingType.PASSIVE_COOLING) ==
               BreachType.NORMAL);
    }


}
