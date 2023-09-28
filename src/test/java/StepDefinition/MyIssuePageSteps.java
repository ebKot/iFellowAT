package StepDefinition;

import Elements.MyIssuePageElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.CreateIssueDialogElements.linkNewIssue;
import static Elements.TestSeleniumPageElements.statusValue;

public class MyIssuePageSteps extends MyIssuePageElements {
    @И("Открывается задача по нажатию на ссылку")
    public static void linkNewIssueFunc() {
        // Открыть задачу
        linkNewIssue.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @И("Задача переводится в статус «Взят в работу»")
    public static void workflowTransitionTakenFunc() throws InterruptedException {
        // Перевести задачу в статус "Взят в работу"
        workflowTransitionTaken.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        Thread.sleep(1000);
    }

    @И("Задача переводится в статус «Исполнено»")
    public static void workflowTransitionFulfilledFunc() throws InterruptedException {
        // Перевести задачу в статус "Исполнено"
        moreTransitions.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionFulfilled.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionFulfilledButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        Thread.sleep(1000);
    }

    @И("Задача переводится в статус «Подтверждено»")
    public static void workflowTransitionConfirmedFunc() throws InterruptedException {
        // Перевести задачу в статус "Подтверждено"
        moreTransitions.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionConfirmed.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        workflowTransitionConfirmedButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        Thread.sleep(1000);
    }

    @Тогда("Статус задачи отображается как «ГОТОВО»")
    public static void runThroughStatusesAsserts() {
        // Проверяем, что статус перешёл в "Готово", выводим его
        Assertions.assertEquals("ГОТОВО", statusValue.getText());
        System.out.println("Задача переведена в статус " + statusValue.getText());
    }
}
