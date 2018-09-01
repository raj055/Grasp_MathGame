package com.mygdx.game.ChapterClass.Ch2Polynomials;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.Component.Nagetiv_Num;
import com.mygdx.game.Component.TextVeriabal;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_SCROLLCH2_BALLDISPLAY;
import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh1;
import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh2;
import static com.mygdx.game.BuilderBlocks.Events.STEP1;
import static com.mygdx.game.BuilderBlocks.Events.STEP2;
import static com.mygdx.game.Enum.Steps.STEP_1;

public class ScrollingUpdateLabelCh2 implements Subscriber{

    private ArrayList<Label> UpdateLable;
    private GlobalsCommonCount glv;
    public BallDisplay ballDisplay;
    private TextVeriabal textVeriabal;
    private Nagetiv_Num nagetiv_num;
    private int ballclick = 0;

    public ScrollingUpdateLabelCh2(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;

        glv = GlobalsCommonCount.getInstance();

        ballDisplay = new BallDisplay(8,8);

        textVeriabal = new TextVeriabal();

        nagetiv_num = new Nagetiv_Num();

        //Get notifier and register the click scrolling events.
        Notifier notifier = Notifier.getInstance();
        notifier.RegisterSubscriber(this, CLICK_ScrollingCh1);
        notifier.RegisterSubscriber(this, CLICK_SCROLLCH2_BALLDISPLAY);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == CLICK_SCROLLCH2_BALLDISPLAY){
            ImageClick1();
        }
        else if (evt == CLICK_ScrollingCh2){
            Level3ImageClick();
        }
    }

    private void ImageClick1() {

        ballDisplay.update();

        Label Labal_f1 = getLabel("labelF1");
        Label Labal_f2 = getLabel("labelF2");
        Label Labal_f3 = getLabel("labelF2");
        Label Labal_f4 = getLabel("labelF3");

        Label num_1 = getLabel("number1");
        Label num_2 = getLabel("number2");

        switch (Events.STEP1) {
            case STEP1:
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

                        case 5:
                            if (num_1 != null) {
                                num_1.setText(glv.lableUpdate + " ");
                            }
                            break;
                        case 6:
                            if (num_2 != null) {
                                num_2.setText(glv.lableUpdate + " ");
                            }
                            break;

                        default:
                            break;
                    }
                    for (int i = 0; i < glv.click1; i++){
                        ballDisplay.balls[i][0].setVisible(true);
                        for (int j = 0; j < glv.click2; j++) {
                            ballDisplay.balls[i][j].setVisible(true);
                        }
                    }

                }
                break;

            case STEP2:
                if (glv.lableWrite) {

                    switch (glv.countClick) {
                        case 1:
                            if (num_1 != null) {
                                num_1.setText(glv.lableUpdate + " ");
                            }
                            break;
                        case 2:
                            if (num_2 != null) {
                                num_2.setText(glv.lableUpdate + " ");
                            }
                            break;

                        default:
                            break;
                    }
                }
                break;


    default:
      break;
}
    }
    private void Level3ImageClick() {

        Label quotient = getLabel("quotient");
        Label quotient1 = getLabel("quotient1");


        switch (GameStates.steps) {
            case STEP_1:
                if (glv.lableWrite) {

                    quotient.setText(textVeriabal.string_labal + " ");

                }
                break;

            case STEP_2:

                if (glv.lableWrite) {

                    quotient1.setText(nagetiv_num.string_labal + " ");

                }
                break;

            default:
                break;
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
