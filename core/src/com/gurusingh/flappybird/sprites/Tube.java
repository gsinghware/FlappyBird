package com.gurusingh.flappybird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by gsingh on 11/29/15.
 */
public class Tube
{
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBotTube;
    private Random rand;

    public Tube (float x)
    {
        this.topTube = new Texture("toptube.png");
        this.bottomTube = new Texture("bottomtube.png");
        this.rand = new Random();
        this.posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        this.posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - bottomTube.getHeight());
    }


    public Texture getTopTube() { return topTube; }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }
}
