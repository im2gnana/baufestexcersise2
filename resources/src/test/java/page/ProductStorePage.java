package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static stepDef.stepDefUI.driver;

public class ProductStorePage {
    private final static By SIGNUP_BTN = By.id("signin2");
    private final static By SIGNUP_MODEL_WINDOW_HEADER = By.cssSelector("#signInModalLabel");
    private final static By USERNAME_LABEL = By.cssSelector("[for='sign-username']");
    private final static By USERNAME_INPUT_FIELD = By.id("sign-username");
    private final static By PASSWORD_LABEL = By.cssSelector("[for='sign-password']");
    private final static By PASSWORD_INPUT_FIELD = By.id("sign-password");
    private final static By LOGIN_BTN_NAVIGATION = By.id("login2");
    private final static By CART_BTN_NAVIGATION = By.id("cartur");
    private final static By LOGIN_USERNAME_INPUT_FIELD = By.id("loginusername");
    private final static By LOGIN_PASSWORDINPUT_FIELD = By.id("loginpassword");
    private final static By LOGIN_BTN_MODEL_WINDOW = By.cssSelector("#logInModal div.modal-footer button.btn.btn-primary");
    private final static By CLOSE_BTN_LOGIN_MODEL_WINDOW = By.cssSelector("#logInModal div.modal-footer button.btn.btn-secondary");
    private final static By LOGGED_IN_USER = By.id("nameofuser");
    private final static By CATEGORY_LIST = By.cssSelector("a#itemc");
    private final static By CART_TITLE = By.cssSelector("h4.card-title");
    private final static By CART_TABLE_HEADER = By.xpath("//table//tr//th");
    private final static By CART_TABLE_BODY = By.xpath("//table//tr//td");
    private final static By ADDTOCART = By.xpath("//a[ text() = 'Add to cart' ]");
    private final static By LOGOUT = By.id("logout2");
    private final static By DELETE_CART = By.xpath("//a[ text() = 'Delete' ]");
    private final static By SIGNUP_BTN_MODEL_WINDOW = By.cssSelector("#signInModal div.modal-footer button.btn.btn-primary");
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
    public WebElement getLoginUsernameInput(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_USERNAME_INPUT_FIELD));
    }
    public WebElement getLoginPasswordInput(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_PASSWORDINPUT_FIELD));
    }
    public WebElement getLoginBtnModelWindow(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_BTN_MODEL_WINDOW));
    }
    public WebElement getCloseBtnLoginModelWindow(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(CLOSE_BTN_LOGIN_MODEL_WINDOW));
    }
    public WebElement getLoginBtnMenu(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGIN_BTN_NAVIGATION));
    }
    public WebElement getCartBtnMenu(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(CART_BTN_NAVIGATION));
    }
    public WebElement getLoggedUserName(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGGED_IN_USER));
    }
    public List<WebElement> getCategoryList(){
        List<WebElement> categoryList = driver.findElements(CATEGORY_LIST);
        return  categoryList;
    }
    public List<WebElement> getCartTitle(){
        List<WebElement> cartTitle = driver.findElements(CART_TITLE);
        return  cartTitle;
    }
    public WebElement getAddCartBtn(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(ADDTOCART));
    }
    public List<WebElement> getTableHeader(){
        List<WebElement> cartHeader = driver.findElements(CART_TABLE_HEADER);
        return  cartHeader;
    }
    public List<WebElement> getTableBody(){
        List<WebElement> cartBody = driver.findElements(CART_TABLE_BODY);
        return  cartBody;
    }
    public WebElement getLogoutBtn(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(LOGOUT));
    }
    public List<WebElement> getDeleteCartBtns(){
        List<WebElement> deletecart = driver.findElements(DELETE_CART);
        return  deletecart;
    }
    public WebElement getSignUpModelWindowButton(){
        return  (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(SIGNUP_BTN_MODEL_WINDOW));
    }
}
