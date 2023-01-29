package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.Messages;
import io.cucumber.plugin.event.Node;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class hooks extends utils.driverutils{

    @Before("@SmokeTest")
    public void initialise_test() throws IOException {
        stepdefinition.driver=initialseDriver
            (stepdefinition.driver,"chrome");
     //stepdefinition.driver.get("http://automationpractice.com/index.php");
        String url=utils.commonUtils.getUrl("src/test/Resources/automation.properties");
        stepdefinition.driver.get(url);
    }
    @Before()
    public void initialise_smartbear() throws IOException {
        smartBearSteps.driver=initialseDriver(smartBearSteps.driver,"chrome");
        String url=utils.commonUtils.getUrl("src/test/Resources/smartbear.properties");
        smartBearSteps.driver.get(url);

    }
    @After("@SanityTest")
    public void close_smartbear(){
        //smartBearSteps.driver.close();
    }
    /*@After()
   public void close_test(Scenario scenario , WebDriver driver , String fileName){
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String directoryName="src/test/resources/screenshots/";
        String Filename=directoryName+ fileName + "_" + System.currentTimeMillis()+".png";
        try {
            FileUtils.copyFile(screenshotFile,new File(Filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    @Before("@Temp")
    public void initialise_smartbea() throws IOException {
        smartBearSteps.driver=initialseDriver(smartBearSteps.driver,"chrome");
        String url=utils.commonUtils.getUrl("src/test/Resources/smartbear.properties");
        smartBearSteps.driver.get(url);

    }
}
