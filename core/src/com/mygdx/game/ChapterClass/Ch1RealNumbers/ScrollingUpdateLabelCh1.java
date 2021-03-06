package com.mygdx.game.ChapterClass.Ch1RealNumbers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.StringBuilder;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.CLICK_ScrollingCh1;

public class ScrollingUpdateLabelCh1 implements Subscriber {

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    ArrayList<Label> UpdateLable;

    private GlobalsCommonCount glv;

    public BallDisplay ballDisplay;

    int FinalScore;

    public ScrollingUpdateLabelCh1(ArrayList<Label> arrLabel){

        UpdateLable = arrLabel;

        glv = GlobalsCommonCount.getInstance();

        ballDisplay = new BallDisplay(9,9);

        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this, CLICK_ScrollingCh1);
    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(evt == CLICK_ScrollingCh1){
            ImageClick1();
        }
    }

    private void ImageClick1() {

        ballDisplay.update();

        Label labelX = getLabel("LabelB");

        Label Score = getLabel("Score1");

        Gdx.app.log("Click 1",labelX.toString());

        if (glv.lableWrite){

            glv.lableWrite = false;

            StringBuilder str = new StringBuilder(labelX.getText());
            str.append(glv.lableUpdate);
            str.append("*");
            labelX.setText(str);
            Gdx.app.log("labelUpdate", String.valueOf(glv.countClick));

            switch (glv.countClick) {
                case 1:
                    glv.click1 = glv.lableUpdate;
                    Gdx.app.log("Click global value 1", String.valueOf(glv.click1));
                    break;

                case 2:
                    glv.click2 = glv.lableUpdate;
                    Gdx.app.log("Click 2",String.valueOf(glv.click2));
                    break;

                default:
                    break;
            }

            for (int i = 0; i < glv.click1; i++){
                ballDisplay.balls[i][0].setVisible(true);
                for (int j = 0; j < glv.click2; j++) {
                    ballDisplay.balls[i][j].setVisible(true);
                }
            }

            FinalScore = glv.click1 * glv.click2;

            Score.setText("" + FinalScore);
        }
    }

    private Label getLabel(String LabelShow) {

        for (Label updatable : UpdateLable) {
            String str = updatable.getName();

            if (str.equals(LabelShow)){
                return updatable;
            }
        }
        return null;
    }
}
