package com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh5;
import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh5L3;

public class ScrollingUpdateCh5 implements Subscriber {

    ArrayList<Label> UpdateLable;

    private GlobalsCommonCount glv;

    public ScrollingUpdateCh5(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;
        glv = GlobalsCommonCount.getInstance();

        Notifier notifier = Notifier.getInstance();
        notifier.RegisterSubscriber(this, CLICK_ScrollingCh5);
        notifier.RegisterSubscriber(this, CLICK_ScrollingCh5L3);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == CLICK_ScrollingCh5){
            ImageClick1();
        }
        else if (evt == CLICK_ScrollingCh5L3){
            ImageClick2();
        }
    }

    private void ImageClick1() {
        Label value4 = getLabel("Value4");
        Label valueD = getLabel("ValueD");

        if (glv.lableWrite) {
            value4.setText("47");
            valueD.setText(glv.lableUpdate + " ");
        }
    }

    private void ImageClick2() {
        Label val4 = getLabel("Value4");

        if (glv.lableWrite){
            val4.setText(glv.lableUpdate + " ");
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
