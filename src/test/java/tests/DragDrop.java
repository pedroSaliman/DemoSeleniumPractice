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

public class DragDrop {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/drag_and_drop']"));
        link.click();

        WebElement ele1= driver.findElement(By.cssSelector("#column-a"));
        WebElement ele2= driver.findElement(By.cssSelector("#column-b"));

        Actions act= new Actions(driver);
        act.dragAndDrop(ele1,ele2);
        driver.quit();





    }
}
