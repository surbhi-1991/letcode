package Factory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver driver;

	public static WebDriver startWebBrowser(String appURL) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(appURL);
		return driver;
	}

	public static WebDriver startBrowser(String browser, String appURL) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			Map<String, String> map = new HashMap<String, String>();
			String downloadDirectory = System.getProperty("user.dir") + "/DownlodedFile/";
			map.put("download.default_directory", downloadDirectory);
			opt.setExperimentalOption("prefs", map);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Sorry currently we do not support" + browser);
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(appURL);
		return driver;

	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();

		}
	}
}
