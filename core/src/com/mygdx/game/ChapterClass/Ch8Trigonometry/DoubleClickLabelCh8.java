package com.mygdx.game.ChapterClass.Ch8Trigonometry;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnClickCallBack;

import java.awt.Label;
import java.util.ArrayList;

public class DoubleClickLabelCh8 extends OnClickCallBack {

    ArrayList<Label> ValueLable = new ArrayList<Label>();

    public DoubleClickLabelCh8(Events triggerEvent) { super(triggerEvent);}

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
