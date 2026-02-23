package de.wiedel.my2dgame.chapter61;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PollingInputExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture player;
    private float x, y;
    private static final float SPEED = 200f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Texture(Gdx.files.internal("mushroom.png"));
        // Start in center
        x = Gdx.graphics.getWidth() / 2f - player.getWidth() / 2f;
        y = Gdx.graphics.getHeight() / 2f - player.getHeight() / 2f;
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        // Poll keyboard for arrow keys
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= SPEED * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += SPEED * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += SPEED * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= SPEED * delta;

        // Poll mouse/touch: jump to touch position
        if (Gdx.input.isTouched()){
            x = Gdx.input.getX() - player.getWidth() / 2f;
            y = Gdx.graphics.getHeight() - Gdx.input.getY() - player.getHeight() / 2f;
        }

        // Render sprite and update position
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
}
