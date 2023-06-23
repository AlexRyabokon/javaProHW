package org.example;


import junit.textui.TestRunner;
import org.junit.platform.console.ConsoleLauncher;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class ProjectTestRunner {

    private static final String RESULT_FILE = "results.txt";
    private static final String ERRORS_FILE = "errors.txt";
    private static Logger LOGGER = Logger.getLogger(TestRunner.class.getName());




    public static void runTestClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            runTestClass(clazz);
        } catch (ClassNotFoundException e) {
            LOGGER.info("Class not found: " + className);
        }
    }

    public static void runTestClass(Class<?> clazz) {
        Result result = JUnitCore.runClasses(clazz);
        printTestResults(result);
        printTestResultsInFile(clazz.getName());
    }

    public static void runTestClasses(String... classNames) {
        for (String className : classNames) {
            runTestClass(className);
        }
    }

    public static void runTestClasses(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            runTestClass(clazz);
        }
    }

    public static void runTestsInPackage(String packageName) {
        Package pkg = Package.getPackage(packageName);
        if (pkg != null) {
            runTestClass(pkg.getName());
        } else {
            LOGGER.info("Package not found: " + packageName);
        }
    }

    private static void printTestResults(Result result) {
        if (result.wasSuccessful()) {
            LOGGER.info( "All tests passed!");
        } else {
            LOGGER.info("Tests failed:");
            for (Failure failure : result.getFailures()) {
                LOGGER.info(failure.toString());
            }
        }
    }

    private static void printTestResultsInFile(String className) {
        String[] select = {"--select-class", className, "--disable-banner"};
        try {
            PrintWriter writer = new PrintWriter(RESULT_FILE);
            ConsoleLauncher.execute(writer, new PrintWriter(ERRORS_FILE), select);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
