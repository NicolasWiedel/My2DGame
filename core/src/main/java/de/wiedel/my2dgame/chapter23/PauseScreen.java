package de.wiedel.my2dgame.chapter23;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class PauseScreen implements Screen {

    private final My2DGame game;
    private final PlayScreen parent;

    public PauseScreen(My2DGame game, PlayScreen parent){
        this.game = game;
        this.parent = parent;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // dim the gameplay frame
        ScreenUtils.clear(0, 0, 0, 0.5f);

        // Draw pause overlay

        // Resume on escape
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(parent);
            dispose();
        }
    }

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
        // no assets allocated here, so often empty
    }
}
