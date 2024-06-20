package com.proschool.tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class captureScreenShot  implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((setup) result.getInstance()).driver;
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), new File("screenshots/" + result.getName() + ".png").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

