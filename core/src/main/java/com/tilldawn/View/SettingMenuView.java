package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tilldawn.Control.SettingMenuController;

public class SettingMenuView implements Screen {
    private Stage stage;
    private Table table;
    private Skin skin;

    private TextButton toggleMusicButton;
    private TextButton volumeUpButton;
    private TextButton volumeDownButton;
    private SelectBox<String> musicSelectBox;
    private TextButton backButton;
    private Label messageLabel;

    private SettingMenuController controller;

    public SettingMenuView(SettingMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        toggleMusicButton = new TextButton("Mute / Unmute", skin);
        volumeUpButton = new TextButton("Volume +", skin);
        volumeDownButton = new TextButton("Volume -", skin);
        musicSelectBox = new SelectBox<>(skin);
        musicSelectBox.setItems("Track 1", "Track 2", "Track 3");
        backButton = new TextButton("Back", skin);
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

        table.add(toggleMusicButton).pad(10);
        table.row();

        table.add(volumeUpButton).pad(10);
        table.row();

        table.add(volumeDownButton).pad(10);
        table.row();

        table.add(new Label("Select Music:", skin)).pad(5);
        table.row();
        table.add(musicSelectBox).pad(10);
        table.row();

        table.add(backButton).pad(10);
        table.row();

        table.add(messageLabel).pad(10);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.15f, 1f);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.handleButtons();
    }

    @Override public void resize(int w, int h) { stage.getViewport().update(w, h, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { stage.dispose(); }

    public TextButton getToggleMusicButton() { return toggleMusicButton; }
    public TextButton getVolumeUpButton() { return volumeUpButton; }
    public TextButton getVolumeDownButton() { return volumeDownButton; }
    public SelectBox<String> getMusicSelectBox() { return musicSelectBox; }
    public TextButton getBackButton() { return backButton; }
    public void showMessage(String message) { messageLabel.setText(message); }
}
