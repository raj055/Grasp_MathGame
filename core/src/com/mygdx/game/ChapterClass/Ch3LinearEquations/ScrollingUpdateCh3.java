package com.mygdx.game.ChapterClass.Ch3LinearEquations;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Component.TextVeriabal;
import com.mygdx.game.Component.TextveriabalCh3;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh3;

public class ScrollingUpdateCh3 implements Subscriber {

    ArrayList<Label> UpdateLable;

    private GlobalsCommonCount glv;


    public ScrollingUpdateCh3(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;

        glv = GlobalsCommonCount.getInstance();

        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this, CLICK_ScrollingCh3);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == CLICK_ScrollingCh3){
            if(GameStates.steps == Steps.STEP_1){
                ImageClick1();
            }
            else if (GameStates.steps == Steps.STEP_2){
                ImageClick2();
            }
            else if (GameStates.steps == Steps.STEP_3){
                ImageClick3();
            }
            else if (GameStates.steps == Steps.STEP_4){
                ImageClick4();
            }
            else if (GameStates.steps == Steps.STEP_5){
                ImageClick5();
            }
            else if (GameStates.steps == Steps.STEP_6){
                ImageClick6();
            }
            else if (GameStates.steps == Steps.STEP_7){
                ImageClick7();
            }
        }
    }

    private void ImageClick1() {

        Label labelP = getLabel("LabelP");
        Label labelE = getLabel("LabelE");

        String strvalue = "";
        if (glv.lableWrite) {
            if(glv.lableUpdate <= glv.TextLevel3.length){
                strvalue = glv.TextLevel3[glv.lableUpdate];
            }
            switch (glv.countClick){
                case 1:
                    labelP.setText(strvalue);
                    break;
                case 2:
                    labelE.setText(strvalue);
                    break;
                default:
                    break;
            }
        }
    }

    private void ImageClick2() {
        Label value1 = getLabel("Value1");
        Label value3 = getLabel("Value3");
        Label value11 = getLabel("Value11");
        Label value13 = getLabel("Value13");

        if (glv.lableWrite) {

            switch (glv.countClick) {
                case 1:
                    if (value1 != null)
                    value1.setText(glv.lableUpdate + " ");
                    break;
                case 2:
                    if (value3 != null)
                    value3.setText(glv.lableUpdate + " ");
                    break;
                case 3:
                    if (value11 != null)
                    value11.setText(glv.lableUpdate + " ");
                    break;
                case 4:
                    if (value13 != null)
                    value13.setText(glv.lableUpdate + " ");
                    break;

                default:
                    break;
            }
        }
    }

    private void ImageClick3() {
    }

    private void ImageClick4() {
        Label value2 = getLabel("Value2");
        Label value12 = getLabel("Value12");

        if (glv.lableWrite) {

            switch (glv.countClick) {
                case 1:
                    if (value2 != null)
                    value2.setText(glv.lableUpdate + " ");
                    break;

                case 2:
                    if (value12 != null)
                    value12.setText(glv.lableUpdate + " ");
                    break;

                default:
                    break;

            }
        }
    }

    private void ImageClick5() {

    }

    private void ImageClick6() {

    }

    private void ImageClick7() {

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
