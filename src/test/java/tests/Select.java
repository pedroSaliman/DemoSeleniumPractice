package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;

public class Select {


    WebDriver driver;
    @BeforeClass
    @Parameters("browser")

    void setup(@Optional String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "edg":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                driver=null;
                break;
        }



    }
    @Test
    void test1(){
        driver.get("https://the-internet.herokuapp.com/");

        WebElement link= driver.findElement(By.cssSelector("a[href='/dropdown']"));
        link.click();

        WebElement select= driver.findElement(By.cssSelector("#dropdown"));
        WebElement option1=select.findElement(By.cssSelector("option[value='1']"));
        WebElement option2=select.findElement(By.cssSelector("option[value='2']"));


        org.openqa.selenium.support.ui.Select s1=new org.openqa.selenium.support.ui.Select(select);
        s1.selectByIndex(1);
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
driver.quit();

    }
}
