package pl.jsystems.qa.frontend.factory.test;

import org.junit.jupiter.api.Test;
import pl.jsystems.qa.frontend.Configuration;
import pl.jsystems.qa.frontend.cucumber.CucumberStepConfig;
import pl.jsystems.qa.frontend.factory.page.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontEndTest extends CucumberStepConfig.FrontConfig {





//    @BeforeEach
//    public void before() {
//        WebDriverManager.chromedriver().setup();
//    }

    @Test
    public void firstFrontendTest() {

        MainPage mainPage = new MainPage(driver);
        assertTrue(driver.getTitle().contains("WordPress.com"));
        assertEquals(mainPage.logIn.getText(), "Log In");
        assertTrue(mainPage.logIn.isDisplayed());
        mainPage.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);

        loginEmailPage.waitForVisilibityOfElement(loginEmailPage.loginEmail, 30);
        loginEmailPage.waitForVisilibityOfElement(loginEmailPage.emailContinueButton, 30);

        assertTrue(loginEmailPage.loginEmail.isDisplayed());
        assertTrue(loginEmailPage.emailContinueButton.isDisplayed());

        loginEmailPage.loginEmail.clear(); //metoda czyszcząca pole
        loginEmailPage.loginEmail.sendKeys(Configuration.WORDPRESS_LOGIN);
        loginEmailPage.emailContinueButton.click();
//        driver.findElement(By.cssSelector())



        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);

        loginPasswordPage.waitForVisilibityOfElement(loginPasswordPage.passwordInput, 30);
        loginPasswordPage.waitForVisilibityOfElement(loginPasswordPage.loginButton, 30);

        loginPasswordPage.passwordInput.clear();
        loginPasswordPage.passwordInput.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPasswordPage.loginButton.click();

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisilibityOfElement(userMainPage.userAvatar, 30);

        userMainPage.userAvatar.click();

        UserPersonalPage userPersonalPage = new UserPersonalPage(driver);
        userPersonalPage.waitForVisilibityOfElement(userPersonalPage.privateLink, 30);
        userPersonalPage.privateLink.click();

        PrivatPage privatPage = new PrivatPage(driver);
        privatPage.waitForVisilibityOfElement(privatPage.checkbox,30);
        assertFalse(privatPage.saveButton.isEnabled());

        privatPage.checkbox.click();
        assertTrue(privatPage.saveButton.isEnabled());


//        driver.quit();
//        driver = null;



    }

    @Test
    public void secondFrontendTest() {

        MainPage mainPage = new MainPage(driver);
        assertTrue(driver.getTitle().contains("WordPress.com"));
        assertEquals(mainPage.logIn.getText(), "Log In");
        assertTrue(mainPage.logIn.isDisplayed());
        mainPage.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);

        loginEmailPage.waitForVisilibityOfElement(loginEmailPage.loginEmail, 30);
        loginEmailPage.waitForVisilibityOfElement(loginEmailPage.emailContinueButton, 30);

        assertTrue(loginEmailPage.loginEmail.isDisplayed());
        assertTrue(loginEmailPage.emailContinueButton.isDisplayed());

        loginEmailPage.loginEmail.clear(); //metoda czyszcząca pole
        loginEmailPage.loginEmail.sendKeys(Configuration.WORDPRESS_LOGIN);
        loginEmailPage.emailContinueButton.click();
//        driver.findElement(By.cssSelector())



        LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);

        loginPasswordPage.waitForVisilibityOfElement(loginPasswordPage.passwordInput, 30);
        loginPasswordPage.waitForVisilibityOfElement(loginPasswordPage.loginButton, 30);

        loginPasswordPage.passwordInput.clear();
        loginPasswordPage.passwordInput.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPasswordPage.loginButton.click();

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisilibityOfElement(userMainPage.userAvatar, 30);

        userMainPage.userAvatar.click();

        UserPersonalPage userPersonalPage = new UserPersonalPage(driver);
        userPersonalPage.waitForVisilibityOfElement(userPersonalPage.privateLink, 30);
        userPersonalPage.notification.click();

        NotificationPage notificationPage = new NotificationPage(driver);

        assertTrue(notificationPage.secondSelector.isSelected());
        notificationPage.secondSelector.click();
        assertFalse(notificationPage.secondSelector.isSelected());
        notificationPage.secondSelector.click();
        assertTrue(notificationPage.secondSelector.isSelected());


//        driver.quit();
//        driver = null;



    }
}
