package de.wiedel.my2dgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import de.wiedel.my2dgame.My2DGame222ScreenAdapter;

public class PlayScreen222 extends ScreenAdapter {

    private final My2DGame222ScreenAdapter game;
    private SpriteBatch batch;
    private Texture player;
    private float x, y;

    public PlayScreen222(My2DGame222ScreenAdapter game){
        this.game = game;
        batch = new SpriteBatch();
        player = new Texture(Gdx.files.internal("libgdx.png"));
        x = Gdx.graphics.getWidth() / 2f - player.getWidth() / 2f;
        y = Gdx.graphics.getHeight() / 2f - player.getHeight() / 2f;
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= My2DGame222ScreenAdapter.SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += My2DGame222ScreenAdapter.SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += My2DGame222ScreenAdapter.SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= My2DGame222ScreenAdapter.SPEED * delta;
        }

        // keep image on Screen
        x = Math.max(0, Math.min(x,Gdx.graphics.getWidth() - player.getWidth()));
        y = Math.max(0, Math.min(y, Gdx.graphics.getHeight() - player.getHeight()));
    }

    private void draw(){
        ScreenUtils.clear(My2DGame222ScreenAdapter.CORNFLOWER_BLUE);

        // Draw image at updated position
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
