import org.junit.Test;

import static org.junit.Assert.*;

public class InviteMemberpageTest extends BaseTest{
    @Test
    public void testInvalidMemberInvite() {
        BoardPage boardPage = new BoardPage(driver);
        InviteMemberpage inviteMemberpage = new InviteMemberpage(driver);
        boardPage.openFirstBoard();
        inviteMemberpage.clickInviteMember();
        inviteMemberpage.enterEmail("abc@gmail.com");
        inviteMemberpage.submitInvite();
        // Optionally, you can add assertions to verify that an error message appeared.
    }

}