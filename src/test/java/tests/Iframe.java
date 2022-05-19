package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Iframe {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/frames']"));
        link.click();
        WebElement frame= driver.findElement(By.cssSelector("a[href='/iframe']"));
        frame.click();

WebElement fr= driver.findElement(By.cssSelector("#mce_0_ifr"));
    driver.switchTo().frame(fr);
  WebElement type=driver.findElement(By.cssSelector("#tinymce"));
    type.clear();
    type.sendKeys("good");
driver.quit();







    }
}
