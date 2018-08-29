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
import com.mygdx.game.Global.GlobalsCommonCount;


/**
 * Created by HP on 14-11-2017.
 */

public class NumberCh3 implements Disposable {

  public static final int NUMBERCOUNT = 10;

  public Array<Image> numbers;

  private GlobalsCommonCount gblVar;


  public NumberCh3(){

    gblVar = GlobalsCommonCount.getInstance();

    numbers = new Array<Image>();

    int posX = 10;
    int posY;
    for(int numCount = 0; numCount < NUMBERCOUNT; numCount++)
    {
      final Image img = new Image(new Texture(gblVar.NumberLevel1[numCount]));

      final  int count = numCount;

      posY = 50 + gblVar.posYNum[numCount];
      img.setSize(30,40);
      img.setPosition(posX,posY);
      posX += 40;

      img.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {


          Gdx.app.log("click 1","First" + gblVar.countClick++);

          gblVar.lableUpdate = count;
          gblVar.lableWrite = true;

        }
      });

      numbers.add(img);
    }

  }

  public void addToStage(Stage stg){
    for(Image img : numbers)
    {
      stg.addActor(img);
      }

  }
  public void update(float deltaTime){

    for(Image img : numbers)
    {
      float y = img.getY();
      y -= gblVar.posYDiff[0];
      img.setPosition(img.getX(),y);
      if (y <= 0) {
        y = 400;
        float x;
        x = MathUtils.random(10, 360);
        img.setPosition(x, y);
      }

    }

  }

  @Override
  public void dispose() {
    gblVar.clear();
  }

}
