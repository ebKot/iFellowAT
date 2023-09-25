package Steps;

import Elements.CreateIssueDialogElements;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.switchTo;

public class CreateIssueDialogSteps extends CreateIssueDialogElements {
    public static void createIssueFunc() {
        // Кнопка Создать
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();

        // Поле Тема
        summaryField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue("Ошибка создания бага");

        // Поле Описание
        switchTo().frame(summaryDescriptionFrame);
        summaryDescription.shouldBe(Condition.exist, Duration.ofSeconds(15)).setValue("1. Заполнить поля \n Нажать Создать");
        switchTo().defaultContent();

        // Исправить в версиях
        fixVersion20.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();

        // Поле Приоритет
        priorityField.shouldBe(Condition.exist, Duration.ofSeconds(15)).click();
        priorityField.sendKeys("Highest" + Keys.ENTER);

        // Поле Метки
        labelsField.shouldBe(Condition.visible, Duration.ofSeconds(15)).sendKeys("Xpath");

        // Поле Окружение
        switchTo().frame(environmentFieldFrame);
        environmentField.shouldBe(Condition.exist, Duration.ofSeconds(15)).setValue("Windows 10, Google Chrome 117.0.5938.92");
        switchTo().defaultContent();

        // Затронуты версии
        selectVersion20.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();

        // Назначить меня
        assignButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();

        // Кнопка Создать
        confirmCreateButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    public static void createIssueAsserts() {
        // Проверяем, что после создания задачи появляется надпись "Запрос *** успешно создан" с ссылкой на неё. Выводим надпись
        Assertions.assertTrue(textLinkNewIssue.getText().endsWith(" успешно создан."));
        System.out.println(textLinkNewIssue.getText());
    }
}
