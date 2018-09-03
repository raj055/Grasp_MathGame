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
 * Created by HP on 25-11-2017.
 */

public class Numberch6 implements Disposable {

  public static final int NUMBERCOUNT = 6;

  public Array<Image> numbers;

  private GlobalsCommonCount gblVar;

  public String string_labal;

  int posX = 406;
  int posY = 700;

  public Numberch6(){

    gblVar = GlobalsCommonCount.getInstance();

    numbers = new Array<Image>();


    for(int numCount = 0; numCount < NUMBERCOUNT; numCount++)
    {
        final Image img = new Image(new Texture(gblVar.NumberDecimal[numCount]));
      ScrollingImageClick scrollingImageClick = new ScrollingImageClick(Events.CLICK_ScrollingCh6);

//      gblVar.NumberLevel11[numCount] = gblVar.NumberLevel12[numCount];
      scrollingImageClick.setCount(numCount);

      scrollingImageClick.setStringValue(numCount);
        final  int count = numCount;

        posY = 700 + gblVar.posYNum[numCount];
        img.setSize(30,40);
        img.setPosition(posX,posY);
        posX += 40;

        img.addListener(scrollingImageClick);
//          new ClickListener(){
//          @Override
//          public void clicked(InputEvent event, float x, float y) {
//
//            Gdx.app.log("TextVariable","click_" + gblVar.countClick++);
//
//            string_labal = gblVar.NumberLevel12[count];
//
//            gblVar.lableUpdate = count;
//            gblVar.lableWrite = true;
//
//          }
//        });

        numbers.add(img);
    }


  }
  public void setPositionX(int positionX){
//    this.posX = positionX + 6;
  }
  public void update(float deltaTime){
    int yCount = 0;

    for(Image img : numbers)
    {
      float y = img.getY();
      y -= gblVar.posYDiff[0];
      img.setPosition(img.getX(),y);
      if (y <= 0) {
        y = 700;
        float x;
        x = MathUtils.random(50 + 400, 360 + 400);
        img.setPosition(x, y);
      }

      }

  }
  public void addToStage(Stage stg){
    for(Image img : numbers)
    {
      stg.addActor(img);
    }
  }
  @Override
  public void dispose() {
    gblVar.clear();
  }

}
