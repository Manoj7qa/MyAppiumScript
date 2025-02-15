package Demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AppManagement {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		File filePath = new File("./Apk's/ApiDemos.apk");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("appium:deviceName", "demoAndroid");
		dc.setCapability("appium:automationName", "UiAutomator2");
		dc.setCapability("appium:platformVersion", "15");
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, dc);
		String packageName = "io.appium.android.apis";

//		if (driver.isAppInstalled(packageName)) {
//			// install app
//			driver.removeApp(packageName);
//			System.out.println("App uninstalled.");
//		} else {
//			// install application
//			driver.installApp(filePath.getAbsolutePath());
//			System.out.println("App sucessfully installed.");
//
//			driver.activateApp(packageName);// Open app
//			Thread.sleep(5000);
//			driver.terminateApp(packageName);// close app
//		}

		driver.removeApp(packageName);
		if (!driver.isAppInstalled(packageName)) {
			// install application
			driver.installApp(filePath.getAbsolutePath());
			System.out.println("App sucessfully installed.");
		} else {
			System.out.println("App already installed.");
		}

		// activate the application
		driver.activateApp(packageName);
		Thread.sleep(5000);
		driver.terminateApp(packageName);// close app
		Thread.sleep(2000);
		driver.quit();// close session
	}
}
