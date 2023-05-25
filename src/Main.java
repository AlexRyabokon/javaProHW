import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class Main {

    public static void main(String[] args) throws Exception {
        TestRunner.start(MyTest.class);
    }
}