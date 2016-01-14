package com.gurusingh.flappybird.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gurusingh.flappybird.FlappyBird;
import com.gurusingh.flappybird.sprites.Bird;
import com.gurusingh.flappybird.sprites.Tube;


/**
 * Created by gsingh on 11/26/15.
 */
public class PlayState extends State
{
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -30;

    private Bird bird;
    private Texture bg;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm)
    {
        super(gsm);
        this.bird = new Bird(50, 300);
        this.cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
        this.bg = new Texture("bg.png");
        this.tubes = new Array<Tube>();

        for (int i = 1; i <= TUBE_COUNT; i++)
        {
            this.tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }

        this.ground = new Texture("ground.png");
        this.groundPos1 = new Vector2(this.cam.position.x - this.cam.viewportWidth/2, GROUND_Y_OFFSET);
        this.groundPos2 = new Vector2((this.cam.position.x - this.cam.viewportWidth/2) + this.ground.getWidth(), GROUND_Y_OFFSET);
    }

    @Override
    protected void handleInput()
    {
        if (Gdx.input.justTouched()) {
            this.bird.jump();
        }
    }

    @Override
    public void update(float dt)
    {
        this.handleInput();
        this.updateGround();
        this.bird.update(dt);

        this.cam.position.x = this.bird.getPosition().x + 80;

        for (int i = 0; i < this.tubes.size; i++) {
            Tube tube = tubes.get(i);
            if (this.cam.position.x - (this.cam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth())
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));

            if (tube.collide(bird.getBounds()))
                gsm.set(new PlayState(gsm));
        }

        if (this.bird.getPosition().y <= this.ground.getHeight() + this.GROUND_Y_OFFSET) {
            gsm.set(new PlayState(gsm));
        }

        this.cam.update();

    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.setProjectionMatrix(this.cam.combined);
        sb.begin();
        sb.draw(this.bg, this.cam.position.x - (this.cam.viewportWidth / 2), 0);
        sb.draw(this.bird.getBird(), this.bird.getPosition().x, this.bird.getPosition().y);

        for (Tube tube : tubes)
        {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }

        sb.draw(this.ground, this.groundPos1.x, this.groundPos1.y);
        sb.draw(this.ground, this.groundPos2.x, this.groundPos2.y);
        sb.end();
    }

    @Override
    public void dispose()
    {
        this.bg.dispose();
        this.bird.dispose();

        for (Tube tube : this.tubes) {
            tube.dispose();
        }
        this.ground.dispose();
    }

    private void updateGround() {
        if ((this.cam.position.x - this.cam.viewportWidth/2) > (this.groundPos1.x + this.ground.getWidth())) {
            this.groundPos1.add(this.ground.getWidth() * 2, 0);
        }
        if ((this.cam.position.x - this.cam.viewportWidth/2) > (this.groundPos2.x + this.ground.getWidth())) {
            this.groundPos2.add(this.ground.getWidth() * 2, 0);
        }
    }

}
