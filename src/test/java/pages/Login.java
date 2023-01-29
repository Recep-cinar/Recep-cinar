package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public static WebDriver driver;

    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver , this);

    }
    @FindBy(id = "ctl00_MainContent_username")
    private WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_login_button\"]")
    private WebElement loginbutton;

    @FindBy(xpath = "//*[@id=\"ctl00_menu\"]/li[3]/a")
    private WebElement orderpage;

    public void loginMethodforusername() throws InterruptedException {
        username.sendKeys("Tester");
        Thread.sleep(2000);

    }
    public void loginmethodforpassword() throws InterruptedException {
        password.sendKeys("test");
        Thread.sleep(2000);

    }

    public void setloginbutton() throws InterruptedException {
       loginbutton.click();
       Thread.sleep(1000);
    }
    public void setOrderpage(){
        orderpage.click();
    }

}
