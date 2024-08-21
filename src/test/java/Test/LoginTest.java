package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Factory.BrowserFactory;

public class LoginTest extends BaseTest {
	private By editButton = By.xpath("//div/footer/a[text()='Edit']");
	// private By pageHeader = By.xpath("//div/h1[contains (text(),'Input')]");
	private By enterYourName = By.xpath("//input[@id='fullName']");
	private By appendText = By.xpath("//input[@id='join']");
	private By getMe = By.id("getMe");
	private By clearMe = By.id("clearMe");
	private By noEdit = By.id("noEdit");//
	private By dontwrite = By.id("dontwrite");
	WebDriver driver = BrowserFactory.driver;
	private WebDriverWait wait;

	@Test(priority = 0)
	public void VerifyThePageUrl() {
		WebDriver driver = BrowserFactory.driver;
		String url = driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		driver.findElement(editButton).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait1.until(ExpectedConditions.urlToBe("https://letcode.in/edit"));
		String currentTitle = driver.getTitle();
		Assert.assertEquals(currentTitle, "Interact with Input fields");
		// Assert.assertEquals(url, "https://letcode.in/edit");

	}

	@Test(priority = 1)
	public void VerifyFields() {
		WebDriver driver = BrowserFactory.driver;//
		driver.findElement(enterYourName).sendKeys("Surbhi Sharma");
		driver.findElement(appendText).sendKeys("Thanks", Keys.TAB);
		String myValueString = driver.findElement(getMe).getAttribute("value");
		System.out.println(myValueString);
		driver.findElement(clearMe).clear();
		Boolean isEdit = driver.findElement(noEdit).isEnabled();
		System.out.println(isEdit);
		Actions action = new Actions(driver).moveToElement(driver.findElement(dontwrite));
		String readOnly = driver.findElement(dontwrite).getAttribute("value");
		System.out.println(readOnly);

	}
}
