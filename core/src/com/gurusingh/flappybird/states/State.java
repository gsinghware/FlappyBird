package com.gurusingh.flappybird.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by gsingh on 11/23/15.
 */

public abstract class State
{
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    // Constructor
    protected State(GameStateManager gsm)
    {
        this.cam = new OrthographicCamera();
        this.mouse = new Vector3();
        this.gsm = gsm;
    }

    // setter functions
    protected abstract void handleInput();
    public abstract void update(float dt);              // dt - delta time, diff in frame render
    public abstract void render(SpriteBatch sb);        // sb - container for render everything on screen
    public abstract void dispose();

}
