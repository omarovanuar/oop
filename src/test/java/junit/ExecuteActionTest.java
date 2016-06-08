package junit;

import com.epam.module3.task3.oop.action.ExecuteAction;
import com.epam.module3.task3.oop.entity.BatteryEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.entity.LowPowerEquipment;
import com.epam.module3.task3.oop.exception.ConsumptionRangeException;
import com.epam.module3.task3.oop.exception.EquipmentNotFoundException;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ExecuteActionTest {
    private Integer action;
    private static List<Electronics> electronics;

    public ExecuteActionTest(Integer action) {
        this.action = action;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{7}, {8}, {9}, {0}});
    }

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
    public void testExecuteActionCycle() throws NoEquipmentsException, EquipmentNotFoundException, ConsumptionRangeException, IOException {
        Assert.assertTrue("Variable repeat become false", ExecuteAction.execute(action, 0, electronics));
    }

}
