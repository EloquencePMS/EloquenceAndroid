package technobytes.com.eloquence.rest.responses;

import technobytes.com.eloquence.rest.models.User;

/**
 * Created by seisan on 4/7/16.
 */
public class AuthenticateLogin {

    User user;
    String token;

    public User getUser() {
        return user;
}

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
