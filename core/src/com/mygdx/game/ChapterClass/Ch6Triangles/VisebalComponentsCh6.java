package com.mygdx.game.ChapterClass.Ch6Triangles;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.MyGame;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DRAG_TRIANGLE_P;

public class VisebalComponentsCh6 implements Subscriber {

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    ArrayList<Image> visibleComponents;

    public VisebalComponentsCh6(ArrayList<Image> arrImages) {

        visibleComponents = arrImages;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_TRIANGLE_P);
    }


    @Override
    public void UpdateAllElements(Events evt) {
        if(evt == Events.DRAG_TRIANGLE_P){
            imageTriangle();
        }
    }

    private void imageTriangle() {

//        triangle_p.setPosition(170, MyGame.HEIGHT - 390);
    }

}
