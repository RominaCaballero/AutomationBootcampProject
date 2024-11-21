import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    private By firstNameLocator = By.id("customer.firstName");
    private By lastNameLocator = By.id("customer.lastName");
    private By addressLocator = By.id("customer.address.street");
    private By cityLocator = By.id("customer.address.city");
    private By stateLocator = By.id("customer.address.state");
    private By zipCodeLocator = By.id("customer.address.zipCode");
    private By phoneNumberLocator = By.id("customer.phoneNumber");
    private By ssnLocator = By.id("customer.ssn");
    private By usernameLocator = By.id("customer.username");
    private By passwordLocator = By.id("customer.password");
    private By confirmPasswordLocator = By.id("repeatedPassword");
    private By clickConfirmButton = By.cssSelector("td input.button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void setUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void setSsn(String ssn) {
        driver.findElement(ssnLocator).sendKeys(ssn);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(zipCodeLocator).sendKeys(zipCode);
    }

    public void setState(String state) {
        driver.findElement(stateLocator).sendKeys(state);
    }

    public void setCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void setAddress(String address) {
        driver.findElement(addressLocator).sendKeys(address);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void clickConfirmButton() {
        driver.findElement(clickConfirmButton).click();
    }

    // for the assert
    private By loginSuccessLocator = By.partialLinkText("Your account was created successfully.");

    public String getLoginSuccessMessage() {
        return driver.findElement(loginSuccessLocator).getText();
    }

    // for creating an extra account
    private By openNewAccountLocator = By.cssSelector("a[href=\"openaccount.htm\"]");

    public void clickOpenNewAccount() {
        driver.findElement(openNewAccountLocator).click();
    }

    private By openAccountLocator = By.cssSelector("input[value='Open New Account']");

    public void clickOpenNewAccountClickFinish() {
        driver.findElement(openAccountLocator).click();
    }

}
