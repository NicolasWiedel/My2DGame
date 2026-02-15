package de.wiedel.my2dgame.chapter24;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MethodSplitPlayScreen extends ScreenAdapter {

    private final My2DGame game;
    private SpriteBatch batch;
    private Texture playerTexture;
    private float playerX, playerY;
    private float playerSize = 50f;
    private static final float SPEED = 150f; // px per second

    public MethodSplitPlayScreen(My2DGame game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        playerTexture = new Texture(Gdx.files.internal("mushroom.png"));
        playerX = Gdx.graphics.getWidth() / 2f - playerTexture.getWidth() / 2f;
        playerY = Gdx.graphics.getHeight() / 2f - playerTexture.getHeight() / 2f;
    }

    @Override
    public void render(float delta) {
        // Phase 1: Input and States update
        handleInput(delta);
        updateGameState(delta);
        renderFrame();
    }

    private void handleInput(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            playerX -= SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            playerX += SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            playerY += SPEED * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            playerY -= SPEED * delta;
        }
    }

    private void updateGameState(float delta){
        clampToScreen();
        // Future hooks: updatePhysics(delta), updateAI(delta), etc.
    }

    private void clampToScreen(){
        playerX = Math.max(
            0,
            Math.min(playerX,Gdx.graphics.getWidth() - playerSize)
        );
        playerY = Math.max(
            0,
            Math.min(playerY, Gdx.graphics.getHeight() - playerSize));
    }

    private void renderFrame(){
        ScreenUtils.clear(0.39f, 0.58f, 0.93f, 1f);

        batch.begin();
        batch.draw(playerTexture, playerX, playerY, playerSize, playerSize);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        playerTexture.dispose();
    }
}
