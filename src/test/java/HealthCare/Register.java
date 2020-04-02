package HealthCare;

		import java.util.Set;
		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
		
		public class Register {
			
			@Test
			public static void createpatient() throws InterruptedException {
				// TODO Auto-generated method stub
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://demo.openemr.io/a/openemr");
				
				driver.findElement(By.id("authUser")).click();
				driver.findElement(By.id("authUser")).sendKeys("admin");
				driver.findElement(By.id("clearPass")).click();
				driver.findElement(By.id("clearPass")).sendKeys("pass");
				
				driver.findElement(By.className("btn")).click();
				
				Actions act = new Actions(driver);
				
				act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/div"))).perform();
				driver.findElement(By.xpath("//*[@id=\"menu_logo\"]/div/div/span[5]/div/ul/li[2]/div")).click();
				
				Thread.sleep(2000);
				
				driver.switchTo().frame(driver.findElement(By.name("pat")));
				
				String Pgtitle = driver.getTitle();
				Assert.assertEquals("OpenEMR", Pgtitle);
				
				Select title = new Select(driver.findElement(By.id("form_title")));
				title.selectByIndex(2);
					
				driver.findElement(By.id("form_fname")).sendKeys("abc");
				driver.findElement(By.id("form_lname")).click();
				driver.findElement(By.id("form_lname")).sendKeys("xyz");
				driver.findElement(By.id("form_DOB")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.className("xdsoft_today")).click();
				
				driver.findElement(By.id("form_sex")).click();
				Select sex = new Select(driver.findElement(By.id("form_sex")));
				sex.selectByIndex(2);
				
				driver.findElement(By.id("create")).click();
				Thread.sleep(3000);				
				driver.switchTo().defaultContent();
				
				driver.switchTo().frame(driver.findElement(By.id("modalframe")));
				driver.findElement(By.xpath("/html/body/center/input")).click();
				driver.switchTo().defaultContent();
				
				Thread.sleep(3000);
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				
				driver.switchTo().frame(driver.findElement(By.id("modalframe")));
				System.out.println(driver.findElement(By.className("h2")).getText());
				driver.switchTo().defaultContent();
				
				driver.findElement(By.className("closeDlgIframe")).click();
			
				Actions logout = new Actions(driver);
				
				logout.moveToElement(driver.findElement(By.xpath("//*[@id=\"username\"]/span[1]"))).perform();
				driver.findElement(By.xpath("//*[@id=\"username\"]/div/ul/li[4]")).click();
				
				driver.close();
				
			}

		
	}


