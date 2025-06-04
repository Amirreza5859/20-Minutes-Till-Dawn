package com.tilldawn.Control;

import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Pregame;
import com.tilldawn.Model.Repository;
import com.tilldawn.View.GameView;
import com.tilldawn.View.PreGameMenuView;

public class PreGameMenuController {
    private final Repository repo;
    private PreGameMenuView view;
    private final Pregame pregame;

    public PreGameMenuController(Repository repo) {
        this.repo = repo;
        this.pregame = new Pregame();
    }

    public void setView(PreGameMenuView view) {
        this.view = view;
    }

    public void handlePreGameMenuButtons() {
        if (view.getPlayButton().isPressed()) {

            String selectedHero = view.getSelectHero().getSelected();
            String selectedWeapon = view.getSelectWeapon().getSelected();
            String selectedDurationStr = view.getSelectDuration().getSelected();

            int duration = parseDuration(selectedDurationStr);

            pregame.setHero(selectedHero);
            pregame.setWeapon(selectedWeapon);
            pregame.setDuration(duration);

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new GameView(new GameController(repo,pregame), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 0.5f);
        }
    }

    private int parseDuration(String durationStr) {
        try {
            return Integer.parseInt(durationStr.split(" ")[0]);
        } catch (Exception e) {
            return 5;
        }
    }
}
