package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class autoLogin {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid"); // Use the "appium:" prefix for non-W3C keys
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "com.hts.awan_gas_driver_app.staging");
		dc.setCapability("appium:appActivity", "com.example.awan_gas_driver_app.MainActivity");

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);
//	        WebElement phoneField = driver.findElement(By.className("android.widget.EditText"));
//	       WebElement submitButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send OTP\"]"));
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("968574278");
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send OTP\"]")).click();
		Thread.sleep(5000);
//	       WebElement netMesg=driver.findElement(By.className("android.view.View"));
		String msg = driver.findElement(By.xpath(
				"//android.view.View[@content-desc=\"Connection error. Please check your internet connection.\"]"))
				.getAttribute("content-desc");
		Thread.sleep(2000);
//	       WebElement okButton=driver.findElement(By.xpath("android.widget.Button"));
		driver.findElement(By.className("android.widget.Button")).click();
		Assert.assertEquals(msg, "Connection error. Please check your internet connection.");
//	       driver.quit();
	}

}
