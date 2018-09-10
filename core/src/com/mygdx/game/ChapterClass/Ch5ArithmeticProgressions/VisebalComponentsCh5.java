package com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_ADD;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L1_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L1_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L1_VALUE13;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L1_VALUE2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L2_VAL1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L2_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L3S1_VAL1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L3S1_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L3S2_VAL1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_C5L3S2_VALUE1;

public class VisebalComponentsCh5 implements Subscriber {

    ArrayList<Image> visibleImage;
    ArrayList<Label> visibleLabel;

    public VisebalComponentsCh5(ArrayList<Image> arrImages, ArrayList<Label> arrLabel) {

        visibleImage = arrImages;
        visibleLabel = arrLabel;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DOUBLE_CLICK_ADD);

        notifier.RegisterSubscriber(this,DRAG_C5L1_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_C5L1_VALUE2);
        notifier.RegisterSubscriber(this,DRAG_C5L1_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_C5L1_VALUE13);

        notifier.RegisterSubscriber(this,DRAG_C5L2_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_C5L2_VAL1);

        notifier.RegisterSubscriber(this,DRAG_C5L3S1_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_C5L3S1_VAL1);

        notifier.RegisterSubscriber(this,DRAG_C5L3S2_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_C5L3S2_VAL1);
    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(evt == Events.DOUBLE_CLICK_ADD){
            clickImage();
        }
        else if(evt == DRAG_C5L1_VALUE1){
            dragVallue1L1();
        }
        else if(evt == DRAG_C5L1_VALUE2){
            dragVallue2L1();
        }
        else if(evt == DRAG_C5L1_VALUE12){
            dragVallue12L1();
        }
        else if(evt == DRAG_C5L1_VALUE13){
            dragVallue13L1();
        }
        else if(evt == DRAG_C5L2_VALUE1){
            dragVallue1L2();
        }
        else if(evt == DRAG_C5L2_VAL1){
            dragVal1L2();
        }

        if(GameStates.steps == Steps.STEP_1){
            if(evt == DRAG_C5L3S1_VALUE1){
                dragVallueL3s1();
            }
            else if(evt == DRAG_C5L3S1_VAL1){
                dragVal1L3s1();
            }
        }
        else if (GameStates.steps == Steps.STEP_2){
            if(evt == DRAG_C5L3S2_VALUE1){
                dragVallueL3s2();
            }
            else if(evt == DRAG_C5L3S2_VAL1){
                dragVal1L3s2();
            }
        }
        else if (GameStates.steps == Steps.STEP_3){ }

    }

    private void clickImage() {

    }

    private void dragVallue1L1() {

    }

    private void dragVallue2L1() {

    }

    private void dragVallue12L1() {

    }

    private void dragVallue13L1() {

    }

    private void dragVallue1L2() {

    }

    private void dragVal1L2() {

    }

    private void dragVallueL3s1() {

    }

    private void dragVal1L3s1() {

    }

    private void dragVallueL3s2() {

    }

    private void dragVal1L3s2() {

    }

    private Label getLabel(String LabelShow) {

        for (Label updatable : visibleLabel) {
            String str = updatable.getName();

            if (str.equals(LabelShow)){
                return updatable;
            }
        }
        return null;
    }
    private Image getImage(String imageName) {

        for (Image updatable : visibleImage) {
            String str = updatable.getName();

            if (str.equals(imageName)){
                return updatable;
            }
        }
        return null;
    }

}
