package conceptJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		//System.setProperty("driver/chromedriver");-->relative path
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");//go to the website and right click-->inspect-->opens a pop up window on the side-->click on arrow at the top-->then place it on username field 
		//and click-->highlights the xml code associated with it , copy the "id" value. Now in eclipse use driver object to invoke ,method findEment and pass By.id("username")
		//and then we are sending value in that field i.e. sendKeys("demo@techfios.com")
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
	
}
