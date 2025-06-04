package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tilldawn.Control.MainMenuController;
import com.tilldawn.Model.User;

public class MainMenuView implements Screen {

    private Stage stage;
    private Table table;
    private Table userInfo;
    private final Skin skin;

    private final TextButton preGameMenu;
    private final TextButton scoreBoard;
    private final TextButton ProfileMenu;
    private final TextButton TalentMenu;
    private final TextButton settingMenu;
    private final TextButton resumeGame;
    private final TextButton logout;
    private final Label messageLabel;

    private final Texture avatarTexture;
    private final Image avatarImage;
    private final Label usernameLabel;
    private final Label scoreLabel;

    private final MainMenuController controller;


    public MainMenuView(MainMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        this.preGameMenu = new TextButton("Pre Game", skin);
        this.scoreBoard = new TextButton("Score Board", skin);
        this.ProfileMenu = new TextButton("Profile", skin);
        this.TalentMenu = new TextButton("Talent", skin);
        this.settingMenu = new TextButton("Settings", skin);
        this.resumeGame = new TextButton("Resume", skin);
        this.logout = new TextButton("Logout", skin);
        this.messageLabel = new Label("", skin);

        User user = controller.getRepo().getCurrentUser();
        String username = user.getUsername();
        int score = user.getScore();
        String imagePath = user.getAvatarPath();

        this.avatarTexture = new Texture(Gdx.files.internal(imagePath));
        this.avatarImage = new Image(avatarTexture);
        avatarImage.setSize(64, 64);
        this.usernameLabel = new Label("User : " + username, skin);
        this.scoreLabel = new Label("Score : " + score, skin);

        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        this.table = new Table(skin);
        table.setFillParent(true);
        table.center();
        table.add(preGameMenu).width(330).pad(10).colspan(2);
        table.row();
        table.add(scoreBoard).width(330).pad(10).colspan(2);
        table.row();
        table.add(ProfileMenu).width(330).pad(10).colspan(2);
        table.row();
        table.add(TalentMenu).width(330).pad(10).colspan(2);
        table.row();
        table.add(settingMenu).width(330).pad(10).colspan(2);
        table.row();
        table.add(resumeGame).width(330).pad(10);
        table.add(logout).width(330).pad(10);
        table.row();

        table.add(messageLabel).colspan(2).width(330).pad(10);

        stage.addActor(table);

        this.userInfo = new Table(skin);
        userInfo.setFillParent(true);
        userInfo.top().left();

        userInfo.pad(100);
        userInfo.add(avatarImage).pad(10);
        userInfo.row();
        userInfo.add(usernameLabel).pad(10);
        userInfo.row();
        userInfo.add(scoreLabel).pad(10);

        stage.addActor(userInfo);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.15f, 1f);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        controller.handleMainMenuButtons();
    }

    @Override
    public void resize(int width, int height) {

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

    public TextButton getPreGameMenu() {
        return preGameMenu;
    }

    public TextButton getScoreBoard() {
        return scoreBoard;
    }

    public TextButton getProfileMenu() {
        return ProfileMenu;
    }

    public TextButton getTalentMenu() {
        return TalentMenu;
    }

    public TextButton getSettingMenu() {
        return settingMenu;
    }

    public TextButton getResumeGame() {
        return resumeGame;
    }

    public TextButton getLogout() {
        return logout;
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }
}

