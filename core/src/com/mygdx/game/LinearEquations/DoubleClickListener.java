package com.mygdx.game.LinearEquations;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnClickCallBack;

public class DoubleClickListener extends OnClickCallBack {

    public DoubleClickListener(Events triggerEvent) {
        super(triggerEvent);
    }

    @Override
    protected void postEvent() {
        super.postEvent();
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {


        postEvent();
    }
}
