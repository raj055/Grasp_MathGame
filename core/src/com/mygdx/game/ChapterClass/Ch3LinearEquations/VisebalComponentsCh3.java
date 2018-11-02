package com.mygdx.game.ChapterClass.Ch3LinearEquations;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG_Y1;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG_Y2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_LABEL;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_A1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_A2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_B1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_B11;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_B2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_B22;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_C1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_VALUE_C2;

public class VisebalComponentsCh3 implements Subscriber {

    ArrayList<Image> visibleComponents;
    ArrayList<Label> labelsList;

    public VisebalComponentsCh3(ArrayList<Image> arrImages, ArrayList<Label> labelArr) {

        visibleComponents = arrImages;
        labelsList = labelArr;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();
        notifier.RegisterSubscriber(this,DOUBLE_CLICK_IMG_Y1);
        notifier.RegisterSubscriber(this,DOUBLE_CLICK_IMG_Y2);

        notifier.RegisterSubscriber(this, DRAG_VALUE_A1);
        notifier.RegisterSubscriber(this, DRAG_VALUE_A2);
        notifier.RegisterSubscriber(this, DRAG_VALUE_B1);
        notifier.RegisterSubscriber(this, DRAG_VALUE_B2);
        notifier.RegisterSubscriber(this, DRAG_VALUE_C1);
        notifier.RegisterSubscriber(this, DRAG_VALUE_C2);
        notifier.RegisterSubscriber(this, DRAG_VALUE_B11);
        notifier.RegisterSubscriber(this, DRAG_VALUE_B22);
    }

    void updateY1(){
        Image imgsqureL = getImage("SqurelImage");
        Image  y1= getImage("y1Image");

        Image  imgsquer = getImage("SquerImage");
        Image  imgsqureL2 = getImage("Squrel2Image");
        Image imground = getImage("RoundImage");
        Image imground1 = getImage("Round1Image");
        Image imground2 = getImage("Round2Image");

        Label label_x = getLabel("Labelx");
        Label y2 = getLabel("Valuey2");
        Label num = getLabel("Number");
        Label eqval = getLabel("Equal");
        Label min = getLabel("");


        Image imgShap1 = getImage("Shap1");

        Image img_y2 = getImage("y2Image");


        imgsqureL.setVisible(false);
        y1.setVisible(false);

        imgsquer.setPosition(15,MyGame.HEIGHT - 400);
        imgsqureL2.setPosition(120,MyGame.HEIGHT - 395);
        imground.setPosition(MyGame.WIDTH - 130,MyGame.HEIGHT - 300);
        imground1.setPosition(MyGame.WIDTH - 130,MyGame.HEIGHT - 360);
        imground2.setPosition(MyGame.WIDTH - 130,MyGame.HEIGHT - 420);

        label_x.setPosition(70,MyGame.HEIGHT - 360);
        y2.setPosition(100,MyGame.HEIGHT - 310);
        num.setPosition(MyGame.WIDTH - 115,MyGame.HEIGHT - 370);
        eqval.setPosition(MyGame.WIDTH - 185, MyGame.HEIGHT - 360);

//        min.setVisible(true);
        imgShap1.setVisible(true);

        img_y2.setTouchable(Touchable.enabled);

    }

