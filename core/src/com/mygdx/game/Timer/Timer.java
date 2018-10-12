package com.mygdx.game.Timer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.MyGame;

/**
 * Created by HP on 12-01-2018.
 */

public class Timer implements Disposable {

  public Stage stage;

  private Integer worldTimer;
  private boolean timeUp;
  private float timeCount;

  //Scene2D widgets
  private Label countdownLabel;

  private Label timeLabel;

  private BitmapFont font;

  private Label.LabelStyle labelStyle2;

  public Timer(){

    worldTimer = 30;
    timeCount = 0;

    stage = new Stage();

    labelStyle2 = new Label.LabelStyle();
    font = new BitmapFont(Gdx.files.internal("fonts/gamebird.fnt"));
    labelStyle2.font = font;
    labelStyle2.fontColor = Color.WHITE;

    //define a table used to organize our hud's labels
    Table table = new Table();
    //Top-Align table
    table.top();
    //make the table fill the entire stage
    table.setFillParent(true);

    //define our labels using the String, and a Label style consisting of a font and color
    countdownLabel = new Label(String.format("%02d", worldTimer), labelStyle2);
    countdownLabel.setSize(10,10);

    Image value10 = new Image(new Texture("data1/asset1.png"));
    value10.setSize(150,60);
    value10.setPosition(MyGame.WIDTH - 180, MyGame.HEIGHT - 75);
    stage.addActor(value10);

    Label label = new Label("TIMER",labelStyle2);
    label.setSize(15,15);
    label.setPosition(MyGame.WIDTH - 160,MyGame.HEIGHT - 50);
    stage.addActor(label);

    Image value11 = new Image(new Texture("data1/asset21.png"));
    value11.setSize(60,60);
    value11.setPosition(MyGame.WIDTH - 63, MyGame.HEIGHT - 70);
    stage.addActor(value11);

    //add our labels to our table, padding the top, and giving them all equal width with expandX
    table.add(timeLabel).expandX().padTop(20).padLeft(335);
    //add a second row to our table
    table.row();
    table.add(countdownLabel).expandX().padLeft(335);

    //add our table to the stage
    stage.addActor(table);

  }

  public void update(float dt){
    timeCount += dt;
    if(timeCount >= 1){
      if (worldTimer > 0) {
        worldTimer--;
//        timeUp = false;
      } else {
        timeUp = true;
      }
      countdownLabel.setText(String.format("%02d", worldTimer));
      timeCount = 0;
    }
  }

  public void RestartTime(){
    countdownLabel.clear();
    worldTimer = 31;
  }

  @Override
  public void dispose() { stage.dispose(); }

  public boolean isTimeUp() { return timeUp; }
}
