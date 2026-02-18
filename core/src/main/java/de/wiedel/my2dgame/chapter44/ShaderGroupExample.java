package de.wiedel.my2dgame.chapter44;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.ScreenUtils;

// Program does not run because the shader are missing.
public class ShaderGroupExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private ShaderProgram glowShader;
    private Texture entityTexture;
    private TextureRegion idleRegion;
    private Sprite normalSprite, glowSprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        entityTexture = new Texture(Gdx.files.internal("char.png"));
        idleRegion = new TextureRegion(entityTexture, 0, 640, 64,64);

        normalSprite = new Sprite(idleRegion);
        glowSprite = new Sprite(idleRegion);

        // Load simple glow shader
        glowShader = new ShaderProgram(Gdx.files.internal("..."),
            Gdx.files.internal("..."));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);

        batch.begin();
        batch.draw(idleRegion, 100, 100, 128, 128);
        batch.setShader(glowShader);
        glowSprite.setPosition(300, 150);
        glowSprite.draw(batch);
        batch.setShader(null);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        entityTexture.dispose();
        glowShader.dispose();
    }
}
