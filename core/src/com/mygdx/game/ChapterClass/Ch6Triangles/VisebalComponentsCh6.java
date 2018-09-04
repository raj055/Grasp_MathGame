package com.mygdx.game.ChapterClass.Ch6Triangles;

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

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_LabelAC;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_CIRCLE;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_CIRCLE_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_SQUARE;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_SQUARE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_TRIANGLE_P;

public class VisebalComponentsCh6 implements Subscriber {

    ArrayList<Image> visibleComponents;
    ArrayList<Label> visebleLable;

    public VisebalComponentsCh6(ArrayList<Image> arrImages, ArrayList<Label> arrLable) {

        visibleComponents = arrImages;
        visebleLable = arrLable;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_SQUARE);
        notifier.RegisterSubscriber(this,DRAG_SQUARE1);
        notifier.RegisterSubscriber(this,DRAG_CIRCLE);
        notifier.RegisterSubscriber(this,DRAG_CIRCLE_1);
        notifier.RegisterSubscriber(this,DRAG_TRIANGLE_P);

        notifier.RegisterSubscriber(this, DOUBLE_CLICK_LabelAC);
    }


    @Override
    public void UpdateAllElements(Events evt) {
        if(GameStates.steps == Steps.STEP_1){

        }
        else if (GameStates.steps == Steps.STEP_2){

        }
        else if (GameStates.steps == Steps.STEP_3){

        }

        if(evt == Events.DRAG_SQUARE){
            imageSquare();
        }
        else if (evt == Events.DRAG_SQUARE1){
            imageSquare1();
        }
        else if (evt == Events.DRAG_CIRCLE){
            imageCircle();
        }
        else if (evt == Events.DRAG_CIRCLE_1){
            imageCircle1();
        }
        else if (evt == Events.DRAG_TRIANGLE_P){
            imageTriangle();
        }

        else if(evt == Events.DOUBLE_CLICK_LabelAC){
            changeValue();
        }
    }

    private void imageCircle1() {
        Image sercal1 = getImage("sercal1Image");

        sercal1.setPosition(30,MyGame.HEIGHT - 510);
    }

    private void imageCircle() {
        Image sercal = getImage("sercalImage");

        sercal.setPosition(MyGame.WIDTH - 120,MyGame.HEIGHT - 230);
    }

    private void imageSquare1() {
        Image square1 = getImage("square1Image");

        square1.setPosition(MyGame.WIDTH - 100,MyGame.HEIGHT - 450);
    }

    private void imageSquare() {
        Image square = getImage("squareImage");

        square.setPosition(20,MyGame.HEIGHT - 220);
    }

    private void imageTriangle() {
        Image triangle_p = getImage("triangle_p");

        triangle_p.setPosition(170, MyGame.HEIGHT - 390);
    }

    private void changeValue() {
        Label labelAns = getLabel("numeric3");

        if (labelAns != null) {
            labelAns.setText("AC");
        }
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
