package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepDef.stepDefUI.driver;

public class ProductStorePage {
    private final static By SIGNUP_BTN = By.id("signin2");
    private final static By SIGNUP_MODEL_WINDOW_HEADER = By.cssSelector("#signInModalLabel");
    private final static By USERNAME_LABEL = By.cssSelector("[for='sign-username']");
    private final static By USERNAME_INPUT_FIELD = By.id("sign-username");
    private final static By PASSWORD_LABEL = By.cssSelector("[for='sign-password']");
    private final static By PASSWORD_INPUT_FIELD = By.id("sign-password");
    private final static By LOGIN_USERNAME_INPUT_FIELD = By.id("loginusername");
    private final static By LOGIN_PASSWORDINPUT_FIELD = By.id("loginpassword");
    public Wait waitForVisible(){
        Wait<WebDriver> waitForVisibleInside = new WebDriverWait(driver, Duration.ofSeconds(10));
        return waitForVisibleInside;
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){}
    }
    public WebElement getSignUpBtn(){
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(SIGNUP_BTN));
    }
    public WebElement getSignUpModelWindowHeader(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(SIGNUP_MODEL_WINDOW_HEADER));
    }
    public WebElement getUserNameLabel(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(USERNAME_LABEL));
    }
    public WebElement getUserNameInput(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(USERNAME_INPUT_FIELD));
    }
    public WebElement getPasswordLabel(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(PASSWORD_LABEL));
    }
    public WebElement getPasswordInput(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(PASSWORD_INPUT_FIELD));
    }
}
