package com.tilldawn.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tilldawn.Model.Enums.HeroType;

public class Player {
    private final HeroType heroType;
    private final Sprite playerSprite;

    private float posX;
    private float posY;
    private float playerHealth;
    private float time = 0f;
    private boolean isPlayerIdle = true;
    private boolean isPlayerRunning = false;
    private final CollisionRect rect;

    public Player(HeroType heroType) {
        this.heroType = heroType;
        this.playerHealth = heroType.getHp();

        Texture idleTexture = heroType.getIdleTexture();
        this.playerSprite = new Sprite(idleTexture);
        this.posX = Gdx.graphics.getWidth() / 2f;
        this.posY = Gdx.graphics.getHeight() / 2f;

        playerSprite.setPosition(posX, posY);
        playerSprite.setSize(idleTexture.getWidth() * 3, idleTexture.getHeight() * 3);
        rect = new CollisionRect(posX, posY, idleTexture.getWidth() * 3, idleTexture.getHeight() * 3);
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public float getSpeed() {
        return heroType.getSpeed();
    }

    public float getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(float playerHealth) {
        this.playerHealth = playerHealth;
    }

    public CollisionRect getRect() {
        return rect;
    }

    public boolean isPlayerIdle() {
        return isPlayerIdle;
    }

    public void setPlayerIdle(boolean playerIdle) {
        isPlayerIdle = playerIdle;
    }

    public boolean isPlayerRunning() {
        return isPlayerRunning;
    }

    public void setPlayerRunning(boolean playerRunning) {
        isPlayerRunning = playerRunning;
    }

    public float getTime() {
        return time;
    }

    public void updateTime(float delta) {
        this.time += delta;
    }

    public Texture getCurrentFrame() {
        return heroType.getIdleAnimation().getKeyFrame(time, true);
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
