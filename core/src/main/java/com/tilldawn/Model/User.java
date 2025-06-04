package com.tilldawn.Model;

import com.tilldawn.Model.Enums.Question;

public class User {
    private final String username;
    private final String password;
    private final Question question;
    private final String answer;
    private int score;
    private String avatarPath;

    public User(String username, String password, Question question, String answer, String avatarPath) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.score = 0;
        this.avatarPath = avatarPath;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
