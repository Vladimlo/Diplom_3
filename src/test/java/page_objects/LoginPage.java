package page_objects;

import io.qameta.allure.Step;
import org.example.user.UserCreds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    private final By pageName = By.xpath(".//div[@class = 'Auth_login__3hAey']/h2");
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input");
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input");
    private final By loginButton = By.xpath(".//button[text() = 'Войти']");
    private final By registrHref = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By forgotPasswordHref = By.xpath(".//a[text() = 'Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка текущей страницы")
    public String getPageName() {
        return driver.findElement(pageName).getText();
    }

    @Step("Переход на страницу востанновления пароля")
    public void clickForgotPasswordHref(){
        driver.findElement(forgotPasswordHref).click();
    }

    @Step("Переход на страницу регистрации")
    public void clickRegistHref(){
        driver.findElement(registrHref).click();
    }

    @Step("Авторизация пользователя")
    public LoginPage login(UserCreds userCreds) {
        driver.findElement(emailField).sendKeys(userCreds.getEmail());
        driver.findElement(passwordField).sendKeys(userCreds.getPassword());
        clickOnElement(driver.findElement(loginButton));
        return this;
    }
}
