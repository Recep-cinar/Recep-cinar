package stepdefinitions;

import com.sun.javafx.collections.MappingChange;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ListAllOrders;
import pages.Login;
import pages.Order;

import java.util.Map;

public class smartBearSteps {
    public static WebDriver driver;
    static Logger log=LogManager.getLogger(smartBearSteps.class);

    @Given("^user on the login page$")
    public void user_on_the_login_page() throws Throwable {
        utils.commonUtils.getScreenshot(driver,"login page");
        log.info("user on the login page -"+ driver.getTitle());

    }

    @When("^user enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_username_as_something_and_password_as_something(String strArg1, String strArg2) throws Throwable {

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(strArg1);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(strArg2);
        utils.commonUtils.getScreenshot(driver,"beforeloginclick");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
    @Then("^user is loggedin$")
    public void user_is_loggedin() throws Throwable {
        WebElement visitibletext=driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/table/tbody/tr/td[1]/h1"));
        visitibletext.getText().equalsIgnoreCase("Web Orders");
        if (visitibletext.isDisplayed()){
            System.out.println("yay");
        }else{
            System.out.println("nay");
        }

    }
    @Given("^User is on the View all orders page$")
    public void user_is_on_the_view_all_orders_page() throws Throwable {
        user_enter_username_as_something_and_password_as_something("Tester","test");


    }

    @When("^user views the title as \"([^\"]*)\"$")
    public void user_views_the_title_as_something(String strArg1) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();


    }
    @Then("^view all order page load successfully$")
    public void view_all_order_page_load_successfully() throws Throwable {

    }
    @Given("^user on the order page$")
    public void user_on_the_order_page() throws Throwable {
        user_enter_username_as_something_and_password_as_something("Tester","test");
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
    }

    @When("^user entered all information$")
    public void user_entered_all_information(Map<String ,String>data) throws Throwable {
        WebElement product=driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]"));
        Select productdropdown=new Select(product);
        productdropdown.selectByVisibleText(data.get("Product"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"))
                .sendKeys(data.get("Quantity"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"))
                .sendKeys(data.get("Customer name"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]"))
                .sendKeys(data.get("Street"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"))
                .sendKeys(data.get("City"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"))
                .sendKeys(data.get("Zip"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"))
                .sendKeys(data.get("Card"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"))
                .sendKeys(data.get("Card Nr"));
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"))
                .sendKeys(data.get("expire date"));

    }
    @Then("^user order is successfully$")
    public void user_order_is_successfully() throws Throwable {

    }
    @Given("^user wants to enter username$")
    public void user_wants_to_enter_username() throws Throwable {
        Login login=new Login(driver);
        login.loginMethodforusername();

    }
    @Then("^user wants to enter password$")
    public void user_wants_to_enter_password() throws Throwable {
        Login login=new Login(driver);
        login.loginmethodforpassword();
        login.setloginbutton();


    }

    @Then("^user wants to go to order page$")
    public void user_wants_to_go_to_order_page() throws Throwable {
        /* Login login=new Login(driver);
        login.setOrderpage();*/
        ListAllOrders listallorders=new ListAllOrders(driver);
        listallorders.clickorder();


    }

    @Then("^user vants to enter prodact information$")
    public void user_vants_to_enter_prodact_information(Map<String,String>datatable) throws Throwable {
        Order order=new Order(driver);
        order.productinfo(datatable);


    }
    @Then("^user vants to enter adress information$")
    public void user_vants_to_enter_adress_information(Map<String,String>datatable) throws Throwable {
        Order order=new Order(driver);
        order.adressinfo(datatable);

    }

    @Then("^user vant to enter payment information$")
    public void user_vant_to_enter_payment_information(Map<String,String>datatable) throws Throwable {
        Order order =new Order(driver);
        order.paymentinfo(datatable);

    }
    @Then("^user vants to enter prodact information as \"([^\"]*)\"$")
    public void user_vants_to_enter_prodact_information_as_something(String productInfo ) throws Throwable {

        Order order =new Order(driver);
        order.scenarioOutlineExample(productInfo);
    }


    @Then("^user vant to enter payment information as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_vant_to_enter_payment_information_as_something_and_something_and_something(String Card, String cardnr, String expdate) throws Throwable {

        Order order=new Order(driver);
        order.paymentinfoscenariooutline(Card,cardnr,expdate);
    }




}
