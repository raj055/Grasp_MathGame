package com.mygdx.game.ChapterClass.Ch4QuadraticEquations;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh4;

public class ScrollingUpdateCh4 implements Subscriber {

    //Updatable
    ArrayList<Label> UpdateLable;
    //Global variables
    private GlobalsCommonCount glv;
    //Count number of clicks
    int ballclick = 0;
    //BallDisplay - two dimensional array of balls
    public BallDisplay ballDisplay;
    private int FinalScore;

    public ScrollingUpdateCh4(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;

        glv = GlobalsCommonCount.getInstance();

        ballDisplay = new BallDisplay(9,9);

        //Get notifier and Register click for scrolling.
        Notifier notifier = Notifier.getInstance();
        notifier.RegisterSubscriber(this, CLICK_ScrollingCh4);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == CLICK_ScrollingCh4){
            if(GameStates.steps == Steps.STEP_1){
                ImageClick1();
            }
            else if (GameStates.steps == Steps.STEP_2){
                ImageClick2();
            }
            else if (GameStates.steps == Steps.STEP_3){ }
        }
    }

    private void ImageClick1() {
      ballDisplay.update();

      Label Labal_f1 = getLabel("labelF1");
      Label Labal_f2 = getLabel("labelF2");
      Label Labal_f3 = getLabel("labelF2");
      Label Labal_f4 = getLabel("labelF3");

      Label Score = getLabel("Score1");

      if (glv.lableWrite) {
          switch (glv.countClick) {
              case 1:
                  if (Labal_f1 != null) {
                      Labal_f1.setText(glv.lableUpdate + " ");
                  }
                  ballclick = glv.click1 = glv.lableUpdate;
                  break;
              case 2:
                  if (Labal_f2 != null) {
                      Labal_f2.setText(glv.lableUpdate + " ");
                  }
                  ballclick = glv.click2 = glv.lableUpdate;
                  break;
              case 3:
                  if (Labal_f3 != null) {
                      Labal_f3.setText(glv.lableUpdate + " ");
                  }
                  ballclick = glv.click3 = glv.lableUpdate;
                  break;
              case 4:
                  if (Labal_f4 != null) {
                      Labal_f4.setText(glv.lableUpdate + " ");
                  }
                  ballclick = glv.click4 = glv.lableUpdate;
                  break;

              default:
                  break;
          }
          for (int i = 0; i < glv.click1; i++) {
              ballDisplay.balls[i][0].setVisible(true);
              for (int j = 0; j < glv.click2; j++) {
                  ballDisplay.balls[i][j].setVisible(true);
              }
          }

          FinalScore = glv.click1 * glv.click2 * glv.click3 * glv.click4;

          Score.setText("" + FinalScore);

      }
    }
    private void ImageClick2() {
        Label num_1 = getLabel("number1");
        Label num_2 = getLabel("number2");

        Label Score = getLabel("Score1");

        if (glv.lableWrite) {

            switch (glv.countClick) {
                case 1:
                    if (num_1 != null) {
                        num_1.setText(glv.lableUpdate + " ");
                    }
                    ballclick = glv.click1 = glv.lableUpdate;
                    break;
                case 2:
                    if (num_2 != null) {
                        num_2.setText(glv.lableUpdate + " ");
                    }
                    ballclick = glv.click1 = glv.lableUpdate;
                    break;

                default:
                    break;
            }

//            FinalScore = glv.click1 + glv.click2;

//            Score.setText("" + FinalScore);
        }
    }

    private Label getLabel(String LabelShow) {

        for (Label updatable : UpdateLable) {
            String str = updatable.getName();

            if (str.equals(LabelShow)){
                return updatable;
            }
        }
        return null;
    }

}
