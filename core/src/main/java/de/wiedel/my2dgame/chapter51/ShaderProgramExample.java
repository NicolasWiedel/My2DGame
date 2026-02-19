package de.wiedel.my2dgame.chapter51;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ScreenUtils;

public class ShaderProgramExample extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture tex;
    private ShaderProgram shader;

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
            throw new GdxRuntimeException("Shader compile error:\n" + shader.getLog());
        }

        // load texture
        tex = new Texture(Gdx.files.internal("mushroom.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);

        // Bind custom shader
        batch.setShader(shader);
        batch.begin();
        batch.draw(tex, 100, 100, 50, 50);
        batch.end();
        batch.setShader(null);
    }

    @Override
    public void dispose() {
        batch.dispose();
        tex.dispose();
        shader.dispose();
    }
}
