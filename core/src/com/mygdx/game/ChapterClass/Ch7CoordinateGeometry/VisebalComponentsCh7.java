package com.mygdx.game.ChapterClass.Ch7CoordinateGeometry;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE14;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE14;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK4;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE12_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE14;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE14_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE1_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE22;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE22_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE24;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE24_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE3_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_LABEL;

public class VisebalComponentsCh7 implements Subscriber {

    ArrayList<Image> visibleComponentsImage;
    ArrayList<Label> visibleComponentsLabel;

    public VisebalComponentsCh7(ArrayList<Image> arrImages, ArrayList<Label> arrLabel) {

        visibleComponentsImage = arrImages;
        visibleComponentsLabel = arrLabel;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_L1_VALUE);
        notifier.RegisterSubscriber(this,DRAG_L1_VALUE3);
        notifier.RegisterSubscriber(this,DRAG_L1_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_L1_VALUE14);

        notifier.RegisterSubscriber(this,DRAG_L2_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUE14);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK1);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK2);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUE3);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK3);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK4);

        notifier.RegisterSubscriber(this,DRAG_L3_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE1_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE3);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE3_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE12_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE14);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE14_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE22);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE22_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE24);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE24_1);

    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == Events.DRAG_L1_VALUE){

        }
        else if (evt == Events.DRAG_L1_VALUE3){

        }
        else if (evt == Events.DRAG_L1_VALUE12){

        }
        else if (evt == Events.DRAG_L1_VALUE14){

        }
        else if (evt == Events.DRAG_L2_VALUE12){

        }
        else if (evt == Events.DRAG_L2_VALUE14){

        }
        else if (evt == Events.DRAG_L2_VALUEK1){

        }
        else if (evt == Events.DRAG_L2_VALUEK2){

        }
        else if (evt == Events.DRAG_L2_VALUE1){

        }
        else if (evt == Events.DRAG_L2_VALUE3){

        }
        else if (evt == Events.DRAG_L2_VALUEK3){

        }
        else if (evt == Events.DRAG_L2_VALUEK4){

        }
        else if (evt == Events.DRAG_L3_VALUE1){

        }
        else if (evt == Events.DRAG_L3_VALUE1_1){

        }
        else if (evt == Events.DRAG_L3_VALUE3){

        }
        else if (evt == Events.DRAG_L3_VALUE3_1){

        }
        else if (evt == Events.DRAG_L3_VALUE12){

        }
        else if (evt == Events.DRAG_L3_VALUE12_1){

        }
        else if (evt == Events.DRAG_L3_VALUE14){

        }
        else if (evt == Events.DRAG_L3_VALUE14_1){

        }
        else if (evt == Events.DRAG_L3_VALUE22){

        }
        else if (evt == Events.DRAG_L3_VALUE22_1){

        }
        else if (evt == Events.DRAG_L3_VALUE24){

        }
        else if (evt == Events.DRAG_L3_VALUE24_1){

        }
    }
}
