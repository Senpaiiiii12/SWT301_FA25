package QuocThinh.example;

import java.util.regex.Pattern;

public class AccountService {

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.length() <= 6) {
            throw new IllegalArgumentException("Password must be longer than 6 characters");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return true;
    }
}
