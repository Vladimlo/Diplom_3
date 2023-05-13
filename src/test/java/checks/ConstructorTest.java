package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import page_objects.MainPage;

import static org.example.config.DriverFarm.getDriver;


@DisplayName("Проверка переходов между вкладками конструктора")
public class ConstructorTest extends Check {

    @Before
    public void classSetup(){
        driver = getDriver(AppConfig.MAIN_PAGE);
    }

    @Test
    @DisplayName("Проверка перехода к соусам")
    public void souceTabTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        mainPage.isCorrectPosition("Соусы");
    }

    @Test
    @DisplayName("Проверка перехода к начинкам")
    public void topingTubTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopingTab();
        mainPage.isCorrectPosition("Начинки");
    }

    @Test
    @DisplayName("Проверка перехода к булкам")
    public void bunTubTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        mainPage.isCorrectPosition("Булки");
    }
}
