package com.mygdx.game.ChapterClass.Ch1RealNumbers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnDragCallBack;
import com.mygdx.game.Factory.ChapterScreen;
import com.mygdx.game.MyGame;

import java.util.ArrayList;

public class BallDragListener extends OnDragCallBack {

  ArrayList<Image> displayBalls = new ArrayList<Image>();

  //Get the Chapter1 Variables.
  ChapterVariables chapterVariables = ChapterVariables.getInstance();

  public BallDragListener(Events triggerEvent) {
    super(triggerEvent);
  }

  @Override
  public void drag(InputEvent event, float x, float y, int pointer) {
    //Drag12 all the balls
    if(!(displayBalls.isEmpty())) {
      for (Image disBall : displayBalls) {
        disBall.moveBy(x, y);
      }
    }
  }

  @Override
  public void dragStop(InputEvent event, float x, float y, int pointer) {

      //Update the relevant variables
      updateGlobalVariables();

      //Update the relevant labels
      postEvent();
  }

  public void setDisplayBalls(ArrayList<Image> dispBalls){
    if(dispBalls != null) {
      displayBalls.addAll(dispBalls);
    }
  }

  void updateGlobalVariables(){

    int xPos = 155;

    for(Image disBall : displayBalls) {
      chapterVariables.chapter1Variables.ValueOfScore++;
      disBall.setPosition(xPos, MyGame.HEIGHT - 140);
      xPos += 40;
    }
    chapterVariables.chapter1Variables.ValueOfQ++;
    chapterVariables.chapter1Variables.ValueOfB++;
  }
}
