package StepDefinition;

import Elements.TestSeleniumPageElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.DashboardPageElements.goToTestSeleniumIssue;
import static Elements.DashboardPageElements.searchString;

public class TestSeleniumPageSteps extends TestSeleniumPageElements {
    @Step("Ищем в строке поиска и переходим в задачу {selenium}")
    @Когда("В строку поиска вводится {string} и осуществляется переход на первый выводимый вариант нажатием в выпадающем меню")
    public static void testSeleniumFunc(String selenium) {
        searchString.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(selenium);
        goToTestSeleniumIssue.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Проверка статуса задачи и затронутой версии")
    @Тогда("Статус задачи отображается и затронутая версия - 2.0")
    public static void testSeleniumAsserts() {
        // Проверяем статус задачи и выводим его
        Assertions.assertTrue(statusValue.shouldBe(Condition.visible, Duration.ofSeconds(15)).exists());

        // Проверяем, что затронутая версия – 2.0 и выводим её
        Assertions.assertEquals("Version 2.0", fixVersions.shouldBe(Condition.visible, Duration.ofSeconds(15)).getText());
    }
}
