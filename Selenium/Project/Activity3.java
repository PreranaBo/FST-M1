package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {
    WebDriver driver;


    @BeforeTest
    public void beforemethod(){
        driver= new FirefoxDriver();
        driver.navigate().to("https://alchemy.hguy.co/lms/");


    }
    @Test
    public void CheckTitleInfobox() throws InterruptedException {
        String actualTitle="Actionable Training";
        WebElement titleof1stInfoBox=driver.findElement(By.xpath("//h3[text()=' Actionable Training ']"));
        String expectedtitle=titleof1stInfoBox.getText();
        Assert.assertEquals(actualTitle,expectedtitle);
    }

    @AfterTest
    public void aftermethod(){

        driver.close();
    }
}
