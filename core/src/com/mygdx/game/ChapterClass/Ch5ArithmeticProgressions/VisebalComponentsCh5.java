package com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.ClickPluse;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;

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

    ClickPluse clickPluse;

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

        Image imgadd = getImage("PluseBttn");

        Label valueS = getLabel("Secondterm");
        Label valueS2 = getLabel("ValueS2");
        Label valueT = getLabel("Thirdterm");
        Label valueT2 = getLabel("ValueT2");
        Label valueF1 = getLabel("Firstterm");
        Label valueF12 = getLabel("ValueF12");

        switch (clickPluse){
            case CLICK_Add_1:
                valueS.setVisible(false);
                valueS2.setVisible(true);
                imgadd.setTouchable(Touchable.disabled);
                break;

            case CLICK_Add_2:
                valueT.setVisible(false);
                valueT2.setVisible(true);
                imgadd.setTouchable(Touchable.disabled);
                break;

            case CLICK_Add_3:
                valueF1.setVisible(false);
                valueF12.setVisible(true);
                imgadd.setTouchable(Touchable.disabled);
                break;

            default:
                break;
        }
    }

    private void dragVallue1L1() {
        Label valueF = getLabel("Firstterm");
        Label value11 = getLabel("Value11");
        Label value1 = getLabel("Value1");

        if ((value1 != null) || (valueF != null) || (value11 != null)) {
            valueF.setVisible(false);
            value11.setVisible(true);
            value1.setPosition(130, MyGame.HEIGHT - 330);
        }
    }

    private void dragVallue2L1() {
        Label value2 = getLabel("Value2");
        Label value12 = getLabel("Value12");
        Label pluse = getLabel("Pluse");

        Image imgadd = getImage("PluseBttn");

        if ((value2 != null) || (value12 != null) || (pluse != null) || (imgadd != null)) {
            value2.setPosition(250, MyGame.HEIGHT - 330);
            value12.setVisible(true);
            pluse.setVisible(true);
            imgadd.setTouchable(Touchable.enabled);
            clickPluse = ClickPluse.CLICK_Add_1;
        }
    }

    private void dragVallue12L1() {
        Label value12 = getLabel("Value12");
        Label value13 = getLabel("Value13");
        Label pluse1 = getLabel("Pluse1");

        Image imgadd = getImage("PluseBttn");

        if ((value12 != null) || (value13 != null) || (pluse1 != null) || (imgadd != null)) {
            value12.setPosition(250, MyGame.HEIGHT - 390);
            value13.setVisible(true);
            pluse1.setVisible(true);
            imgadd.setTouchable(Touchable.enabled);
            clickPluse = ClickPluse.CLICK_Add_2;
        }
    }

    private void dragVallue13L1() {
        Label value13 = getLabel("Value13");
        Label value14 = getLabel("Value14");
        Label pluse2 = getLabel("Pluse2");

        Image imgadd = getImage("PluseBttn");

        if ((value13 != null) || (value14 != null) || (pluse2 != null) || (imgadd != null)) {
            value13.setPosition(250, MyGame.HEIGHT - 450);
            value14.setVisible(true);
            pluse2.setVisible(true);
            imgadd.setTouchable(Touchable.enabled);
            clickPluse = ClickPluse.CLICK_Add_3;
        }
    }

    private void dragVallue1L2() {
        Label valueN = getLabel("ValueN");
        Label value1 = getLabel("Value1");

        if ((valueN != null) || (value1 != null)) {
            valueN.setVisible(false);
            value1.setPosition(190, MyGame.HEIGHT - 190);
        }
    }

    private void dragVal1L2() {
        Label valueA = getLabel("ValueA");
        Label val1 = getLabel("Labelval1");

        if ((val1 != null) || (valueA != null)) {
            valueA.setVisible(false);
            val1.setPosition(130, MyGame.HEIGHT - 190);
        }
    }

    private void dragVallueL3s1() {
        Label valueN = getLabel("ValueN");
        Label value1 = getLabel("Value1");

        if ((valueN != null) || (value1 != null)) {
            valueN.setVisible(false);
            value1.setPosition(190, MyGame.HEIGHT - 190);
        }
    }

    private void dragVal1L3s1() {
        Label valueA = getLabel("ValueA");
        Label val1 = getLabel("Labelval1");

        if ((val1 != null) || (valueA != null)) {
            valueA.setVisible(false);
            val1.setPosition(130, MyGame.HEIGHT - 190);
        }
    }

    private void dragVallueL3s2() {
        Label valueA = getLabel("ValueA");
        Label val1 = getLabel("LabelVal1");

        if ((val1 != null) || (valueA != null)) {
            valueA.setVisible(false);
            val1.setPosition(180, 130);
        }
    }

    private void dragVal1L3s2() {
        Label valueL1 = getLabel("LabelValueL1");
        Label valL = getLabel("LabelValL");
        Label val4 = getLabel("LabelVal4");

        if ((valueL1 != null) || (valL != null) || (val4 != null)) {
            valueL1.setVisible(false);
            valL.setPosition(235, 130);
            val4.setText("245");
        }
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
