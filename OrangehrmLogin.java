package orangehrm1;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.ExcelUse;

public class OrangehrmLogin {
	WebDriver driver;

	@BeforeTest
	public void tt() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C://Users/Shreya Pillai/Desktop/selenium/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();

		Thread.sleep(3000);
	}

	@Test(dataProvider = "DP")
	@Parameters({ "username", "password" })
	public void login(String username, String password) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();

		if (!driver.findElements(By.id("welcome")).isEmpty()) {
			// assertEquals(true,!driver.findElements(By.id("welcome")).isEmpty() );
			System.out.println("Successfull Login");
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("Welcome")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();

		} else {
			System.out.println("Invalid ");
		}

	}

	@DataProvider(name = "DP")
	public Object[][] dataprovider() {
		return new Object[][] { { "Admin", "admin123" }, { "Shreya", "shreya123" }, { "Ritu", "Ritu123" },
				{ "Admin", "admin123" } };
	}

}
