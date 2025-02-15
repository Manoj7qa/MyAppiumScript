package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class longPress {
static	AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid"); // Use the "appium:" prefix for non-W3C keys
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		dc.setCapability("appium:appPackage", "com.google.android.dialer");
		dc.setCapability("appium:appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		 driver = new AndroidDriver(url, dc);
		Thread.sleep(5000);

		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/digits")).sendKeys("9685745");
		Thread.sleep(2000);
		WebElement backButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"backspace\"]"));
		Thread.sleep(2000);
		backButton.click();
		Thread.sleep(2000);
		longPress(backButton);
	}
	static void longPress(WebElement ele) {
		Point loaction = ele.getLocation();
		PointerInput finger =new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence longpress =new Sequence(finger,1);
		longpress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),loaction.x,loaction.y));
		longpress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		longpress.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),loaction.x,loaction.y));
		longpress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(longpress));
	}

}
