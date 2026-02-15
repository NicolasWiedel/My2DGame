package de.wiedel.my2dgame.chapter23;

import com.badlogic.gdx.Game;

public class My2DGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render(); // delegates tothe active Screen´s render(delta)
    }
}
