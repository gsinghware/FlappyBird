package com.gurusingh.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

/**
 * Created by gsingh on 11/29/15.
 */
public class Tube
{
    public static final int TUBE_WIDTH = 52;

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;
    private Random rand;

    private Rectangle boundsTop, boundsBot;


    public Tube (float x)
    {
        this.topTube = new Texture("toptube.png");
        this.bottomTube = new Texture("bottomtube.png");
        this.rand = new Random();

        this.posTopTube = new Vector2(x, this.rand.nextInt(this.FLUCTUATION) + this.TUBE_GAP + this.LOWEST_OPENING);
        this.posBotTube = new Vector2(x, this.posTopTube.y - this.TUBE_GAP - this.bottomTube.getHeight());

        this.boundsTop = new Rectangle(this.posTopTube.x, this.posTopTube.y, this.topTube.getWidth(), this.topTube.getHeight());
        this.boundsBot = new Rectangle(this.posBotTube.x, this.posBotTube.y, this.bottomTube.getWidth(), this.bottomTube.getHeight());

    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void reposition(float x)
    {
        this.posTopTube.set(x, this.rand.nextInt(this.FLUCTUATION) + this.TUBE_GAP + this.LOWEST_OPENING);
        this.posBotTube.set(x, this.posTopTube.y - this.TUBE_GAP - this.bottomTube.getHeight());
        this.boundsTop.setPosition(this.posTopTube.x, this.posTopTube.y);
        this.boundsBot.setPosition(this.posBotTube.x, this.posBotTube.y);
    }

    public boolean collide(Rectangle player) {
        return player.overlaps(this.boundsBot) || player.overlaps(this.boundsTop);
    }

    public void dispose()
    {
        this.topTube.dispose();
        this.bottomTube.dispose();
    }
}
