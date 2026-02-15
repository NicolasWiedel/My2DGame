package de.wiedel.my2dgame.chapter32;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

public class DifferentLoading {

    public DifferentLoading() {
        // !!! this is not a working class !!!

        // 1. first instantiate AssetManager
        AssetManager manager = new AssetManager();

        // 2. Loading Textures and Atlas
        manager.load("player.png", Texture.class);
        manager.load("enemies.atlas", TextureAtlas.class);

        // Block until everything is loaded
        manager.finishLoading();

        // Retrieve and use
        Texture playerTex = manager.get("player.png", Texture.class);
        TextureAtlas enemiesAtlas = manager.get("enemies.atlas", TextureAtlas.class);
        // for region named goblin inside enemies atlas
        TextureRegion goblinRegion = enemiesAtlas.findRegion("goblin");

        // 3. Loading BitmapFonts and TrueTypeFonts

        // Register FreeTypeFontGenerator and BitmapFont (.ttf) loaders
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class,
            new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf",
            new FreetypeFontLoader(resolver));
        // Queue a packed BitmapFont(.fnt) and a TTF font
        manager.load("fonts/arcade.fnt", BitmapFont.class);

        FreetypeFontLoader.FreeTypeFontLoaderParameter ttfParams =
            new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        ttfParams.fontFileName = "fonts/gamefonts.ttf";
        ttfParams.fontParameters.size = 32;
        manager.load("fonts/gamefonts.ttf", BitmapFont.class);

        // Bloch until done
        manager.finishLoading();

        // Retrieve
        BitmapFont arcadeFont = manager.get("fonts/arcadefont.fnt", BitmapFont.class);
        BitmapFont gameFont = manager.get("fonts/gamefont.ttf", BitmapFont.class);

        // 4. Audio
        manager.load("audio/jump.wav", Sound.class);
        manager.load("audio/background.mp3", Music.class);

        //Block until loaded
        manager.finishLoading();

        // retrieve and play
        Sound jumpSound = manager.get("audio/jump.wav", Sound.class);
        Music backgroundMusic = manager.get("audio/background.mp3", Music.class);

        jumpSound.play(0.75f);
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
    }
}
