package com.mygdx.game.ChapterClass.Ch1RealNumbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Global.GlobalsCommonCount;

/**
 *
 */

public class BallDisplay {

  public Image[][] balls;

  public static int columns = 6;
  public static int rows = 6;

  private GlobalsCommonCount global;

  private int posX;
  private int posY;

  public BallDisplay(){

    global = GlobalsCommonCount.getInstance();

    global.lableUpdate = columns;
    global.lableUpdate = rows;
    balls = new Image[columns][rows];

    for (int i = 0; i < columns; i++){
      for (int j = 0; j < rows; j++){
        final Image img = new Image(new Texture("data/ball_1.png"));

        balls[i][j] = img;
        balls[i][j].setVisible(true);
      }
    }
  }

  public void update(){

    for (int i = 0; i < columns; i++){
      for (int j = 0; j < rows; j++) {

        posX = 50 + global.posXBall[i];
        posY = 440 - global.posYBall[j];

        balls[i][j].setSize(40, 40);
        balls[i][j].setPosition(posX,posY);
      }
    }
  }
}
