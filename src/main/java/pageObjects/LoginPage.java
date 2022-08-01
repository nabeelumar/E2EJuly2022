package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#login1")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(css = "input[name='proceed']")
	private WebElement login;

	public WebElement getUsername() {

		return userName;
	}

	public WebElement getPassword() {

		return password;
	}

	public WebElement getLogin() {

		return login;
	}
}
