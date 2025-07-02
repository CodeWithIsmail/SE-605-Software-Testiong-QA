import org.example.DashboardPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class TestLoginAndBoardFlow {
    private WebDriver driver;
    private Login login;
    private DashboardPage dashboardPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/opt/firefox/firefox");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:4000/sign_in");

        login= new Login(driver);
        dashboardPage = new DashboardPage(driver);
    }

//    @Test
//    public void testFullFlow() {
//        login.login("mahfuz@gmail.com", "12345678");
//
//        dashboardPage.createBoard("My board");
//        dashboardPage.createList("Shopping List");
//        dashboardPage.addCard("Milk", "Carrot");
//        dashboardPage.signOut();
//    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
