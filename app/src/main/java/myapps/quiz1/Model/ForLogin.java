package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by comsol on 16-Jan-18.
 */
public class ForLogin {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("message")
    private String message;

    @SerializedName("login")
    private Login login;


    public ForLogin(Boolean success, String message, Login login) {
        this.success = success;
        this.message = message;
        this.login =  login;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Login getLogin() {
        return login;
    }
}
