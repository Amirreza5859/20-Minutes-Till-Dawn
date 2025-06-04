package com.tilldawn.Control;


import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.View.*;

public class MainMenuController {
    private Repository repo;
    private MainMenuView view;
    private boolean buttonHandled = false;

    public MainMenuController(Repository repo) {
        this.repo = repo;
    }

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public Repository getRepo() {
        return repo;
    }

    public void handleMainMenuButtons() {

        if (view.getPreGameMenu().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Pre-Game menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new PreGameMenuView(new PreGameMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getScoreBoard().isPressed() && !buttonHandled) {
            buttonHandled = true;
        }

        else if (view.getProfileMenu().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Profile menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new ProfileMenuView(new ProfileMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getTalentMenu().isPressed() && !buttonHandled) {
            buttonHandled = true;
        }

        else if (view.getSettingMenu().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Setting menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new SettingMenuView(new SettingMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getResumeGame().isPressed() && !buttonHandled) {
            buttonHandled = true;
        }

        else if (view.getLogout().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Login Menu...");

            repo.setCurrentUser(null);
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }
    }
}
