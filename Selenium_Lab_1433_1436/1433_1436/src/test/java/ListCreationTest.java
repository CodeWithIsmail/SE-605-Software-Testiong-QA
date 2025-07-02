import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListCreationTest extends BaseTest {

    @Test
    public void listCreationTest() {
        BoardPage boardPage = new BoardPage(driver);

        boardPage.openFirstBoard();
        boardPage.clickAddNewList();
        boardPage.enterListName("My List for Test");
        boardPage.submitList();
    }
}