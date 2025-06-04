package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tilldawn.Control.ForgetPasswordController;

public class ForgetPasswordView implements Screen {
    private Stage stage;
    private Table table;
    private Skin skin;

    private Label questionLabel;
    private TextField usernameField;
    private TextField answerField;
    private TextButton applyButton;
    private TextButton showButton;
    private TextButton backButton;
    private Label messageLabel;

    private ForgetPasswordController controller;

    public ForgetPasswordView(ForgetPasswordController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        questionLabel = new Label("", skin);
        usernameField = new TextField("", skin);
        answerField = new TextField("", skin);
        applyButton = new TextButton("Apply", skin);
        showButton = new TextButton("Show", skin);
        backButton = new TextButton("Back", skin);
        messageLabel = new Label("", skin);

        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table = new Table(skin);

        table.setFillParent(true);
        table.center();

        table.add(questionLabel).colspan(2).pad(10);
        table.row();

        table.add("username :").pad(10);
        table.add(usernameField).width(250).pad(10);
        table.row();

        table.add("answer :").pad(10);
        table.add(answerField).width(250).pad(10);
        table.row();

        table.add(applyButton).width(230).pad(10);
        table.add(showButton).width(230).pad(10);
        table.row();

        table.add(backButton).width(250).colspan(2).pad(10);
        table.row();

        table.add(messageLabel).colspan(2).pad(10);

        stage.addActor(table);

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        controller.handleForgetPasswordButtons();
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

    public void showQuestion(String question) {
        questionLabel.setText(question);
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getAnswerField() {
        return answerField;
    }

    public TextButton getApplyButton() {
        return applyButton;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public TextButton getShowButton() {
        return showButton;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}
