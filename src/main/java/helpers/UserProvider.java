package helpers;

import java.io.File;

public class UserProvider {
    public String defaultuserName = "arsen";
    public String defaultPassword = "Password123";
    private String userName;
    private String password;

    public UserProvider(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public UserProvider() {
    }


}
