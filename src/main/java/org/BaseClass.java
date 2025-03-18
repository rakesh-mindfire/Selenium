package org;

import PomPages.AdminPages;
import PomPages.DashBoardpages;
import PomPages.LoginPage;
import Utility.SeleniumUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public SeleniumUtility seleniumUtility=new SeleniumUtility();
    public LoginPage lp;
    public DashBoardpages dashBoardpages;
    public AdminPages adminPages;
    public ExtentReports extent;
    public ExtentTest test;
    @BeforeSuite
    public void reportConfig(){
        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
        ExtentSparkReporter reporterType=new ExtentSparkReporter("extentReport.html");// HTML report path


        extent.attachReporter(reporterType);
    }

    @BeforeClass
    public void startBrowser(){
         driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.
        lp=new LoginPage(driver);
        dashBoardpages=new DashBoardpages(driver);
        adminPages=new AdminPages(driver);

    }

    @AfterClass
    public void stopBrowser(){
        driver.quit();
    }
}
