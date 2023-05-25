import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

class MyTest{
    @BeforeSuite
    public String setup() {
        return "BeforeSuite method";
    }

    @AfterSuite
    public String teardown() {
        return "AfterSuite method";
    }

    @Test(priority = 3)
    public String testMethod1() {
        return "Test method 1";
    }

    @Test(priority = 1)
    public String testMethod2() {
        return "Test method 2";
    }

    @Test(priority = 5)
    public String testMethod3() {
        return "Test method 3";
    }

    public String nonTestMethod() {
        return "Non-test method";
    }
}