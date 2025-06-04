package com.tilldawn.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.tilldawn.Main;
import com.tilldawn.Model.GameAssetManager;
import com.tilldawn.Model.Repository;
import com.tilldawn.View.MainMenuView;
import com.tilldawn.View.SettingMenuView;

public class SettingMenuController {

    private SettingMenuView view;
    private Repository repo;
    private boolean buttonHandled = false;

    private Music[] tracks;
    private Music currentTrack;
    private int currentTrackIndex = 0;

    public SettingMenuController(Repository repo) {
        this.repo = repo;

        tracks = new Music[3];
        tracks[0] = Gdx.audio.newMusic(Gdx.files.internal("audio/song1.mp3"));
        tracks[1] = Gdx.audio.newMusic(Gdx.files.internal("audio/song2.mp3"));
        tracks[2] = Gdx.audio.newMusic(Gdx.files.internal("audio/song3.mp3"));

        for (Music music : tracks) {
            music.setLooping(true);
            music.setVolume(0.5f);
        }

        currentTrack = tracks[0];
        currentTrack.play();
    }

    public void setView(SettingMenuView view) {
        this.view = view;
    }

    public void handleButtons() {
        if (buttonHandled) return;

        if (view.getToggleMusicButton().isPressed()) {
            buttonHandled = true;
            if (currentTrack.isPlaying()) {
                currentTrack.pause();
                view.showMessage("Music paused.");
            } else {
                currentTrack.play();
                view.showMessage("Music playing.");
            }
            resetButtonHandled();
        }

        else if (view.getVolumeUpButton().isPressed()) {
            buttonHandled = true;
            float volume = Math.min(1f, currentTrack.getVolume() + 0.1f);
            currentTrack.setVolume(volume);
            view.showMessage("Volume: " + (int)(volume * 100) + "%");
            resetButtonHandled();
        }

        else if (view.getVolumeDownButton().isPressed()) {
            buttonHandled = true;
            float volume = Math.max(0f, currentTrack.getVolume() - 0.1f);
            currentTrack.setVolume(volume);
            view.showMessage("Volume: " + (int)(volume * 100) + "%");
            resetButtonHandled();
        }

        else if (!view.getMusicSelectBox().getSelected().equals("Track " + (currentTrackIndex + 1))) {
            buttonHandled = true;
            int newIndex = view.getMusicSelectBox().getSelectedIndex();
            if (newIndex != currentTrackIndex) {
                currentTrack.stop();
                currentTrackIndex = newIndex;
                currentTrack = tracks[currentTrackIndex];
                currentTrack.play();
                view.showMessage("Now playing: Track " + (currentTrackIndex + 1));
            }
            resetButtonHandled();
        }

        else if (view.getBackButton().isPressed()) {
            buttonHandled = true;
            view.showMessage("Returning to main menu...");
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    Main.getMain().setScreen(new MainMenuView(new MainMenuController(repo), GameAssetManager.getGameAssetManager().getSkin()));
                }
            }, 1f);
        }
    }

    private void resetButtonHandled() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                buttonHandled = false;
            }
        }, 0.3f);
    }
}
