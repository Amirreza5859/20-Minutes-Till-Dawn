package com.tilldawn.Model.Enums;

public enum Question {
    QUESTION1("What is your maternal grandmother's first name?"),
    QUESTION2("What was the name of your first school?"),
    QUESTION3("What was the name of your childhood pet?");

    private final String question;

    Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public static Question fromText(String text) {
        for (Question q : values()) {
            if (q.getQuestion().equals(text)) {
                return q;
            }
        }
        throw new IllegalArgumentException("No Question with text: " + text);
    }
}
