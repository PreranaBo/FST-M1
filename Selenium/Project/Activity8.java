package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity8 {
    WebDriver driver;

        @BeforeTest
        public void beforemethod(){
            driver= new FirefoxDriver();
            driver.navigate().to("https://alchemy.hguy.co/lms/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }
        @Test
        public void ContactAdmin(){
            WebElement navigationBar =driver.findElement(By.xpath("//ul[@id='primary-menu']"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement contactlink=driver.findElement(By.xpath("//li[@id='menu-item-1506']/a"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            contactlink.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement sendMsgForm=driver.findElement(By.xpath("//h2[text()=' Send us a message  ']"));
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",sendMsgForm);
            WebElement fullName=driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']"));
            fullName.sendKeys("Prerana");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement email=driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']"));
            email.sendKeys("Prerana@ibm.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement message=driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']"));
            message.sendKeys("Test message");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement sendMsgBtn=driver.findElement(By.xpath("//button[@id='wpforms-submit-8']"));
            sendMsgBtn.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement confirmationMsg= driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']/p"));
            confirmationMsg.isDisplayed();
            System.out.println("Confirmation msg is "+ confirmationMsg.getText() );

        }

        @AfterTest
        public void aftermethod(){
            driver.close();
        }
    }
