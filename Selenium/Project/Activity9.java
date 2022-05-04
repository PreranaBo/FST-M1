package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforemethod() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().to("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void CompleteLesson() {
        WebElement navigationBar = driver.findElement(By.xpath("//ul[@id='primary-menu']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-1507']/a")));
        WebElement myAccountlink = driver.findElement(By.xpath("//li[@id='menu-item-1507']/a"));
        myAccountlink.click();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-1508']/a")));
        WebElement allCoursesLink = driver.findElement(By.xpath("//li[@id='menu-item-1508']/a"));
        allCoursesLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ld-course-list-items row']")));
        WebElement allCourses = driver.findElement(By.xpath("//div[@class='ld-course-list-items row']"));
        allCourses.isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@id='post-69']/div/p/a")));
        WebElement firstCourseLink = driver.findElement(By.xpath("//article[@id='post-69']/div/p/a"));
        firstCourseLink.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement firstLessonLink = driver.findElement(By.xpath("//div[contains(text(),'Developing')]"));
        js.executeScript("arguments[0].click()", firstLessonLink);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Complete']")));
        WebElement lessionStatus = driver.findElement(By.xpath("//div[text()='Complete']"));
        Assert.assertTrue(lessionStatus.isDisplayed());
        System.out.println("Status of lession is "+ lessionStatus.getText());
    }

    @AfterTest
    public void aftermethod() {

        driver.close();
    }
}
