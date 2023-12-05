package baseDemo;

import java.time.Duration;

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
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
