// Apptest script for atomberg
package AtombergTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Atomberg {
    static AppiumDriver driver;

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
        cap.setCapability("deviceName", "SM-M127G/DS");
        cap.setCapability("udid", "RZ8T60V88JT");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        cap.setCapability("appPackage", "com.package.app");
        cap.setCapability("appActivity", "com.package.app.Activity");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("apksigner", "C:\\Users\\Rohit\\Desktop\\android-sdk\\build-tools\\34.0.0\\lib\\apksigner.jar");


        URL url;
        try {
            url = new URL("http://url:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        driver = new AndroidDriver(url, cap);
        System.out.println("Application Started....");
    }
}

