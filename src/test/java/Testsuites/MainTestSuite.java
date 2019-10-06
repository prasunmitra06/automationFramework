/*package Testsuites;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestSuite {
	
	WebDriver driver;
	
	@BeforeTest
	public void DriverSetup()
	{
		String ChromePath = System.getProperty("user.dir")+("\\src\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",ChromePath );
		driver = new ChromeDriver();
	
	}
	
	
	@Test
	public void testCaseForGoogleSearch()
	{
		driver.get("https://www.google.com");
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("Hey Tom");
		ele.sendKeys(Keys.ENTER);
	}

}
*/