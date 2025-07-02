package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AuthManagerTest {
    private AuthManager authManager;
    private PassHash mockPassHash;
    private UserRepo mockUserRepo;

    private User validUser;
    private User nonExistentUser;
    private User wrongPasswordUser;

    private String validHashedPassword;
    private String wrongHashedPassword;

    @Before
    public void setUp() {
        mockPassHash = mock(PassHash.class);
        mockUserRepo = mock(UserRepo.class);
        authManager = new AuthManager(mockUserRepo, mockPassHash);

        validUser = new User("ali", "pass123");
        nonExistentUser = new User("ismail", "nopass");
        wrongPasswordUser = new User("hossain", "wrongpass");

        validHashedPassword = "ismail360";
        wrongHashedPassword = "hossain99";

        when(mockUserRepo.checkUserExists(validUser.getUsername())).thenReturn(true);
        when(mockPassHash.hashPassword(validUser.getPassword())).thenReturn(validHashedPassword);
        when(mockUserRepo.checkUserPassword(validUser.getUsername(), validHashedPassword)).thenReturn(true);

        when(mockUserRepo.checkUserExists(nonExistentUser.getUsername())).thenReturn(false);

        when(mockUserRepo.checkUserExists(wrongPasswordUser.getUsername())).thenReturn(true);
        when(mockPassHash.hashPassword(wrongPasswordUser.getPassword())).thenReturn(wrongHashedPassword);
        when(mockUserRepo.checkUserPassword(wrongPasswordUser.getUsername(), wrongHashedPassword)).thenReturn(false);
    }

    @Test
    public void testLoginSuccess() {
        boolean result = authManager.login(validUser.getUsername(), validUser.getPassword());
        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserNotFound() {
        authManager.login(nonExistentUser.getUsername(), nonExistentUser.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongPassword() {
        authManager.login(wrongPasswordUser.getUsername(), wrongPasswordUser.getPassword());
    }
}
