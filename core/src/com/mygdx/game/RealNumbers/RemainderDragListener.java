package com.mygdx.game.RealNumbers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnDragCallBack;

public class RemainderDragListener extends OnDragCallBack {

  //Get the event to be notified for
  public RemainderDragListener(Events triggerEvent) {
    super(triggerEvent);

    //Update the varibles value
    chapterVariables.chapter1Variables.RBallHeight = 40;
    chapterVariables.chapter1Variables.RBallWidth = 40;

    //Initial Position
    chapterVariables.chapter1Variables.RBallPosX = 20;
  }

  //Get the chapter 1 variables.
  ChapterVariables chapterVariables = ChapterVariables.getInstance();

  public void drag(InputEvent event, float x, float y, int pointer) {

    //Drag the currently being dragged image.
    Image currentImg = (Image)event.getListenerActor();
    currentImg.moveBy(x, y);
  }

  @Override
  public void dragStop(InputEvent event, float x, float y, int pointer) {

    //Get the image being dragged
    Image draggedEntity = (Image)event.getListenerActor();

    //Update the dragged entity.
    if (draggedEntity != null) {

      //update the dragged entity.
      draggedEntity.setSize(chapterVariables.chapter1Variables.RBallWidth,
      chapterVariables.chapter1Variables.RBallHeight);
      draggedEntity.setPosition(chapterVariables.chapter1Variables.RBallPosX,170);

      //update Global Variables
      updateGlobalVariables();

      //Send relevant notification
      postEvent();

    }
  }

  void updateGlobalVariables(){

    //Update Global Variables
    //Add to the Remainder Ball Position X
    chapterVariables.chapter1Variables.RBallPosX += 40;

    //Add the score
    chapterVariables.chapter1Variables.ValueOfScore++;

    //Add to remainder
    chapterVariables.chapter1Variables.ValueOfR++;
  }
}
