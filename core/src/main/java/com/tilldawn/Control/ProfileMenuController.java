package com.tilldawn.Control;

import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.View.MainMenuView;
import com.tilldawn.View.ProfileMenuView;

public class ProfileMenuController {
    private ProfileMenuView view;
    private Repository repo;
    private boolean buttonHandled = false;

    public ProfileMenuController(Repository repo) {
        this.repo = repo;
    }

    public void setView(ProfileMenuView view) {
        this.view = view;
    }

    public void handleProfileMenubuttons() {
        if (view.getChangeUsername().isPressed() && !buttonHandled) {
            buttonHandled = true;
            //view.ch
        }

        else if (view.getChangePassword().isPressed() && !buttonHandled) {
            buttonHandled = true;
            //view.
        }

        else if (view.getChangeAvatar().isPressed() && !buttonHandled) {
            buttonHandled = true;
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new ProfileMenuView(new ProfileMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getBackButton().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Main menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new MainMenuView(new MainMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }
    }
}
