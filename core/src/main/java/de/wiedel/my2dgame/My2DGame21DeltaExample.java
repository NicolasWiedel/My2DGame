package de.wiedel.my2dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class My2DGame21DeltaExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;
    private float x;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("libgdx.png"));
        x = 0f;
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();


        x += 100f * deltaTime;

        if(x > Gdx.graphics.getWidth()){
            x= -image.getWidth();
        }

        // Clear Screen
        ScreenUtils.clear(0.39f, 0.58f, 0.93f, 1f);

        batch.begin();
        batch.draw(image, x, Gdx.graphics.getHeight() / 2 - image.getHeight() / 2f);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
