/*
 Automate the following test case:
Scenario: Users will be able to add deposit
1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
2. Enter username: demo@techfios.com 
3. Enter password: abc123
4. Click login button
5. Click on Bank & Cash button
6. Click on New Account button 
7. Fill out the Add New Account form
8. Click on submit button
9. Visually check if the account has been created
Visually check to make sure the deposit posted*/

package conceptJUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestWithJUnit {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {// Methods with @BeforeClass and @AfterClass annotations have to be static
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass() {

		System.out.println("After Class");
	}

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

		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.id("account")).sendKeys("Ur123");
		driver.findElement(By.id("description")).sendKeys("checking");
		driver.findElement(By.id("balance")).sendKeys("5000");
		driver.findElement(By.id("account_number")).sendKeys("12345");
		driver.findElement(By.id("contact_person")).sendKeys("Ur123");
		driver.findElement(By.id("contact_phone")).sendKeys("1234510101");
		driver.findElement(By.id("account_number")).sendKeys("12345");
		//driver.findElement(By.id("ib_url")).sendKeys("abc@cde.com");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("button.btn-primary")).click();
		Thread.sleep(4000);
	}
	

	/*
	 * @Test public void negloginTest() throws InterruptedException {// negative
	 * test case System.out.println("neg test case method-->@Test");
	 * driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
	 * driver.findElement(By.id("password")).sendKeys("abc12323444");
	 * driver.findElement(By.name("login")).click();//to find in which line error
	 * exists copy the method name or class name //where the error has occurred then
	 * go to console press cmd + f then paste the class name or method name in find
	 * text box and hit enter-->gives line no Thread.sleep(2000);
	 * 
	 * }
	 */

	@After
	public void tearDown() {// closing driver
		System.out.println("tear down method-->@After");
		driver.close();
		driver.quit();
	}
}
//see the console to observe how many times @BeforeClass,@AfterClass,@Before and @Ater gets executed
