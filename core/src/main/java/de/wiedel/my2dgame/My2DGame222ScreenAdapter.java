package de.wiedel.my2dgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import de.wiedel.my2dgame.screens.PlayScreen222;

public class My2DGame222ScreenAdapter extends Game {

    public static final float SPEED = 200f;
    public static final Color CORNFLOWER_BLUE = new Color(0.39f, 0.58f, 0.93f, 1f);


    @Override
    public void create() {
        setScreen(new PlayScreen222(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
