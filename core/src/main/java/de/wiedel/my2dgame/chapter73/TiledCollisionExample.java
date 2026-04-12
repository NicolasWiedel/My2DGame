package de.wiedel.my2dgame.chapter73;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import sun.java2d.Disposer;

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
        map = new TmxMapLoader().load("Maps/town.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, UNIT_SCALE);

        // 2. Set up camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 20, 15);
        camera.update();

        // 3. Initialize Box2D world (no gravity for top-down)
        world = new World(new Vector2(0, 0),true);
        debugRenderer = new Box2DDebugRenderer();

        // 4. Parse collision objects
        MapObjects objects = map.getLayers().get("Objects").getObjects();

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
            else if (object instanceof EllipseMapObject){
                createStaticBody((EllipseMapObject) object);
            }
            // Add support for PolylineMapObject or EllipseMapObject as needed
        }
    }

    @Override
    public void render() {
        // 1. Step physics
        world.step(1/60f, 6, 2);

        // 2. Render map
        ScreenUtils.clear(0, 0, 0, 1f);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        // 3. Draw debug outlines
        debugRenderer.render(world, camera.combined);
    }

    @Override
    public void dispose() {
        renderer.dispose();
        map.dispose();
        world.dispose();
        debugRenderer.dispose();
    }

    private void createStaticBody(RectangleMapObject rectObject){
        // 1. Get rectangle in world units
        Rectangle rect = rectObject.getRectangle();
        float x = (rect.x + rect.width/2) * UNIT_SCALE;
        float y = (rect.y + rect.height/2) * UNIT_SCALE;
        float hx = rect.width / 2 * UNIT_SCALE;
        float hy = rect.height / 2 * UNIT_SCALE;

        // 2. Define body
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);

        // 3. Create shape
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(hx,hy);

        // 4. Create body and fixture
        Body body = world.createBody(bdef);
        body.createFixture(shape, 1.0f);
        shape.dispose();
    }

    private void createStaticBody(PolygonMapObject polyObject){
        Polygon polygon = polyObject.getPolygon();
        float[] vertices = polygon.getTransformedVertices();
        // Box2D needs scaled coordinates and centered origin
        float[] worldVerts = new float[vertices.length];
        for (int i = 0; i < vertices.length; i++){
            worldVerts[i] = vertices[i] * UNIT_SCALE;
        }

        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bdef);

        PolygonShape shape = new PolygonShape();
        shape.set(worldVerts);
        body.createFixture(shape, 1.0f);
        shape.dispose();
    }

    private void createStaticBody(CircleMapObject circleMapObject){
        Circle circle = circleMapObject.getCircle();
        float x = circle.x * UNIT_SCALE;
        float y = circle.y * UNIT_SCALE;
        float radius = circle.radius * UNIT_SCALE;

        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);

        CircleShape shape = new CircleShape();
        shape.setRadius(radius);

        Body body = world.createBody(bdef);
        body.createFixture(shape, 1.0f);
        shape.dispose();
    }

    private void createStaticBody(EllipseMapObject ellipseMapObject){
        Ellipse ellipse = ellipseMapObject.getEllipse();
        float x = ellipse.x * UNIT_SCALE;
        float y = ellipse.y * UNIT_SCALE;
        float width = ellipse.width * UNIT_SCALE;
        float height = ellipse.height * UNIT_SCALE;

        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x + width / 2, y + height / 2);

        CircleShape shape = new CircleShape();
        shape.setRadius(width / 2);

        Body body = world.createBody(bdef);
        body.createFixture(shape, 1.0f);
        shape.dispose();
    }
}
