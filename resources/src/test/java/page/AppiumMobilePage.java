package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepDef.stepDefAppium.appiumDriver;

public class AppiumMobilePage {
    private final static By FORM_BTN = By.xpath("//android.widget.TextView[@text=\"Forms\"]");

    public Wait waitForVisible() {
        Wait<WebDriver> waitForVisibleInside = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        return waitForVisibleInside;
    }

    public WebElement getFormButton() {
        return (WebElement) waitForVisible().until(ExpectedConditions.presenceOfElementLocated(FORM_BTN));
    }
}
