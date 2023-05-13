package checks;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_objects.ForgotPasswordPage;
import page_objects.LoginPage;
import page_objects.MainPage;
import page_objects.RegisterPage;

@DisplayName("Проверка переходов к странице авторизации")
public class GoToLoginPageTest extends Check {

    @Test
    @DisplayName("Переход к авторизации через кнопку \"Войти в аккаунт\"")
    public void mainPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToLogo();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToLoginBtn();

        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Переход к авторизации через кнопку \"Личный кабинет\"")
    public void goToAccountBtnTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToLogo();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountBtn();

        loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Переход к авторизации со страницы регистрации")
    public void registrPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistHref();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToLoginClick();

        loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Переход к авторизации со страницы востановления пароля")
    public void forgotPasswordPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordHref();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.goToLoginClick();

        loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }
}
