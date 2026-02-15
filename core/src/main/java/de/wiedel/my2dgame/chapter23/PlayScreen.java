package de.wiedel.my2dgame.chapter23;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayScreen implements Screen {

    private final My2DGame game;

    // Game specific fields (player, enemies, world, etc)

    public PlayScreen(My2DGame game){
        this.game = game;
        // initialize gameplay assets
    }

    @Override
    public void show() {
        // called, when this screen becomes active
    }

    @Override
    public void render(float delta) {
        // On-screen logic and drawing
        updateGameLogic(delta);
        drawGameFrame();

        // pause transition
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(new PauseScreen(game, this));
        }
    }

    private void updateGameLogic(float delta){
        // your movement, collision, scoring, etc
    }

    private void drawGameFrame(){
        ScreenUtils.clear(0.1f,0.1f,0.1f,1f);
        // batch draw calls here
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
        // clean up game assets
    }
}
