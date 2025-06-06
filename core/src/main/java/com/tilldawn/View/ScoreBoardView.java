package com.tilldawn.View;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.tilldawn.Control.ScoreBoardController;

public class ScoreBoardView implements Screen {
    private Stage stage;
    private Table table;
    private final Skin skin;


    private final ScoreBoardController controller;

    public ScoreBoardView(ScoreBoardController controller, Skin skin) {
        this.controller = controller;

        this.skin = skin;
        controller.setView(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

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
}
