package de.wiedel.my2dgame.chapter41;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StaticTextureExample extends ApplicationAdapter {

    private AssetManager manager;
    private SpriteBatch batch;
    private Texture logo;

    @Override
    public void create() {
        manager = new AssetManager();
        // enqueue and block until loaded
        manager.load("libgdx.png", Texture.class);
        manager.finishLoading();

        logo = manager.get("libgdx.png", Texture.class);

        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0,1f);

        // draw logo at (100, 150)
        batch.begin();
        batch.draw(logo, 100f, 150f);
        batch.end();
    }

    @Override
    public void dispose() {
        manager.dispose();
        batch.dispose();
    }
}
