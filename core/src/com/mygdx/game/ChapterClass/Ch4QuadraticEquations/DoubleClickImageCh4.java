package com.mygdx.game.ChapterClass.Ch4QuadraticEquations;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnClickCallBack;

public class DoubleClickImageCh4 extends OnClickCallBack {


    public DoubleClickImageCh4(Events triggerEvent) { super(triggerEvent);}

    @Override
    protected void postEvent() {
        super.postEvent();
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {

//        UpdateElements();

        postEvent();

    }

    private void UpdateElements() {

    }
}
