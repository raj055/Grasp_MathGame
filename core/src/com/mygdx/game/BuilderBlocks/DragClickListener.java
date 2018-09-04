package com.mygdx.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class DragClickListener extends OnDragCallBack {


    public DragClickListener(Events triggerEvent) { super(triggerEvent); }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {

        event.getListenerActor().moveBy(x,y);

    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {

        postEvent();

    }
}