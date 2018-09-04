package com.mygdx.game.ChapterClass.Ch6Triangles;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Component.Numberch6;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh6;

public class ScrollingUpdateCh6 implements Subscriber {

    ArrayList<Label> UpdateLable;

    private GlobalsCommonCount glv;

    private Numberch6 numberch6;

    public ScrollingUpdateCh6(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;

        glv = GlobalsCommonCount.getInstance();

        numberch6 = new Numberch6();

        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this, CLICK_ScrollingCh6);

    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == CLICK_ScrollingCh6){
            if(GameStates.steps == Steps.STEP_1){
            }
            else if (GameStates.steps == Steps.STEP_2){
                ImageClick();
            }
            else if (GameStates.steps == Steps.STEP_3){
                ImageClick1();
            }
        }
    }

    public void setUpdatable(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;
    }

    private void ImageClick() {

        Label value = getLabel("value");
        Label value1 = getLabel("value1");
        Label value3 = getLabel("value3");

        String strvalue = "";
        if (glv.lableWrite){
            if(glv.lableUpdate <= glv.NumberLevel12.length){
                strvalue = glv.NumberLevel12[glv.lableUpdate];
            }

            switch (glv.countClick){
                case 1:
                    value.setText(strvalue);
                    break;

                case 2:
                    value1.setText(strvalue);
                    break;

                case 3:
                    value3.setText(strvalue);
                    break;

                default:
                    break;
            }
        }
    }

    private void ImageClick1() {

        Label anser = getLabel("Labelanser");

        String strvalue = "";
        if (glv.lableWrite){
            if(glv.lableUpdate <= glv.NumberLevel12.length){
                strvalue = glv.NumberLevel12[glv.lableUpdate];
            }

            switch (glv.countClick){
                case 1:
                    anser.setText(strvalue);
                    break;

                default:
                    break;
            }
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
