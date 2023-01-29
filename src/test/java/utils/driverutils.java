package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverutils {

    public WebDriver initialseDriver(WebDriver driver, String browsername){

        switch (browsername){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver();
                driver=new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver();
                driver=new ChromeDriver();
                break;
        }
        //WebDriverManager.chromedriver().setup();
        //driver=new ChromeDriver();
        return driver;
    }
}
