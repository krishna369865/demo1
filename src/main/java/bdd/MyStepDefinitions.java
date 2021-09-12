package bdd;



import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.demo.pageobject.googlesignin;
import com.demo.pageobject.landui;
import com.demo.reusablecomponents.ReusableMethods;
import com.demo.reusablecomponents.reusablecomponents;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends reusablecomponents {

    @Given("^Initialize chrome browser$")
    public void initialize_chrome_browser() throws Throwable {
    	driver=initializeDriver();
		driver.manage().window().maximize();
    }
    @Given("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    @Given("^Move to more and click on trains$")
    public void move_to_more_and_click_on_trains() throws Throwable {
    	Actions a=new Actions(driver);
		WebElement actels=driver.findElement(com.demo.pageobject.trains.more);
		a.moveToElement(actels).build().perform();
		ReusableMethods.click(com.demo.pageobject.trains.trains, driver);
    }
    @When("^click on alert and click search button$")
    public void click_on_alert_and_click_search_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	ReusableMethods.click(com.demo.pageobject.trains.alert, driver);
		ReusableMethods.click(com.demo.pageobject.trains.searching, driver);
    }



    
    @Given("^click on signup button$")
    public void click_on_signup_button() throws Throwable {
    	Actions a=new Actions(driver);
		WebElement actel=driver.findElement(landui.signin);
		a.moveToElement(actel).build().perform();
		ReusableMethods.click(landui.signup, driver);
    }

    @When("^User signup to application using \"([^\"]*)\"$")
    public void user_signup_to_application_using(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	ReusableMethods.sendKeys(googlesignin.login,arg1, driver);
    }
    @Then("^validate homepage title$")
    public void validate_homepage_title() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	 Assert.assertTrue(true);
    	 driver.close();
        
    }


  
    

   

}