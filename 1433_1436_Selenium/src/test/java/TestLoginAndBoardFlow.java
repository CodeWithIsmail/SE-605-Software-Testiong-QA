import org.codewithismail.DashboardPage;
import org.codewithismail.Login;
import org.junit.After;
import org.junit.Before;
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

        login = new Login(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
