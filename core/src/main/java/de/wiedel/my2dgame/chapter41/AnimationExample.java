package de.wiedel.my2dgame.chapter41;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class AnimationExample extends ApplicationAdapter {

    private AssetManager manager;
    private SpriteBatch batch;
    private Animation<TextureRegion> walkAnimation;
    private float stateTime;

    @Override
    public void create() {
        manager = new AssetManager();
        // load atlas
        manager.load("atlas/test.atlas", TextureAtlas.class);
        manager.finishLoading();

        TextureAtlas atlas  = manager.get("atlas/test.atlas", TextureAtlas.class);

        // 10 frames per second animation looping
        walkAnimation = new Animation<>(0.1f,
            atlas.findRegions("p1_walk"), Animation.PlayMode.LOOP);
        stateTime = 0f;

        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;

        ScreenUtils.clear(0, 0, 0, 1f);

        // get current frame based on state time
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime);

        batch.begin();
        float x = Gdx.graphics.getWidth() / 2f - currentFrame.getRegionWidth() / 2f;
        float y = Gdx.graphics.getHeight() / 2f - currentFrame.getRegionHeight() / 2f;
        batch.draw(currentFrame, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        manager.dispose();
    }
}
