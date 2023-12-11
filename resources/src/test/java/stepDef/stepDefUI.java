package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ProductStorePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static page.ProductStorePage.sleep;

public class stepDefUI {

    public static WebDriver driver;
    private ProductStorePage productStorePage;
    public static String UserName;
    public static String Password;
    public static String LOGGEDINUSER;
    public static String URL;
    Properties props=new Properties();


    public void getProperties() throws IOException {
        FileReader reader=new FileReader("src/config.properties");
        props.load(reader);
        URL = props.getProperty("url");
    }
    //    public WebDriver getDriver() {
//        return this.driver;
//    }

    @Before
    public void before(){
        driver = new ChromeDriver();
        sleep(500);
        //this.driver=driver;
    }
    @After
    public void after(){
        driver.quit();
    }

    @Given("^navigate to the page")
    public  void open() throws IOException {
        getProperties();
        driver.get(URL);
        if(productStorePage == null){
            productStorePage=new ProductStorePage();
        }
        driver.getTitle();
        System.out.println(driver.getTitle());
    }

    @When("^click on signup button$")
    public  void signUp(){
        WebElement signUp = productStorePage.getSignUpBtn();
        signUp.click();
        sleep(3000);
    }
    @Then("^click on signup button in model window$")
    public  void signup_model_window(){
        WebElement signUpBtnModel = productStorePage.getSignUpModelWindowButton();
        signUpBtnModel.click();
        sleep(3000);
    }
    @Then("^verify the alert message \"([^\"]*)\" is displayed$")
    public  void alert_message(String expectedMsg){
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        Assert.assertEquals("Message is displayed",expectedMsg,actual);
        alert.dismiss();
        sleep(3000);
    }
    @And("^Verify the \"([^\"]*)\" model window is displayed")
    public  void signUp_model_window_header(String btnText) {
        WebElement signUpModelWindowHeader = productStorePage.getSignUpModelWindowHeader();
        String actualTxt = signUpModelWindowHeader.getText();
        Assert.assertEquals("Model window is displayed",btnText,actualTxt);
    }
    @And("^Verify the \"user name\" label is displayed")
    public  void signUp_model_username_label() {
        WebElement username = productStorePage.getUserNameLabel();
        Assert.assertEquals("Username label is displayed","Username:",username.getText());
    }
    @Then("^provide username as \"([^\"]*)\"")
    public  void signUp_model_username_input(String inputUsrName) {
        WebElement userNameInput = productStorePage.getUserNameInput();
        if(inputUsrName.equals("test")){
            userNameInput.sendKeys(inputUsrName);
        }else{
        String randomTxt= RandomStringUtils.randomAlphabetic(5);
        UserName = inputUsrName+randomTxt.toLowerCase();
        userNameInput.sendKeys(UserName);}
    }
    @And("^Verify the \"password\" label is displayed")
    public  void signUp_model_password_label() {
        WebElement passwordLabel = productStorePage.getPasswordLabel();
        Assert.assertEquals("Username label is displayed","Password:",passwordLabel.getText());
    }
    @Then("^provide password as \"([^\"]*)\"")
    public  void signUp_model_password_input(String inputPassword) {
        WebElement passWordInput = productStorePage.getPasswordInput();
        if(inputPassword.equals("test")){
            passWordInput.sendKeys(inputPassword);
        }else{
        String randomPasswordTxt= RandomStringUtils.randomAlphanumeric(5);
        Password = inputPassword+randomPasswordTxt.toLowerCase();
        passWordInput.sendKeys(Password);}
    }
    @Then("^click on the login button from menu item")
    public  void click_login_btn_menu_item() {
        WebElement loginBtnMenu = productStorePage.getLoginBtnMenu();
        loginBtnMenu.click();
        sleep(2000);
    }
    @Then("^Enter user name as \"([^\"]*)\" in login window")
    public  void enter_username_login_window(String input) {
        LOGGEDINUSER = input;
        WebElement username = productStorePage.getLoginUsernameInput();
        username.sendKeys(input);
    }
    @Then("^Enter the password as \"([^\"]*)\" in login window")
    public  void enter_password_login_window(String input) {
        WebElement password = productStorePage.getLoginPasswordInput();
        password.sendKeys(input);
    }
    @Then("^click Login button")
    public  void click_login_button_model() {
        WebElement loginBtnModelWindow = productStorePage.getLoginBtnModelWindow();
        loginBtnModelWindow.click();
        sleep(3000);
    }
    @And("^Verify the user is logged in")
    public  void verify_logged_in_user() {
        WebElement loggedin = productStorePage.getLoggedUserName();
        String actualTxt = loggedin.getText();
        Assert.assertEquals("Logged user details should be displayed",LOGGEDINUSER,actualTxt);
    }
    @And("^Then select \"([^\"]*)\" from the category item")
    public  void select_category_list(String list) {
        List<WebElement> s = productStorePage.getCategoryList();
        for(WebElement e: s){
            if(e.getText().equals(list)){
                e.click();
                break;
            }
        }
        sleep(3000);
    }
    @And("^Then add \"([^\"]*)\" to the cart from the category item")
    public  void select_category_value(String listvalue) {
        List<WebElement> value = productStorePage.getCartTitle();
        for(WebElement x: value){
            if(x.getText().equals(listvalue)){
                x.click();
                break;
            }
        }
        sleep(3000);
    }
    @And("^click on \"Add to cart\" button")
    public  void click_add_to_cart_btn() {
        sleep(2000);
        WebElement addCart = productStorePage.getAddCartBtn();
        addCart.click();
    }
    @And("^click ok from alert window")
    public  void click_alert_ok() {
        sleep(2000);
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
    @And("^click on \"Cart\" button")
    public  void click_on_cart_btn() {
        WebElement cartBtnMenu = productStorePage.getCartBtnMenu();
        cartBtnMenu.click();
        sleep(20);
    }
    @And("^Verify the \"([^\"]*)\" is displayed in cart for \"([^\"]*)\"")
    public  void verify_the_cart(String cartHeader, String body) {
        List<WebElement> cartHeaderValue = productStorePage.getTableHeader();
        for(int i=0;i<cartHeaderValue.size();i++){
            String headerName = cartHeaderValue.get(i).getText();
            if (headerName.equals(cartHeader)){
                List<WebElement> cartBodyValue = driver.findElements(By.xpath("//table//tr["+i+"]//td[2]"));
              for (int j=0;j<cartBodyValue.size();j++){
                  String headerBody = cartBodyValue.get(j).getText();
                  if(headerBody.equals(body)) {
                      Assert.assertEquals("Product is added",body,headerBody);
                      break;
                  }
              }
            }

        }
        sleep(3000);
    }
    @And("^click on \"Logout\" button")
    public  void click_on_logout_btn() {
        WebElement logout = productStorePage.getLogoutBtn();
        logout.click();
        sleep(20);
    }
    @And("^Delete any item from the cart if exist")
    public  void delete_existing_cart() {

        List<WebElement> cartItems = productStorePage.getDeleteCartBtns();
        for(int i=0;i<cartItems.size();i++){
            String txt = cartItems.get(i).getText();
            if(txt.equals("Delete")) {
                cartItems.get(i).click();
            }
            else{
                System.out.println("No items in cart");
            }
        }

    }
}


