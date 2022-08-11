package stewartjumbe.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	protected AndroidDriver driver;
	protected AppiumDriverLocalService service;
	
//	//constructor
//	public BaseTest(AndroidDriver driver, AppiumDriverLocalService service) {
//		
//		this.driver = driver;
//		this.service = service;
//		
//	}
	
	//Methods
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		System.out.println("Starting configuration");
		
		//Starting appium server when using PC
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("\\Users\\Jumbe_Home\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723)
				.build();
		
		
		//Starting appium server when using Laptop
//		service = new AppiumServiceBuilder()
//		.withAppiumJS(new File("\\Users\\stewart.jumbe\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723)
//		.build();
		
		//starting server
		service.start();
		
		
		//Android driver
		//How architecture works, appiam code -> appium server (interprets code and triggers action on the device) -> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		
		//name of the phone we're using
		options.setDeviceName("Pixel_4_XL_API_31");
		
		//use on desktop
		options.setApp("\\Users\\Jumbe_Home\\Documents\\Software Development\\JAVA\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		//use on laptop
		//options.setApp("\\Users\\stewart.jumbe\\Documents\\Software Development\\JAVA\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//waiting before closing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Quitting and Stopping Server");
		driver.quit();
		service.stop(); //stopping server
	}
	
	
	protected void longPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "duration",2000));
	}
	
	/**
	 * Method to Scroll to the end of a page/view
	 */
	protected void scrollToEndAction() {
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));}
		while(canScrollMore);
	}
	
	 /**
	  * Method to scroll to the text of a particular element
	  * If you don't know what element to scroll to use scrollToEndAction method
	  * @param textName, text Attribute of the element to be scrolled to 
	  * 
	  */
	protected void scrollToText(String textName) {
		
		driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));",textName)));
		
	}
	
	/**
	 * 
	 * @param elementToSwipeFrom, the WebElement that the swipe should be applied on
	 * @param swipeDirection, the direction that the swipe should go (left or right)
	 */
	protected void swipeAction(WebElement elementToSwipeFrom, String swipeDirection) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) elementToSwipeFrom).getId(),
			    "direction", swipeDirection,
			    "percent", 0.75
			));
	}
	
	
	/**
	 * @param source, WebElement of the element to be picked up and dragged
	 * @param xCoordinate, onscreen x coordinate determined via appium inspector
	 * @param yCoordinate, onscrren y coordinate determined via appium inpsector
	 */
	protected void dragNDropAction(WebElement source, int xCoordinate, int yCoordinate) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", xCoordinate,
			    "endY", yCoordinate
			));
	}
}