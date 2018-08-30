package com.mygdx.game.ChapterClass.Ch6Triangles;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_LabelAC;

public class UpdateLabelCh6 implements Subscriber {

    ArrayList<Label> visebleLable;

    public UpdateLabelCh6(ArrayList<Label> arrLabel){

        //Assign the visible components
        visebleLable = arrLabel;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        //Register for the ball drag and remainder ball drag events.
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_LabelAC);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == Events.DOUBLE_CLICK_LabelAC){
            changeValue();
        }
    }

    private void changeValue() {

        Label labelAns = getLabel("numeric3");

        if (labelAns != null) {
            labelAns.setText("AC");
        }
    }

    private Label getLabel(String LabelShow) {

        for (Label updatable : visebleLable) {
            String str = updatable.getName();

            if (str.equals(LabelShow)){
                return updatable;
            }
        }
        return null;
    }
}
