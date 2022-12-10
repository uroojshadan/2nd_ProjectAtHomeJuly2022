package conceptJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase2WithMethods {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		init();
		loginTest();
		tearDown();
		
		init();
		negloginTest();
		tearDown();
		
		
		
	}
	public static void init() {//initial steps for launching browser and going to url
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
	}
	public static void loginTest() throws InterruptedException{//positive test case
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
		

	}
	public static void negloginTest() throws InterruptedException{//negative test case
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc12323444");
		driver.findElement(By.name("login")).click();
		Thread.sleep(4000);
		

	}
	public static void tearDown() {//closing driver
		driver.close();
	}

}
