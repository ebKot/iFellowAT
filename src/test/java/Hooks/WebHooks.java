package Hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @Before(value = "@Login")
    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "chrome");
        Selenide.open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
    }

    @After(value = "@NewIssue")
    @AfterEach
    public void driverClose() {
        closeWebDriver();
    }

}
