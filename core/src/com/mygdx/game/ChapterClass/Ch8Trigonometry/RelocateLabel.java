package com.mygdx.game.ChapterClass.Ch8Trigonometry;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_AB;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_AB1;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_AC;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_AC1;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_BC;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_BC1;

public class RelocateLabel implements Subscriber {

    ArrayList<Label> visebleLable;

    public RelocateLabel(ArrayList<Label> arrLabel){

        //Assign the visible components
        visebleLable = arrLabel;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        //Register for the ball drag and remainder ball drag events.
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_AC);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_AC1);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_AB);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_AB1);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_BC);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_BC1);
    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(GameStates.steps == Steps.STEP_1 || (GameStates.steps == Steps.STEP_2)){
            if(evt == Events.DOUBLE_CLICK_AC){
                showAC();
            }
            else if(evt == Events.DOUBLE_CLICK_AC1){
                showAC1();
            }
            else if(evt == Events.DOUBLE_CLICK_AB){
                showAB();
            }
            else if(evt == Events.DOUBLE_CLICK_AB1){
                showAB1();
            }
            else if(evt == Events.DOUBLE_CLICK_BC){
                showBC();
            }
            else if(evt == Events.DOUBLE_CLICK_BC1){
                showBC1();
            }
        }
        else if (GameStates.steps == Steps.STEP_3){ }
    }

    private void showAC() {
        Label labelAC = getLabel("LabelValue1");

        if (labelAC != null) {
            labelAC.setPosition(MyGame.WIDTH - 70, MyGame.HEIGHT - 190);
        }
    }

    private void showAC1() {
        Label labelAC1 = getLabel("LabelValue1_1");

        if (labelAC1 != null) {
            labelAC1.setPosition(130,MyGame.HEIGHT - 190);
        }
    }

    private void showAB() {
        Label labelAB = getLabel("LabelValue3");

        if (labelAB != null) {
            labelAB.setPosition(240,MyGame.HEIGHT - 300);
        }
    }

    private void showAB1() {
        Label labelAB1 = getLabel("LabelValue3_1");

        if (labelAB1 != null) {
            labelAB1.setPosition(MyGame.WIDTH - 70,MyGame.HEIGHT - 140);
        }
    }

    private void showBC() {
        Label labelBC = getLabel("LabelValue5");

        if (labelBC != null) {
            labelBC.setPosition(240,MyGame.HEIGHT - 250);
        }
    }

    private void showBC1() {
        Label labelBC1 = getLabel("LabelValue5_1");

        if (labelBC1 != null) {
            labelBC1.setPosition(130,MyGame.HEIGHT - 140);
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
