package com.proschool.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class setup {

    WebDriver driver;
    @BeforeMethod
    public void setupBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\ProSchool.ai\\ProSchoolAutomation\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://proschool.ai/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
