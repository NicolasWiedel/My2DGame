package de.wiedel.my2dgame.chapter42;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class DrawingSpriteSheets extends ApplicationAdapter {

    private AssetManager manager;
    private SpriteBatch batch;
    private Texture sheet;
    private Texture warriorSheet;
    private Animation<TextureRegion> walkDownAnimation;
    private float stateTime;

    @Override
    public void create() {
        manager = new AssetManager();

        // enqueue and block until loaded
        manager.load("platformer/player/slim_.32x32.png", Texture.class);
        manager.load("platformer/player/Warrior.png", Texture.class);
        manager.finishLoading();
        sheet = manager.get("platformer/player/slim_.32x32.png", Texture.class);

        // 4x4 sprite sheet
        warriorSheet = manager.get("platformer/player/slim_.32x32.png", Texture.class);
        TextureRegion[][] warriorArray = TextureRegion.split(warriorSheet, 16, 16);
        TextureRegion[] walkDownFrames = new TextureRegion[4];
        System.arraycopy(warriorArray[0], 0, walkDownFrames, 0, 4);
        walkDownAnimation = new Animation<>(0.1f, walkDownFrames);

        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;

        ScreenUtils.clear(0, 0, 0,1f);

        TextureRegion playerIdle = new TextureRegion(sheet, 0, 0, 32,32);
        TextureRegion currentFrame = walkDownAnimation.getKeyFrame(stateTime);
        // 4x4 sprite sheet


        // Animate warrior

        // draw logo at (100, 150)
        batch.begin();
        batch.draw(playerIdle, 100f, 150f,
            playerIdle.getRegionWidth() * 2, playerIdle.getRegionHeight() * 2);
        batch.draw(currentFrame, 400, 400, 64, 64);
        batch.end();
    }

    @Override
    public void dispose() {
        manager.dispose();
        batch.dispose();
    }
}
