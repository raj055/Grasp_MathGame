package com.mygdx.game.ChapterClass.Ch2Polynomials;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnDragCallBack;
import com.mygdx.game.MyGame;

import java.util.ArrayList;

public class DragPoint extends OnDragCallBack {

    ArrayList<Image> DragLine = new ArrayList<Image>();

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    public DragPoint(Events triggerEvent) {
        super(triggerEvent);
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {

        event.getListenerActor().moveBy(x,y);

    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {


        //Update the relevant variables
        updateGlobalVariables();

        //Update the relevant labels
        postEvent();

    }

    public void setDisplayBalls(ArrayList<Image> dispEliment){
        if (dispEliment != null) {
            DragLine.addAll(dispEliment);
        }
    }


    void updateGlobalVariables(){

            int xPos = 240;

            for (Image disBall : DragLine) {
                disBall.setPosition(xPos, MyGame.HEIGHT - 130);
                xPos += 50;
            }
    }
}
