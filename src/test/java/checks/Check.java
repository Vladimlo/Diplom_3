package checks;

import org.example.config.AppConfig;
import org.example.user.User;
import org.example.user.UserClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static org.example.config.DriverFarm.getDriver;
import static org.example.user.RandomUser.getRandomUser;

public class Check {
    static WebDriver driver;

    UserClient userClient;
    User user;

    @Before
    public void classSetup(){
        driver = getDriver(AppConfig.LOGIN_PAGE);
    }

    public Check(){
        this.userClient = new UserClient();
        this.user = getRandomUser();
    }

    @After
    public void tearDown() {
        if(userClient.getTokensCount() != 0){
            userClient.delete();
        }
        driver.quit();
    }
}
