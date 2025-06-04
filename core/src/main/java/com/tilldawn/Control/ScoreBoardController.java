package com.tilldawn.Control;

import com.tilldawn.Model.Repository;
import com.tilldawn.View.ScoreBoardView;

import javax.swing.text.View;

public class ScoreBoardController {
    private ScoreBoardView view;
    private Repository repo;

    public ScoreBoardController(Repository repo) {
        this.repo = repo;
    }

    public void setView(ScoreBoardView scoreBoardView) {
        this.view = scoreBoardView;
    }
}
