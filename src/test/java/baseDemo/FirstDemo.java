package baseDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstDemo {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();	
	}
	
	@Test(priority=1)
	public void TC_001_getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Google");
	}
	
	@Test(priority=2)
	public void TC_002_getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertEquals(currentUrl,"https://www.google.com/");
	}
	
	@Test(priority=3)
	public void TC_003_elementIsDisplayed() {
		boolean contains = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println(contains);
		Assert.assertEquals(contains,true);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
