package de.wiedel.my2dgame.chapter43;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class ShapeRendererExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture player;
    private float x, y;
    private ShapeRenderer shapeRenderer;
    private static final float SPEED = 120f; // pixel per second

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Texture(Gdx.files.internal("starfish.png"));
        x = Gdx.graphics.getWidth() / 2f - player.getWidth() / 2f;
        y = Gdx.graphics.getHeight() / 2f - player.getHeight() / 2f;
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        handleMovement(delta);

        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);

        // 1. Draw player Sprite
        batch.begin();
        batch.draw(player, x, y);
        batch.end();

        // 2. Draw debug rectangle around sprite
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 0, 0, 1); // red outline
        shapeRenderer.rect(x, y, player.getWidth(), player.getHeight());
        shapeRenderer.end();

        // 3. Draw and fill health bar UI at the top
        float healthPercent = 0.6f; // example 60%
        float barWidth = 200;
        float barHeight = 20;
        float barX = 20;
        float barY = Gdx.graphics.getHeight() - barHeight - 20;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // Background
        shapeRenderer.setColor(0.2f, 0.2f, 0.2f, 1f);
        shapeRenderer.rect(barX, barY, barWidth, barHeight);
        // Fill base on health
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.rect(barX, barY,
            barWidth * healthPercent, barHeight);
        shapeRenderer.end();

        // 4. Draw border around the healt bar
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 1, 1, 1);
        shapeRenderer.rect(barX, barY, barWidth, barHeight);
        shapeRenderer.end();
    }

    private void handleMovement(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -=SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x +=SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            y +=SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -=SPEED * delta;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        shapeRenderer.dispose();
    }
}
