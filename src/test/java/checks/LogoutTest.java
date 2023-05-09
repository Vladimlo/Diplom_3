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
import pageObjects.AccountPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import static org.example.config.DriverFarm.getDriver;

@DisplayName("Проверка выхода пользователя")
public class LogoutTest extends Check {
    User user;
    UserClient userClient;

    @Before
    public void classSetup() {
        driver = getDriver(AppConfig.LOGIN_PAGE);
        user = RandomUser.getRandomUser();
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Проверка логаута пользователя")
    public void logoutTest() {
        userClient.create(user);
        UserCreds userCreds = new UserCreds(user);
        userClient.login(userCreds);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userCreds);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickGoToAccountBtn();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.logout();
        Assert.assertEquals("Не произошел переход на страницу авторизации",
                "Вход", loginPage.getPageName());
    }

    @After
    public void tearDown() {
        driver.quit();
        userClient.delete();
    }
}
