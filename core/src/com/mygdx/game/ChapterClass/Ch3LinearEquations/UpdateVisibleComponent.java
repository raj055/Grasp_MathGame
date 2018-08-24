package com.mygdx.game.ChapterClass.Ch3LinearEquations;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DOUBLE_CLICK;

public class UpdateVisibleComponent implements Subscriber {

    ChapterVariables chapterVariables = ChapterVariables.getInstance();
    ArrayList<Image> visibleComponents;

    public UpdateVisibleComponent(ArrayList<Image> arrayList){

        //Assign the visible components
        visibleComponents = arrayList;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        //Register for the ball drag and remainder ball drag events.
        notifier.RegisterSubscriber(this, DOUBLE_CLICK);
    }

    private void updateVisibleComponents() {
        Image imgsqureL = visibleComponents.get(0);
        imgsqureL.setVisible(true);
    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(evt == Events.BALL_DRAG_EVENT){

            updateVisibleComponents();
        }
    }
}
