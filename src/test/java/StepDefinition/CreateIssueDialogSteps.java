package StepDefinition;

import Elements.CreateIssueDialogElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.switchTo;

public class CreateIssueDialogSteps extends CreateIssueDialogElements {
    @Когда("Происходит нажатие на кнопку Создать")
    public static void createButtonFunc() {
        // Кнопка Создать
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @И("В поле Тема вводится {string}")
    public static void captionFieldFunc(String caption) {
        // Поле Тема
        captionField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(caption);
    }

    @И("В поле Описание вводится {string}")
    public static void descriptionFieldFunc(String description) {
        // Поле Описание
        switchTo().frame(descriptionFrame);
        descriptionField.shouldBe(Condition.exist, Duration.ofSeconds(15)).setValue(description);
        switchTo().defaultContent();
    }

    @И("Нажимается вариант «Version 2.0» в поле «Исправить в версиях»")
    public static void fixVersion20Func() {
        // Исправить в версиях
        fixVersion20.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @И("Нажимается на поле Приоритет и вводится туда значение {string} и нажимается Enter")
    public static void priorityFieldFunc(String priority) {
        // Поле Приоритет
        priorityField.shouldBe(Condition.exist, Duration.ofSeconds(15)).click();
        priorityField.sendKeys(priority + Keys.ENTER);
    }

    @И("В поле метки вводится {string}")
    public static void labelsFieldFunc(String label) {
        // Поле Метки
        labelsField.shouldBe(Condition.visible, Duration.ofSeconds(15)).sendKeys(label);
    }

    @И("В поле Окружение вводится значение {string}")
    public static void environmentFieldFunc(String environment) {
        // Поле Окружение
        switchTo().frame(environmentFieldFrame);
        environmentField.shouldBe(Condition.exist, Duration.ofSeconds(15)).setValue(environment);
        switchTo().defaultContent();
    }

    @И("Нажимается вариант «Version 2.0» в поле «Затронуты версии»")
    public static void selectVersion20Func() {
        // Затронуты версии
        selectVersion20.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @И("Нажимается кнопка «Назначить меня»")
    public static void assignButtonFunc() {
        // Назначить меня
        assignButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @И("Нажимается кнопка Создать")
    public static void confirmCreateButtonFunc() {
        // Кнопка Создать
        confirmCreateButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Тогда("После создания задачи появляется надпись «Запрос *** успешно создан» с ссылкой на неё")
    public static void createIssueAsserts() {
        // Проверяем, что после создания задачи появляется надпись "Запрос *** успешно создан" с ссылкой на неё. Выводим надпись
        Assertions.assertTrue(textLinkNewIssue.getText().endsWith(" успешно создан."));
        System.out.println(textLinkNewIssue.getText());
    }
}
