package com.mygdx.game.ChapterClass.Ch1RealNumbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.ShowEntity;
import com.mygdx.game.BuilderBlocks.Subscriber;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.BALL_DRAG_EVENT;
import static com.mygdx.game.BuilderBlocks.Events.REMAINDER_BALL_DRAG;

public class VisibleComponents extends ShowEntity implements Subscriber {

  ChapterVariables chapterVariables = ChapterVariables.getInstance();
  ArrayList<Image> visibleComponents;

  public VisibleComponents(Image progressBar, ArrayList<Image> arrImages) {

    //super constructor
    super(progressBar, arrImages);

    //Assign the visible components
    visibleComponents = arrImages;

    //Get Notifier instance
    Notifier notifier = Notifier.getInstance();

    //Register for the ball drag and remainder ball drag events.
    notifier.RegisterSubscriber(this, BALL_DRAG_EVENT);
    notifier.RegisterSubscriber(this, REMAINDER_BALL_DRAG);

  }
  void updateProgressBar(int score){

    //Update the value of Progress Bar length variable.
    Gdx.app.debug("Value of A", String.valueOf(chapterVariables.chapter1Variables.ValueOfA));
    float progBarSize = score * (800/chapterVariables.chapter1Variables.ValueOfA);

    //Set Progress Bar size.
    this.progressBar.setSize(40, progBarSize);

    //Set Visibility of the progress bar
    if(this.progressBar.isVisible() == false){

      this.progressBar.setVisible(true);
    }
  }

  void updateVisibleComponents(){

    Image dispBallImg = visibleComponents.get(chapterVariables.chapter1Variables.ValueOfQ - 1);
    dispBallImg.setVisible(true);
  }

  @Override
  public void UpdateAllElements(Events evt){

    if(evt == Events.BALL_DRAG_EVENT){
      updateProgressBar(chapterVariables.chapter1Variables.ValueOfScore);
      updateVisibleComponents();
    }
    else if(evt == Events.REMAINDER_BALL_DRAG){
      updateProgressBar(chapterVariables.chapter1Variables.ValueOfScore);
    }
  }
}
