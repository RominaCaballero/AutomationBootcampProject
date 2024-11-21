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
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

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

        String expectedUrl = "https://parabank.parasoft.com/parabank/register.htm";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        RegisterPage.clickOpenNewAccount();

        try {
            // Wait for 5 seconds (5000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RegisterPage.clickOpenNewAccountClickFinish();

        driver.quit();

    }

}
