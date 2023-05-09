package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.AppConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RegisterPage;

import static org.example.config.DriverFarm.getDriver;

@DisplayName("Проверка переходов к странице авторизации")
public class GoToLoginPageTest extends Check {

    @Test
    @DisplayName("Переход к авторизации через кнопку \"Войти в аккаунт\"")
    public void mainPageTest() {
        driver = getDriver(AppConfig.MAIN_PAGE);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToLoginBtn();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Переход к авторизации через кнопку \"Личный кабинет\"")
    public void goToAccountBtnTest() {
        driver = getDriver(AppConfig.MAIN_PAGE);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountBtn();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Переход к авторизации со страницы регистрации")
    public void registrPageTest() {
        driver = getDriver(AppConfig.REGISTER_PAGE);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.goToLoginClick();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Переход к авторизации со страницы востановления пароля")
    public void forgotPasswordPageTest() {
        driver = getDriver(AppConfig.FORGOT_PASSWORD);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.goToLoginClick();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Не произошол переход на страницу логина",
                "Вход", loginPage.getPageName());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