    void updateY2(){

//        Image imgsqureL2.setVisible(false);
//        Image y2.setVisible(false);
//
//        imgsquer.setPosition(15,MyGame.HEIGHT - 400);
//        imground.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 300);
//        imground1.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 360);
//        imground2.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 420);
//
//        label_x.setPosition(70,MyGame.HEIGHT - 360);
//        num.setPosition(MyGame.WIDTH - 165,MyGame.HEIGHT - 370);
//        eqval.setPosition(160,MyGame.HEIGHT - 360);
//
//        min.setPosition(MyGame.WIDTH - 125,MyGame.HEIGHT - 360);
//
//        imgShap1.setSize(80,150);
//        imgShap1.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 400);
//
//        imgShap2.setVisible(true);
//
//        imgShap2.setSize(80,150);
//        imgShap2.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 355);
//
//        label_2y.setVisible(true);
//
//        AnsValue.setVisible(true);
//
//        imgsqureL2.setVisible(false);
//        y2.setVisible(false);
//
//        imgsquer.setPosition(15,MyGame.HEIGHT - 400);
//        imground.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 300);
//        imground1.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 360);
//        imground2.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 420);
//
//        label_x.setPosition(70,MyGame.HEIGHT - 360);
//        num.setPosition(MyGame.WIDTH - 165,MyGame.HEIGHT - 370);
//        eqval.setPosition(160,MyGame.HEIGHT - 360);
//
//        min.setPosition(MyGame.WIDTH - 125,MyGame.HEIGHT - 360);
//
//        imgShap1.setSize(80,150);
//        imgShap1.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 400);
//
//        imgShap2.setVisible(true);
//
//        imgShap2.setSize(80,150);
//        imgShap2.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 355);
//
//        label_2y.setVisible(true);
//
//        AnsValue.setVisible(true);

    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(evt == Events.DOUBLE_CLICK_IMG_Y1){
            updateY1();
        }
        else if(evt == Events.DOUBLE_CLICK_IMG_Y2){
            updateY2();
        }
        else if(evt == Events.DRAG_VALUE_A1){
            updateA1();
        }
        else if(evt == Events.DRAG_VALUE_A2){
            updateA2();
        }
        else if(evt == Events.DRAG_VALUE_B1){
            updateB1();
        }
        else if(evt == Events.DRAG_VALUE_B2){
            updateB2();
        }
        else if(evt == Events.DRAG_VALUE_C1){
            updateC1();
        }
        else if(evt == Events.DRAG_VALUE_C2){
            updateC2();
        }
        else if(evt == Events.DRAG_VALUE_B11){
            updateB11();
        }
        else if(evt == DRAG_VALUE_B22){
            updateB22();
        }
    }

    private void updateA1() {
        Label a = getLabel("LabelA1");
        Label valueA = getLabel("ValueA1");

        if ((a != null) || (valueA != null)) {
            a.setVisible(false);
            valueA.setPosition(115, MyGame.HEIGHT - 350);
        }
    }
    private void updateA2() {
        Label a2 = getLabel("LabelA2");
        Label valueA1 = getLabel("ValueA1");

        if ((a2 != null) || (valueA1 != null)) {
            a2.setVisible(false);
            valueA1.setPosition(275, MyGame.HEIGHT - 430);
        }
    }
    private void updateB1() {
        Label b = getLabel("Labelb");
        Label valueB = getLabel("ValueB");

        if ((b != null) || (valueB != null)) {
            b.setVisible(false);
            valueB.setPosition(120, MyGame.HEIGHT - 305);
        }
    }
    private void updateB2() {
        Label b2 = getLabel("Labelb2");
        Label valueB1 = getLabel("ValueB1");

        if ((b2 != null) || (valueB1 != null)) {
            b2.setVisible(false);
            valueB1.setPosition(275, MyGame.HEIGHT - 305);
        }
    }
    private void updateC1() {
        Label c = getLabel("Labelc1");
        Label valueC = getLabel("ValueC");

        if ((c != null) || (valueC != null)) {
            c.setVisible(false);
            valueC.setPosition(340, MyGame.HEIGHT - 305);
        }
    }
    private void updateC2() {
        Label c2 = getLabel("Labelc2");
        Label valueC1 = getLabel("ValueC1");

        if ((c2 != null) || (valueC1 != null)) {
            c2.setVisible(false);
            valueC1.setPosition(190, MyGame.HEIGHT - 305);
        }
    }
    private void updateB11() {
        Label b11 = getLabel("Labelb11");
        Label valueB11 = getLabel("ValueB11");

        if ((b11 != null) || (valueB11 != null)) {
            b11.setVisible(false);
            valueB11.setPosition(345, MyGame.HEIGHT - 430);
        }
    }
    private void updateB22() {
        Label b12 = getLabel("Labelb12");
        Label valueB12 = getLabel("ValueB12");

        if ((b12 != null) || (valueB12 != null)) {
            b12.setVisible(false);
            valueB12.setPosition(185, MyGame.HEIGHT - 430);
        }
    }

    private Label getLabel(String LabelShow) {

        for (Label updatable : labelsList) {
            String str = updatable.getName();

            if (str.equals(LabelShow)){
                return updatable;
            }
        }
        return null;
    }
    private Image getImage(String imageName) {

        for (Image updatable : visibleComponents) {
            String str = updatable.getName();

            if (str.equals(imageName)){
                return updatable;
            }
        }
        return null;
    }
}
