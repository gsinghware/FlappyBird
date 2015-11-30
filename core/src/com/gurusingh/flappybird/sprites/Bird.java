package com.gurusingh.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by gsingh on 11/27/15.
 */
public class Bird
{
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Bird(int x, int y)
    {
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
        this.bird = new Texture("bird.png");
    }

    public void update(float dt)
    {
        if (this.position.y > 0)
            this.velocity.add(0, this.GRAVITY, 0);

        this.velocity.add(0, GRAVITY, 0);
        this.velocity.scl(dt);
        this.position.add(0, this.velocity.y, 0);

        if (this.position.y < 0)
            this.position.y = 0;

        this.velocity.scl(1/dt);
    }

    public Vector3 getPosition()
    {
        return this.position;
    }

    public Texture getBird() { return bird; }

    public void jump()
    {
        this.velocity.y = 250;
    }
}
