package de.wiedel.my2dgame.chapter64;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class TableLayoutExample extends ApplicationAdapter {

    private Stage stage;
    private Skin skin;

    @Override
    public void create() {
        // 1) load skin and create stage
        skin = new Skin(
            Gdx.files.internal("ui/uiskin.json"),
            new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas")));

        stage = new Stage(new ScreenViewport());

        Gdx.input.setInputProcessor(stage);

        // 2) Create Table and configure defaults
        Table table = new Table(skin);
        table.setFillParent(true);
        table.pad(20);
        table.defaults().expandX().fillX().pad(10);

        // 3) Add title spanning 2 columns
        Label title = new Label("Main Menu", skin);
        table.add(title).colspan(1).row();

        // 4) add play button
        TextButton play = new TextButton("Play", skin);
        play.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.log("UI", "Play clicked!");
                // Transition to game screen here
            }
        });
        table.add(play).width(200);

        // 5) Add exit Button
        TextButton exit = new TextButton("Exit", skin);
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        table.add(exit).width(200).row();

        // 6) Add options slider row
        table.add(new Label("Volume", skin)).width(100);
        table.add(new Slider(0f, 100f, 1f, false, skin)).row();

        // 7) add a check box
        CheckBox fullScreen = new CheckBox("Fullscreen", skin);
        table.add(fullScreen).colspan(2).left().row();

        // Add the table to the stage
        stage.addActor(table);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1f);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
