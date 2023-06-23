package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class TestResultParser {
    public static TestResult parse(File fileName) {
        TestResult testResult = new TestResult(null, 0, 0, 0);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] lineSplit = line.split(" ");

                if (line.startsWith("Test run finished")) {
                    String timeOfTest = getTimeOfTest(lineSplit);
                    testResult.setTestStartTime(timeOfTest);
                } else if (line.contains("tests found")) {
                    int amountTests = getAmountOfTests(lineSplit);
                    testResult.setTotalTests(amountTests);
                } else if (line.contains("tests successful")) {
                    int testsSuccessful = getNumberOfSuccessfulTests(lineSplit);
                    testResult.setPassedTests(testsSuccessful);
                } else if (line.contains("tests failed")) {
                    int testsFailed = getNumberOfFailedTests(lineSplit);
                    testResult.setFailedTests(testsFailed);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testResult;
    }

    private static String getTimeOfTest(String[] lineSplit) {
        return lineSplit[4].trim() + " " + lineSplit[5].trim();
    }

    private static int getAmountOfTests(String[] lineSplit) {
        return Integer.parseInt(lineSplit[9].trim());
    }

    private static int getNumberOfSuccessfulTests(String[] lineSplit) {
        return Integer.parseInt(lineSplit[9].trim());
    }

    private static int getNumberOfFailedTests(String[] lineSplit) {
        return Integer.parseInt(lineSplit[9].trim());
    }

    public static TestResult parse(String fileName) {
        File file = new File(fileName);
        TestResult testResult = parse(file);
        return testResult;
    }

    public static TestResult parse (Path fileName) {
        File file = fileName.toFile();
        TestResult testResult = parse(file);
        return testResult;
    }
}
