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

public class AppiumBasics extends BaseTest {
	


	@Test
	public void WifiSettingsName() throws MalformedURLException {
		
	
		//configureAppium();method is automatically executed due to AfterClass annotation on parent class (BaseTest);
		
		
		//Actual Automation
		
		//
		//findElement(By. :Xpath, id, classname, 
		//findElement(AppiumBy. :accessibilityId, androidUIAutomator
		
		
		//Xpath Syntax:
		//tagName[@attribute='value']
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		//tearDown() method is automatically executed due to AfterClass annotation on parent class (BaseTest);
		
	}
	
}
