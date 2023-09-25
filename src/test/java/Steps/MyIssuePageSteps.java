package Steps;

import Elements.MyIssuePageElements;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.CreateIssueDialogElements.linkNewIssue;
import static Elements.TestSeleniumPageElements.statusValue;

public class MyIssuePageSteps extends MyIssuePageElements {
    public static void runThroughStatusesFunc() throws InterruptedException {
        // Открыть задачу
        linkNewIssue.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();

        // Перевести задачу в статус "Взят в работу"
        workflowTransitionTaken.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        Thread.sleep(1000);

        // Перевести задачу в статус "Исполнено"
        moreTransitions.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionFulfilled.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionFulfilledButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        Thread.sleep(1000);

        // Перевести задачу в статус "Подтверждено"
        moreTransitions.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionConfirmed.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionConfirmedButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        Thread.sleep(1000);
    }

    public static void runThroughStatusesAsserts() {
        // Проверяем, что статус перешёл в "Готово", выводим его
        Assertions.assertEquals("ГОТОВО", statusValue.getText());
        System.out.println("Задача переведена в статус " + statusValue.getText());
    }
}
