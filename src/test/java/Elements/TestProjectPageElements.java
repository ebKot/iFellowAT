package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPageElements {

    // Перейти в проект Test
    public static SelenideElement goToProjectMain = $x("//a[@title='Test' and text()='Test']");

    // Перейти в раздел Задачи
    public static SelenideElement goToIssues = $x("//span[text()='Задачи']//parent::a");

    // Счётчик количества задач
    public static SelenideElement countIssues = $x("//span[contains(text(),'1 из')]");

}
