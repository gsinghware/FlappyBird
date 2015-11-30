package com.gurusingh.flappybird.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gurusingh.flappybird.FlappyBird;
import com.gurusingh.flappybird.sprites.Bird;

/**
 * Created by gsingh on 11/26/15.
 */
public class PlayState extends State
{
    private Bird bird;
    private Texture bg;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        this.bird = new Bird(50, 300);
        this.cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
        this.bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput()
    {
        if (Gdx.input.justTouched())
        {
            this.bird.jump();
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
        this.bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(this.cam.combined);
        sb.begin();
        sb.draw(this.bg, this.cam.position.x - (this.cam.viewportWidth / 2), 0);
        sb.draw(this.bird.getBird(), this.bird.getPosition().x, this.bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose()
    {

    }
}
