package com.mygdx.game.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class TrainAnimation {

    private SpriteBatch batch;

    private TextureAtlas charset;

    private TextureRegion currentFrame;

    private Animation runningAnimation;

    private static float FRAME_DURATIONTrain = .3f;

    private float stateTime= 0;

    private float origin_x, origin_y;

    private float width;
    private float height;

    public TrainAnimation(){

        batch = new SpriteBatch();
    }

    public void show(){}

    public void TrainAnimation(){
        width = 400;
        height = 200;

        charset = new TextureAtlas( Gdx.files.internal("Train/train.atlas") );

        Array<TextureAtlas.AtlasRegion> runningFrames = charset.findRegions("t");

        runningAnimation = new Animation(FRAME_DURATIONTrain, runningFrames, Animation.PlayMode.NORMAL);

        origin_x = (0);
        origin_y = (90);
    }

    public void update(float delta){

        currentFrame = (TextureRegion) runningAnimation.getKeyFrame(delta);

        batch.begin();
        batch.draw(currentFrame, origin_x, origin_y,width,height);

        batch.end();
    }
}
