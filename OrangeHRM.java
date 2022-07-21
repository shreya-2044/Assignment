package orangehrm1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM {

	WebDriver driver;

	@BeforeTest
	public void tt() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C://Users/Shreya Pillai/Desktop/selenium/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();

		Thread.sleep(3000);
	}
	@Test
	public void test() throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		System.out.println(driver.getTitle());

		driver.findElement(By.linkText("Admin")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("PIM")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Leave")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Time")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Recruitment")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Directory")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Maintenance")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Dashboard")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Buzz")).click();
		System.out.println(driver.getTitle());


		// welcome link
		driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		Thread.sleep(3000);
		// logout
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
}
