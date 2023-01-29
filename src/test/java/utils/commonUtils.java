package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class commonUtils {

    public static String getUrl(String PropFileName) throws IOException {
        Properties prop=new Properties();
        FileInputStream in =new FileInputStream(PropFileName);
        prop.load(in);
        return prop.getProperty("url");
    }
    public static void getScreenshot(WebDriver driver,String fileName){
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String directoryName="src/test/resources/screenshots/";
        String Filename=directoryName+ fileName + "_" + System.currentTimeMillis()+".png";
        try {
            FileUtils.copyFile(screenshotFile,new File(Filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void timeOut(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
