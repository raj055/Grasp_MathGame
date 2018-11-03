package com.mygdx.game.BuilderBlocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class DragAndDropElements extends DragAndDrop {

    Events notifyEvent;
    Notifier notifier;

    public DragAndDropElements(Events triggerEvent) {

        //Execute the super class's constructor
        super();

        //Get the single instance of Notifier.
        notifier = Notifier.getInstance();

        //Assign the notifier event.
        notifyEvent = triggerEvent;
    }

    protected void postEvent() {

        //Notify the post events.
        notifier.PostEvents(notifyEvent);

        //Log the event
        Gdx.app.log("POST EVENT",notifyEvent.toString());
    }

    public void defineComponentLabelImage(final Actor dragActor, final Actor TargetActor){

        Source source = new Source(dragActor) {
            @Override
            public Payload dragStart(InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();

                payload.setDragActor(dragActor);

                dragActor.moveBy(x,y);

                return payload;
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, Payload payload, Target target) {
                Gdx.app.log("Drag Stop","Level");
            }
        };

        Target target = new Target(TargetActor) {
            @Override
            public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(Source source, Payload payload, float x, float y, int pointer) {
                Gdx.app.log("Drop Target","Level");
                postEvent();
            }
        };

        this.addSource(source);
        this.addTarget(target);
    }

    public void defineComponentLabelImage1(final Actor PayloadCloan, final Actor dragActor, final Actor TargetActor){

        Source source = new Source(dragActor) {
            @Override
            public Payload dragStart(InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();

                payload.setDragActor(PayloadCloan);

                dragActor.moveBy(x,y);

                return payload;
            }

            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, Payload payload, Target target) {
                Gdx.app.log("Drag Stop","Level");
            }
        };

        Target target = new Target(TargetActor) {
            @Override
            public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
                return true;
            }

            @Override
            public void drop(Source source, Payload payload, float x, float y, int pointer) {
                Gdx.app.log("Drop Target","Level");
                postEvent();
            }
        };

        this.addSource(source);
        this.addTarget(target);
    }

}
