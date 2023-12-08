package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static stepDef.stepDef.driver;

public class LoginPage{
    private final static By SIGNUP_BTN = By.id("signin2");
    private final static By SIGNUP_MODEL_WINDOW_HEADER = By.cssSelector("#signInModalLabel");
    private final static By USERNAME_LABEL = By.cssSelector("[for='sign-username']");
    private final static By USERNAME_INPUT_FIELD = By.id("sign-username");
    private final static By PASSWORD_LABEL = By.cssSelector("[for='sign-password']");
    private final static By PASSWORD_INPUT_FIELD = By.id("sign-password");
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
