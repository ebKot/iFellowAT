package StepDefinition;

import Elements.TestProjectPageElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class TestProjectPageSteps extends TestProjectPageElements {
    @Когда("Осуществляется переход в раздел Задачи")
    public static void issuesQuantityFunc() {
        goToIssues.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Тогда("Отображается счётчик количества задач вида «1 из *число*»")
    public static void issuesQuantityAsserts() {
        // Проверяем, что количество заведённых задач отображено и выводим его
        Assertions.assertTrue(countIssues.shouldBe(Condition.visible, Duration.ofSeconds(15)).getText().startsWith("1 из "));
        System.out.println("Общее количество заведенных задач в проекте" + countIssues.getText().replace("1 из ", ": "));
        System.out.println();
    }
}

