package com.mygdx.game.ChapterClass.Ch7CoordinateGeometry;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.OnDragCallBack;

import java.util.ArrayList;

public class DragLabelCh7 extends OnDragCallBack {

    ArrayList<Image> DragLabel = new ArrayList<Image>();

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    public DragLabelCh7(Events triggerEvent) { super(triggerEvent); }

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
