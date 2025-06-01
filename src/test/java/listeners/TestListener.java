package listeners;

import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.BaseUiTest;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());

        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            Allure.addAttachment("Stacktrace", throwable.toString());
        }

        Object testClass = result.getInstance();
        if (testClass instanceof BaseUiTest baseTest) {
            byte[] screenshot = baseTest.takeScreenshot();
            if (screenshot != null) {
                Allure.addAttachment("Screenshot on Failure", "image/png", new ByteArrayInputStream(screenshot), ".png");
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }
}
