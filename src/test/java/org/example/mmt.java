package org.example;

import Utility.SeleniumUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class mmt {
   // @Test
    public void m1() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='departure']")).click();
        String currentdate = m2();
        SeleniumUtility seleniumUtility=new SeleniumUtility();
        WebElement CurrentDateWebElement=driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']"));
        seleniumUtility.scrollToElement(driver,CurrentDateWebElement);
        //Thread.sleep(500);
        CurrentDateWebElement.click();
        //driver.findElement(CurrentDateWebElement).click();
        seleniumUtility.scrollToElement(driver,driver.findElement(By.xpath("//div[@data-cy='returnArea']")));

        driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();



        LocalDate dateAfterSevenDays = LocalDate.now().plusDays(7);
        System.out.println(dateAfterSevenDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
        String dateAfterSevenDaysString= dateAfterSevenDays.format(formatter);
        String xpath="//div[@aria-label='"+dateAfterSevenDaysString+"']";
        System.out.println(xpath);
        SeleniumUtility se=new SeleniumUtility();
        se.scrollToElement(driver,driver.findElement(By.xpath(xpath)));
        Thread.sleep(500);
        driver.findElement(By.xpath(xpath)).click();



    }
    //@Test
    public String m2(){
        LocalDate currentDate = LocalDate.now();

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");

        // Format and print the date
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);
        return formattedDate;
    }
    @Test
    public void m3() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class='sc-cSHVUG NyvQv icon icon-datev2']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        for(int i=0;i<3;i++){
            driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[last()]")).click();
           // Thread.sleep(1000);
          //System.out.println(driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[2]")).getText());
        }
        driver.findElement(By.xpath("//span[text()='1']")).click();
        driver.quit();


        //String monthYearVal = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[2]")).g
    }
}
