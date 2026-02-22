package de.wiedel.my2dgame.chapter51;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ScreenUtils;

public class ShaderProgramExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture sprite;
    private ShaderProgram shader;
    private float time;

    @Override
    public void create() {
        //// Allow missing GLSL precission qualifiers
        ShaderProgram.pedantic = false;

        // Read shader from source
        String vert = Gdx.files.internal("shaders/default.vert").readString();
        String frag = Gdx.files.internal("shaders/default.frag").readString();

        // compile link into ShaderProgram
        shader = new ShaderProgram(vert, frag);
        if(!shader.isCompiled()){
            Gdx.app.error("ShaderError", shader.getLog());
            Gdx.app.exit();
        }

        // load texture
        sprite = new Texture(Gdx.files.internal("mushroom.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        time += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1f);

        // Bind custom shader
        batch.setShader(shader);
        shader.bind();
        shader.setUniformf("u_time", time);

        batch.begin();
        batch.draw(sprite, 100, 100, 50, 50);
        batch.end();
        batch.setShader(null);
    }

    @Override
    public void dispose() {
        batch.dispose();
        sprite.dispose();
        shader.dispose();
    }
}
