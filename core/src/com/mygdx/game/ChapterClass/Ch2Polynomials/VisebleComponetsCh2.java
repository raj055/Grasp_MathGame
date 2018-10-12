package com.mygdx.game.ChapterClass.Ch2Polynomials;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_CIRCLE;

public class VisebleComponetsCh2 implements Subscriber {

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    ArrayList<Image> visibleComponents;
    private Image image;

    private GlobalsCommonCount glv;

    public VisebleComponetsCh2(ArrayList<Image> arrImages) {

        visibleComponents = arrImages;

        glv = GlobalsCommonCount.getInstance();

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_CIRCLE);
        notifier.RegisterSubscriber(this,CLICK_ScrollingCh2);
    }

    void updateVisibleComponents() {

        Image line = visibleComponents.get(0);

        Image line1 = visibleComponents.get(1);

        line.setVisible(false);
        line1.setVisible(true);

    }


    @Override
    public void UpdateAllElements(Events evt) {

        if(evt == Events.DRAG_CIRCLE){
            if(GameStates.steps == Steps.STEP_1){

            }
            else if (GameStates.steps == Steps.STEP_2){

            }
            else if (GameStates.steps == Steps.STEP_3){

            }
            updateVisibleComponents();
        }
        else if (evt == CLICK_ScrollingCh2){
            ImageVisibleLevel3();
        }
    }

    private void ImageVisibleLevel3() {

        Image syntex1 = getImage("Syntex1");
        Image imgsyntex1 = getImage("Imgsyntex1");

        Image imgsyntax = getImage("SyntaxLv13");

        Image syntex2 = getImage("Syntex2");
        Image imgsyntex2 = getImage("ImageSyntex2");
        Image imgsyntex3 = getImage("ImageSyntex3");

        if(GameStates.steps == Steps.STEP_1){
            if (glv.lableWrite) {
                if ((syntex1 != null) || (imgsyntex1 != null)) {
                    syntex1.setVisible(true);
                    imgsyntex1.setVisible(true);
                }
            }
        }
        else if (GameStates.steps == Steps.STEP_2){
            if (glv.lableWrite) {

                if ((syntex1 != null) && (imgsyntex1 != null) && (imgsyntax != null)
                        && (syntex2 != null) && (imgsyntex2 != null) && (imgsyntex3 != null)) {

                    syntex1.setVisible(false);
                    imgsyntex1.setVisible(false);
                    imgsyntax.setVisible(false);

                    syntex2.setVisible(true);
                    imgsyntex2.setVisible(true);
                    imgsyntex3.setVisible(true);
                }
            }
        }
        else if (GameStates.steps == Steps.STEP_3){
        }
    }

    private Image getImage(String ImageShow) {

        for (Image updatable : visibleComponents) {
            String str = updatable.getName();

            if (str.equals(ImageShow)){
                return updatable;
            }
        }

        return null;
    }

}
