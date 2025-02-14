package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import java.util.Arrays;

public class dragAndDropPointerInput {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:deviceName", "demoAndroid"); 
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:platformVersion", "15");
        dc.setCapability("appium:appPackage", "io.appium.android.apis");
        dc.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
        
        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        AndroidDriver driver = new AndroidDriver(url, dc);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();
        Thread.sleep(2000);

        WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement dest = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));

        // Get source and destination coordinates
        int startX = src.getLocation().getX() + (src.getSize().getWidth() / 2);
        int startY = src.getLocation().getY() + (src.getSize().getHeight() / 2);
        int endX = dest.getLocation().getX() + (dest.getSize().getWidth() / 2);
        int endY = dest.getLocation().getY() + (dest.getSize().getHeight() / 2);

        // Create a touch action using PointerInput
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragAndDrop = new Sequence(finger, 0);
        dragAndDrop.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        dragAndDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragAndDrop.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        dragAndDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the action
        driver.perform(Arrays.asList(dragAndDrop));

        Thread.sleep(3000);
        driver.quit();
    }
}
