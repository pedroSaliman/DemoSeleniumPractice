package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NestedFrame {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/nested_frames']"));
        link.click();
        WebElement parentframe= driver.findElement(By.cssSelector("frame[name='frame-top']"));
        driver.switchTo().frame(parentframe);
        WebElement childframe= driver.findElement(By.cssSelector("frame[name='frame-left']"));
        driver.switchTo().frame(childframe);
        WebElement left=driver.findElement(By.cssSelector("body"));
        System.out.println(left.getText());
        Assert.assertEquals("LEFT",left.getText());
        driver.quit();

    }
}
