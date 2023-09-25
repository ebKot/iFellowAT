import Hooks.WebHooks;
import org.junit.jupiter.api.Test;

import static Steps.CreateIssueDialogSteps.createIssueAsserts;
import static Steps.CreateIssueDialogSteps.createIssueFunc;
import static Steps.DashboardPageSteps.goToProjectAsserts;
import static Steps.DashboardPageSteps.goToProjectFunc;
import static Steps.LoginPageSteps.loginAsserts;
import static Steps.LoginPageSteps.loginFunc;
import static Steps.MyIssuePageSteps.runThroughStatusesAsserts;
import static Steps.MyIssuePageSteps.runThroughStatusesFunc;
import static Steps.TestProjectPageSteps.issuesQuantityAsserts;
import static Steps.TestProjectPageSteps.issuesQuantityFunc;
import static Steps.TestSeleniumPageSteps.testSeleniumAsserts;
import static Steps.TestSeleniumPageSteps.testSeleniumFunc;

public class CssXpathTest extends WebHooks {

    // 1.	Авторизоваться в edujira.ifellow.ru
    @Test
    public void loginTest() {
        loginFunc();
        loginAsserts();
    }

    //2.	Перейти в проект TestProject
    @Test
    public void goToProjectTest() {
        loginFunc();
        goToProjectFunc();
        goToProjectAsserts();
    }

    // 3.	Проверить общее количество заведенных задач в проекте ( например в  строке ‘1 из 30’ )
    @Test
    public void issuesQuantityTest() {
        loginFunc();
        goToProjectFunc();
        issuesQuantityFunc();
        issuesQuantityAsserts();
    }

    //4.	Перейти в задачу TestSelenium и проверить статус задачи и привязку в затронутой версии - Version 2.0
    @Test
    public void testSeleniumTest() {
        loginFunc();
        testSeleniumFunc();
        testSeleniumAsserts();
    }

    //5.	Создать автотестом новый баг с описанием. Перевести задачу по статусам до закрытого.
    @Test
    public void createIssueTest() throws InterruptedException {
        loginFunc();
        createIssueFunc();
        createIssueAsserts();
        runThroughStatusesFunc();
        runThroughStatusesAsserts();
    }

}
