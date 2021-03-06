package com.mygdx.game.Component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingImageClick;
import com.mygdx.game.Global.GlobalsCommonCount;

/**
 * Created by HP on 12-12-2017.
 */

public class TextveriabalCh3 implements Disposable {


  public static final int TextCOUNT = 6;

  public Array<Image> texts;

  private GlobalsCommonCount gblVar;

  public String string_labal;

  int posX = 10;
  int posY = 700;

  public TextveriabalCh3(){

    gblVar = GlobalsCommonCount.getInstance();

    texts = new Array<Image>();

    for(int numCount = 0 ; numCount < TextCOUNT; numCount++)
    {
      final Image img = new Image(new Texture(gblVar.TextLevel1[numCount]));

      ScrollingImageClick scrollingImageClick = new ScrollingImageClick(Events.CLICK_ScrollingCh3);

      scrollingImageClick.setCount(numCount);

      scrollingImageClick.setStringValue(numCount);

      posY = 50 + gblVar.posYNum[numCount];
      img.setSize(30,40);
      img.setPosition(posX,posY);
      posX += 40;

      img.addListener(scrollingImageClick);
      texts.add(img);
    }
  }

  public void addToStage(Stage stg){
    for (Image img : texts) {
      stg.addActor(img);
    }
  }
  public void update(float deltaTime) {

    for (Image img : texts) {
      float y = img.getY();
      y -= gblVar.posYDiff[0];
      img.setPosition(img.getX(), y);
      if (y <= 0) {
        y = 400;
        float x;
        x = MathUtils.random(50, 360);
        img.setPosition(x, y);
      }
    }
  }
  public void setPositionX(int positionX){
//    this.posX = positionX + 6;
  }

  @Override
  public void dispose() {
    gblVar.clear();
  }
}
