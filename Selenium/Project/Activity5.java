package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforemethod() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().to("https://alchemy.hguy.co/lms/");

    }

    @Test
    public void NavigatetoAnotherPage() {
        String actualTitle = "https://alchemy.hguy.co/lms/my-account/";
        WebElement navigationBar = driver.findElement(By.xpath("//ul[@id='primary-menu']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-1507']/a")));
        WebElement myAccountlink = driver.findElement(By.xpath("//li[@id='menu-item-1507']/a"));
        myAccountlink.click();
        String expectedTitle = driver.getCurrentUrl();
        System.out.println(expectedTitle);
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @AfterTest
    public void aftermethod() {

        driver.close();
    }
}
