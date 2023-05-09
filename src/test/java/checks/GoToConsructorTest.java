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

@DisplayName("Проверка переходов к конструктору")
public class GoToConsructorTest extends Check {

    User user;
    UserClient userClient;

    @Before
    public void classSetup() {
        driver = getDriver(AppConfig.LOGIN_PAGE);
        user = RandomUser.getRandomUser();
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета клиента в конструктор по логотипу")
    public void TestLogo() {
        userClient.create(user);
        UserCreds userCreds = new UserCreds(user);
        userClient.login(userCreds);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userCreds);
        loginPage.clickGoToAccountBtn();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickToLogo();

        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePage());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета клиента в конструктор по ссылке \"Конструктор\"")
    public void TestConstructorHref() {
        userClient.create(user);
        UserCreds userCreds = new UserCreds(user);
        userClient.login(userCreds);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userCreds);
        loginPage.clickGoToAccountBtn();

        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickToConstructorHref();

        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePage());
    }

    @After
    public void tearDown() {
        driver.quit();
        userClient.delete();
    }
}
