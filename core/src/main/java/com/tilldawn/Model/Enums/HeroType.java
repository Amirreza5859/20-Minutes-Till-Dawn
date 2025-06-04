package com.tilldawn.Model.Enums;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public enum HeroType {
    SHANA("Shana", 4, 5, "1/", 6);

    private final String name;
    private final float hp;
    private final float speed;
    private final String idlePathPrefix;
    private final int idleFrameCount;

    private Texture idleTexture;
    private Animation<Texture> idleAnimation;

    HeroType(String name, float hp, float speed, String idlePathPrefix, int idleFrameCount) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.idlePathPrefix = idlePathPrefix;
        this.idleFrameCount = idleFrameCount;
    }

    public String getName() {
        return name;
    }

    public float getHp() {
        return hp;
    }

    public float getSpeed() {
        return speed;
    }

    public Texture getIdleTexture() {
        if (idleTexture == null) {
            idleTexture = new Texture(idlePathPrefix + "Idle_0.png");
        }
        return idleTexture;
    }

    public Animation<Texture> getIdleAnimation() {
        if (idleAnimation == null) {
            Texture[] frames = new Texture[idleFrameCount];
            for (int i = 0; i < idleFrameCount; i++) {
                frames[i] = new Texture(idlePathPrefix + "Idle_" + i + ".png");
            }
            idleAnimation = new Animation<>(0.1f, frames);
        }
        return idleAnimation;
    }
}
