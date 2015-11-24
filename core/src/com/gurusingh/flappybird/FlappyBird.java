package com.gurusingh.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gurusingh.flappybird.States.GameStateManager;
import com.gurusingh.flappybird.States.MenuState;

public class FlappyBird extends ApplicationAdapter
{
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Flappy Bird";

	private GameStateManager gsm;
	private SpriteBatch batch;
	
	@Override
	public void create ()
	{
		this.batch = new SpriteBatch();
		this.gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		this.gsm.push(new MenuState(this.gsm));
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.gsm.update(Gdx.graphics.getDeltaTime());
		this.gsm.render(batch);
	}
}
