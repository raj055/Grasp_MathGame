package com.mygdx.game.ChapterClass.Ch6Triangles;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG1;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG2;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG3;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG4;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG5;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG6;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG7;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG8;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG9;
import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK_IMG9_2;

public class UpdateImageCh6 implements Subscriber {

    ArrayList<Image> visebleImage;

    public UpdateImageCh6(ArrayList<Image> arrImage){

        //Assign the visible components
        visebleImage = arrImage;


        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        //Register for the ball drag and remainder ball drag events.
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG1);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG2);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG3);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG4);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG5);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG6);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG7);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG8);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG9);
        notifier.RegisterSubscriber(this, DOUBLE_CLICK_IMG9_2);
    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(GameStates.steps == Steps.STEP_1){
            if(evt == Events.DOUBLE_CLICK_IMG1){
                changeImg1();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG5){
                changeImg5();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG7){
                changeImg7();
            }
        }
        else if (GameStates.steps == Steps.STEP_2){
            if(evt == Events.DOUBLE_CLICK_IMG2){
                changeImg2();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG4){
                changeImg4();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG8){
                changeImg8();
            }
        }
        else if (GameStates.steps == Steps.STEP_3){
            if(evt == Events.DOUBLE_CLICK_IMG){
                changeImg();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG3){
                changeImg3();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG5){
                changeImg5();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG6){
                changeImg6();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG8){
                changeImg8();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG9){
                changeImg9();
            }
            else if(evt == Events.DOUBLE_CLICK_IMG9_2){
                changeImg9_2();
            }
        }
    }

    private void changeImg() {
        Image Image = getImage("imgVlu");

        if (Image != null) {
            Image.setSize(80,30);
            Image.setPosition(280,310);
        }
    }

    private void changeImg1() {
        Image Image1 = getImage("imgVlu1");

        if (Image1 != null) {
            Image1.setSize(80,30);
            Image1.setPosition(280,310);
        }
    }

    private void changeImg2() {
        Image Image2 = getImage("imgVlu2");

        if (Image2 != null) {
            Image2.setSize(40,20);
            Image2.setPosition(275,315);
        }
    }

    private void changeImg3() {
        Image Image3 = getImage("imgVlu3");

        if (Image3 != null) {
            Image3.setSize(40,20);
            Image3.setPosition(180,315);
        }
    }

    private void changeImg4() {
        Image Image4 = getImage("imgVlu4");

        if (Image4 != null) {
            Image4.setSize(80,30);
            Image4.setPosition(170,310);
        }
    }

    private void changeImg5() {
        Image Image5 = getImage("imgVlu5");

        if (Image5 != null) {
            Image5.setSize(40,20);
            Image5.setPosition(115,315);
        }
    }

    private void changeImg6() {
        Image Image6 = getImage("imgVlu6");

        if (Image6 != null) {
            Image6.setSize(40,20);
            Image6.setPosition(345,315);
        }
    }

    private void changeImg7() {
        Image Image7 = getImage("imgVlu7");

        if (Image7 != null) {
            Image7.setSize(10,10);
            Image7.setPosition(260,310);
        }
    }

    private void changeImg8() {
        Image Image8 = getImage("imgVlu8");

        if (Image8 != null) {
            Image8.setSize(20,20);
            Image8.setPosition(250,315);
        }
    }

    private void changeImg9() {
        Image Image9 = getImage("imgVlu9");

        if (Image9 != null) {
            Image9.setSize(20,5);
            Image9.setPosition(160,320);
        }
    }

    private void changeImg9_2() {
        Image Image9_2 = getImage("imgVlu9_2");

        if (Image9_2 != null) {
            Image9_2.setSize(20,5);
            Image9_2.setPosition(320,320);
        }
    }

    private Image getImage(String ImageShow) {

        for (Image updatable : visebleImage) {
            String str = updatable.getName();

            if (str.equals(ImageShow)){
                return updatable;
            }
        }
        return null;
    }
}
