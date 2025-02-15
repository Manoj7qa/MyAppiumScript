package Demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		File filePath = new File("./Apk's/chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid");
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("appium:chromedriverExecutableDir", filePath.getParent());

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, dc);
		driver.get("https://www.google.com/");
		// find search box web element
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Naruto");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
	}
}
