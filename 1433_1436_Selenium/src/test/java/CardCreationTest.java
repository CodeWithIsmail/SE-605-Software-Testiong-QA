import org.codewithismail.BoardPage;
import org.codewithismail.ListPage;
import org.junit.Test;

public class CardCreationTest extends BaseTest{
    @Test
    public void cardCreationTest() {
        BoardPage boardPage = new BoardPage(driver);
        ListPage listPage = new ListPage(driver);

        boardPage.openFirstBoard();
        listPage.clickAddNewCard();
        listPage.enterCardName("My Card");
        listPage.submitCard();

        // Optionally add assertions here to verify the card creation succeeded
    }
}
