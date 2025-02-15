package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.implementation.bytecode.Division;

public class autoCalling {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid"); // Use the "appium:" prefix for non-W3C keys
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "com.google.android.dialer");
		dc.setCapability("appium:appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/digits")).sendKeys("9685745");
		Thread.sleep(2000);
		//Call button
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"dial\"]")).click();
		Thread.sleep(5000);
		//EndCall
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"End call\"]")).click();
		

	}

}
