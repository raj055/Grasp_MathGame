package com.mygdx.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class DragAndDropListener extends DragAndDropElements{

    public DragAndDropListener(Events triggerEvent) {
        super(triggerEvent);
    }

    @Override
    public void addSource(Source source) {

        DragListener listener = new DragListener() {
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                event.getListenerActor().moveBy(x,y);
            }
            @Override
            public void drag (InputEvent event, float x, float y, int pointer) {

            }
            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {
                postEvent();
            }
        };

    }

    @Override
    public void addTarget(Target target) {
        DragListener listenerTarget = new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {

            }
            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer) {

            }
        };
    }
}
