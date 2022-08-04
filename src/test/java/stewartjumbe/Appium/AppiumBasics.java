package stewartjumbe.Appium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
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
		//tagName[@attribute='value'] or //tagName
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle,"WiFi settings","Text WiFi settings not found");
		
		//Entering wifi name
		driver.findElement(By.id("android:id/edit")).sendKeys("ABC");
		//clicking ok
		//driver.findElement(By.id("android:id/button1")).click(); //alternative way of doing the same shown below
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		//tearDown() method is automatically executed due to AfterClass annotation on parent class (BaseTest);
		
	}
	
}
