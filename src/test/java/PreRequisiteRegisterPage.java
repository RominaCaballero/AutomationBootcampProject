import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class PreRequisiteRegisterPage {

    @Test
    public void testRegisterSuccesfulPreRequisites(){
        // Go to the register page first to create an account
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Fill all the required fields
        RegisterPage RegisterPage = new RegisterPage(driver);
        RegisterPage.setFirstName("Mina");
        RegisterPage.setLastName("Caballero");
        RegisterPage.setAddress("Choferes del chaco");
        RegisterPage.setCity("Asuncion");
        RegisterPage.setState("Central");
        RegisterPage.setZipCode("12345");
        RegisterPage.setPhoneNumber("0976123456");
        RegisterPage.setSsn("111");
        RegisterPage.setUsername("Mina1");
        RegisterPage.setPassword("12345");
        RegisterPage.setConfirmPassword("12345");

        RegisterPage.clickConfirmButton();

        // Confirm our registration was successful and we got redirected to the right page
        String expectedUrl = "https://parabank.parasoft.com/parabank/register.htm";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        // Open a new account since is a prerequisite in our test cases
        RegisterPage.clickOpenNewAccount();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RegisterPage.clickOpenNewAccountClickFinish();

        driver.quit();

    }

}
