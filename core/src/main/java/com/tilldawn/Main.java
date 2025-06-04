package com.tilldawn;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tilldawn.Control.PreGameMenuController;
import com.tilldawn.Control.SignUpMenuController;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.View.PreGameMenuView;
import com.tilldawn.View.SignUpMenuView;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private final Repository repo = new Repository();
    private static Main main;
    private static SpriteBatch batch;
    private Music backgroundMusic;

    @Override
    public void create() {
        main = this;
        batch = new SpriteBatch();
        //getMain().setScreen(new SignUpMenuView(new SignUpMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
        getMain().setScreen(new PreGameMenuView(new PreGameMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        backgroundMusic.dispose();
    }

    public static Main getMain() {
        return main;
    }

    public static SpriteBatch getBatch() {
        return batch;
    }

    public Music getBackgroundMusic() {
        return backgroundMusic;
    }

}
