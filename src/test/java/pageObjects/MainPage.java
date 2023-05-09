package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    private final By goToLoginBtn = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By discription = By.xpath(".//h1[text() = 'Соберите бургер']");
    private final By bunTab = By.xpath(".//span[text() = 'Булки']/..");
    private final By sauceTab = By.xpath(".//span[text() = 'Соусы']/..");
    private final By topingTab = By.xpath(".//span[text() = 'Начинки']/..");
    private final By bunHeader = By.xpath(".//h2[text() = 'Булки']");
    private final By sauceHeader = By.xpath(".//h2[text() = 'Соусы']");
    private final By topingHeader = By.xpath(".//h2[text() = 'Начинки']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход к странице авторизации")
    public void clickGoToLoginBtn() {
        clickOnElement(driver.findElement(goToLoginBtn));
    }

    @Step("Проверка текущей страницы")
    public boolean isManePage() {
        return !driver.findElements(discription).isEmpty();
    }

    @Step("Переход ко вкладке Булок")
    public void clickBunTab() {
        clickOnElement(driver.findElement(bunTab));
    }

    @Step("Переход ко вкладке Соусов")
    public void clickSauceTab() {
        clickOnElement(driver.findElement(sauceTab));
    }

    @Step("Переход ко вкладке Начинок")
    public void clickTopingTab() {
        clickOnElement(driver.findElement(topingTab));
    }

    @Step("Получение позиций заголовков конструктора")
    public Integer[] getPositions() {
        Integer[] positions = {driver.findElement(bunHeader).getLocation().y,
                driver.findElement(sauceHeader).getLocation().y,
                driver.findElement(topingHeader).getLocation().y};
        return positions;
    }
}
