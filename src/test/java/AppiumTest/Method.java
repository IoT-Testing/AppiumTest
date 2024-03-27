package AppiumTest;
										//adb logcat *:E | findstr "com.atomberg.app"
										// robot -d Output Test/Login.robot
										//adb shell monkey -p com.atomberg.app -v 5000 --throttle 100
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

public class Method
{
     public static void captureScreenshot(AppiumDriver driver) 
     {
        try {
	            File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            String destinationFilePath = "C:\\Users\\Rohit\\Desktop\\Rohit\\Appium Screenshots\\NEWMOBILES\\Trail1\\Screenshot_" + timestamp + ".png";
	            FileUtils.copyFile(screenshotFile, new File(destinationFilePath));
	            System.out.println("Appium screenshot saved to: " + destinationFilePath);
        	} catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
    }
    public static void ScrollUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.10);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(350), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        System.out.println("Scrolled Up");
    }
    public static void ScrollDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize(); // Assuming getWindowSize() returns the window size
        int startX = size.getHeight() / 2;
        int startY = size.getHeight() / 2;
        int endX = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.85); // Adjusted to scroll down

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        System.out.println("Scrolled Down");
    }
    public static void swipeToRight(AppiumDriver driver, double x, double y) {
        Dimension size = driver.manage().window().getSize(); // Assuming getWindowSize() returns the window size
        int startY = (int) (size.getHeight() * y);
        int startX = (int) (size.getWidth() * x); // Adjusted to swipe right
        int endX = (int) (size.getWidth() * 0.50); // Adjusted to swipe right

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(150)))
                .addAction(finger.createPointerMove(Duration.ofMillis(150), PointerInput.Origin.viewport(), endX, startY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        System.out.println("Right Swipe");
    }
    public static void swipeToLeft(AppiumDriver driver, double x, double y) {
        Dimension size = driver.manage().window().getSize(); // Assuming getWindowSize() returns the window size
        int startY = (int) (size.getHeight() * y);
        int startX = (int) (size.getWidth() * x); // Adjusted to swipe left
        int endX = (int) (size.getWidth() * 0.50); // Adjusted to swipe left

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
        		.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(150)))
                .addAction(finger.createPointerMove(Duration.ofMillis(150), PointerInput.Origin.viewport(), endX, startY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        System.out.println("Left Swipe");
   }
    public static void FanControl(AppiumDriver driver) {
    	WebElement Speed1 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"1\"]"));
        Speed1.click();
        System.out.println("Speed1");
        sleep(3000);
        Method.captureScreenshot(driver);
 
        WebElement Speed2 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"2\"]"));
        Speed2.click();
        System.out.println("Speed2");
        sleep(3000);
        Method.captureScreenshot(driver);
                
        WebElement Speed3 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"3\"]"));
        Speed3.click();
        System.out.println("Speed3");
        sleep(3000);
        Method.captureScreenshot(driver);
    
        WebElement Speed4 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"4\"]"));
        Speed4.click();
        System.out.println("Speed4");
        sleep(3000);
        Method.captureScreenshot(driver);
        
        WebElement Speed5 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"5\"]"));
        Speed5.click();
        System.out.println("Speed5");
        sleep(3000);
        Method.captureScreenshot(driver);
        
        WebElement Boost = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[5]"));
        Boost.click();
        System.out.println("Boost");
        sleep(3000);
        Method.captureScreenshot(driver);
        
    }
    private static void sleep(long millis) 
    {
        try {
        		Thread.sleep(millis);
        	} catch (InterruptedException e) 
        	{
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
        	}
        System.out.println("......");
    }
    public static void tap(AppiumDriver driver, int x, int y) 
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(150)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        System.out.println("Tap with Coordinates");
    }
	public static void AddDevice(AppiumDriver driver, String searchText) 
	{
	    int count = 0; //no. of retry
	    
	    for (int i = 1; i <= 10; i++)// assumed 10 maximum devices
	   		{
	    	sleep(15000);	
	        WebElement element = null;
	        String xpathExpression = "//android.view.View[@content-desc=\"" + searchText + "\"][" + i + "]";
	        	//Search Fan Only
	        try {
		            element = driver.findElement(By.xpath(xpathExpression));
		        } catch (NoSuchElementException ignored) {}
	
	        if (element != null) // if device is available
			        {
			            System.out.println("Text found at index " + i);
			            Method.captureScreenshot(driver);
			            WebElement connect = driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Connect\"])[" + i + "]"));
			            connect.click();
			            System.out.println("Connect button clicked.");
			            //Connect to fan
			            sleep(5000);
			            if (searchText == "Atomberg Smart Fan")
					            {
			            	sleep(5000);
					            WebElement ConnectLock = null; //check if a lock connect button is clicked
					            try {
					            		ConnectLock = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"How to reset?\"]"));
					            	} catch (NoSuchElementException ignored) {}
					            
						            if(ConnectLock != null)
						            {
						            	WebElement Cancel = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]"));
						            	Cancel.click();
						            	i++; // next connect button index
						            	WebElement NewConnect = driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Connect\"])[" + i + "]"));
						            	NewConnect.click();
						            	i--;
						            }
					            }
			            else if (searchText == "Atomberg Smart Lock")
					            {
							        	sleep(5000);
							        	WebElement ConnectFan = null; //check if a lock connect button is clicked
							            try {
							            		ConnectFan = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"How to reset?\"]"));
							            	} catch (NoSuchElementException ignored) { }
							            
								            if(ConnectFan != null)
								            {
								            	
								            	WebElement Cancel = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Cancel\"]"));
								            	Cancel.click();
								            	i++; // next connect button index
								            	WebElement NewConnect = driver.findElement(By.xpath("(//android.view.View[@content-desc=\"Connect\"])[" + i + "]"));
								            	NewConnect.click();
								            	i--;
								            }
					            }
			           if(searchText == "Atomberg Smart Fan")
					           { 
					        	   WebElement dialogue = null; 
						       try {
						            		dialogue = driver.findElement(By.xpath("//android.view.View[@content-desc=\"This smart device has already been added in another family. Please ask the admin to add you to the family.\"]"));
						            } catch (NoSuchElementException ignored) {}
					
					            if (dialogue != null)// if fan is already added
						            {
						            	System.out.println("This smart device has already been added in another family.");
						            	Method.captureScreenshot(driver);
						            	Method.tap(driver, 200, 200);     // random tap)
						                System.out.println("Dialogue Box Skipped.");
						                continue; // Next iteration
						            }
					            else 
						            {
						            	break;
						            }
					           }
			           else if (searchText == "Atomberg Smart Lock")
					           {
					        	   
					           }
			        }
	            else {
			        	 WebElement Device = null;
			             try {
			            	 		Device = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Discovered devices\"]"));
			             	 } catch (NoSuchElementException ignored) {}
				             if(Device == null) // if No Device Available
						            {
							            sleep(15000);
							            WebElement tryAgain = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Try Again\"]"));
							            tryAgain.click();
							            i--;
							            count++;
							            System.out.println("Trying Again...." + count);
							            System.out.println("Value of i: " + i); 
							            if (count == 10) 
								            {
								                System.out.println("No device found");
								                break;
								            }
							            else 
								            {
								            	sleep(15000);
								            }
						            }
				            else
				            {
				            	continue;
	  		                }
	            	}
	   		}
	}
	public static void SearchWiFi(AppiumDriver driver, String SearchString) {
	////android.widget.EditText[@text="Better_Together"]
	    for (int i = 1; i <= 10; i++) {
	    	WebElement element=null;
	    	try {
	      element = driver.findElement(By.xpath("//android.widget.EditText[@text=\""+ SearchString +"\"]"));
	    	}catch(Exception e) {}
	       if (element != null) {
	          System.out.println(""+ SearchString + " Available");
	          sleep(1000);
	          WebElement Password = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
	          Password.getText();
	          if(Password.getText() != "987654321")
	          {
	        	  Password.clear();
	          }
	          Password.click();
	          Password.sendKeys("987654321");
	          sleep(1000);
	          WebElement Continue = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]"));
	          Continue.click();
	          break;
	       } else 
	       {
	    	   WebElement WiFI = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
	    	   WiFI.click();
	    	   WiFI.sendKeys("Better_Together");
	    	   sleep(1000);
	    	   WebElement Password = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
	           Password.click();
	           Password.sendKeys("987654321");
	       }
	       
	    }
	 }
	public static void AdditionProcess(AppiumDriver driver)
	{
		sleep(5000);
		WebElement Next = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")); // Add 2nd Device
		System.out.println("Next");
		Next.click();
		sleep(5000);
	    SearchWiFi(driver, "Better_Together");
	    Method.swipeToLeft(driver, 0.80, 0.18);  //0.80, 0.365
	    sleep(500);
	    
	    Method.captureScreenshot(driver);
	    Method.swipeToRight(driver, 0.20, 0.18);
	    sleep(500);
	    Method.captureScreenshot(driver);
	   
	
	    // Select Room
	    
	    WebElement MasterBedroom = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Master Bedroom\"]")); 
	    MasterBedroom.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement GuestRoom = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Guest Room\"]"));
	    GuestRoom.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement Kitchen = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Kitchen\"]"));
	    Kitchen.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement CommonBR = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Common Bedroom\"]")); 
	    CommonBR.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement Lobby = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Lobby\"]")); 
	    Lobby.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement Balcony = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Balcony\"]")); 
	    Balcony.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement LivingRoom = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Living Room\"]"));
	    LivingRoom.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	    WebElement ContinueToAdd = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]"));
	    ContinueToAdd.click();
	    Method.captureScreenshot(driver);
	    sleep(30000);
	    WebElement Skip = null;
	    try {
	    	Skip = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Skip\"]"));
	    	}catch(Exception e) {}
	    if (Skip == null) {
	    	System.out.println("Taking More time...");
	    	sleep(30000);
	    } 
	    	    Skip.click();
	    Method.captureScreenshot(driver);
	    sleep(1000);
	}
	public static void Tap(AppiumDriver driver, double x, double y) {
	    Dimension size = driver.manage().window().getSize(); // Assuming getWindowSize() returns the window size
	    int startY = (int) (size.getHeight() * y);
	    int startX = (int) (size.getWidth() * x); // Adjusted to swipe left
	
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence sequence = new Sequence(finger, 1)
	    		.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
	            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	            .addAction(new Pause(finger, Duration.ofMillis(150)))
	            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    driver.perform(Collections.singletonList(sequence));
	    System.out.println("Tap With %");
	}
	public static void SwitchFamily(AppiumDriver driver)
	{
		 WebElement continueButton1 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]\r\n" + ""));
	     continueButton1.click(); // Continue to Login
	     sleep(10000);
	      Method.captureScreenshot(driver);
	}
	public static void Fans(AppiumDriver driver) {
		WebElement element = null;
	    try {
	        sleep(2000);
	        element = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Select your fan color\"]"));
	        System.out.println("Select your fan color");
	    } catch (Exception exp) {}
	        if (element != null) {
	        	WebElement Xpath= null;
	        	
	        	try {
	            Xpath = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Marble White\"]"));
	        	}catch(Exception e) {}
	            
	        	if (Xpath != null) {
	        		System.out.println("Impala");
	                WebElement ColorSelect = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Dark Teakwood\"]")); // Add 2nd Device
	                ColorSelect.click();
	                System.out.println("Dark Teakwood");
	                sleep(1500);
	                Xpath.click();
	                System.out.println("Marble White");
	                sleep(1000);
	                Method.AdditionProcess(driver);
	
	            } else {
	            	System.out.println("Erica");
	                WebElement ColorSelect = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Umber Brown\"]")); // Add 2nd Device
	                ColorSelect.click();
	                sleep(1000);
	                WebElement ColorSelect1 = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Snow White\"]")); // Add 2nd Device
	                ColorSelect1.click();
	                sleep(3000);
	                Method.AdditionProcess(driver);
	            }
	        }else
	        {
	        	 //Select Model
	        	sleep(2000);
	            WebElement Renesa = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Renesa\"]")); // Add 1st Device
	            Renesa.click();
	            System.out.println("Renesa Selected");
	            Method.captureScreenshot(driver);
	            sleep(2000);
	            WebElement StudioPlus = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Studio+\"]")); 
	            StudioPlus.click();
	            System.out.println("Studio+ Selected");
	            Method.captureScreenshot(driver);
	            sleep(2000);
	            
	            WebElement RenesaPlus = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Renesa+\"]")); 
	            RenesaPlus.click();
	            System.out.println("Renesa+ Selected");
	            Method.captureScreenshot(driver);
	            sleep(2000);
	          
	            WebElement Continue = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]"));// Add 2nd Device
	            Continue.click();
	            Method.captureScreenshot(driver);
	     //Color Select
	            
	            WebElement gOakWood = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Golden Oakwood\"]")); 
	            gOakWood.click();
	            Method.captureScreenshot(driver);
	            sleep(1000);
	            
	            Method.swipeToLeft(driver, 0.80, 0.75);
	            Method.captureScreenshot(driver);
	            sleep(500);
	            
	            WebElement EarthBrown = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Earth Brown\"]")); 
	            EarthBrown.click();
	            Method.captureScreenshot(driver);
	            sleep(1000);
	            WebElement nOakWood = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Natural Oakwood\"]")); 
	            nOakWood.click();
	            Method.captureScreenshot(driver);
	            sleep(1000);
	            Method.swipeToRight(driver, 0.20, 0.75);
	            Method.captureScreenshot(driver);
	            sleep(1000);
	            WebElement PearlWhite = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Pearl White\"]")); 
	            PearlWhite.click();
	            Method.captureScreenshot(driver);
	            sleep(1000);
	            Method.AdditionProcess(driver);
	        }
	}
}
