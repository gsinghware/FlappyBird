package com.gurusingh.flappybird.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by gsingh on 11/23/15.
 *
 * GameStateManager - manages tge states of the game. i.e. play state, pause state.
 * This game has a stack of states and the state on top of the stack is the
 * one that is displayed. Other states can be pushed on top to replace that state.
 * Stack implementation.
 */
public class GameStateManager
{
    // stack of states
    private Stack<State> states;

    // constructors
    public GameStateManager()
    {
        this.states = new Stack<State>();
    }

    // push a new state on the
    public void push(State state)
    {
        this.states.push(state);
    }

    // pop
    public void pop()
    {
        this.states.pop();
    }

    // set
    public void set(State state)
    {
        this.states.pop();
        this.states.push(state);
    }

    // peak
    public void update(float dt)
    {
        this.states.peek().update(dt);
    }

    // render
    public void render(SpriteBatch sb)
    {
        this.states.peek().render(sb);
    }
}
