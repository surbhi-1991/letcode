package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Factory.BrowserFactory;

public class BaseTest {
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startWebBrowser("https://letcode.in/test");

	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.closeDriver();
	}
}
