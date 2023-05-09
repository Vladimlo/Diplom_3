package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends Page {

    private final By discriptionText = By.xpath(".//p[text() = " +
            "'В этом разделе вы можете изменить свои персональные данные']");
    private final By logoutBtn = By.xpath(".//button[text() = 'Выход']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка текущей страницы")
    public boolean IsAccountPage() {
        return !driver.findElements(discriptionText).isEmpty();
    }

    @Step("Выход пользователя")
    public void logout() {
        clickOnElement(driver.findElement(logoutBtn));
    }
}
