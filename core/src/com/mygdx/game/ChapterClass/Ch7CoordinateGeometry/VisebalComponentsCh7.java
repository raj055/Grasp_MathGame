package com.mygdx.game.ChapterClass.Ch7CoordinateGeometry;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DRAG_LABEL;

public class VisebalComponentsCh7 implements Subscriber {

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    ArrayList<Image> visibleComponents;

    public VisebalComponentsCh7(ArrayList<Image> arrImages) {

        visibleComponents = arrImages;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_LABEL);
    }

    void updateVisibleComponents(){

        Image line = visibleComponents.get(0);
        line.setVisible(false);

        Image line1 = visibleComponents.get(1);
        line1.setVisible(true);
    }

    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == Events.DRAG_LABEL){
            updateVisibleComponents();
        }
    }
}
