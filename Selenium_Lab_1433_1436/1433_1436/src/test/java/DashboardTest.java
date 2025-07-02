import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

public class DashboardTest extends BaseTest{
    @Test
    public void testCreateBoardAndAddListAndCards() {
//        loginAsValidUser();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> homePage.isSignOutButtonVisible());

        driver.findElement(By.cssSelector(".inner")).click();
        wait.until(d -> d.findElement(By.id("board_name"))).sendKeys("My board");

        driver.findElement(By.cssSelector("form#new_board_form button")).click();
        wait.until(d -> d.findElement(By.cssSelector(".inner"))).click();

        driver.findElement(By.id("list_name")).sendKeys("Shopping List");
        driver.findElement(By.cssSelector("form#new_board_form button")).click();

        wait.until(d -> d.findElement(By.linkText("Add a new card..."))).click();
        driver.findElement(By.id("card_name")).sendKeys("Milk\nCarrot");
        driver.findElement(By.cssSelector("form#new_card_form button")).click();

        assertTrue(driver.getPageSource().contains("Shopping List"));
        assertTrue(driver.getPageSource().contains("Milk"));
        assertTrue(driver.getPageSource().contains("Carrot"));

        System.out.println(driver.getPageSource());

        driver.findElement(By.cssSelector("#crawler-sign-out > span")).click();
    }
}
