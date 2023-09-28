import Hooks.WebHooks;
import org.junit.jupiter.api.Test;

import static StepDefinition.CreateIssueDialogSteps.*;
import static StepDefinition.DashboardPageSteps.goToProjectAsserts;
import static StepDefinition.DashboardPageSteps.goToProjectFunc;
import static StepDefinition.LoginPageSteps.loginAsserts;
import static StepDefinition.LoginPageSteps.loginFunc;
import static StepDefinition.MyIssuePageSteps.*;
import static StepDefinition.TestProjectPageSteps.issuesQuantityAsserts;
import static StepDefinition.TestProjectPageSteps.issuesQuantityFunc;
import static StepDefinition.TestSeleniumPageSteps.testSeleniumAsserts;
import static StepDefinition.TestSeleniumPageSteps.testSeleniumFunc;

public class CssXpathTest extends WebHooks {

    // 1.	Авторизоваться в edujira.ifellow.ru
    @Test
    public void loginTest() {
        loginFunc("AT1", "Qwerty123");
        loginAsserts();
    }

    //2.	Перейти в проект TestProject
    @Test
    public void goToProjectTest() {
        loginFunc("AT1", "Qwerty123");
        goToProjectFunc();
        goToProjectAsserts();
    }

    // 3.	Проверить общее количество заведенных задач в проекте ( например в  строке ‘1 из 30’ )
    @Test
    public void issuesQuantityTest() {
        loginFunc("AT1", "Qwerty123");
        goToProjectFunc();
        issuesQuantityFunc();
        issuesQuantityAsserts();
    }

    //4.	Перейти в задачу TestSelenium и проверить статус задачи и привязку в затронутой версии - Version 2.0
    @Test
    public void testSeleniumTest() {
        loginFunc("AT1", "Qwerty123");
        testSeleniumFunc("TestSelenium");
        testSeleniumAsserts();
    }

    //5.	Создать автотестом новый баг с описанием. Перевести задачу по статусам до закрытого.
    @Test
    public void createIssueTest() throws InterruptedException {
        loginFunc("AT1", "Qwerty123");
        createButtonFunc();
        captionFieldFunc("Ошибка создания бага");
        descriptionFieldFunc("1. Заполнить поля \n Нажать Создать");
        fixVersion20Func();
        priorityFieldFunc("Highest");
        labelsFieldFunc("Xpath");
        environmentFieldFunc("Windows 10, Google Chrome 117.0.5938.92");
        selectVersion20Func();
        assignButtonFunc();
        confirmCreateButtonFunc();
        createIssueAsserts();
        linkNewIssueFunc();
        workflowTransitionTakenFunc();
        workflowTransitionFulfilledFunc();
        workflowTransitionConfirmedFunc();
        runThroughStatusesAsserts();
    }

}
