package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.user.UserCreds;
import org.junit.Assert;
import org.junit.Test;
import page_objects.AccountPage;
import page_objects.LoginPage;
import page_objects.MainPage;

@DisplayName("Проверка выхода пользователя")
public class LogoutTest extends Check {

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
}
