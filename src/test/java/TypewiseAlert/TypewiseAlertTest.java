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
      assertTrue(alert.inferBreach(0, TypewiseAlert.CoolingType.HI_ACTIVE_COOLING) ==
        TypewiseAlert.BreachType.TOO_LOW);
    }

    @Test
    public void testinfersHighBreachAsPerLimits()
    {
        TypewiseAlert alert = new TypewiseAlert();
        assertTrue(alert.inferBreach(45, TypewiseAlert.CoolingType.MED_ACTIVE_COOLING) ==
                TypewiseAlert.BreachType.TOO_HIGH);
    }

    @Test
    public void testinfersNormalBreachAsPerLimits()
    {
        TypewiseAlert alert = new TypewiseAlert();
        assertTrue(alert.inferBreach(25,  TypewiseAlert.CoolingType.PASSIVE_COOLING) ==
                TypewiseAlert.BreachType.NORMAL);
    }


}
