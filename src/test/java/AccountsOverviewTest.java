import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AccountsOverviewTest extends BaseTest {

    //@Test
    public void testAccountsOverview() {

        RegisterPage registerPage = new RegisterPage(driver);

        String expectedUrl = "https://parabank.parasoft.com/parabank/overview.htm";
        assertEquals(expectedUrl,driver.getCurrentUrl());

        registerPage.clickOpenNewAccount();
        String expectedOpenNewAccountUrl = "https://parabank.parasoft.com/parabank/openaccount.htm";
        assertEquals(expectedOpenNewAccountUrl,driver.getCurrentUrl());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registerPage.clickOpenNewAccountClickFinish();

    }

    @Test
    public void accountLinkRedirectsUserToCorrectAccountDetailsPage() {

        String previousURL = driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        accountsOverviewPage.clickFirstAccount();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String accountNumber = accountsOverviewPage.getAccountNumber();
        System.out.println("Account number:" + accountNumber);

        String expectedUrl = "https://parabank.parasoft.com/parabank/activity.htm?id=" + accountNumber;
        System.out.println("URL expected: " + expectedUrl);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url: " + currentUrl);

        assertEquals(expectedUrl, currentUrl);

        String expectedDetails = "Account Details";
        String actualDetails = accountsOverviewPage.getAccountDetails();

        System.out.println("Expected title details: " + expectedDetails + ". Actual title details: " + actualDetails);
        assertEquals(expectedDetails, actualDetails);

        driver.get(previousURL);

        accountsOverviewPage.clickSecondAccount();

        try {
            // Wait for 5 seconds (5000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String accountNumberTwo = accountsOverviewPage.getAccountNumber();
        System.out.println("Account number:" + accountNumberTwo);

        String expectedUrlTwo = "https://parabank.parasoft.com/parabank/activity.htm?id=" + accountNumberTwo;
        System.out.println("URL expected: " + expectedUrlTwo);

        String currentUrlTwo = driver.getCurrentUrl();
        System.out.println("Current url: " + currentUrlTwo);

        assertEquals(expectedUrlTwo, currentUrlTwo);

        actualDetails = accountsOverviewPage.getAccountDetails();

        System.out.println("Expected title details: " + expectedDetails + ". Actual title details: " + actualDetails);
        assertEquals(expectedDetails, actualDetails);

    }

    @Test
    public void basicNavigationThroughTheSite() {

        String previousURL = driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        accountsOverviewPage.clickFirstAccount();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String accountNumber = accountsOverviewPage.getAccountNumber();
        System.out.println("Account number:" + accountNumber);

        String expectedUrl = "https://parabank.parasoft.com/parabank/activity.htm?id=" + accountNumber;
        System.out.println("URL expected: " + expectedUrl);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current url: " + currentUrl);

        assertEquals(expectedUrl, currentUrl);

        String expectedDetails = "Account Details";
        String actualDetails = accountsOverviewPage.getAccountDetails();

        System.out.println("Expected title details: " + expectedDetails + ". Actual title details: " + actualDetails);
        assertEquals(expectedDetails, actualDetails);

        accountsOverviewPage.selectMonth("November");
        accountsOverviewPage.selectActivity("Credit");
        accountsOverviewPage.clickAccountActivityButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedNoAccountsMessage = "No transactions found.";
        String actualNoAccountMessage = accountsOverviewPage.getNoAccountsMessage();

        assertEquals(expectedNoAccountsMessage, actualNoAccountMessage);
        System.out.println("Expected message: " + expectedNoAccountsMessage + ". Actual message: " + actualNoAccountMessage);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(previousURL);
    }

}
