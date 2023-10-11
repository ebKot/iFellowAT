package StepDefinition;

import Elements.LoginPageElements;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.DashboardPageElements.listOfProjects;

public class LoginPageSteps extends LoginPageElements {
    @Step("Выполняем авторизацию на edujira")
    @Когда("В поле Пароль вводится {string} и в поле Логин вводится {string} и нажимается кнопка Войти")
    public static void loginFunc(String login, String password) {
        loginFormUsername.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(login);
        loginFormPassword.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue(password);
        loginButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    @Step("Проверка успешности авторизации")
    @Тогда("Отображается кнопка с выпадающим меню Проекты")
    public static void loginAsserts() {
        // После авторизации появляется выпадающее меню Проекты
        Assertions.assertEquals("Проекты", listOfProjects.shouldBe(Condition.visible, Duration.ofSeconds(15)).getText());
    }
}
