package AppiumTest; //To check 


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;

public class Atomberg3 {
   public static AppiumDriver driver;

   public static void main(String[] args) {
      try {
         openAtomberg();
      } catch (Exception exp) {
         System.out.println(exp.getCause());
         System.out.println(exp.getMessage());
         exp.printStackTrace();
      }
   }

   public static void openAtomberg() {
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability("deviceName", "POCO M6 Pro 5G");
      cap.setCapability("udid", "e5b51506054a");
      cap.setCapability("platformName", "Android");
      cap.setCapability("platformVersion", "13");
      cap.setCapability("appPackage", "com.atomberg.app");
      cap.setCapability("appActivity", "com.atomberg.app.MainActivity");
      cap.setCapability("apksigner",
         "C:\\Users\\Rohit\\Desktop\\android-sdk\\build-tools\\34.0.0\\lib\\apksigner.jar");
      try {
         System.out.println("Initializing Appium driver..."); // Check if the Appium driver is initialized
         URL url = new URL("http://192.168.8.255:4723/wd/hub"); // URL of the Appium session
         driver = new AppiumDriver(url, cap);
         System.out.println("Appium driver initialized.");
      } catch (MalformedURLException e) {
         System.out.println("Error clicking button: " + e.getMessage());
         Assert.fail("Expected element to click not found");
         Method.captureScreenshot(driver);
         e.printStackTrace();
         return;
      }

      System.out.println("Atomberg App Opened...");
      sleep(6000);
      Method.captureScreenshot(driver);

      // Click on Login with Email image(mail icon)
      WebElement emailLoginButton = driver.findElement(By.xpath(
              "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]\r\n"
                      + "")); // Click on Login with Email image(mail icon)
      emailLoginButton.click();
      sleep(1000);
      waitForElementAndClick(By.xpath("//android.widget.EditText"));
      sleep(1000);
      Method.tap(driver, 300, 170);
      WebElement emailField = driver.findElement(By.xpath("//android.widget.EditText"));
      
      emailField.sendKeys("wametis763@bookspre.com"); // Enter Email id
      Method.captureScreenshot(driver);
      sleep(1000);
      System.out.println("Email Entered...");
      sleep(1000);

      WebElement continueButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]"));
      continueButton.click(); // Continue button
      sleep(2000);
      Method.captureScreenshot(driver);

      WebElement passwordField = driver
              .findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]\r\n" + ""));
      passwordField.click();
      passwordField.sendKeys("Atomberg@123");
      Method.captureScreenshot(driver);
      System.out.println("Password entered..."); // Enter Password

      WebElement continueButton1 = driver
              .findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]\r\n" + ""));
      continueButton1.click(); // Continue to Login
      sleep(10000);
       Method.captureScreenshot(driver);//Check for Allow button, if pop-up without any interaction means there is a device present, if not the need to add 1st device
      
      WebElement AllowButton = null;
      try {
          sleep(2000);
          AllowButton = driver.findElement(By.id("com.android.permissioncontroller:id/permission_message"));
   
      } catch (Exception exp) {
      	
      }
      if (AllowButton != null) // if not null means at least 1 device present
      {
      					            	
      	allowPermissionButton("com.android.permissioncontroller:id/permission_allow_button");
          sleep(2000);
          Method.captureScreenshot(driver);
         allowPermissionButton("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
          sleep(3000); // Click on allow permissions
          System.out.println("On Home Screen");
          Method.captureScreenshot(driver);
          sleep(3000);
          WebElement Addbutton = driver
                  .findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.ImageView"));
      	Addbutton.click();
      	Method.captureScreenshot(driver);
          System.out.println("2nd Device");
          sleep(15000);
      }
      else {
      	System.out.println("Adding 1st Device");
      	Method.tap(driver, 550, 1940);
          sleep(2000);
          // Click on allow permissions
          allowPermissionButton("com.android.permissioncontroller:id/permission_allow_button");
          sleep(2000);
          Method.captureScreenshot(driver);
          allowPermissionButton("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
          sleep(3000); // Click on allow permissions
          System.out.println("On Home Screen");
          Method.captureScreenshot(driver);
          sleep(3000);

          Method.tap(driver, 550, 1940);
          sleep(15000);
      }

      List<WebElement> elements = driver.findElements(By.xpath("//android.view.View"));
      System.out.print("Number of Elements found: " + elements.size() + " ");
      for (WebElement element : elements) 
      {
          System.out.print("Element: " + element.getTagName() + "\n ");
          if(element.getTagName() != null)
          {
        	  System.out.println("Element index: " + element.getDomAttribute("contentDescription")+"\n");
        	  element.click();
        	  sleep(5000);
          }
      }
     
   }

   private static void allowPermissionButton(String resourceId) {
      WebElement permissionButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"" + resourceId + "\"]\r\n" + ""));
      permissionButton.click();
   }


   private static void waitForElementAndClick(By by) {
       Awaitility.await()
               .atMost(Duration.ofSeconds(10))
               .pollInterval(Duration.ofMillis(500))
               .until(() -> {
                   WebElement element = driver.findElement(by);
                   element.click();
                   return true;
               });
   }

   public static void SearchDevice(AppiumDriver driver, String searchText) {

      for (int i = 1; i <= 10; i++) {
         String xpathExpression = "(//android.view.View[@content-desc=\"" + searchText + "\"])[" + i + "]";
         WebElement element = driver.findElement(By.xpath(xpathExpression));

         if (element != null) {
            System.out.println("Text found at index" + i + "");

         } else {
            System.out.println("Text not found.");
         }
      }
   }
   private static void sleep(long millis) {
	    Awaitility.await().atMost(millis, TimeUnit.MILLISECONDS);
	}
   
}