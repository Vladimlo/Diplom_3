package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

    private final By goToAccountBtn = By.xpath(".//p[text() = 'Личный Кабинет']");

    private final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    private final By constructorHref = By.xpath("//p[text() = 'Конструктор']/..");
    static WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public Page clickOnElement(WebElement element) {
        scroll(element).click();
        return this;
    }

    @Step("Переход в личный кабинет")
    public void clickGoToAccountBtn() {
        clickOnElement(driver.findElement(goToAccountBtn));
    }

    @Step("Переход к конструктору по логотипу")
    public void clickToLogo() {
        clickOnElement(driver.findElement(logo));
    }

    @Step("Переход к конструктору по ссылке")
    public void clickToConstructorHref() {
        clickOnElement(driver.findElement(constructorHref));
    }
}
