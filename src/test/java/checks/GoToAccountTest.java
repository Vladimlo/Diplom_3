package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.user.UserCreds;
import org.junit.Assert;
import org.junit.Test;
import page_objects.AccountPage;
import page_objects.LoginPage;

@DisplayName("Проверка переходов в личный кабинет")
public class GoToAccountTest extends Check {

    @Test
    @DisplayName("Проверка перехода в личный кабинет пользователя")
    public void goToAccountPageTest() {
        userClient.create(user);
        userClient.login(new UserCreds(user));

        LoginPage loginPage = new LoginPage(driver)
                .login(new UserCreds(user));
        loginPage.clickGoToAccountBtn();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isAccountPage());
    }
}
