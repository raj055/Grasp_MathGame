package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGame;


public class Assets {

    public static TextureRegionDrawable play;
    public static TextureRegionDrawable playOver;
    public static TextureRegionDrawable exit;
    public static TextureRegionDrawable exitOver;
    public static TextureRegionDrawable soundOn;
    public static TextureRegionDrawable soundOff;
    public static TextureRegionDrawable musicOn;
    public static TextureRegionDrawable musicOff;

    public static TextureRegionDrawable scoreBackground;
    public static TextureRegion smallStar;
    public static TextureRegion bigStar;
    public static TextureRegion cocarde;
    public static TextureRegionDrawable home;
    public static TextureRegionDrawable homeOver;
    public static TextureRegionDrawable replay;
    public static TextureRegionDrawable replayOver;

    public static Array<TextureRegion> balloonsTextures;
    public static Sound clickSound;
    public static Music music;
    private static TextureAtlas itemsAtlas;

    public static Label.LabelStyle souses20;
    public static Label.LabelStyle souses22;
    public static Label.LabelStyle souses45;

    public static Image background;

    public static void load() {

        // Load Textures

        background = new Image(new Texture("bg.png"));
        background.setSize(MyGame.WIDTH,MyGame.HEIGHT);

        itemsAtlas = new TextureAtlas(Gdx.files.internal("balloons.pack"));

        play = new TextureRegionDrawable(itemsAtlas.findRegion("btnPlay"));
        playOver = new TextureRegionDrawable(itemsAtlas.findRegion("btnPlayOver"));
        exit = new TextureRegionDrawable(itemsAtlas.findRegion("btn-exit"));
        exitOver = new TextureRegionDrawable(itemsAtlas.findRegion("btn-exit-over"));
        soundOn = new TextureRegionDrawable(itemsAtlas.findRegion("sound-on"));
        soundOff = new TextureRegionDrawable(itemsAtlas.findRegion("sound-off"));
        musicOn = new TextureRegionDrawable(itemsAtlas.findRegion("music-on"));
        musicOff = new TextureRegionDrawable(itemsAtlas.findRegion("music-off"));


        // Score screen
        scoreBackground = new TextureRegionDrawable(itemsAtlas.findRegion("fenetre"));
        smallStar = itemsAtlas.findRegion("etoile-s");
        bigStar = itemsAtlas.findRegion("etoile-g");
        cocarde = itemsAtlas.findRegion("cocarde");


        replay = new TextureRegionDrawable(itemsAtlas.findRegion("btn-replay"));
        replayOver = new TextureRegionDrawable(itemsAtlas.findRegion("btn-replay-over"));
        home = new TextureRegionDrawable(itemsAtlas.findRegion("btn-home"));
        homeOver = new TextureRegionDrawable(itemsAtlas.findRegion("btn-home-over"));

        // Load Music and sounds
        music = Gdx.audio.newMusic(Gdx.files.internal("music.ogg"));
        music.setLooping(true);
        music.setVolume(0.5f);

        clickSound = Gdx.audio.newSound(Gdx.files.internal("selectionclick.mp3"));
    }

    public static void playSound(Sound sound) {
        if (Settings.soundEnabled) sound.play(1);
    }

    public static void dispose() {
        itemsAtlas.dispose();
        clickSound.dispose();
        music.dispose();
    }
}
