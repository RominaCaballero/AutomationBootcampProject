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


    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstAccount() {
        driver.findElement(firstAccountLocator).click();
    }

    public void clickSecondAccount() {
        driver.findElement(secondAccountLocator).click();
    }

    public void selectMonth(String monthName) {
        // Locate the dropdown element
        Select select = new Select(driver.findElement(activityDropDownMenuLocator));

        // Select by visible text (e.g., "November")
        select.selectByVisibleText(monthName);
    }

    public void selectActivity(String activityName) {
        Select select = new Select(driver.findElement(typeActivityLocator));
        select.selectByVisibleText(activityName);
    }



    public void clickAccountActivityButton() {
        driver.findElement(accountActivityButton).click();
    }


}
