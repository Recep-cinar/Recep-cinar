package stepdefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class stepdefinition {

     public static WebDriver driver;

    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() throws Throwable {
        String url=utils.commonUtils.getUrl("src/test/Resources/automation.properties");
        driver.get(url);
        utils.commonUtils.getScreenshot(driver,"homepage");

    }

    @When("^user enter (.+) in the search box and clicks search button$")
    public void user_enter_shirt_in_the_search_box_and_clicks_search_button(String item) throws Throwable {
        driver.findElement(By.name("search_query")).sendKeys(item);
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("^search results are displayed to the user (.+)")
    public void search_results_are_displayed_to_the_user(String item) throws Throwable {
       String resulttext= driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
       if (resulttext.contains(item)){
           System.out.println(item + " result are displayed");
       }else {
           System.out.println(item + " result are not displayed on the system");
       }

    }

    @Given("^results are displayed to the user$")
    public void results_are_displayed_to_the_user() throws Throwable {
        driver.findElement(By.name("search_query")).sendKeys("shirt");
        driver.findElement(By.name("submit_search")).click();
    }


    @When("^user click on the search button and enters details$")
    public void user_click_on_the_search_button_and_enters_details() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("qty")).clear();
        driver.findElement(By.name("qty")).sendKeys("5");
        WebElement size=driver.findElement(By.name("group_1"));
        Select sizeDropDown=new Select(size);
        sizeDropDown.selectByVisibleText("L");
        driver.findElement(By.name("Blue")).click();
        driver.findElement(By.name("Submit")).click();
    }
    @Then("^user can add them to the cart$")
    public void user_can_add_them_to_the_cart() throws Throwable {
        Thread.sleep(2000);
       String result= driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();
        System.out.println(result);
    }
    @When("user enters details to search")
    public void enterdetails(DataTable data){
        List<String> details=data.asList();
        String searchitem=details.get(0);
        driver.findElement(By.name("search_query")).sendKeys(searchitem);
        driver.findElement(By.name("submit_search")).click();
    }
    @Then("results are displayed based on his search")
    public void verifyResults(DataTable data){
        List<String> details=data.asList();
        String searchitem=details.get(0);

        String resulttext= driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[1]")).getText();
        if (resulttext.contains(searchitem)){
            System.out.println(searchitem + " result are displayed");
        }else {
            System.out.println(searchitem + " result are not displayed on the system");
        }
    }
    @Given("^user is on contact us page$")
    public void user_is_on_contact_us_page() throws Throwable {

    }
    @When("^user add all information on the page$")
    public void user_add_all_information_on_the_page(DataTable data) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a")).click();
        List<String> details= data.asList();
        WebElement subject=driver.findElement(By.xpath("//*[@id=\"id_contact\"]"));
        Select subjectDropDown=new Select(subject);
        subjectDropDown.selectByVisibleText(details.get(0));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(details.get(1));
        driver.findElement(By.xpath("//*[@id=\"id_order\"]")).sendKeys(details.get(2));
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(details.get(3));
        driver.findElement(By.xpath("//*[@id=\"submitMessage\"]/span")).click();
    }
    @Then("^user send all information$")
    public void user_send_all_information() throws Throwable {
        String resulttext =driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
        System.out.println(resulttext);
    }

}
