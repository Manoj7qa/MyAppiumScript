package Demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AppInstall {
    public static void main(String[] args) throws MalformedURLException {
        // Set desired capabilities
        File filePath = new File("./Apk's/Supervisorhts-Production-0.1.4.apk");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:deviceName", "demoAndroid"); // Use the "appium:" prefix for non-W3C keys
        dc.setCapability("appium:automationName", "UiAutomator2");		
        dc.setCapability("appium:app", filePath.getAbsolutePath());
        dc.setCapability("appium:platformVersion", "15");
        // Create URL for Appium server
        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        // Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, dc);
        // Add further actions or quit driver after use
        System.out.println("App installed successfully!");
        driver.quit(); // Quit the driver when done
    }
}
