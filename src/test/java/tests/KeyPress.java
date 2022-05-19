package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyPress {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/key_presses']"));
        link.click();

        WebElement select= driver.findElement(By.cssSelector("#target"));
        Actions act= new Actions(driver);
        act.sendKeys(Keys.TAB).perform();
        WebElement txt= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals("You entered: TAB",txt.getText());





    }
}
