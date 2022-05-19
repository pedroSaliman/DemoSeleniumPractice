package tests;

import Action.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Hover {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/hovers']"));
        link.click();

        WebElement select= driver.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
        Actions act= new Actions(driver);
        act.moveToElement(select).perform();
        WebElement txt= driver.findElement(By.xpath("//h5[normalize-space()='name: user1']"));
        Assert.assertEquals("name: user1",txt.getText());


driver.quit();


    }
}
