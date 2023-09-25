package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumPageElements {

    // Статус задачи
    public static SelenideElement statusValue = $x("//span[@id='status-val']//child::span");

    // Затронута версия
    public static SelenideElement fixVersions = $x("//strong[@title='Затронуты версии']//following-sibling::span//descendant::span[@title='Version 2.0 ']");

}
