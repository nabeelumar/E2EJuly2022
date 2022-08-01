package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver) {

		this.driver = driver;
	}

	private By signIn = By.linkText("Sign in");

	public LoginPage userSignIn() {

		 driver.findElement(signIn).click();
		 return new LoginPage(driver);
	}

}
