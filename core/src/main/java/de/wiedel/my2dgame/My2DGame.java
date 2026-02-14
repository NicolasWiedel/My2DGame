package de.wiedel.my2dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class My2DGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.log("My2DGame", "create() called");
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render() {
        // called every frame(-60times per second)
        float deltaTime = Gdx.graphics.getDeltaTime();
        Gdx.app.log("My2DGame", "render() deltaTime; " + deltaTime);

        // Clear Screen
        ScreenUtils.clear(0.39f, 0.58f, 0.93f, 1f);

        // Draw "Hello LibGDX" at coordinates 100, 150
        batch.begin();
        font.draw(batch, "Hello LibGDX!", 100, 150);
        batch.end();
    }

    @Override
    public void dispose() {
        Gdx.app.log("My2DGame", "dispose() called");
        batch.dispose();
        font.dispose();
    }
}
