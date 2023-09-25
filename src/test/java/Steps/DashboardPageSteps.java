package Steps;

import Elements.DashboardPageElements;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.TestProjectPageElements.goToProjectMain;

public class DashboardPageSteps extends DashboardPageElements {
    public static void goToProjectFunc() {
        listOfProjects.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        goToTestProject.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    public static void goToProjectAsserts() {
        // Когда мы находимся в проекте, в левом верхнем углу появляется ссылка с названием проекта
        Assertions.assertEquals("Test", goToProjectMain.shouldBe(Condition.exist, Duration.ofSeconds(15)).getText());
    }
}
