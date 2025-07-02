//import org.example.HomePage;
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class BaseTest {
//    protected WebDriver driver;
//    protected Login loginPage;
//    protected HomePage homePage;
//    protected WebDriverWait wait;
//
//    @Before
//    public void setUp() throws Exception {
//        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
//
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("/opt/firefox/firefox");
//
//        driver = new FirefoxDriver(options);
//        driver.manage().window().setSize(new Dimension(1366, 736));
//        driver.get("http://localhost:4000/");
//
//        loginPage = new Login(driver);
//        homePage = new HomePage(driver);
//
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        homePage.signOutIfPresent();
//        loginPage.loginAs("john@phoenix-trello.com", "12345678");
//        wait.until(d -> homePage.isSignOutButtonVisible());
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}


import org.example.HomePage;
//import org.example.Login;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Login loginPage;
    protected HomePage homePage;
    protected WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        // Optional: set binary path if Chrome is not on PATH
        // options.setBinary("/usr/bin/google-chrome");

        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1366, 736));
        driver.get("http://localhost:4000/");

        loginPage = new Login(driver);
        homePage = new HomePage(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage.signOutIfPresent();
        loginPage.loginAs("john@phoenix-trello.com", "12345678");
        wait.until(d -> homePage.isSignOutButtonVisible());
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
//            driver.quit();
        }
    }
}