package junit;

import com.epam.module3.task3.oop.action.CalculateTotalConsumption;
import com.epam.module3.task3.oop.entity.BatteryEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.entity.LowPowerEquipment;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TotalConsumptionTest {
    private static List<Electronics> electronics;

    @BeforeClass
    public static void setUp() {
        electronics = new ArrayList<>();
        electronics.add(new BatteryEquipment(1, "microphone", 25, 2, 3));
        electronics.add(new LowPowerEquipment(2, "lamp", 10, 4, true));
        electronics.add(new HighPowerEquipment(3, "fridge", 100, 20, true));
    }

    @AfterClass
    public static void tearDown() {
        electronics.clear();
    }

    @Test
    public void testCalculateTotalConsumption() throws NoEquipmentsException {
        double expected = 4 * 24 * 30 * 1.034 + 20 * 24 * 30 * 1.284;
        double actual = CalculateTotalConsumption.calculate(electronics);
        Assert.assertEquals("Mistake in calculation of the total consumption", expected, actual, 0.0001);
    }
}
