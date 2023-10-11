package StepDefinition;

import Elements.DashboardPageElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.TestProjectPageElements.goToProjectMain;

public class DashboardPageSteps extends DashboardPageElements {
    @Step("Переходим в проект Test")
    @Когда("Нажимается кнопка Проекты и в выпадающем меню нажимается строка Test \\(TEST)")
    public static void goToProjectFunc() {
        listOfProjects.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        goToTestProject.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Проверка того, что мы вошли в проект Test")
    @Тогда("В левом верхнем углу появляется ссылка с названием проекта")
    public static void goToProjectAsserts() {
        // Когда мы находимся в проекте, в левом верхнем углу появляется ссылка с названием проекта
        Assertions.assertEquals("Test", goToProjectMain.shouldBe(Condition.exist, Duration.ofSeconds(15)).getText());
    }
}
