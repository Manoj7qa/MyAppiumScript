package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwitchHandling {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid"); // Use the "appium:" prefix for non-W3C keys
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "com.android.settings");
		dc.setCapability("appium:appActivity", "com.android.settings.Settings");
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);
//Click on Notification	
		driver.findElement(
				By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.android.settings:id/text_frame\"])[4]"))
				.click();
		Thread.sleep(5000);
		// Click on App notifiction
		driver.findElement(By
				.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"App notifications\"]"))
				.click();
		Thread.sleep(5000);
		// Click on Turn off notification Appium settings and message
		WebElement Appium = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Appium Settings\"]"));
		if(Appium.isSelected()==true)
		{
			System.out.println("Its On");
		}else {
			System.out.println("Its Off");
			Appium.click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Messages\"]")).click();
		Thread.sleep(2000);
		// Click on back
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.ImageButton")).click();
		Thread.sleep(2000);
		// Scroll till System
		String scrollEle = "System";
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + scrollEle + "\"))"));
	}

}
