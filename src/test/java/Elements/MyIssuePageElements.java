package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyIssuePageElements {

    // Перевести задачу в статус "Взят в работу"
    public static SelenideElement workflowTransitionTaken = $x("//span[text()='В работе']//parent::a");

    // Кнопка "Бизнес-процесс"
    public static SelenideElement moreTransitions = $x("//span[text()='Бизнес-процесс']//parent::a");

    // Перевести задачу в статус "Исполнено"
    public static SelenideElement workflowTransitionFulfilled = $x("//span[text()='Исполнено']//parent::a");
    public static SelenideElement workflowTransitionFulfilledButton = $x("//input[@value='Исполнено']");

    // Перевести задачу в статус "Подтверждено"
    public static SelenideElement workflowTransitionConfirmed = $x("//span[text()='Подтверждено']//parent::a");
    public static SelenideElement workflowTransitionConfirmedButton = $x ("//input[@value='Подтверждено']");

}