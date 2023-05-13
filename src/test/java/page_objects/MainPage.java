package page_objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class MainPage extends Page {

    private final By goToLoginBtn = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By discription = By.xpath(".//h1[text() = 'Соберите бургер']");
    private final By bunTab = By.xpath(".//span[text() = 'Булки']/..");
    private final By sauceTab = By.xpath(".//span[text() = 'Соусы']/..");
    private final By topingTab = By.xpath(".//span[text() = 'Начинки']/..");
    private final By bunHeader = By.xpath(".//h2[text() = 'Булки']");
    private final By sauceHeader = By.xpath(".//h2[text() = 'Соусы']");
    private final By topingHeader = By.xpath(".//h2[text() = 'Начинки']");
    private final By container = By.xpath(".//div[@class = 'BurgerIngredients_ingredients__menuContainer__Xu3Mo']");

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
        driver.findElement(bunTab).click();
    }

    @Step("Переход ко вкладке Соусов")
    public void clickSauceTab() {
       driver.findElement(sauceTab).click();
    }

    @Step("Переход ко вкладке Начинок")
    public void clickTopingTab() {
        driver.findElement(topingTab).click();
    }

    @Step("Получение позиций заголовков конструктора")
    public boolean isCorrectPosition(String headerName) {

        Map<String, By> headers = Map.of(
                "Булки", bunHeader,
                "Соусы", sauceHeader,
                "Начинки", topingHeader
        );

        if(!headers.containsKey(headerName)){
            return false;
        }

        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                drv -> (Math.abs(drv.findElement(container).getLocation().y -
                        drv.findElement(headers.get(headerName)).getLocation().y) < 1));
    }
}
