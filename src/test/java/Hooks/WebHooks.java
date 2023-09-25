package Hooks;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "chrome");
        Selenide.open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void driverClose() {
        closeWebDriver();
    }

}
