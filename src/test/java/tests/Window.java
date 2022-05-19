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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Window {

    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");



    }
    @Test
    void test1(){
        WebElement link= driver.findElement(By.cssSelector("a[href='/windows']"));
        link.click();
        String windowparent=driver.getWindowHandle();
        System.out.println("the parent window "+windowparent);
        WebElement link2= driver.findElement(By.cssSelector("a[href='/windows/new']"));
        link2.click();
        System.out.println(driver.getTitle());
        Set<String> wondows=driver.getWindowHandles();
        List<String> thewindows=new ArrayList<>(wondows);
        System.out.println("the child window"+wondows);
        driver.switchTo().window(thewindows.get(1));
        driver.close();





    }
}
