package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforemethod() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().to("https://alchemy.hguy.co/lms/");

    }

    @Test
    public void LoginintoSite() {
        String actualTitle = "https://alchemy.hguy.co/lms/my-account/";
        String actualuserDisplay = "root";
        WebElement navigationBar = driver.findElement(By.xpath("//ul[@id='primary-menu']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-1507']/a")));
        WebElement myAccountlink = driver.findElement(By.xpath("//li[@id='menu-item-1507']/a"));
        myAccountlink.click();
        String expectedTitle = driver.getCurrentUrl();
        System.out.println(expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")));
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']"));
        loginBtn.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='user_login']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='user_pass']"));
        WebElement login = driver.findElement(By.xpath("//input[@id='wp-submit']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_login']")));
        username.sendKeys("root");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_pass']")));
        password.sendKeys("pa$$w0rd");
        login.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='root']")));
        String expecteduserDisplay = driver.findElement(By.xpath("//span[text()='root']")).getText();
        Assert.assertEquals(actualuserDisplay, expecteduserDisplay);


    }

    @AfterTest
    public void aftermethod() {

        driver.close();
    }
}

