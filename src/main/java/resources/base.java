package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initalizeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/java/resources/chromedriver");
			
			ChromeOptions options = new ChromeOptions();
			
			if(browser.contains("headless")) {
				
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/src/main/java/resources/msedgedriver");
			driver = new EdgeDriver();

		} else if (browser.equals("safari")) {

			driver = new SafariDriver();
		} else {

			System.out.println("NOT ABLE TO FIND THE BROWSER. PLEASE CHECK!!!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;

	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
