package org.example.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFarm {

    public static String browserName = Dotenv.load().get("browser");

    public static WebDriver getDriver(String url) {

    WebDriver driver;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver(new ChromeOptions()
                        .setBinary("C:/Users/ldv19/AppData/Local/Yandex/YandexBrowser/Application/browser.exe")
                );
                break;
            default:
                throw new RuntimeException("Browser " + browserName + " not exist");
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverConfig.WAIT_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_TIME));
        driver.get(url);

        return driver;
    }
}
