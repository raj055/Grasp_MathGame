package com.mygdx.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnClickCallBack;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.awt.Label;
import java.util.ArrayList;

public class ScrollingImageClick extends OnClickCallBack {

    ArrayList<Label> ValueLable = new ArrayList<Label>();

    private GlobalsCommonCount gblVar;

    int count;

    public ScrollingImageClick(Events triggerEvent) {super(triggerEvent);}

    @Override
    protected void postEvent() {
        super.postEvent();
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {

        UpdateElements();

        postEvent();

    }

    public void setCount(int count){
        this.count = count;
    }

    private void UpdateElements() {

        gblVar = GlobalsCommonCount.getInstance();

        gblVar.countClick++;

        gblVar.lableUpdate = count;
        gblVar.lableWrite = true;
    }

}
