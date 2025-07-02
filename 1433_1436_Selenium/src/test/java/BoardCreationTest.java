import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;
public class BoardCreationTest extends BaseTest{
    @Test
    public void testBoardCreation() {
        homePage.clickAddNewBoard();
        homePage.enterBoardName("First Board");
        homePage.submitBoard();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".view-header h3"), "First Board"));
        String createdBoardName = driver.findElement(By.cssSelector(".view-header h3")).getText();
        assertEquals("First Board", createdBoardName);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}