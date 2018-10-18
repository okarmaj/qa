package pl.jsystems.qa.frontend.cucumber;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pl.jsystems.qa.frontend.Configuration;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class CucumberStepConfig {

    public WebDriver driver = null;
    public String baseUrl;
    //    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public String id = "0";



    @Before
    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        System.out.println("================== @Before Frontend Cucumber =====================");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--start-maximized");
//        openBaseUrl = "https://wordpress.com/";
        if (driver == null) {
            driver = new ChromeDriver(chromeOptions);
        }
        prepareDriver();
        return driver;
    }

    void prepareDriver(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @After
    public void tearDown(Scenario scenario) {

        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";
//            status = "++++++++++";
            scenario.write("Scenario passed");
        } else {
            status = "(✖╭╮✖)";
//            status = "-------------";
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"images/png");
            scenario.write("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
//            driver.close();
        }
            driver.quit();
            driver = null;
    }

    public static class FrontConfig {

        public WebDriver driver;

        @BeforeAll
        public static void setupAll() {
            WebDriverManager.chromedriver().setup();
        }

    //        ChromeOptions chromeOptions= new ChromeOptions();
    //        chromeOptions.addArguments("--start-maximized");

    //        WebDriver driver = new ChromeDriver(chromeOptions);
        @BeforeEach
        public void setUp () {
            if (driver == null) {
                driver = new ChromeDriver();

            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            driver.get(Configuration.WORDPRESS_URL);

        }

    //    @AfterEach
    //    public void teareDown() {
    //        driver.quit();
    //        driver = null;

    //    }
    }
}
