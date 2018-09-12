package com.mygdx.game.ChapterClass.Ch4QuadraticEquations;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DRAGA1;
import static com.mygdx.game.BuilderBlocks.Events.DRAGA2;
import static com.mygdx.game.BuilderBlocks.Events.DRAGB1;
import static com.mygdx.game.BuilderBlocks.Events.DRAGB2;
import static com.mygdx.game.BuilderBlocks.Events.DRAGB3;
import static com.mygdx.game.BuilderBlocks.Events.DRAGC1;
import static com.mygdx.game.BuilderBlocks.Events.DRAGC2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_IMGBOX1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_IMGLIGHT;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_IMGSQUARE;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_IMGSQUARE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_IMGSQUARE2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_LABEL;

public class VisebleComponentsCh4 implements Subscriber {

    ArrayList<Image> visibleComponents;

    public VisebleComponentsCh4(ArrayList<Image> arrImages) {

        visibleComponents = arrImages;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_IMGLIGHT);
        notifier.RegisterSubscriber(this,DRAG_IMGSQUARE);
        notifier.RegisterSubscriber(this,DRAG_IMGSQUARE1);
        notifier.RegisterSubscriber(this,DRAG_IMGSQUARE2);
        notifier.RegisterSubscriber(this,DRAG_IMGBOX1);

        notifier.RegisterSubscriber(this,DRAGA1);
        notifier.RegisterSubscriber(this,DRAGA2);
        notifier.RegisterSubscriber(this,DRAGB1);
        notifier.RegisterSubscriber(this,DRAGB2);
        notifier.RegisterSubscriber(this,DRAGB3);
        notifier.RegisterSubscriber(this,DRAGC1);
        notifier.RegisterSubscriber(this,DRAGC2);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(GameStates.steps == Steps.STEP_1){
            if(evt == Events.DRAG_IMGLIGHT){
                draglight();
            }
        }
        else if (GameStates.steps == Steps.STEP_2){
            if (evt == Events.DRAG_IMGSQUARE){
                dragsquare();
            }
            else if (evt == Events.DRAG_IMGSQUARE1){
                dragsquare1();
            }
            else if (evt == Events.DRAG_IMGSQUARE2){
                dragsquare2();
            }
            else if (evt == Events.DRAG_IMGBOX1){
                dragbox();
            }
        }
        else if (GameStates.steps == Steps.STEP_3){ }
    }

    private void draglight() {

    }
    private void dragsquare() {

    }
    private void dragsquare1() {

    }
    private void dragsquare2() {

    }
    private void dragbox() {

    }
}
