package de.wiedel.my2dgame.chapter44;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class StaticBackgroundExample extends ApplicationAdapter {

    private SpriteCache cache;
    private TextureRegion tileRegion;

    @Override
    public void create() {
        cache = new SpriteCache();

        Texture texture = new Texture("platformer/maps/Tile1.png");
        tileRegion = new TextureRegion(texture, 32, 0, 32, 32);

        cache.beginCache();
        // Draw 10x10 tile grid at (0, 0)
        for (int row = 0; row < 10; row++){
            for (int col = 0; col < 10; col++){
                cache.add(tileRegion, col * 32, row * 32);
            }
        }
        cache.endCache();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);

        cache.begin();
        cache.draw(0);
        cache.end();
    }

    @Override
    public void dispose() {
        cache.dispose();
    }
}
