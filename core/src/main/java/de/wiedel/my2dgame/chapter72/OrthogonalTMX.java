package de.wiedel.my2dgame.chapter72;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class OrthogonalTMX extends ApplicationAdapter {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    @Override
    public void create() {
        // load map
        map = new TmxMapLoader().load("Maps/town.tmx");
        // create renderer with unit scale - 32 pixels = 1 unit
        renderer = new OrthogonalTiledMapRenderer(map, 1/32f);

        // set up camera for a 20 x 15 unit viewport
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 20,15);
        camera.update();

        renderer.setView(camera);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);

        // Update camera if moved, then set view again
        camera.update();
        renderer.setView(camera);

        // Draw all layers
        renderer.render();
    }

    @Override
    public void dispose() {
        renderer.dispose();
        map.dispose();
    }
}
