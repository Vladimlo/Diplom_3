package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.AppConfig;
import org.example.user.UserCreds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_objects.LoginPage;
import page_objects.RegisterPage;

import static org.example.config.DriverFarm.getDriver;

@DisplayName("Проверка регистрации пользователя")
public class TestRegistration extends Check {

    @Before
    @Override
    public void classSetup() {
        driver = getDriver(AppConfig.REGISTER_PAGE);
    }

    @Test
    @DisplayName("Проверка регистрации пользователя")
    public void testRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userRegistration(user.getName(), user.getEmail(), user.getPassword());
        userClient.login(new UserCreds(user));
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Не успешная регистрация", "Вход", loginPage.getPageName());
    }

    @Test
    @DisplayName("Проверка отображения сообщения при регистрации с коротким паролем")
    public void testRegistrationEasyPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userRegistration(user.getName(), user.getEmail(), "test");
        Assert.assertEquals("Сообщение об ошибке не корректное",
                "Некорректный пароль", registerPage.getEasyPasswordMessage());
    }
}
