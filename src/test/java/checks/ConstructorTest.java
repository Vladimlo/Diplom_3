package checks;

import io.qameta.allure.junit4.DisplayName;
import org.example.config.AppConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjects.MainPage;

import static org.example.config.DriverFarm.getDriver;

@DisplayName("Проверка переходов между вкладками конструктора")
public class ConstructorTest extends Check {

    Integer[] bunPositionsExpected = {243, 574, 1163};
    Integer[] soucePositionsExpected = {-87, 243, 831};
    Integer[] topingPositionsExpected = {-675, -344, 243};

    @Before
    public void classSetup() {
        driver = getDriver(AppConfig.MAIN_PAGE);
    }

    @Test
    @DisplayName("Проверка перехода к соусам")
    public void souceTabTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSauceTab();
        Thread.sleep(1000);
        Integer[] actualPosition = mainPage.getPositions();
        Assert.assertEquals("Булки ожидались в другой позиции",
                soucePositionsExpected[0], actualPosition[0]);
        Assert.assertEquals("Соусы ожидались в другой позиции",
                soucePositionsExpected[1], actualPosition[1]);
        Assert.assertEquals("начинки ожидались в другой позиции",
                soucePositionsExpected[2], actualPosition[2]);
    }

    @Test
    @DisplayName("Проверка перехода к начинкам")
    public void topingTubTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickTopingTab();
        Thread.sleep(1000);
        Integer[] actualPosition = mainPage.getPositions();
        Assert.assertEquals("Булки ожидались в другой позиции",
                topingPositionsExpected[0], actualPosition[0]);
        Assert.assertEquals("Соусы ожидались в другой позиции",
                topingPositionsExpected[1], actualPosition[1]);
        Assert.assertEquals("начинки ожидались в другой позиции",
                topingPositionsExpected[2], actualPosition[2]);
    }

    @Test
    @DisplayName("Проверка перехода к булкам")
    public void bunTubTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSauceTab();
        Thread.sleep(1000);
        mainPage.clickBunTab();
        Thread.sleep(1000);
        Integer[] actualPosition = mainPage.getPositions();
        Assert.assertEquals("Булки ожидались в другой позиции",
                bunPositionsExpected[0], actualPosition[0]);
        Assert.assertEquals("Соусы ожидались в другой позиции",
                bunPositionsExpected[1], actualPosition[1]);
        Assert.assertEquals("начинки ожидались в другой позиции",
                bunPositionsExpected[2], actualPosition[2]);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
