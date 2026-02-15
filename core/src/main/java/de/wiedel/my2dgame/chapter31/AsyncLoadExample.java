package de.wiedel.my2dgame.chapter31;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AsyncLoadExample extends ApplicationAdapter {

    private AssetManager manager;
    private Texture starTexture, mushroomTexture;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        manager = new AssetManager();
        // Enqueue everything up front
        manager.load("mushroom.png", Texture.class);
        manager.load("starfish.png", Texture.class);
    }

    @Override
    public void render() {
        //boolean finished = manager.update(16);
        // update returns true, wan all assets finish loading
        if (manager.update()){
            // Retrieve assets and render them
            starTexture = manager.get("starfish.png", Texture.class);
            mushroomTexture = manager.get("mushroom.png", Texture.class);

            batch.begin();
            batch.draw(mushroomTexture, Gdx.graphics.getWidth() / 4f - mushroomTexture.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f - mushroomTexture.getHeight() / 2f);
            batch.draw(starTexture, Gdx.graphics.getWidth() / 4f  * 3f - starTexture.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f -starTexture.getHeight() / 2f);
            batch.end();
        } else {
            // Display progress
            float progress = manager.getProgress();
            Gdx.app.log("Assetmanager progress", progress * 100 + "%!");
        }
    }

    @Override
    public void dispose() {
        manager.dispose();
        batch.dispose();
    }
}
