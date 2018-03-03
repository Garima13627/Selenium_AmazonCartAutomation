/**
 * 
 */
package firsttestngpackage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
/**
 * @author Garima Mathur
 *
 */
public class AmazonTestCase {

static ChromeDriver driver=null;
static WebDriverWait wait=null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Garima Mathur\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");

	        driver = new ChromeDriver();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
driver.get("http://www.amazon.com");
	}

	@Test
	public void testAddToCart() {
		driver.manage().window().maximize();
	       driver.get("https://www.amazon.com");
	       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sandals");
	       driver.findElement(By.id("twotabsearchtextbox")).submit();
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       driver.findElement(By.xpath("//h2[@class='a-size-small a-color-base s-inline  s-access-title  a-text-normal' and contains(text(), \"B.O.C - Womens - Zita\")]")).click();
	
	       wait=new WebDriverWait(driver,2);
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
	
	       driver.findElementById("add-to-cart-button").click();
	
	       //Test
	       assertTrue(driver.getTitle().equals("Amazon.com Shopping Cart"));
		

	}

	
	@AfterClass
	public static void Cleanup() {
	//	driver.quit();
	}
}
