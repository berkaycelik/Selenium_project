package Test;

import Utils.TestBase;
import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestCaseFunction.LoginFunction;
import listener.Listener;
@Listeners({Listener.class})
public class Log extends TestBase {
    @Test
    public void loginTestCase() {
        BaseTest loginFunction = new BaseTest(driver);
        loginFunction.LoginForm();
}
