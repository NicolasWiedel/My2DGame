package de.wiedel.my2dgame.chapter24;

import com.badlogic.gdx.Game;

public class My2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MethodSplitPlayScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
