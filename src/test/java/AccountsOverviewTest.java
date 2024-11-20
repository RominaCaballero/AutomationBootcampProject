import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AccountsOverviewTest extends BaseTest {

    @Test
    public void testAccountsOverview() {

        RegisterPage registerPage = new RegisterPage(driver);

        String expectedUrl = "https://parabank.parasoft.com/parabank/overview.htm";
        assertEquals(expectedUrl,driver.getCurrentUrl());

        registerPage.clickOpenNewAccount();
        String expectedOpenNewAccountUrl = "https://parabank.parasoft.com/parabank/openaccount.htm";
        assertEquals(expectedOpenNewAccountUrl,driver.getCurrentUrl());

        try {
            // Wait for 5 seconds (5000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        registerPage.clickOpenNewAccountClickFinish();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement openAccountButton = wait.until(
//                ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Open New Account']"))
//        );

        registerPage.clickOpenNewAccountClickFinish();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void accountLinkRedirectsUserToCorrectAccountDetailsPage() {

        String previousURL = driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        accountsOverviewPage.clickFirstAccount();

        driver.get(previousURL);

        accountsOverviewPage.clickSecondAccount();

    }

    @Test
    public void basicNavigationThroughTheSite() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        accountsOverviewPage.clickFirstAccount();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        accountsOverviewPage.selectMonth("November");
        accountsOverviewPage.selectActivity("Credit");
        accountsOverviewPage.clickAccountActivityButton();
    }

}
