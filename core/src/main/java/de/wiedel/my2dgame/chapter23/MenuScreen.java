package de.wiedel.my2dgame.chapter23;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {

    private final My2DGame game;

    public MenuScreen(My2DGame game){
        this.game = game;
    }

    @Override
    public void show() {
        // load menu assets here (fonts, buttons, textures, etc.)
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // Draw Menu UI here

        //transition on ENTER key
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            game.setScreen(new PlayScreen(game));
            dispose();
        }
    }

    // other Screen methods
    @Override
    public void resize(int width, int height) {    }

    @Override
    public void pause() {    }

    @Override
    public void resume() {    }

    @Override
    public void hide() {    }

    @Override
    public void dispose() {
        // unload menu assets here
    }
}
