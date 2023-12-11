package stepDef;

import io.appium.java_client.AppiumBy;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

import static page.ProductStorePage.sleep;

public class stepDefAppium {

    public static AppiumDriver appiumDriver;
    private AppiumMobilePage appiumMobilePage;
    public static String FormInputText;
    public static String Switch;
    public static String EmailId;
    public static String Password;

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
        sleep(2000);
    }
    @After
    public void after(){
        appiumDriver.quit();
    }
    @When("^click on Forms button from home page")
    public  void forms_button(){
        WebElement s = appiumMobilePage.getFormButton();
        s.click();
        sleep(2000);
    }
    @When("^click on Login button from home page")
    public  void login_button_homescreen(){
        WebElement lgnBtn = appiumMobilePage.getLoginBtn();
        lgnBtn.click();
        sleep(3000);
    }
    @And("^Enter the input value \"([^\"]*)\" in input field")
    public  void forms_input_field(String inputtext){
        FormInputText = inputtext;
        WebElement inputValue = appiumMobilePage.getFormInputField();
        inputValue.sendKeys(FormInputText);
        sleep(200);
    }
    @Then("^Verify the entered input value is displayed in result field")
    public  void forms_input_result_field(){
        WebElement inputResult= appiumMobilePage.getFormInputResultField();
        String result = inputResult.getText();
        Assert.assertEquals("Entered input is displayed",FormInputText,result);
    }
    @And("^Turn \"([^\"]*)\" the switch")
    public  void forms_switch_field(String switchinput){
        Switch = switchinput;
        WebElement switchBtn = appiumMobilePage.getFormSwitch();
        String expectedResult  = "Click to turn the switch "+Switch;
        if(Switch.equals("OFF")){
            switchBtn.click();
            WebElement switchResult = appiumMobilePage.getFormSwitchText();
            String actualSwitchResultText = switchResult.getText();
            Assert.assertEquals("Switch result is displayed",expectedResult,actualSwitchResultText);
        }else{
            WebElement switchResult = appiumMobilePage.getFormSwitchText();
            String actualSwitchResultText = switchResult.getText();
            Assert.assertEquals("Switch result is displayed",expectedResult,actualSwitchResultText);
        }
    }
    @And("^Select the value \"([^\"]*)\" in form dropdown field")
    public  void forms_select_dropdown_value(String inputtext){
        WebElement dropdownBtn = appiumMobilePage.getFormDropdown();
        dropdownBtn.click();
        List<WebElement> dropdownList = appiumMobilePage.getFormDropdownValue();
        for(WebElement e:dropdownList) {
            String text = e.getText();
            if (text.equals(inputtext)) {
                e.click();
                break;
            }
        }
    }
    @And("^click \"([^\"]*)\" button in the form")
    public  void forms_button_field(String inputBtnName){
        WebElement inputValue = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text=\""+inputBtnName+"\"]"));
        inputValue.click();
        sleep(1000);
    }
    @Then("^verify the alert window is displayed")
    public  void verify_alert_window(){
        WebElement modelWindow = appiumMobilePage.getFormAlertModelWindow();
        Assert.assertTrue(modelWindow.isDisplayed());
    }
    @Then("^verify the alert window header is displayed")
    public  void verify_alert_window_header(){
        WebElement modelWindow = appiumMobilePage.getFormAlertModelWindowHeader();
        Assert.assertTrue(modelWindow.isDisplayed());
    }
    @And("^verify the alert window message is displayed")
    public  void verify_alert_window_message(){
        WebElement modelWindow = appiumMobilePage.getFormAlertModelWindowMessage();
        Assert.assertTrue(modelWindow.isDisplayed());
    }
    @And("^click \"([^\"]*)\" button in the form model window")
    public  void forms_model_window_btn_action(String modelWindowBtnName){
        int value;
        if (modelWindowBtnName.toLowerCase().equals("ask me later")){
            value = 3;
        } else if (modelWindowBtnName.toLowerCase().equals("cancel")) {
            value = 2 ;
        } else{
            value =1;
        }
        WebElement inputValue = appiumDriver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button"+value+"\"]"));
        inputValue.click();
        sleep(1000);
    }
    @And("^Verify the \"([^\"]*)\" is displayed$")
    public  void text_display(String textMsg){
        WebElement inputValue = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text=\""+textMsg+"\"]"));
        String expectedMsg = inputValue.getText();
        Assert.assertEquals("Expected message is displayed",textMsg,expectedMsg);
    }

    @Then("^Enter the email id")
    public  void login_input_email(){
        WebElement emailId = appiumMobilePage.getLoginEmailInput();
        String random = RandomStringUtils.randomAlphanumeric(8)+"@yopmail.com";
        emailId.sendKeys(random);
       EmailId = random;
    }
    @Then("^Enter the password as \"([^\"]*)\"")
    public  void login_input_password(String pass){
        WebElement emailId = appiumMobilePage.getLoginPasswordInput();
        String password = pass+RandomStringUtils.randomAlphanumeric(4);
        emailId.sendKeys(password);
        Password = password;
    }
    @Then("^Enter the \"([^\"]*)\" confirm password")
    public  void login_input_confim_password(String value){
        WebElement emailId = appiumMobilePage.getLoginRepeatPasswordInput();
        String password = RandomStringUtils.randomAlphanumeric(8);
        if(value.toLowerCase().equals("different")){
        emailId.sendKeys(password);
        }
        else {
            emailId.sendKeys(Password);
        }
    }
    @And("^Click on the \"signup\" button")
    public  void click_signup_btn(){
        WebElement signUpBtn = appiumMobilePage.getSignUpBtn();
        signUpBtn.click();
    }
    @And("^Click on the \"SIGNUP\" button")
    public  void click_signup_btn_model_window(){
        WebElement signUpBtn = appiumMobilePage.getSignUpButton();
        signUpBtn.click();
        sleep(3000);
    }
    @And("^verify the login/signup form model is displayed")
    public  void verify_the_model_header(){
        WebElement loginModelHeader = appiumMobilePage.getLoginModelHeader();
        Assert.assertTrue(loginModelHeader.isDisplayed());
    }
    @And("^verify the login/signup form model message is displayed")
    public  void verify_the_model_message(){
        WebElement modelWindowMessageAlert = appiumMobilePage.getFormAlertModelWindowMessage();
        Assert.assertTrue(modelWindowMessageAlert.isDisplayed());
    }
    @And("^click on Login model window \"ok\" button")
    public  void verify_the_model_ok_btn(){
        WebElement okBtn = appiumMobilePage.getLoginModelOkBtn();
        Assert.assertTrue(okBtn.isDisplayed());
        okBtn.click();
        sleep(5000);
    }
    @Then("^click on Login button in model window navigation")
    public  void click_login_btn_model(){
        WebElement loginBtn = appiumMobilePage.getLoginBtn();
        loginBtn.click();
        sleep(1000);
    }
    @And("^Verify the consent message in login page")
    public  void login_consent_page(){
        String message ="When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.";
        WebElement language = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text=\""+message+"\"]"));
        Assert.assertTrue(language.isDisplayed());
    }
    @When("^click on Login button in model window bottom")
    public  void click_login_button_model_window(){
        WebElement loginBtnModelWindow = appiumMobilePage.getLoginBtnModelWindow();
        loginBtnModelWindow.click();
        sleep(3000);
    }

    @When("^click on Webview button from home page")
    public  void click_Web_view_home(){
        WebElement lgnBtn = appiumMobilePage.getWebviewHomeBtn();
        lgnBtn.click();
        sleep(2000);
    }
}


