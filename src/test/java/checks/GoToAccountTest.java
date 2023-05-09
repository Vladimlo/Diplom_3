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

import static org.example.config.DriverFarm.getDriver;

@DisplayName("Проверка переходов в личный кабинет")
public class GoToAccountTest extends Check {

    User user;
    UserClient userClient;

    @Before
    public void classSetup() {
        driver = getDriver(AppConfig.LOGIN_PAGE);
        user = RandomUser.getRandomUser();
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет пользователя")
    public void goToAccountPageTest() {
        userClient.create(user);
        userClient.login(new UserCreds(user));

        LoginPage loginPage = new LoginPage(driver)
                .login(new UserCreds(user));
        loginPage.clickGoToAccountBtn();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.IsAccountPage());
    }

    @After
    public void tearDown() {
        userClient.delete();
        driver.quit();
    }
}
