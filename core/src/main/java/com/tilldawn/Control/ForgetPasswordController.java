package com.tilldawn.Control;

import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.Model.User;
import com.tilldawn.View.ForgetPasswordView;
import com.tilldawn.View.LoginMenuView;
import com.tilldawn.View.SignUpMenuView;

public class ForgetPasswordController {
    private ForgetPasswordView view;
    private Repository repo;
    private boolean buttonHandled = false;

    public ForgetPasswordController(Repository repo) {
        this.repo = repo;
    }

    public void setView(ForgetPasswordView view) {
        this.view = view;
    }

    public void handleForgetPasswordButtons() {


        if (view.getApplyButton().isPressed() && !buttonHandled) {
            buttonHandled = true;

            String username = view.getUsernameField().getText();
            String answer = view.getAnswerField().getText();

            if (!repo.getUserByUsername(username).getAnswer().equals(answer)) {
                buttonHandled = false;
                view.showMessage("Wrong answer");
                return;
            }

            view.showMessage("Your password is : " + repo.getUserByUsername(username).getPassword());

        }

        else if (view.getBackButton().isPressed() && !buttonHandled) {
            view.showMessage("Loading Login menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new LoginMenuView(new LoginMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 2);
        }

        else if (view.getShowButton().isPressed() && !buttonHandled) {
            buttonHandled = true;

            String username = view.getUsernameField().getText();

            if (repo.getUserByUsername(username) == null) {
                buttonHandled = false;
                view.showMessage("user not found");
                return;
            }
            User user = repo.getUserByUsername(username);
            view.showQuestion(user.getQuestion().getQuestion());
        }

        else {
            buttonHandled = false;
        }
    }
}
