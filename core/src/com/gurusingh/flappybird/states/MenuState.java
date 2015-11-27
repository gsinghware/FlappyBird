package com.gurusingh.flappybird.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.gurusingh.flappybird.FlappyBird;

/**
 * Created by gsingh on 11/24/15.
 */
public class MenuState extends State
{
    private Texture background;
    private Texture playbtn;

    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        this.background = new Texture("bg.png");
        playbtn = new Texture("playBtn.png");
    }

    @Override
    public void handleInput()
    {
        if (Gdx.input.justTouched())
        {
            this.gsm.set(new PlayState(gsm));
            this.dispose();
        }
    }

    @Override
    public void update(float dt)
    {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(this.background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        sb.draw(this.playbtn, (FlappyBird.WIDTH / 2) - (playbtn.getWidth() / 2), FlappyBird.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose()
    {
        this.background.dispose();
        this.playbtn.dispose();
    }
}
