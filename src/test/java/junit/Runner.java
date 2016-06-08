package junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteTest.class);
        List<Failure> failures = result.getFailures();
        failures.forEach(System.out::println);
    }
}
