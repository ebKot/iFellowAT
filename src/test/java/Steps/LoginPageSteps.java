package Steps;

import Elements.LoginPageElements;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static Elements.DashboardPageElements.listOfProjects;

public class LoginPageSteps extends LoginPageElements {
    public static void loginFunc() {
        loginFormUsername.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue("AT1");
        loginFormPassword.shouldBe(Condition.visible, Duration.ofSeconds(15)).setValue("Qwerty123");
        loginButton.shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
    }

    public static void loginAsserts() {
        // После авторизации появляется выпадающее меню Проекты
        Assertions.assertEquals("Проекты", listOfProjects.shouldBe(Condition.visible, Duration.ofSeconds(15)).getText());
    }
}
