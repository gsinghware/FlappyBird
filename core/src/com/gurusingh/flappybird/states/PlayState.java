package com.gurusingh.flappybird.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gurusingh.flappybird.FlappyBird;

/**
 * Created by gsingh on 11/26/15.
 */
public class PlayState extends State
{
    private Texture bird;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        bird = new Texture("bird.png");
        this.cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
    }

    @Override
    protected void handleInput()
    {

    }

    @Override
    public void update(float dt)
    {

    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(this.cam.combined);
        sb.begin();
        sb.draw(this.bird, 50, 50);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
