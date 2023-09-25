package Steps;

import Elements.TestSeleniumPageElements;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.DashboardPageElements.goToTestSeleniumIssue;
import static Elements.DashboardPageElements.searchString;

public class TestSeleniumPageSteps extends TestSeleniumPageElements {
    public static void testSeleniumFunc() {
        searchString.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue("TestSelenium");
        goToTestSeleniumIssue.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    public static void testSeleniumAsserts() {
        // Проверяем статус задачи и выводим его
        Assertions.assertTrue(statusValue.shouldBe(Condition.visible, Duration.ofSeconds(15)).exists());
        System.out.println("Статус задачи: " + statusValue.getText());

        // Проверяем, что затронутая версия – 2.0 и выводим её
        Assertions.assertEquals("Version 2.0", fixVersions.shouldBe(Condition.visible, Duration.ofSeconds(15)).getText());
        System.out.println("Затронуты версии: " + fixVersions.getText());
    }
}
