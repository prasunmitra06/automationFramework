import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginPage {
 
	//setBrowser();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\driver\\chromedriver.exe"));
		WebDriver driver = new ChromeDriver();
/*		
		System.setProperty("webdriver.gecko.driver", "//Users//vinodsinghrao//Documents//geckodriver");
		WebDriver driver = new FirefoxDriver();*/
		
		driver.get("https://lr-candidate-demo1.hub.loginradius.com/auth.aspx");
		//System.out.println(driver.getTitle());
		
		Thread.sleep(6000);
	    driver.findElement(By.cssSelector("#loginradius-login-emailid")).sendKeys("rao.vinodsingh@gmail.com");
		//driver.findElement(By.xpath("//[@id='loginradius']")).sendKeys("rao.vinodsingh@gmail.com");
	    Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='loginradius-login-password']")).sendKeys("Apple!23");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='loginradius-submit-login']")).click();
	}

}