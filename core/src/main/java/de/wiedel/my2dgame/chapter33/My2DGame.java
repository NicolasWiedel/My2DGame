package de.wiedel.my2dgame.chapter33;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

public class My2DGame extends Game {

    private AssetManager manager;

    @Override
    public void create() {
        manager = new AssetManager();
        setScreen(new LoadingScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public AssetManager getManager() {
        return manager;
    }
}
