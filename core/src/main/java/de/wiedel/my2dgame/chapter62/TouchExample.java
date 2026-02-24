package de.wiedel.my2dgame.chapter62;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TouchExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture touchDot;

    @Override
    public void create() {
        batch = new SpriteBatch();
        touchDot = new Texture("mushroom.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);

        batch.begin();
        for (int p = 0; p< 5; p++){
            if (Gdx.input.isTouched(p)){
                float tx = Gdx.input.getY(p);
                float ty = Gdx.graphics.getHeight() - Gdx.input.getY(p);
                batch.draw(touchDot, tx - 16, ty - 16);
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        touchDot.dispose();
    }
}
