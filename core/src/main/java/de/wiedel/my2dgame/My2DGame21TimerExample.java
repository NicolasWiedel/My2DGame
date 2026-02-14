package de.wiedel.my2dgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class My2DGame21TimerExample extends ApplicationAdapter {

    private float timer;

    @Override
    public void create() {
        timer = 0f;
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        timer += deltaTime;

        // Trigger every 2 seconds
        if(timer >= 2f){
            performSpawn();
            timer -= 2f; // subtract instead of reset to avoid drift
        }
    }

    private void performSpawn(){
        Gdx.app.log("TimerExample", "Spawn event at " + timer);
    }
}
