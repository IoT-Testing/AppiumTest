// AppiumTest
//Script
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
        cap.setCapability("deviceName", "model");
        cap.setCapability("udid", "ADB value");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "version");
        cap.setCapability("appPackage", "com.package.app");
        cap.setCapability("appActivity", "com.package.app.MainActivity");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("apksigner", "file\\apksigner.jar");


        URL url;
        try {
            url = new URL("http://192.168.11.233:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        driver = new AndroidDriver(url, cap);
        System.out.println("Application Started....");
    }
}

