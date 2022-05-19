package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;



        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

//        driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
//        List<WebElement> lista=driver.findElements(By.xpath("//ul[@id='select2-billing_country-results']/li"));
//        System.out.println(lista.size());
//        for (int i = 0; i <lista.size() ; i++) {
//         String country = lista.get(i).getText();
//         if (country.equalsIgnoreCase("Eritrea"))
//         {
//             lista.get(i).click();
//         }
//
//
//
//        }
driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("mac");
Thread.sleep(3000);
List<WebElement> lista=driver.findElements(By.xpath("//ul[@id='ui-id-1']//li//a//span"));
        System.out.println(lista.size());
        for (int i = 0; i <lista.size() ; i++) {
            String name=lista.get(i).getText();
            System.out.println(name);
            if (name.equalsIgnoreCase("apple macBook Pro 13-inch")){
                lista.get(i).click();
            }


        }
    }


}
