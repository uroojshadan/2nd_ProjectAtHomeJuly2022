package conceptJUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	WebDriver driver;
	
	@Before
	public void init() {// initial steps for launching browser and going to url
		System.out.println("Init method-->@Before");
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// implicitlyWait() This timeout is used to
																		// specify the amount of time the driver
		// should wait while searching for an element if it is not immediately present.
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@Test
	public void loginTest() throws InterruptedException {// positive test case
		System.out.println("positive test case method-->@Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		createAccount();
		
		
	}
	public void createAccount() throws InterruptedException {

		driver.get("https://techfios.com/billing/?ng=accounts/add/");
		driver.findElement(By.id("account")).sendKeys("abc12345");
		driver.findElement(By.id("description")).sendKeys("checking");
		driver.findElement(By.id("balance")).sendKeys("5000");
		driver.findElement(By.id("account_number")).sendKeys("12345");
		driver.findElement(By.id("contact_person")).sendKeys("cde");
		driver.findElement(By.id("contact_phone")).sendKeys("1234510101");
		driver.findElement(By.id("account_number")).sendKeys("12345");
		//driver.findElement(By.id("ib_url")).sendKeys("abc@cde.com");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("button.btn-primary")).click();
		Thread.sleep(4000);
	}
	@After
	public void tearDown() {// closing driver
		System.out.println("tear down method-->@After");
		driver.close();
		driver.quit();
	}
}

