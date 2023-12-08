package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.LoginPage;
import static page.LoginPage.sleep;

import java.util.concurrent.TimeUnit;

public class stepDef {

    public static WebDriver driver;
    private LoginPage loginPage;
    public static String UserName;
    public static String Password;

//    public WebDriver getDriver() {
//        return this.driver;
//    }

    @Before
    public void before(){
        driver = new ChromeDriver();
        //this.driver=driver;
    }
    @After
    public void after(){
        driver.quit();
    }

    @Given("^navigate to the page")
    public  void open(){
        driver.get("https://www.demoblaze.com/index.html");
        if(loginPage == null){
            loginPage=new LoginPage();
        }
        driver.getTitle();
        System.out.println(driver.getTitle());
    }

    @When("^click on signup button")
    public  void signUp(){
        WebElement signUp = loginPage.getSignUpBtn();
        signUp.click();
        sleep(1000);
    }

    @And("^Verify the \"([^\"]*)\" model window is displayed")
    public  void signUp_model_window_header(String btnText) {
        WebElement signUpModelWindowHeader = loginPage.getSignUpModelWindowHeader();
        String actualTxt = signUpModelWindowHeader.getText();
        Assert.assertEquals("Model window is displayed",btnText,actualTxt);
    }
    @And("^Verify the \"user name\" label is displayed")
    public  void signUp_model_username_label() {
        WebElement username = loginPage.getUserNameLabel();
        Assert.assertEquals("Username label is displayed","Username:",username.getText());
    }
    @Then("^provide username as \"([^\"]*)\"")
    public  void signUp_model_username_input(String inputUsrName) {
        WebElement userNameInput = loginPage.getUserNameInput();
        String randomTxt= RandomStringUtils.randomAlphabetic(5);
        UserName = inputUsrName+randomTxt.toLowerCase();
        userNameInput.sendKeys(UserName);
    }
    @And("^Verify the \"password\" label is displayed")
    public  void signUp_model_password_label() {
        WebElement passwordLabel = loginPage.getPasswordLabel();
        Assert.assertEquals("Username label is displayed","Password:",passwordLabel.getText());
    }
    @Then("^provide password as \"([^\"]*)\"")
    public  void signUp_model_password_input(String inputPassword) {
        WebElement passWordInput = loginPage.getPasswordInput();
        String randomPasswordTxt= RandomStringUtils.randomAlphanumeric(5);
        Password = inputPassword+randomPasswordTxt.toLowerCase();
        passWordInput.sendKeys(Password);
    }
}

