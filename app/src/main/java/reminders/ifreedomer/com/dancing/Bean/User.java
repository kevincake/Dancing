package reminders.ifreedomer.com.dancing.bean;

import java.util.ArrayList;

/**
 * Created by eavawu on 1/31/16.
 */
public class User {
    private String userName;
    private String password;
    private String birthday;
    private String habbit;
    private String headIcon;
    private ArrayList<String> friends;
    public User() {
    }
    public User(String userName, String password, String birthday, String habbit, String headIcon, ArrayList<String> friends) {
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
        this.habbit = habbit;
        this.headIcon = headIcon;
        this.friends = friends;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHabbit() {
        return habbit;
    }

    public void setHabbit(String habbit) {
        this.habbit = habbit;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }
}
