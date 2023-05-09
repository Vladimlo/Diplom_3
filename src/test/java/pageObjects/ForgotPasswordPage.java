package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends Page {

    private final By goToLoginHref = By.xpath(".//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход к странице авторизации")
    public void goToLoginClick() {
        clickOnElement(driver.findElement(goToLoginHref));
    }
}
