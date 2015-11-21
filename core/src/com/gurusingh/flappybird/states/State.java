package com.gurusingh.flappybird.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by gsingh on 11/21/15.
 */
public abstract class State
{
    // camera - used to locate position in the world
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    // constructor
    protected State(GameStateManager gsm)
    {
        this.gsm = gsm;
        this.cam = new OrthographicCamera();
        this.mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);              // dt - diff in frame rendered
    public abstract void render(SpriteBatch sb);        // renders everythingon the screen

}
