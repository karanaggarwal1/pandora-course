package io.github.the_dagger.cb_sampleapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Karan on 04-02-2017.
 */

public class SingleUser {
    @SerializedName("avatar_url")
    @Expose
    private String avatarURL;
    @SerializedName("login")
    @Expose
    private String login;

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
