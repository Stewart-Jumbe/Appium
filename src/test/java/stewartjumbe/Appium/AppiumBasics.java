package stewartjumbe.Appium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest {
	

	
	@Test(enabled = false)
	public void WifiSettingsNameTest() throws MalformedURLException {
		
	
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
	public void longPressGestureTest() {
		
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
	public void scrollTest() {
		//Tapping Views
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
		//Scrolling to "WebView" text using androidAutomator
		// To use androidAutomator
				//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();
				scrollToText("Webview");
				
				
		//Alternative Scroll method if you have no idea where the scrolling should stop
				//scrollToEndAction();
	}
	
	@Test(enabled = false)
	public void swipeTest() {
	
		//Tapping Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Tapping Gallery
				driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		//Tapping Photos
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
				
				//Before swiping focusable value should be true for the first image, it will become false when the screen is swiped to the left
				WebElement firstElement = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
				Assert.assertEquals(firstElement.getAttribute("focusable"), "true", "Swipe has failed as focusable attribute is false");
				
				//Swipe
				swipeAction(firstElement,"left");
		
				//Assertion to check that focusable value on first image is not false
				Assert.assertEquals(firstElement.getAttribute("focusable"), "false","Swipe has failed as focusable attribute is true");
	}
	
	@Test(enabled = false)
	public void dragDropTest() {
		//Tapping Views
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
		//Tapping Drag and Drop
				driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
				
				WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
				int xCoordinate = 827;
				int yCoordinate = 757;
				dragNDropAction(source, xCoordinate, yCoordinate);
				
				Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");

	
	}
	
	@Test(enabled =true)
	public void miscellanousAppiumActions() {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//**Changing Screen orientation to landscape
				DeviceRotation landscape = new DeviceRotation(0,0,90);
				driver.rotate(landscape);
				
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle,"WiFi settings","Text WiFi settings not found");
		
		
		//Adding things to the click board 
		driver.setClipboardText("ABC123");
		
		//Entering wifi name from clipboard
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		Assert.assertEquals(driver.findElement(By.id("android:id/edit")).getText(), "ABC123","Wifi name ABC not yet");
		
		//clicking ok
		//driver.findElement(By.id("android:id/button1")).click(); //alternative way of doing the same shown below
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//Using device key
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

		//Presses the home button on the device
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}



	



	
	}