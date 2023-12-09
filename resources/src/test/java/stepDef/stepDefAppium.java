package stepDef;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.AppiumMobilePage;
import page.ProductStorePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static page.ProductStorePage.sleep;

public class stepDefAppium {

    public static AppiumDriver appiumDriver;
    private AppiumMobilePage appiumMobilePage;

    @Before
    public void appium_driver() throws Exception
    {
        if(appiumMobilePage == null){
            appiumMobilePage=new AppiumMobilePage();
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("app", "/Users/gnanaprakasamthangaraj/Downloads/Android-NativeDemoApp-0.4.0.apk");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.wdiodemoapp");
        caps.setCapability("appActivity", ".SplashActivity");
        URL url=new URL("http://0.0.0.0:4723/");
        appiumDriver=new AndroidDriver(url, caps);
        String sessionId= appiumDriver.getSessionId().toString();
        System.out.println(sessionId);
    }
    @After
    public void after(){
        appiumDriver.quit();
    }
    @When("^click on Forms button")
    public  void forms_button(){
        WebElement s = appiumMobilePage.getFormButton();
        s.click();
        sleep(2000);
    }



}


