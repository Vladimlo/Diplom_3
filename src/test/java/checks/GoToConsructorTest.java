package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.user.UserCreds;
import org.junit.Assert;
import org.junit.Test;
import page_objects.AccountPage;
import page_objects.LoginPage;
import page_objects.MainPage;

@DisplayName("Проверка переходов к конструктору")
public class GoToConsructorTest extends Check {

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
}
