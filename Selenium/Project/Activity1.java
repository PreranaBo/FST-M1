package liveproject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;


    @BeforeTest
    public void beforemethod(){
        driver= new FirefoxDriver();
        driver.navigate().to("https://alchemy.hguy.co/lms");



    }
    @Test
    public void Checktiltle(){
        String expectedTitle=driver.getTitle();
        System.out.println("Page title" + expectedTitle);
        String actualTitle="Alchemy LMS – An LMS Application";
        Assert.assertTrue(expectedTitle.equals(actualTitle), "tille not matched");

}
    @AfterTest
    public void aftermethod(){
        driver.close();

    }
}
