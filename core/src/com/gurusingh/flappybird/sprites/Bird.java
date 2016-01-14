package com.gurusingh.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by gsingh on 11/27/15.
 */
public class Bird
{
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    private Rectangle bounds;
    private Animation birdAnimation;

    private Texture texture;
    public Bird(int x, int y)
    {
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
        texture = new Texture("birdAnimation.png");
        this.birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        this.bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());

    }

    public void update(float dt)
    {
        birdAnimation.update(dt);
        if (this.position.y > 0)
            this.velocity.add(0, this.GRAVITY, 0);

        this.velocity.add(0, GRAVITY, 0);
        this.velocity.scl(dt);
        this.position.add(MOVEMENT * dt, this.velocity.y, 0);

        if (this.position.y < 0)
            this.position.y = 0;

        this.velocity.scl(1/dt);

        this.bounds.setPosition(this.position.x, this.position.y);

    }

    public Vector3 getPosition() {
        return this.position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public void jump() {
        this.velocity.y = 250;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public void dispose() {
        this.texture.dispose();
    }
}
