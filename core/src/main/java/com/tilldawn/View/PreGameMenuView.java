package com.tilldawn.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.tilldawn.Control.PreGameMenuController;
import com.tilldawn.Main;

public class PreGameMenuView implements Screen {

    private Stage stage;
    private Table table;
    private Skin skin;

    private final Label gameTitle;
    private final Label heroTitle;
    private final SelectBox<String> selectHero;
    private final Label weaponTitle;
    private final SelectBox<String> selectWeapon;
    private final Label duration;
    private final SelectBox<String> selectDuration;
    private final TextButton playButton;

    private final PreGameMenuController controller;

    public PreGameMenuView(PreGameMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;

        this.gameTitle = new Label("Pregame Menu", skin);
        gameTitle.setFontScale(2f);
        this.heroTitle = new Label("Hero:", skin);
        this.weaponTitle = new Label("Weapon:", skin);
        this.duration = new Label("Game Time:", skin);
        selectHero = new SelectBox<>(skin);
        selectHero.setItems(
            "SHANA",
            "DIAMOND",
            "SCARLET",
            "LILITH",
            "DASHER"
        );

        selectWeapon = new SelectBox<>(skin);
        selectWeapon.setItems(
            "weapon1",
            "weapon2",
            "weapon3"
        );

        selectDuration = new SelectBox<>(skin);
        selectDuration.setItems(
            "2 min",
            "5 min",
            "10 min",
            "20 min"
        );
        this.playButton = new TextButton("Play", skin);

        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);
        table.center();

        table.add(gameTitle).pad(10);
        table.row();
        table.add(heroTitle).pad(10);
        table.row();
        table.add(selectHero).pad(10).width(300);
        table.row();
        table.add(weaponTitle).pad(10);
        table.row();
        table.add(selectWeapon).pad(10).width(300);
        table.row();
        table.add(duration).pad(10);
        table.row();
        table.add(selectDuration).pad(30).width(300);
        table.row();
        table.add(playButton);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.handlePreGameMenuButtons();
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

    public TextButton getPlayButton() {
        return playButton;
    }

    public SelectBox<String> getSelectHero() {
        return selectHero;
    }

    public SelectBox<String> getSelectWeapon() {
        return selectWeapon;
    }

    public SelectBox<String> getSelectDuration() {
        return selectDuration;
    }

}
