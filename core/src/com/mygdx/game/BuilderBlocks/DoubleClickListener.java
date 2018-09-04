package com.mygdx.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnClickCallBack;

import java.util.ArrayList;

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

        if( getTapCount() == 2) {
            postEvent();
        }
    }
}
