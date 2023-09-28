package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateIssueDialogElements {

    // Кнопка Создать
    public static SelenideElement createButton = $x("//a[@id='create_link']");

    // Поле Тема
    public static SelenideElement captionField = $x("//label[text()='Тема ']//following-sibling::input");

    // Поле Описание
    public static SelenideElement descriptionFrame = $x("//div[@id='description-wiki-edit']//iframe");
    public static SelenideElement descriptionField = $x("//body[@data-id='mce_0']//p");

    // Исправить в версиях
    public static SelenideElement fixVersion20 = $x("//div[contains(@class,'versionspicker')]//child::label[@for='fixVersions']//following-sibling::select//descendant::option[contains(text(),'Version 2.0')]");

    // Поле Приоритет
    public static SelenideElement priorityField = $x("//input[@id='priority-field']");

    // Поле Метки
    public static SelenideElement labelsField = $x("//textarea[@id='labels-textarea']");

    // Поле Окружение
    public static SelenideElement environmentFieldFrame = $x("//div[@class='content']//descendant::label[text()='Окружение']//following-sibling::div[@field-id='environment']//descendant::iframe");
    public static SelenideElement environmentField = $x("//body[@data-id='mce_6']//p");

    // Затронуты версии
    public static SelenideElement selectVersion20 = $x("//div[contains(@class,'versionspicker')]//child::label[@for='versions']//following-sibling::select//descendant::option[contains(text(),'Version 2.0')]");

    // Назначить меня
    public static SelenideElement assignButton = $x("//button[text()='Назначить меня']");

    // Кнопка Создать
    public static SelenideElement confirmCreateButton = $x("//input[@value='Создать']");

    // После создания задачи появляется ссылка на новую задачу
    public static SelenideElement linkNewIssue = $x("//a[@class='issue-created-key issue-link']");
    public static SelenideElement textLinkNewIssue = $x("//a[@class='issue-created-key issue-link']//parent::div");
}
