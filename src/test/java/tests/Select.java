package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Select {


    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/dropdown']"));
        link.click();

        WebElement select= driver.findElement(By.cssSelector("#dropdown"));
        WebElement option1=select.findElement(By.cssSelector("option[value='1']"));
        WebElement option2=select.findElement(By.cssSelector("option[value='2']"));


        org.openqa.selenium.support.ui.Select s1=new org.openqa.selenium.support.ui.Select(select);
        s1.selectByIndex(1);
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());


    }
}
