package de.wiedel.my2dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class My2DGame221UpdateRenderExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;
    private float x, y;
    private static final float SPEED = 200f;
    private static final Color CORNFLOWER_BLUE = new Color(0.39f, 0.58f, 0.93f, 1f);

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("libgdx.png"));
        x = Gdx.graphics.getWidth() / 2f - image.getWidth() / 2f;
        y = Gdx.graphics.getHeight() / 2f - image.getHeight() / 2f;
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);
        draw();
    }
    private void update(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= SPEED * delta;
        }

        // keep image on Screen
        x = Math.max(0, Math.min(x,Gdx.graphics.getWidth() - image.getWidth()));
        y = Math.max(0, Math.min(y, Gdx.graphics.getHeight() - image.getHeight()));
    }

    private void draw(){
        ScreenUtils.clear(CORNFLOWER_BLUE);

        // Draw image at updated position
        batch.begin();
        batch.draw(image, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
