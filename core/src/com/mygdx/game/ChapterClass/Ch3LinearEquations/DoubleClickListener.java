package com.mygdx.game.ChapterClass.Ch3LinearEquations;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnClickCallBack;

import java.util.ArrayList;

public class DoubleClickListener extends OnClickCallBack {

    ArrayList<com.badlogic.gdx.scenes.scene2d.ui.Image> ClickImage = new ArrayList<com.badlogic.gdx.scenes.scene2d.ui.Image>();

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
            UpdateElements();
        }

        postEvent();
    }

    public void setClick(ArrayList<com.badlogic.gdx.scenes.scene2d.ui.Image> clickImage) {
        if (clickImage != null){
            ClickImage.addAll(clickImage);
        }
    }

    private void UpdateElements() {

    }

}
