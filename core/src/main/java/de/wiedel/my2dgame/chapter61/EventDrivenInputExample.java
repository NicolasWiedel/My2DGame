package de.wiedel.my2dgame.chapter61;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class EventDrivenInputExample extends ApplicationAdapter implements InputProcessor {

    private SpriteBatch batch;
    private Texture player;
    private float x, y;
    private boolean moveLeft, moveRight, moveUp, moveDown;
    private static final float SPEED = 200f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Texture(Gdx.files.internal("mushroom.png"));
        x = 100f;
        y = 100f;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        // Continuous movement based on flags set in callbacks
        if (moveLeft) x -= SPEED * delta;
        if (moveRight) x += SPEED * delta;
        if (moveUp) y += SPEED * delta;
        if (moveDown) y -= SPEED * delta;

        // Render
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
        if (keycode == Input.Keys.LEFT) moveLeft = true;
        if (keycode == Input.Keys.RIGHT) moveRight = true;
        if (keycode == Input.Keys.UP) moveUp = true;
        if (keycode == Input.Keys.DOWN) moveDown = true;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) moveLeft = false;
        if (keycode == Input.Keys.RIGHT) moveRight = false;
        if (keycode == Input.Keys.UP) moveUp = false;
        if (keycode == Input.Keys.DOWN) moveDown = false;
        return true;
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
