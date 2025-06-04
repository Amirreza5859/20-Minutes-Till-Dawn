package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tilldawn.Control.ProfileMenuController;

import java.awt.*;

public class ProfileMenuView implements Screen {
    private Stage stage;
    private Table table;
    private final Skin skin;

    private final TextButton changeUsername;
    private final TextButton changePassword;
    private final TextButton changeAvatar;
    private final TextButton deleteAccount;
    private final TextButton backButton;
    private final Label messageLabel;

    private final ProfileMenuController controller;

    public ProfileMenuView(ProfileMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        this.changeUsername = new TextButton("Change Username", skin);
        this.changePassword = new TextButton("Change Password", skin);
        this.changeAvatar = new TextButton("Change Avatar", skin);
        this.deleteAccount = new TextButton("Delete Account", skin);
        this.backButton = new TextButton("Back", skin);
        this.messageLabel = new Label("", skin);

        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);
        table.center();

        table.add(changeUsername).pad(10);
        table.row();

        table.add(changePassword).pad(10);
        table.row();

        table.add(changeAvatar).pad(10);
        table.row();

        table.add(deleteAccount).pad(10);
        table.row();

        table.add(backButton).pad(10);
        table.row();

        table.add(messageLabel).pad(10);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.15f, 1f);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        controller.handleProfileMenubuttons();
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

    public Skin getSkin() {
        return skin;
    }

    public TextButton getChangeUsername() {
        return changeUsername;
    }

    public TextButton getChangePassword() {
        return changePassword;
    }

    public TextButton getChangeAvatar() {
        return changeAvatar;
    }

    public TextButton getDeleteAccount() {
        return deleteAccount;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }

}
