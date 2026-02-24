package de.wiedel.my2dgame.chapter62;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class KeybordExample extends ApplicationAdapter implements InputProcessor {

    private SpriteBatch batch;
    private Texture player;
    private float x, y;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Texture(Gdx.files.internal("mushroom.png"));
        x = 100f;
        y = 100f;
        // Event driven discrete actions
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        // poll continuous movement
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x-= 200 * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x+= 200 * delta;

        ScreenUtils.clear(0, 0, 0, 1f);
        batch.begin();
        batch.draw(player, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.SPACE){
            Gdx.app.log("Input", "Space pressed!");
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
