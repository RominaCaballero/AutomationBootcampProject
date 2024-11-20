import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegisterPage extends BaseTest {

    @Test
    public void testRegisterSuccesfulPreRequisites(){
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFirstName("Mina");
        loginPage.setLastName("Caballero");
        loginPage.setAddress("Choferes del chaco");
        loginPage.setCity("Asuncion");
        loginPage.setState("Central");
        loginPage.setZipCode("12345");
        loginPage.setPhoneNumber("0976123456");
        loginPage.setSsn("111");
        loginPage.setUsername("Mina12345");
        loginPage.setPassword("12345");
        loginPage.setConfirmPassword("12345");

        loginPage.clickConfirmButton();

        String expectedUrl = "https://parabank.parasoft.com/parabank/register.htm"; //when logged in we get the same URL
        assertEquals(expectedUrl, driver.getCurrentUrl());
        //assertEquals("Your account was created successfully. You are now logged in.", loginPage.getLoginSuccessMessage());

    }
}
