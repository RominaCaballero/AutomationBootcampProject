import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameLocator = By.cssSelector("input[name=\"username\"]");
    private By passwordLocator = By.cssSelector("input[name=\"password\"]");
    private By loginButtonLocator = By.cssSelector("input[value=\"Log In\"]");

    // Constructor to initialize the WebDriver instance
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to input the password into the password field
    public void setPasswordLocator(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    // Method to input the username into the username field
    public void setUsernameLocator(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

}
