<<<<<<< Updated upstream
package AppiumTest; 
//Add First Device


import java.io.File;
import java.io.IOException;
=======
package AppiumTest;
//Add First Device

>>>>>>> Stashed changes
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities; //Selenium Dependencies for Mobile capabilities
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class OnlyScreenShots {
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

    public static void openAtomberg() // Main
    {
<<<<<<< Updated upstream
    	  DesiredCapabilities cap = new DesiredCapabilities();
    	  cap.setCapability("automationName", "UiAutomator2");
          cap.setCapability("platformName", "Android");
          cap.setCapability("platformVersion", "13");
          cap.setCapability("apksigner","C:\\Users\\Rohit\\Desktop\\android-sdk\\build-tools\\34.0.0\\lib\\apksigner.jar");
          cap.setCapability("dumpAppPackageInfo", true);
         try {
=======
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "POCO M6 Pro 5G");
        cap.setCapability("udid", "e5b51506054a");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("apksigner",
                "C:\\Users\\Rohit\\Desktop\\android-sdk\\build-tools\\34.0.0\\lib\\apksigner.jar");
        cap.setCapability("dumpAppPackageInfo", true);
        try {
>>>>>>> Stashed changes
            System.out.println("Initializing Appium driver..."); // Check if the Appium driver is initialized
            URL url = new URL("http://192.168.8.255:4723/wd/hub"); // URL of the Appium session
            driver = new AppiumDriver(url, cap);
            System.out.println("Appium driver initialized.");
        } catch (MalformedURLException e) {
            System.out.println("Error initializing Appium driver: " + e.getMessage());
            Assert.fail("Expected element to click not found");
            captureScreenshot(driver);
            e.printStackTrace();
            return;
        }
<<<<<<< Updated upstream
         captureScreenshot(driver);
         List<WebElement> el = driver.findElements(By.xpath("//android.widget.ImageView"));
         System.out.println("List Size: " + el.size()+"\n");
         
         for (WebElement element : el) {
        	    System.out.println("Element text: " + element.getDomAttribute("text")+"\n");
        	}
         sleep(500);
         
         }
=======
        Method.captureScreenshot(driver);
        List<WebElement> el = driver.findElements(By.xpath("//android.widget.ImageView"));
        System.out.println("List Size: " + el.size() + "\n");

        for (WebElement element : el) {
            System.out.println("Element text: " + element.getDomAttribute("bounds") + "\n");
        }
        sleep(500);

    }
>>>>>>> Stashed changes

    private static void sleep(long millis)
    {
    	    Awaitility.await().atMost(millis, TimeUnit.MILLISECONDS);
    }
    public static void captureScreenshot(AppiumDriver driver) {
        try {
            File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destinationFilePath = "C:\\Users\\Rohit\\Desktop\\Rohit\\Appium Screenshots\\NEWMOBILES\\Trail1\\Screenshot_" + timestamp + ".png";

            FileUtils.copyFile(screenshotFile, new File(destinationFilePath));

            System.out.println("Appium screenshot saved to: " + destinationFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
