package de.wiedel.my2dgame.chapter73;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class TiledCollisionExample extends ApplicationAdapter {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private static final float UNIT_SCALE = 1/32f;

    @Override
    public void create() {
        // 1. load map and renderer
        map = new TmxMapLoader().load("Maps/mymap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, UNIT_SCALE);

        // 2. Set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 20, 15);
        camera.update();

        // 3. Initialize Box2D world (no gravity for top-down)
        world = new World(new Vector2(0, 0),true);
        debugRenderer = new Box2DDebugRenderer();

        // 4. Parse collision objects
        MapObjects objects = map.getLayers().get("Collision").getObjects();

        for (MapObject object : objects){
            if (object instanceof RectangleMapObject){
                createStaticBody((RectangleMapObject) object);
            }
            else if (object instanceof PolygonMapObject){
                createStaticBody((PolygonMapObject) object);
            }
            else if (object instanceof CircleMapObject){
                createStaticBody((CircleMapObject) object);
            }
            // Add support for PolylineMapObject or EllipseMapObject as needed
        }
    }

    private void createStaticBody(RectangleMapObject rectObject){

    }
}
