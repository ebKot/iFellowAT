package StepDefinition;

import Elements.DashboardPageElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.TestProjectPageElements.goToProjectMain;

public class DashboardPageSteps extends DashboardPageElements {
    @Когда("Нажимается кнопка Проекты и в выпадающем меню нажимается строка Test \\(TEST)")
    public static void goToProjectFunc() {
        listOfProjects.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        goToTestProject.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Тогда("В левом верхнем углу появляется ссылка с названием проекта")
    public static void goToProjectAsserts() {
        // Когда мы находимся в проекте, в левом верхнем углу появляется ссылка с названием проекта
        Assertions.assertEquals("Test", goToProjectMain.shouldBe(Condition.exist, Duration.ofSeconds(15)).getText());
    }
}
