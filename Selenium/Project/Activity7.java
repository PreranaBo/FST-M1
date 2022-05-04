package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity7 {
    WebDriver driver;

    @BeforeTest
    public void beforemethod(){
        driver= new FirefoxDriver();
        driver.navigate().to("https://alchemy.hguy.co/lms/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void CountCourses(){
        WebElement navigationBar =driver.findElement(By.xpath("//ul[@id='primary-menu']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement allCoursesLink=driver.findElement(By.xpath("//li[@id='menu-item-1508']/a"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        allCoursesLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement allCourses=driver.findElement(By.xpath("//div[@class='ld-course-list-items row']"));
        allCourses.isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> noofCourses=driver.findElements(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']"));
        System.out.println("No of courses are " + noofCourses.size());

    }

    @AfterTest
    public void aftermethod(){
        driver.close();
    }
}
