package org;

import PomPages.AdminPages;
import PomPages.DashBoardpages;
import PomPages.LoginPage;
import Utility.SeleniumUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public SeleniumUtility seleniumUtility=new SeleniumUtility();
    public LoginPage lp;
    public DashBoardpages dashBoardpages;
    public AdminPages adminPages;

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
