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

public class Check {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/checkboxes']"));
        link.click();

        WebElement ele1= driver.findElement(By.cssSelector("input:nth-child(1)"));
        ele1.click();
        WebElement ele2= driver.findElement(By.xpath("//input[2]"));
        ele2.click();
        Assert.assertTrue(ele1.isSelected());
        Assert.assertFalse(ele2.isSelected());





    }
}
