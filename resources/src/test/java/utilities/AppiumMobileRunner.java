package utilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/resources/features"}, glue = {"classpath:stepDef"}, monochrome = true, tags ="@appiumtest"
        , plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class AppiumMobileRunner {
}
