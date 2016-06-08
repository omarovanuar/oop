package junit;

import com.epam.module3.task3.oop.entity.BatteryEquipment;
import com.epam.module3.task3.oop.entity.Electronics;
import com.epam.module3.task3.oop.entity.HighPowerEquipment;
import com.epam.module3.task3.oop.entity.LowPowerEquipment;
import com.epam.module3.task3.oop.exception.ConsumptionRangeException;
import com.epam.module3.task3.oop.exception.EquipmentNotFoundException;
import com.epam.module3.task3.oop.exception.NoEquipmentsException;
import com.epam.module3.task3.oop.util.Util;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    private static List<Electronics> electronics;
    private static List<Electronics> result;
    private Util util;

    @BeforeClass
    public static void setUpClass() {
        electronics = new ArrayList<>();
        electronics.add(new BatteryEquipment(1, "microphone", 25, 2, 3));
        electronics.add(new LowPowerEquipment(2, "lamp", 10, 4, true));
        electronics.add(new HighPowerEquipment(3, "fridge", 100, 20, true));
        result = new ArrayList<>();
        result.add(new LowPowerEquipment(2, "lamp", 10, 4, true));
    }

    @Before
    public void setUp() {
        util = new Util();
    }

    @AfterClass
    public static void tearDownClass() {
        electronics.clear();
        result.clear();
    }

    @Test
    public void testSearchByTitle() throws EquipmentNotFoundException {
        List<Electronics> expected = result;
        List<Electronics> actual = util.searchByTitle("lamp", electronics);
        Assert.assertEquals("It must find only lamp equipment, but found smt else", expected, actual);
    }

    @Test
    public void testSearchByConsumption() throws ConsumptionRangeException {
        List<Electronics> expected = result;
        List<Electronics> actual = util.searchByConsumption(3, 5, electronics);
        Assert.assertEquals("It must find only lamp equipment, but found smt else", expected, actual);
    }

    @Test(expected = NoEquipmentsException.class)
    public void testShowList() throws NoEquipmentsException {
        util.showList(new ArrayList<>());
    }
}
