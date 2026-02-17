package de.wiedel.my2dgame.chapter33;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class LoadingScreen implements Screen {

    private final My2DGame game;
    private final AssetManager manager;
    private final SpriteBatch batch;
    private final Texture barEmpty, barFill;
    private final BitmapFont font;

    private float timer;
    private float status;

    public LoadingScreen(My2DGame game){
        this.game = game;
        this.manager= game.getManager();
        batch = new SpriteBatch();
        timer = 0f;
        status = 0;

        // Phase 1: Load only loading UI assets
        manager.load("ui/bar_empty.png", Texture.class); // ****
        manager.load("ui/bar_fill.png", Texture.class);  // ****
        manager.load("fonts/cooper.fnt", BitmapFont.class);  // ****
        manager.finishLoading();

        barEmpty = manager.get("ui/bar_empty.png", Texture.class);
        barFill = manager.get("ui/bar_fill.png", Texture.class);
        font = manager.get("fonts/cooper.fnt", BitmapFont.class);

        // Phase 2: enqueue all game assets
        // manager.load("platformer/player/slim_.32x32.png", Texture.class);  // ****
        // manager.load("platformer/enemies/enemy1/globin1.png", Texture.class);  // ****
        //manager.load("audio/jump.wav", Sound.class);  // ****
        //manager.load("audio/music.mp3", Music.class);  // ****
        // ....
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Load up to 16 ms of assets this frame (=60 fps cap)
        //boolean done = manager.update(16);
//        if (done){
//            //game.setScreen(new PlayScreen(game));
//            //dispose();
//            return;
//        }

        // calculate progress (0...1)
        // float progress = manager.getProgress();

        // clear screen
        ScreenUtils.clear(1, 0, 0,1f);

        timer += delta;

        // Trigger every 0,5 seconds
        if(timer >= 0.5f){
            timer -= 0.5f; // subtract instead of reset to avoid drift
            status += 0.05f;
            if (status >= 1f){
                game.setScreen(new PlayScreen(game));
            }
        }

        drawLoadingBar();
    }

    private void drawLoadingBar(){
        // Draw loading bar and percentage
        batch.begin();
        float x = Gdx.graphics.getWidth() / 2f - barEmpty.getWidth() / 2f;
        float y = Gdx.graphics.getHeight() / 2f - barEmpty.getHeight() / 2f;
        float width = barEmpty.getWidth() * status;
        batch.draw(barEmpty, x, y);
        batch.draw(barFill, x, y, width, barFill.getHeight());
        font.draw(batch,
            String.format("Loading %d%%",
                (int)(status * 100)),
            x + 140, y + barEmpty.getHeight() + 50);
        batch.end();
    }

    // not working method, only for example
    private void unloadAssets(){
        // Suppose levelAssist is a list of file names you loaded from a level
        List<String> levelAssets = new ArrayList<String>();
        for (String assetPath : levelAssets){
            if (manager.isLoaded(assetPath)){
                manager.unload(assetPath);
            }
        }

        // removes all assets and pending (ausstehend) loads
        manager.clear();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
