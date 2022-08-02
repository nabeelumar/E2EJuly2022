package stepDefinition;
 

//import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import resources.base;

 
public class stepDefinitionFile extends base{

    @Given("^user initalizes driver$")
    public void user_initalizes_driver() throws Throwable {
    	driver = initalizeDriver();
    }

   

    @Then("^user should get an error$")
    public void user_should_get_an_error() throws Throwable {
    	
    }

    @And("^navigate to website$")
    public void navigate_to_website() throws Throwable {
    	driver.get(prop.getProperty("url"));
    }

    @When("^user enters invalid (.+) and (.+)$")
    public void user_enters_invalid_and(String username, String password) throws Throwable {
    	MainPage mp = new MainPage(driver);
		LoginPage lp = mp.userSignIn();
    	lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    }
}