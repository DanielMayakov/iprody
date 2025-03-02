package org.example.testframe;

import java.util.HashSet;
import java.util.Set;

public class ExtendedTestAutomationRunner implements Runner {
    private final Set<Printer> printers = new HashSet<>();

    public void addPrinter(Printer printer) {
        printers.add(printer); // HashSet ensures no duplicates
    }

    @Override
    public void run(Test[] tests) {
        for (Test test : tests) {
            String result;
            try {
                test.execute();
                result = "Test " + test.getName() + " PASSED";
            } catch (Exception e) {
                result = "Test " + test.getName() + " FAILED: " + e.getMessage();
            }

            // Print results using all printers
            for (Printer printer : printers) {
                printer.print(result);
            }
        }
    }
}
