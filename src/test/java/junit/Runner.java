package junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteTest.class);
        List<Failure> failures = result.getFailures();
        System.out.println("\nFailures:");
        for (Failure failure : failures) {
            System.out.println(failure + "\n");
        }
        System.out.println("Tests number: " + result.getRunCount());
        System.out.println("Failured: " + result.getFailureCount());
    }
}
