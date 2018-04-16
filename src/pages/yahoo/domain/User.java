package pages.yahoo.domain;

import lombok.Data;

@Data
public class User {
    String usernameWithoutMail;
    String username;
    String password;

    public User(String username, String password) {
        this.username = username + "@yahoo.com";
        this.usernameWithoutMail = username;
        this.password = password;
    }
}
