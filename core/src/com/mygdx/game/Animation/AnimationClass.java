package com.mygdx.game.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationClass {

    private SpriteBatch batch;

    private TextureAtlas charset;

    private TextureRegion currentFrame;

    private Animation runningAnimation;

    private static float FRAME_DURATION = .05f;

    private float origin_x, origin_y;

    private float width = 100;
    private float height = 100;

    public AnimationClass(){

        batch = new SpriteBatch();
    }

    public void show(){

        charset = new TextureAtlas( Gdx.files.internal("birdattacks.atlas") );

        Array<TextureAtlas.AtlasRegion> runningFrames = charset.findRegions("frame_black");

        runningAnimation = new Animation(FRAME_DURATION, runningFrames, Animation.PlayMode.LOOP);

        origin_x = (50);
        origin_y = (200);
    }

    public void update(float delta){

        currentFrame = (TextureRegion) runningAnimation.getKeyFrame(delta);

        batch.begin();
        batch.draw(currentFrame, origin_x, origin_y,width,height);

        batch.end();
    }
}
