package com.tilldawn.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.Enums.Question;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.Model.User;
import com.tilldawn.View.LoginMenuView;
import com.tilldawn.View.MainMenuView;
import com.tilldawn.View.SignUpMenuView;

public class SignUpMenuController {
    private final Repository repo;
    private SignUpMenuView view;
    private boolean buttonHandled = false;

    public SignUpMenuController(Repository repo) {
        this.repo = repo;
    }

    public void setView(SignUpMenuView view) {
        this.view = view;
    }

    public void handleSignUpButtons() {

        if (view.getSignUpButton().isPressed() && !buttonHandled) {
            buttonHandled = true;

            String username = view.getUsernameField().getText().trim();
            String password = view.getPasswordField().getText().trim();
            String question = view.getSecurityQuestionBox().getSelected();
            String answer = view.getSecurityAnswerField().getText().trim();

            if (username.isEmpty()) {
                view.showMessage("Please fill username field.");
                buttonHandled = false;
                return;
            }

            if (repo.getUserByUsername(username) != null) {
                view.showMessage("Username is already in use.");
                buttonHandled = false;
                return;
            }

            if (password.isEmpty()) {
                view.showMessage("Please fill password field.");
                buttonHandled = false;
                return;
            }

            if (!isValidPassword(password)) {
                view.showMessage("Password format is invalid!");
                buttonHandled = false;
                return;
            }

            if (answer.isEmpty()) {
                view.showMessage("Please fill answer field.");
                buttonHandled = false;
                return;
            }

            String avatar = getRandomAvatarPath();

            User user = new User(username, password, Question.fromText(question), answer, avatar);
            repo.addUser(user);
            view.showMessage("Account created successfully!");

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getGuestButton().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Pre-Game Menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new MainMenuView(new MainMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getLoginButton().isPressed() && !buttonHandled) {
            buttonHandled = true;
            view.showMessage("Loading Login Menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getExitButton().isPressed() && !buttonHandled) {
            Gdx.app.exit();
            buttonHandled = true;
        }
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@%$#&*()_]).{8,}$");
    }

    private String getRandomAvatarPath() {
        String[] avatars = {
            "avatars/avatar1.png",
            "avatars/avatar2.png",
            "avatars/avatar3.png",
            "avatars/avatar4.png",
            "avatars/avatar5.png",
            "avatars/avatar6.png",
            "avatars/avatar7.png",
            "avatars/avatar8.png",
        };
        return avatars[MathUtils.random(avatars.length - 1)];
    }

}
