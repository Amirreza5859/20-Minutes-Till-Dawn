package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tilldawn.Control.SignUpMenuController;

public class SignUpMenuView implements Screen {

    private Stage stage;
    private Table table;
    private final Skin skin;

    private final TextField usernameField;
    private final TextField passwordField;
    private final SelectBox<String> securityQuestionBox;
    private final TextField securityAnswerField;
    private final TextButton signUpButton;
    private final TextButton guestButton;
    private final TextButton loginButton;
    private final TextButton exitButton;
    private final Label messageLabel;

    private final SignUpMenuController controller;

    public SignUpMenuView(SignUpMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        usernameField = new TextField("", skin);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        securityQuestionBox = new SelectBox<>(skin);
        securityQuestionBox.setItems(
            "What is your maternal grandmother's first name?",
            "What was the name of your first school?",
            "What was the name of your childhood pet?"
        );
        securityAnswerField = new TextField("", skin);

        signUpButton = new TextButton("Sign Up", skin);
        guestButton = new TextButton("Guest", skin);
        loginButton = new TextButton("Login", skin);
        exitButton = new TextButton("Exit", skin);
        messageLabel = new Label("", skin);

        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);
        table.center();

        table.add("Username:").pad(10);
        table.add(usernameField).width(250).pad(10);
        table.row();

        table.add("Password:").pad(10);
        table.add(passwordField).width(250).pad(10);
        table.row();

        table.add("Security Question:").pad(10);
        table.add(securityQuestionBox).width(250).pad(10);
        table.row();

        table.add("Answer:").pad(10);
        table.add(securityAnswerField).width(250).pad(10);
        table.row();

        table.add(guestButton).width(230).pad(10);
        table.add(signUpButton).width(230).pad(10);
        table.row();

        table.add(loginButton).width(230).pad(10);
        table.add(exitButton).width(230).pad(10);
        table.row();

        table.add(messageLabel).colspan(2).pad(10);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        controller.handleSignUpButtons();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public SelectBox<String> getSecurityQuestionBox() {
        return securityQuestionBox;
    }

    public TextField getSecurityAnswerField() {
        return securityAnswerField;
    }

    public TextButton getSignUpButton() {
        return signUpButton;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public TextButton getExitButton() {
        return exitButton;
    }

    public TextButton getGuestButton() {
        return guestButton;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}
