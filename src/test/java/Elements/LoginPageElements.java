package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageElements {

    // Логин
    public static SelenideElement loginFormUsername = $x("//input[@id='login-form-username']");

    // Пароль
    public static SelenideElement loginFormPassword = $x("//input[@id='login-form-password']");

    // Кнопка Войти
    public static SelenideElement loginButton = $x("//input[@id='login' and @value='Войти']");

}
