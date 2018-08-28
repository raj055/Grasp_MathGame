package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;

/**
 * Created by HP on 12-01-2018.
 */

public class DialogScreen implements Screen {

  private Stage stage;

  private SpriteBatch batch;

  private TextureAtlas charset;

  private TextureRegion currentFrame;

  private Animation runningAnimation;

  private static float FRAME_DURATION = .05f;

  private Image Dialogbox;

  private float origin_x, origin_y;

  private float width = 100;
  private float height = 100;

  public DialogScreen() {}

  @Override
  public void resize (int width, int height) {}

  @Override
  public void show () {

    stage = new Stage();

    batch = new SpriteBatch();

    Gdx.input.setInputProcessor(stage);

    /* load the background image */
    Image bg = new Image(new Texture("blur_bg.png"));
    bg.setSize(MyGame.WIDTH, MyGame.HEIGHT);
    stage.addActor(bg);

    Dialogbox = new Image(new Texture("dialogbox.png"));
    Dialogbox.setPosition(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-100);
    Dialogbox.setSize(240,300);
    Dialogbox.setVisible(true);
    stage.addActor(Dialogbox);

    charset = new TextureAtlas( Gdx.files.internal("birdattacks.atlas") );

    Array<TextureAtlas.AtlasRegion> runningFrames = charset.findRegions("frame_black");

    runningAnimation = new Animation(FRAME_DURATION, runningFrames, Animation.PlayMode.LOOP);

    origin_x = (40);
    origin_y = (50);
  }

  @Override
  public void hide () {}

  @Override
  public void pause () {}

  @Override
  public void resume () {}

  @Override
  public void render (float delta) {

    stage.draw();

    currentFrame = (TextureRegion) runningAnimation.getKeyFrame(delta);

    batch.begin();
    batch.draw(currentFrame, origin_x, origin_y,width,height);

    batch.end();
  }

  @Override
  public void dispose () {
    stage.clear();
    stage.dispose();
  }
}
