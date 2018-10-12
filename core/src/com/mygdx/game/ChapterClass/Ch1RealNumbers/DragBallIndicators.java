package com.mygdx.game.ChapterClass.Ch1RealNumbers;

import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.ProgressData;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.BuilderBlocks.SumIndicator;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.BALL_DRAG_EVENT;
import static com.mygdx.game.BuilderBlocks.Events.REMAINDER_BALL_DRAG;

/**
 *
 *
 */

public class DragBallIndicators extends SumIndicator implements Subscriber {

  enum DragBallLabels {
    Score2,
    Score4,
    TargetScore,
    ValueB,
    ScoreValue
  }
  //Get the Chapter1 Variables.
  ChapterVariables chapterVariables = ChapterVariables.getInstance();

  public int SCOREVAL;

  public DragBallIndicators(ArrayList<ProgressData> members){
    super(members);

   //Subscribe to the relevant events
    Notifier notifier = Notifier.getInstance();
    notifier.RegisterSubscriber(this, BALL_DRAG_EVENT);
    notifier.RegisterSubscriber(this, REMAINDER_BALL_DRAG);
  }
  @Override
  public void UpdateAllElements(Events evt) {

    if(evt.equals(BALL_DRAG_EVENT)){

      updateElement(DragBallLabels.Score2, chapterVariables.chapter1Variables.ValueOfB);

      int val = getValue(DragBallLabels.ValueB);
      chapterVariables.chapter1Variables.ValueB = val;
      int VALUE_B = chapterVariables.chapter1Variables.ValueB;
      int valueA = chapterVariables.chapter1Variables.ValueOfA;
      int QValue = chapterVariables.chapter1Variables.ValueOfQ;
      SCOREVAL = getValue(DragBallLabels.Score2) * VALUE_B + getValue(DragBallLabels.Score4);

      chapterVariables.chapter1Variables.ValueOfScore = SCOREVAL;
      updateElement(DragBallLabels.ScoreValue, SCOREVAL);
      updateChapter1Variables();
    }
    else if (evt.equals(REMAINDER_BALL_DRAG)){

      updateElement(DragBallLabels.Score4, chapterVariables.chapter1Variables.ValueOfR);
      updateElement(DragBallLabels.ScoreValue,
        chapterVariables.chapter1Variables.ValueOfScore);
    }
  }

  public void updateElement(DragBallLabels dragBallLabels, int value){
    for (ProgressData pData : currentProgress){
      if(pData.getLabel().getName().matches(dragBallLabels.toString())){
        pData.getLabel().setText(Integer.toString(value));
        pData.setValue(value);
      }
    }
  }

  public int getValue(DragBallLabels dragBallLabels){
    int value = 0;
    for (ProgressData pData : currentProgress){
      if(pData.getLabel().getName().matches(dragBallLabels.toString())){
        value = pData.valueVar;
        break;
      }
    }
    return value;
  }

  public int getProgressDataIndex(DragBallLabels dragBallLabels){
    int currentProgressDataIndex = 0;
    for (ProgressData pData : currentProgress) {
      if (pData.getLabel().getName().matches(dragBallLabels.toString())) {
        currentProgressDataIndex = currentProgress.indexOf(pData);
      }
    }
    return currentProgressDataIndex;
  }

  void updateChapter1Variables(){
    // Fill value of all the relevant global Variables.

    String ValueOfA = currentProgress.get(getProgressDataIndex(DragBallLabels.TargetScore)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfA = Integer.valueOf(ValueOfA);

    //Score Value
    String ValueOfScore = currentProgress.get(getProgressDataIndex(DragBallLabels.ScoreValue)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfScore = Integer.valueOf(ValueOfScore);

    //Value of B
    String ValueOfB = currentProgress.get(getProgressDataIndex(DragBallLabels.Score2)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfB = Integer.valueOf(ValueOfB);

    //Value of B Main
    String ValueB = currentProgress.get(getProgressDataIndex(DragBallLabels.ValueB)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueB = Integer.valueOf(ValueB);

    //Value of R
    String ValueOfR = currentProgress.get(getProgressDataIndex(DragBallLabels.Score4)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfR = Integer.valueOf(ValueOfR);
  }
}
