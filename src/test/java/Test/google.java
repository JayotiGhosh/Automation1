package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class google {

	@Test(priority=20)
		public void search_for_selenium() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]")).click();
				
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a")).click();
		String title = driver.getTitle();
		Assert.assertEquals("SeleniumHQ Browser Automation", title);
		driver.quit();
	}

	@Test (priority=10)
	public void search_for_google() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	driver.manage().window().maximize();
	driver.get("http://google.com");
	Assert.assertEquals("Google", driver.getTitle());
	driver.quit();
	}
	
}
