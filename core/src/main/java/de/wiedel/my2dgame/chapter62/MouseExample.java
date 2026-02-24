package de.wiedel.my2dgame.chapter62;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MouseExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture curserTex;

    @Override
    public void create() {
        batch = new SpriteBatch();
        curserTex = new Texture("mushroom.png");
    }

    @Override
    public void render() {
        // Poll for click
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            int mx = Gdx.input.getX();
            int my = Gdx.graphics.getHeight()- Gdx.input.getY();
            Gdx.app.log("Mouse", "Clicked at " + mx + ", " + my);
        }

        // Always draw custom cursor
        ScreenUtils.clear(0, 0, 0, 1f);
        batch.begin();
        float mx = Gdx.input.getX();
        float my = Gdx.graphics.getHeight() - Gdx.input.getY();
        batch.draw(curserTex, mx - 8, my - 8);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        curserTex.dispose();
    }
}
