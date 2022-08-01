package stewartjumbe.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {

	@Test
	public void appiumTest() throws MalformedURLException {
		
		System.out.println("Testing testing 123");
		
		//Starting appium server
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("\\Users\\Jumbe Home\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723)
				.build();
		
		service.start();
		
		
		//Android driver
		//How architecture works, appiam code -> appium server (interprets code and triggers action on the device) -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		
		//name of the phone we're using
		options.setDeviceName("Pixel_4_XL_API_31");
		
		options.setApp("\\Users\\Jumbe Home\\Documents\\Software Development\\JAVA\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		@SuppressWarnings("unused")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//Actual Automation
		//By. :Xpath, id, classname, 
		//AppiumBy. :accessibilityId, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
		driver.quit();
		service.stop(); //stopping server
		
	}
}
