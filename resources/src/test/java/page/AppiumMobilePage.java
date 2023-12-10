package page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static stepDef.stepDefAppium.appiumDriver;

public class AppiumMobilePage {

    private final static By FORM_BTN = By.xpath("//android.widget.TextView[@text=\"Forms\"]");
    private final static By LOGIN_BTN_HOME = By.xpath("//android.widget.TextView[@text=\"Login\"]");
    private final static By LOGIN_PGE_SIGNUP_BTN_HOME = By.xpath("//android.widget.TextView[@text=\"Sign up\"]");
    private final static By SIGNUP_BTN = By.xpath("//android.widget.TextView[@text=\"SIGN UP\"]");
    private final static By LOGIN_BTN_MODEL_WINDOW = By.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private final static By FORM_DROPDOWN = By.xpath("//android.widget.EditText[@text=\"Select an item...\"]");
    private final static By FORM_ALERT_WINDOW = By.xpath("/hierarchy/android.widget.FrameLayout");
    private final static By FORM_ALERT_WINDOW_HEADER = By.id("android:id/alertTitle");
    private final static By FORM_ALERT_WINDOW_MESSAGE = By.id("android:id/message");
    private final static By LOGIN_ALERT_HEADER = By.id("android:id/alertTitle");
    private final static By LOGIN_ALERT_OK_BTN = By.id("android:id/button1");
    private final static By WEBVIEW_HOME_BTN = By.xpath("//android.widget.TextView[@text=\"Webview\"]");

    public Wait waitForVisible() {
        Wait<WebDriver> waitForVisibleInside = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        return waitForVisibleInside;
    }

    public WebElement getFormButton() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_BTN));
    }
    public WebElement getFormInputField() {
        WebElement input = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("text-input"));
        return input;
    }
    public WebElement getFormInputResultField() {
        WebElement inputResult = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("input-text-result"));
        return inputResult;
    }
    public WebElement getFormSwitch() {
        WebElement switchField = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("switch"));
        return switchField;
    }
    public WebElement getFormSwitchText() {
        WebElement switchResult = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("switch-text"));
        return switchResult;
    }
    public WebElement getFormDropdown() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_DROPDOWN));
    }
    public List<WebElement> getFormDropdownValue() {
        List<WebElement> btnClick = appiumDriver.findElements(new By.ByClassName("android.widget.CheckedTextView"));
        return btnClick;
       // return (List<WebElement>) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_DROPDOWN_VALUE));
    }
    public WebElement getFormAlertModelWindow() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_ALERT_WINDOW));
    }
    public WebElement getFormAlertModelWindowHeader() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_ALERT_WINDOW_HEADER));
    }
    public WebElement getFormAlertModelWindowMessage() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_ALERT_WINDOW_MESSAGE));
    }
    public WebElement getLoginBtn() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_BTN_HOME));
    }
    public WebElement getSignUpBtn() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_PGE_SIGNUP_BTN_HOME));
    }
    public WebElement getLoginEmailInput() {
        WebElement switchField = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("input-email"));
        return switchField;
    }
    public WebElement getLoginPasswordInput() {
        WebElement switchField = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("input-password"));
        return switchField;
    }
    public WebElement getLoginRepeatPasswordInput() {
        WebElement switchField = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("input-repeat-password"));
        return switchField;
    }
    public WebElement getLoginModelHeader() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_ALERT_HEADER));
    }
    public WebElement getLoginModelOkBtn() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_ALERT_OK_BTN));
    }
    public WebElement getSignUpButton() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(SIGNUP_BTN));
    }
    public WebElement getLoginBtnModelWindow() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_BTN_MODEL_WINDOW));
    }
    public WebElement getWebviewHomeBtn() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(WEBVIEW_HOME_BTN));
    }
}
