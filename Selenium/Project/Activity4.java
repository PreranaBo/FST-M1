package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {
    WebDriver driver;


    @BeforeTest
    public void beforemethod(){
        driver= new FirefoxDriver();
        driver.navigate().to("https://alchemy.hguy.co/lms/");


    }
    @Test
    public void Check2ndTitlePopularCourse() {
        String actualtitle= "Email Marketing Strategies";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement titleof2ndPopularCourse=driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']"));
        js.executeScript("arguments[0].scrollIntoView();",titleof2ndPopularCourse);
        System.out.println(titleof2ndPopularCourse.getText());
        String expectedtitle=titleof2ndPopularCourse.getText();
        Assert.assertEquals(actualtitle,expectedtitle);


    }
    @AfterTest
    public void aftermethod(){

        driver.close();
    }
}
