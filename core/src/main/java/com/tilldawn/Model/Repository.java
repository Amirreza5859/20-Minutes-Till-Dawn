package com.tilldawn.Model;

import javax.swing.text.View;
import java.util.HashMap;
import java.util.Map;

public class Repository {
    private User currentUser;
    private User tempUser;
    private View currentView;
    private static Map<String, User> users;

    public Repository() {
        users = new HashMap<>();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public View getCurrentView() {
        return currentView;
    }

    public User getTempUser() {
        return tempUser;
    }

    public void setTempUser(User tempUser) {
        this.tempUser = tempUser;
    }
}
