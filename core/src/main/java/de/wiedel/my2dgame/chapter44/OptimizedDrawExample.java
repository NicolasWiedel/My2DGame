package de.wiedel.my2dgame.chapter44;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class OptimizedDrawExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture playerTexture;
    private Animation<TextureRegion> walkRightAnimation;
    private Animation<TextureRegion> walkLeftAnimation;
    private Animation<TextureRegion> walkUpAnimation;
    private Animation<TextureRegion> walkDownAnimation;
    private TextureRegion[] walkRightFrames;
    private TextureRegion[] walkLeftFrames;
    private float stateTime;

    @Override
    public void create() {
        batch = new SpriteBatch();
        playerTexture = new Texture(Gdx.files.internal("char.png"));

        // create the animations
        TextureRegion[][] playerArray = TextureRegion.split(playerTexture,64, 64);
        walkRightFrames = new TextureRegion[9];

        stateTime = 0f;
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;

        // clear screen
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);

        // Single batch for all PlayerSprites
        batch.begin();

        // draw first animation
        TextureRegion walkRightFrame = walkRightAnimation.getKeyFrame(stateTime);
        batch.draw(walkRightFrame, 50, 100);

        // draw second Animation
        TextureRegion walkLeftFrame = walkLeftAnimation.getKeyFrame(stateTime);
        batch.draw(walkLeftFrame, 200, 100);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        playerTexture.dispose();
    }
}
