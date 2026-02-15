package de.wiedel.my2dgame.chapter31;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SyncLoadExample extends ApplicationAdapter {

    private AssetManager manager;
    private SpriteBatch batch;
    private Texture logo;

    @Override
    public void create() {
        batch = new SpriteBatch();
        manager = new AssetManager();
        // Queue up only the assets needed immediately
        manager.load("libgdx.png", Texture.class);
        // Block until the logo is ready
        manager.finishLoading();

        logo = manager.get("libgdx.png", Texture.class);
        // you can now render the logo
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.39f, 0.58f, 0.93f, 1f);

        batch.begin();
        batch.draw(logo, Gdx.graphics.getWidth() / 2f - logo.getWidth() / 2f,
            Gdx.graphics.getHeight() / 2f - logo.getHeight() / 2f);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        manager.dispose();
    }
}
