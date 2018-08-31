package com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnDragCallBack;

import java.util.ArrayList;

public class DragLabelCh5 extends OnDragCallBack {

    public DragLabelCh5(Events triggerEvent) { super(triggerEvent); }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {

        event.getListenerActor().moveBy(x,y);
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {

        //Update the relevant labels
        postEvent();

    }
}
