package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPageElements {

    // Раскрывающийся список Проекты
    public static SelenideElement listOfProjects = $x("//a[@id='browse_link'and text()='Проекты']");

    // Перейти в проект Test
    public static SelenideElement goToTestProject = $x("//a[text()='Test (TEST)']");

    // Строка поиска
    public static SelenideElement searchString = $x("//input[@id='quickSearchInput']");

    // Перейти в задачу TestSelenium
    public static SelenideElement goToTestSeleniumIssue = $x("(//span[text()='TestSelenium'])[1]//parent::a");

}
