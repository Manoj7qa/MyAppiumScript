package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class dropdown {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid"); // Use the "appium:" prefix for non-W3C keys
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "io.appium.android.apis");
		dc.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);
		// View Button
		driver.findElements(By.id("android:id/text1")).get(11).click();
		// Controls button
		Thread.sleep(2000);
		driver.findElements(By.id("android:id/text1")).get(4).click();
		// Light theme button
		Thread.sleep(2000);
		driver.findElements(By.id("android:id/text1")).get(0).click();
		// dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		// Dropdown option
		Thread.sleep(2000);
		driver.findElements(By.id("android:id/text1")).get(1).click();
		Thread.sleep(2000);
		driver.quit(); // close session
	}
}
