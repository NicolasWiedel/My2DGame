package de.wiedel.my2dgame.chapter14;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Chapter14 extends ApplicationAdapter {

    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.log("Chapter14", "create() called");
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        Gdx.app.log("Chapter14", "render() deltaTime: " +delta);

        ScreenUtils.clear(0.39f, 0.58f, 0.93f, 1f);

        batch.begin();
        font.draw(batch, "Hello LibGDX!", 100, 150);
        batch.end();
    }
}
