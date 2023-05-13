package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page {

    private final By nameField = By.xpath(".//label[text() = 'Имя']/../input");
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input");
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input");
    private final By registrBtn = By.xpath(".//button[@class = " +
            "'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By easyPasswordMessage = By.xpath(".//p[@class = 'input__error text_type_main-default']");

    private final By goToLoginHref = By.xpath(".//a[text() = 'Войти']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение имени пользователя")
    public RegisterPage addName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    @Step("Заполнение почты пользователя")
    public RegisterPage addEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("Заполнение пароля пользователя")
    public RegisterPage addPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке регистрации")
    public RegisterPage clickRegistrButton() {
        clickOnElement(driver.findElement(registrBtn));
        return this;
    }

    @Step("Регистрация пользователя")
    public RegisterPage userRegistration(String name, String email, String password) {
        addName(name).addEmail(email).addPassword(password).clickRegistrButton();
        return this;
    }

    @Step("Получение сообщения о коротком пароле")
    public String getEasyPasswordMessage() {
        return driver.findElement(easyPasswordMessage).getText();
    }

    @Step("Переход к странице авторизации")
    public void goToLoginClick() {
        clickOnElement(driver.findElement(goToLoginHref));
    }
}
