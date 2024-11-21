import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountsOverviewPage {

    private WebDriver driver;
    private By firstAccountLocator = By.cssSelector("tr:nth-child(1) a");
    private By secondAccountLocator = By.cssSelector("tr:nth-child(2) a");
    private By activityDropDownMenuLocator = By.id("month");
    private By accountActivityButton = By.cssSelector("input.button");
    private By typeActivityLocator = By.id("transactionType");
    private By accountNumberLocator = By.id("accountId");
    private By accountDetailsLocator = By.cssSelector("h1.title ");
    private By noAccountsMessageLocator = By.xpath("//b[text()='No transactions found.']");

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click on the first account link
    public void clickFirstAccount() {
        driver.findElement(firstAccountLocator).click();
    }

    // Click on the second account link
    public void clickSecondAccount() {
        driver.findElement(secondAccountLocator).click();
    }

    // Select month from the dropdown
    public void selectMonth(String monthName) {
        Select select = new Select(driver.findElement(activityDropDownMenuLocator));
        select.selectByVisibleText(monthName); // Ensure monthName exactly matches the dropdown text
    }

    // Select activity type from the dropdown
    public void selectActivity(String activityName) {
        Select select = new Select(driver.findElement(typeActivityLocator));
        select.selectByVisibleText(activityName); // Ensure activityName is a valid option in the dropdown
    }

    // Click the account activity button to apply selected filters
    public void clickAccountActivityButton() {
        driver.findElement(accountActivityButton).click();
    }

    // Get the account number displayed on the page
    public String getAccountNumber() {
        return driver.findElement(accountNumberLocator).getText();
    }

    // Get the account details title
    public String getAccountDetails() {
        return driver.findElement(accountDetailsLocator).getText();
    }

    // Retrieve the message when no transactions are found
    public String getNoAccountsMessage() {
        return driver.findElement(noAccountsMessageLocator).getText();
    }
}
