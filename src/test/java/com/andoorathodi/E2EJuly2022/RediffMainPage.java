package com.andoorathodi.E2EJuly2022;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MainPage;
import resources.base;

public class RediffMainPage extends base {
	public static Logger log = LogManager.getLogger(RediffMainPage.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver = initalizeDriver();
		log.info("Driver intialized");
		
		
	}

	@Test(dataProvider="getData")
	public void start(String username, String password) throws IOException, InterruptedException {
		log.debug("Opening url");
		driver.get(prop.getProperty("url"));
		log.info("url opened");
		MainPage mp = new MainPage(driver);
		LoginPage lp = mp.userSignIn();
		System.out.println("TESTT111111");
		//mp.userSignIn().click();
		Thread.sleep(3000);

		//LoginPage lp = new LoginPage(driver);

		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		System.out.println("TESTT");
		
		log.info("Operation success");
		
 

		
	}
	
	@Test
	public void negativeTest() {
		
		driver.get(prop.getProperty("url"));
		MainPage mp = new MainPage(driver);
		LoginPage lp = mp.userSignIn();
		//mp.userSignIn().click();
		driver.findElement(By.linkText("Newss")).click();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		
		Object[][] data = new Object[2][2];
		data[0][0] ="nabeel";
		data[0][1] ="afd";
		data[1][0] ="shibil";
		data[1][1] ="jkll";
		return data;
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
}
