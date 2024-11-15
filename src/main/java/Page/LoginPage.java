package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class LoginPage extends BaseTest {
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
