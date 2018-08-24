package com.mygdx.game.ChapterClass.Ch3LinearEquations;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
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
            ImageClick1();
        }
    }

    private void ImageClick1() {
        Label labelX = getLabel("LabelB");
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
