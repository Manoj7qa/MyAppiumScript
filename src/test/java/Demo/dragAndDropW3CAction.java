package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class dragAndDropW3CAction {

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
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		// Drag and drop button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
		Thread.sleep(2000);
		WebElement src = driver
				.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
		WebElement dec = driver
				.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]"));
		Point sourceElementCenter = getCenter(src);
		Point targetElementCenter = getCenter(dec);
		// PointerInput class to create a sequence of actions
		// that move the pointer to the center of the element,
		// press down on the element, and then release the element.
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		// Sequence object, which is a list of actions that will be performed on the
		// device
		Sequence sequence = new Sequence(finger1, 1)
				// move finger to the starting position
				.addAction(
						finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
				// finger coming down to contact with screen
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(588)))
				// move finger to the end position
				.addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(),
						targetElementCenter))
				// move the finger up
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		// perform sequence of actions
		// driver.perform(Collections.singletonList(sequence));
		driver.perform(Arrays.asList(sequence));
		Thread.sleep(2000);
		driver.quit(); // close session
	}

	private static Point getCenter(WebElement element) {
        //get location of the element
		Point location = element.getLocation();
        //get dimension (height & width of the element)
		Dimension size = element.getSize();
        //center point
		Point center = new Point(location.x + size.width / 2, location.y + size.height / 2);
		return center;
	}

}
