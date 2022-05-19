package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class Upload {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");



    }
    @Test
    void test1(){
//        WebElement link= driver.findElement(By.cssSelector("a[href='/upload']"));
//        link.click();
String path="E:\\seleniumprojects\\PhpTravlersDemo\\ScreenShots\\ScreenShots_20220404121735.png";
        WebElement ele1= driver.findElement(By.xpath(".//input[@type='file']"));

        ele1.sendKeys(path);





    }
}
