package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Actvity11d {
        public static void main(String[] args) {

            WebDriver driver = new FirefoxDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.get("https://www.training-support.net/selenium/tab-opener");
            System.out.println("Page title is: " + driver.getTitle());
            String parentWindow = driver.getWindowHandle();
            System.out.println("Parent Window: " + parentWindow);
            driver.findElement(By.linkText("Click Me!")).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> allWindowHandles = driver.getWindowHandles();
            System.out.println("All window handles: " + allWindowHandles);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //Print the handle of the current window
            System.out.println("Current window handle: " + driver.getWindowHandle());

            //Wait for page to load completely
            wait.until(ExpectedConditions.titleIs("Newtab"));

            //Print New Tab Title
            System.out.println("New Tab Title is: " + driver.getTitle());

            //Get heading on new page
            String newTabText = driver.findElement(By.cssSelector("div.content")).getText();
            System.out.println("New tab heading is: " + newTabText);

            //Open Another Tab
            driver.findElement(By.linkText("Open Another One!")).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(3));

            //Make sure the new tab's handle is part of the handles set
            allWindowHandles = driver.getWindowHandles();
            System.out.println("All window handles: " + allWindowHandles);
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            System.out.println("New tab handle: " + driver.getWindowHandle());
            wait.until(ExpectedConditions.titleIs("Newtab2"));
            System.out.println("New Tab Title is: " + driver.getTitle());
            newTabText = driver.findElement(By.cssSelector("div.content")).getText();
            System.out.println("New tab heading is: " + newTabText);
            driver.quit();
        }
    }

