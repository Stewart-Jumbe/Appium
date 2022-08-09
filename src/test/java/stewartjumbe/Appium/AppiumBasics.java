package stewartjumbe.Appium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest {
	

	
	@Test(enabled = false)
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
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();// method returns a list of buttons, and gets the element in dex position 1
		//tearDown() method is automatically executed due to AfterClass annotation on parent class (BaseTest);
		
		
	}
	
	@Test(enabled = false)
	public void longPressGestureExample() {
		
		//Tapping Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
		//Tapping Expandable Lists
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		
		//Tapping Custom Adapter
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//custom xpath for People Names
		WebElement peopleNameElement= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		//using keyvalue pair to apply longClick
		longPress(peopleNameElement);
		
		//Checking that 'Sample menu' text appears
		//Method 1
//		String sampleMenuText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title']")).getText();
//		Assert.assertEquals(sampleMenuText, "Sample menu");
		
		//Method 2
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed(),"Expected text was not displyed");
		
		
		
	}
	
	@Test(enabled = false)
	public void scrollExample() {
		//Tapping Views
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
		//Scrolling to "WebView" text using androidAutomator
		// To use androidAutomator
				//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();
				scrollToText("Webview");
				
				
		//Alternative Scroll method if you have no idea where the scrolling should stop
				//scrollToEndAction();
	}
	
	@Test
	public void swipeExample() {
	
		//Tapping Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Tapping Gallery
				driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		//Tapping Photos
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		
	}



	
	}