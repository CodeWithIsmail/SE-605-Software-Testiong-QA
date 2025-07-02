package org.example;

public class AuthManager {
    private final UserRepo userRepo;
    private final PassHash passHash;

    public AuthManager(UserRepo userRepo, PassHash passHash) {
        this.userRepo = userRepo;
        this.passHash = passHash;
    }

    public boolean login(String username, String password) {
        if ((boolean) userRepo.checkUserExists(username)) {
            String hashedPassword = passHash.hashPassword(password);
            boolean result = (boolean) userRepo.checkUserPassword(username, hashedPassword);
            if (result) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong password");
            }

        } else {
            throw new IllegalArgumentException("User does not exist");
        }
    }

}
