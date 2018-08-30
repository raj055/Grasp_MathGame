package com.mygdx.game.ChapterClass.Ch3LinearEquations;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Component.TextVeriabal;
import com.mygdx.game.Component.TextveriabalCh3;
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

//        TextveriabalCh3 textveriabalCh3 = new TextveriabalCh3();

        Label value1 = getLabel("Value1");
        Label value3 = getLabel("Value3");

        Label value11 = getLabel("Value11");
        Label value13 = getLabel("Value13");

        if (glv.lableWrite) {

            switch (glv.countClick) {
                case 1:
                    value1.setText(glv.lableUpdate + " ");
                    break;

                case 2:
                    value3.setText(glv.lableUpdate + " ");
                    break;

                case 3:
                    value11.setText(glv.lableUpdate + " ");
                    break;

                case 4:
                    value13.setText(glv.lableUpdate + " ");

//                    click.setTouchable(Touchable.enabled);
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
