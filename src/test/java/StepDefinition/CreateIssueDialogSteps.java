package StepDefinition;

import Elements.CreateIssueDialogElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.switchTo;

public class CreateIssueDialogSteps extends CreateIssueDialogElements {
    @Step("Нажимаем на кнопку Создать")
    @Когда("Происходит нажатие на кнопку Создать")
    public static void createButtonFunc() {
        // Кнопка Создать
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Заполняем поле Тема")
    @И("В поле Тема вводится {string}")
    public static void captionFieldFunc(String caption) {
        // Поле Тема
        captionField.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(caption);
    }

    @Step("Заполняем поле описание")
    @И("В поле Описание вводится {string}")
    public static void descriptionFieldFunc(String description) {
        // Поле Описание
        switchTo().frame(descriptionFrame);
        descriptionField.shouldBe(Condition.exist, Duration.ofSeconds(15)).setValue(description);
        switchTo().defaultContent();
    }

    @Step("Выбираем версию в \"Исправить в версиях\"")
    @И("Нажимается вариант «Version 2.0» в поле «Исправить в версиях»")
    public static void fixVersion20Func() {
        // Исправить в версиях
        fixVersion20.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Заполняем поле Приоритет")
    @И("Нажимается на поле Приоритет и вводится туда значение {string} и нажимается Enter")
    public static void priorityFieldFunc(String priority) {
        // Поле Приоритет
        priorityField.shouldBe(Condition.exist, Duration.ofSeconds(15)).click();
        priorityField.sendKeys(priority + Keys.ENTER);
    }

    @Step("Заполняем поле Метки")
    @И("В поле Метки вводится {string}")
    public static void labelsFieldFunc(String label) {
        // Поле Метки
        labelsField.shouldBe(Condition.visible, Duration.ofSeconds(15)).sendKeys(label);
    }

    @Step("Заполняем поле Окружение")
    @И("В поле Окружение вводится значение {string}")
    public static void environmentFieldFunc(String environment) {
        // Поле Окружение
        switchTo().frame(environmentFieldFrame);
        environmentField.shouldBe(Condition.exist, Duration.ofSeconds(15)).setValue(environment);
        switchTo().defaultContent();
    }

    @Step("Выбираем затронутую версию")
    @И("Нажимается вариант «Version 2.0» в поле «Затронуты версии»")
    public static void selectVersion20Func() {
        // Затронуты версии
        selectVersion20.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Назначаем исполнителя")
    @И("Нажимается кнопка «Назначить меня»")
    public static void assignButtonFunc() {
        // Назначить меня
        assignButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Нажимаем кнопку Создать")
    @И("Нажимается кнопка Создать")
    public static void confirmCreateButtonFunc() {
        // Кнопка Создать
        confirmCreateButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Проверка создания задачи")
    @Тогда("После создания задачи появляется надпись «Запрос *** успешно создан» с ссылкой на неё")
    public static void createIssueAsserts() {
        // Проверяем, что после создания задачи появляется надпись "Запрос *** успешно создан" с ссылкой на неё. Выводим надпись
        Assertions.assertTrue(textLinkNewIssue.getText().endsWith(" успешно создан."));
    }
}
