package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListAllOrders {

    public static WebDriver driver;

    public ListAllOrders(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver , this);
    }

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_btnCheckAll\"]")
    public WebElement checekallbox;

    @FindBy(xpath = "//*[@id=\"ctl00_menu\"]/li[3]/a")
    public WebElement order;



    public void checkallboxes(){
        checekallbox.click();
    }
    public void clickorder(){
        order.click();
    }


}
