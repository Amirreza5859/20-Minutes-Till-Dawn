package com.tilldawn.Control;

import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.Model.User;
import com.tilldawn.View.ForgetPasswordView;
import com.tilldawn.View.LoginMenuView;
import com.tilldawn.View.MainMenuView;
import com.tilldawn.View.SignUpMenuView;

public class LoginMenuController {
    private LoginMenuView view;
    private Repository repo;
    private boolean buttonHandled = false;

    public LoginMenuController(Repository repo) {
        this.repo = repo;
    }

    public void setView(LoginMenuView view) {
        this.view = view;
    }

    public void handleLoginMenuButtons() {

        if (view.getLoginButton().isPressed() && !buttonHandled) {
            buttonHandled = true;

            String username = view.getUsernameField().getText();
            String password = view.getPasswordField().getText();

            if (username.isEmpty()) {
                buttonHandled = false;
                view.showMessage("Please enter your username!");
                return;
            }

            if (password.isEmpty()) {
                buttonHandled = false;
                view.showMessage("Please enter your password!");
                return;
            }

            if (repo.getUserByUsername(username) == null) {
                buttonHandled = false;
                view.showMessage("User not found!");
                return;
            }

            if (!repo.getUserByUsername(username).getPassword().equals(password)) {
                buttonHandled = false;
                view.showMessage("Wrong password!");
                return;
            }

            User user = repo.getUserByUsername(username);
            repo.setCurrentUser(user);
            view.showMessage("Login successful!");

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new MainMenuView(new MainMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getForgetPasswordButton().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading forget password...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new ForgetPasswordView(new ForgetPasswordController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getBackButton().isPressed() && !buttonHandled) {
            view.showMessage("Back! Loading Sign Up Menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new SignUpMenuView(new SignUpMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }
    }
}
