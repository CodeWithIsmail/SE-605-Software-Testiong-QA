import org.example.HomePage;
//import org.example.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class LoginTest extends BaseTest {

    private WebDriver driver;
    private Login loginPage;
    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        // Optional: specify custom binary if Chrome not on PATH
        // options.setBinary("/usr/bin/google-chrome");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(887, 752));
        driver.get("http://localhost:4000/");

        loginPage = new Login(driver);
        homePage = new HomePage(driver);
        homePage.signOutIfPresent();
    }

    @Test
    public void testValidLogin() {
        loginPage.loginAs("john@phoenix-trello.com", "12345678");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> homePage.isSignOutButtonVisible());
        assertEquals("Boards | Phoenix Trello", homePage.getTitle());
    }

    @Test
    public void testInValidPassword() {
        loginPage.loginAs("john@phoenix-trello.com", "wrongpassword");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error"))); // adjust as needed

        String errorMessage = loginPage.getLoginErrorMessage();
        assertEquals("Invalid email or password", errorMessage); // adjust text as per your app
    }

    @Test
    public void testInValidEmail() {
        loginPage.loginAs("john@phoenix.com", "12345678");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Assuming invalid email should display an error, not sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error"))); // adjust as needed

        String errorMessage = loginPage.getLoginErrorMessage();
        assertEquals("Invalid email or password", errorMessage); // adjust text as per your app
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}