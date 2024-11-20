import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameLocator = By.cssSelector("input[name=\"username\"]");
    private By passwordLocator = By.cssSelector("input[name=\"password\"]");
    private By loginButtonLocator = By.cssSelector("input[value=\"Log In\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPasswordLocator(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void setUsernameLocator(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }
}
