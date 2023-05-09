package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.AppConfig;
import org.example.user.RandomUser;
import org.example.user.User;
import org.example.user.UserClient;
import org.example.user.UserCreds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import static org.example.config.DriverFarm.getDriver;

@DisplayName("Проверка регистрации пользователя")
public class TestRegistration extends Check {

    UserClient userClient;
    User user;

    @Before
    public void classSetup() {
        driver = getDriver(AppConfig.REGISTER_PAGE);
        userClient = new UserClient();
        user = RandomUser.getRandomUser();
    }

    @Test
    @DisplayName("Проверка регистрации пользователя")
    public void testRegistration() throws InterruptedException {
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

    @After
    public void tearDown() {
        userClient.delete();
        driver.quit();
    }
}
