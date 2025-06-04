package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tilldawn.Control.LoginMenuController;

public class LoginMenuView implements Screen {
    private Stage stage;
    private Table table;
    private Skin skin;

    private TextField usernameField;
    private TextField passwordField;
    private TextButton loginButton;
    private TextButton forgetPasswordButton;
    private TextButton back;
    private Label messageLabel;

    private LoginMenuController controller;

    public LoginMenuView(LoginMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        usernameField = new TextField("", skin);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');
        loginButton = new TextButton("Login", skin);
        forgetPasswordButton = new TextButton("Forget", skin);
        back = new TextButton("Back", skin);
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

        table.add("username :").pad(10);
        table.add(usernameField).width(250).pad(10);
        table.row();

        table.add("password :").pad(10);
        table.add(passwordField).width(250).pad(10);
        table.row();

        table.add(forgetPasswordButton).width(230).pad(10);
        table.add(loginButton).width(230).pad(10);
        table.row();

        table.add(back).width(250).colspan(2).pad(10);
        table.row();

        table.add(messageLabel).colspan(2).pad(10);

        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        controller.handleLoginMenuButtons();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public TextButton getForgetPasswordButton() {
        return forgetPasswordButton;
    }

    public TextButton getBackButton() {
        return back;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}
