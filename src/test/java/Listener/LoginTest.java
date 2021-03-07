package Listener;
import Utils.BasePage;
import base.BaseTest;
import org.apache.log4j.LogMF;
import org.apache.log4j.MDC;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.junit.Assert.*;
public class Listener extends BaseTest implements ITestListener {
    LogMF log = null;
    public void onTestStart(ITestResult result) {
        driver.getCurrentUrl("http://www.gittigidiyor.com");

        log.info("GittiGidiyor is Open");
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("success");

        log.info("SUCCESS");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("fail");

        log.error("ERROR");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("skipped");

        MDC.put("fail",result.getThrowable());


        log.warn("ERROR");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "c:/Users/berka/Documents/chromedriver.exe");
        driver = new ChromeDriver();

        MDC.put("name",context.getName());


        log.info("Browser is Open");

    }

    public void onFinish(ITestContext context) {

        log.info("Browser is Close");

    }

}