package com.mygdx.game.ChapterClass.Ch6Triangles;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnDragCallBack;

import java.util.ArrayList;

public class DragShapeCh6 extends OnDragCallBack {

    ArrayList<Image> DragShape = new ArrayList<Image>();

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    public DragShapeCh6(Events triggerEvent) { super(triggerEvent); }

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

    public void setDisplayShape(ArrayList<Image> dispEliment){
        if (dispEliment != null) {
            DragShape.addAll(dispEliment);
        }
    }


    void updateGlobalVariables(){

        /*int xPos = 240;

        for(Image disBall : DragShape) {
            disBall.setPosition(xPos, MyGame.HEIGHT - 130);
            xPos += 50;
        }*/
    }
}
