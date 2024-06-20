package com.proschool.tests;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Login extends setup {

    private org.apache.poi.hssf.usermodel.HSSFRow HSSFRow;
    private Object row;

    @Test(dataProvider = "loginData")
    public void login(String username, String password) throws InterruptedException, IOException {
//        String expectedTitle = " Revolutionise Learning with ProSchool.ai - AI-Powered Education";
//        String actualTitle = driver.getTitle();
//
//        //Soft Assert To CheckCorrect Title
//        SoftAssert asrt = new SoftAssert();
//
//        asrt.assertEquals(actualTitle, expectedTitle, "Home page title does not match");
        driver.findElement(By.xpath("//*[text()='Login / Sign Up']")).click();
        Thread.sleep(2000);
//       Taking Data from Excel Sheet to fill in Input Filed


        Thread.sleep(3000);
        FileInputStream fis = new FileInputStream("D:\\ProSchool.ai\\ProSchoolAutomation\\src\\test\\resources\\InputUsrNamePass.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        for (int i = 1; i <= rowCount; i++) {
            String userEmail = sheet.getRow(i).getCell(1).getStringCellValue();
            String userPassword = sheet.getRow(i).getCell(2).getStringCellValue();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@name='email']")).sendKeys(userEmail);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@name='password']")).sendKeys(userPassword);
            driver.findElement(By.xpath("//*[text()='Student']")).click();
            Thread.sleep(5000);
//
            driver.findElement(By.xpath("//*[text()='Login']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[text()='Login successful.']")).getText();




        }

    }

    @Test(Priority=2)
    public void search() throws InterruptedException, IOException {
       driver.findElement(By.xpath("")).click();
       Thread.sleep(6000);
       driver.findElement(By.linkText("SQL")).click();
       driver.findElement(By.xpath("//*[text()='View']")).click();
       Thread.sleep(3000);



    }
}
