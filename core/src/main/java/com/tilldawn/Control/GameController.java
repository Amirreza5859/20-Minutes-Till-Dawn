package com.tilldawn.Control;

import com.tilldawn.Model.*;
import com.tilldawn.Model.Enums.HeroType;
import com.tilldawn.View.GameView;

public class GameController {
    private Repository repo;
    private Pregame pregame;
    private GameView view;
    private PlayerController playerController;
    private WorldController worldController;
    private WeaponController weaponController;

    public GameController(Repository repo, Pregame pregame) {
        this.repo = repo;
        this.pregame = pregame;
    }


    public void setView(GameView view) {
        this.view = view;
        playerController = new PlayerController(new Player(HeroType.SHANA));
        worldController = new WorldController(playerController);
        weaponController = new WeaponController(new Weapon());
    }

    public void updateGame() {
            worldController.update();
            playerController.update();
            weaponController.update();
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public WeaponController getWeaponController() {
        return weaponController;
    }
}
