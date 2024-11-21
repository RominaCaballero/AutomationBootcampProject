import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsernameLocator("Mina1");
        loginPage.setPasswordLocator("12345");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.clickLoginButton();
    }

    @AfterEach
    public void clean() {
        driver.quit();
    }

}
