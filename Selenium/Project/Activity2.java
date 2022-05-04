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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void beforemethod() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.navigate().to("https://alchemy.hguy.co/lms");
    }

    @Test
    public void CheckHeading() throws InterruptedException {
        String actualHeading = "Learn from Industry Experts";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uagb-ifb-title")));
//        WebElement expectedHeading = driver.findElement(By.xpath("//h1[text()=' Learn from Industry Experts ']"));
        String expectedHeading = driver.findElement(By.className("uagb-ifb-title")).getText();
        Assert.assertEquals(actualHeading,expectedHeading);

    }

    @AfterTest
    public void aftermethod() {
        driver.close();
    }
}

