package junit;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@Categories.ExcludeCategory(ExceptionTests.class)
@SuiteClasses({ExecuteActionTest.class, TotalConsumptionTest.class, UtilTest.class})
public class SuiteTest {

}
