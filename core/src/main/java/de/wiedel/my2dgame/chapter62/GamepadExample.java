package de.wiedel.my2dgame.chapter62;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.controllers.ControllerMapping;

public class GamepadExample extends ApplicationAdapter implements ControllerListener {

    private SpriteBatch batch;
    private Texture avatar;
    private float x, y;

    @Override
    public void create() {
        batch = new SpriteBatch();
        avatar = new Texture("mushroom.png");
        x = 200f;
        y = 200f;

        Controllers.addListener(this);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);
        batch.begin();
        batch.draw(avatar, x, y);
        batch.end();

        // Poll left stick for continuous movement
        Controller c = Controllers.getCurrent();
        if (c != null){
            //float lx = c.getAxis();
            //float ly = c.getAxis();
            Gdx.app.log("Controller", c.getName());
        }
    }

    @Override
    public void connected(Controller controller) {

    }

    @Override
    public void disconnected(Controller controller) {

    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        return false;
    }
}
