package com.mygdx.game.ChapterClass.Ch7CoordinateGeometry;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.Notifier;
import com.mygdx.game.BuilderBlocks.Subscriber;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;

import java.util.ArrayList;

import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE14;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L1_VALUE3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE14;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUE3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK2;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L2_VALUEK4;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE12;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE12_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE14;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE14_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE1_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE22;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE22_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE24;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE24_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE3;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_L3_VALUE3_1;
import static com.mygdx.game.BuilderBlocks.Events.DRAG_LABEL;

public class VisebalComponentsCh7 implements Subscriber {

    ArrayList<Image> visibleComponentsImage;
    ArrayList<Label> visibleComponentsLabel;

    public VisebalComponentsCh7(ArrayList<Image> arrImages, ArrayList<Label> arrLabel) {

        visibleComponentsImage = arrImages;
        visibleComponentsLabel = arrLabel;

        //Get Notifier instance
        Notifier notifier = Notifier.getInstance();

        notifier.RegisterSubscriber(this,DRAG_L1_VALUE);
        notifier.RegisterSubscriber(this,DRAG_L1_VALUE3);
        notifier.RegisterSubscriber(this,DRAG_L1_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_L1_VALUE14);

        notifier.RegisterSubscriber(this,DRAG_L2_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUE14);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK1);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK2);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUE3);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK3);
        notifier.RegisterSubscriber(this,DRAG_L2_VALUEK4);

        notifier.RegisterSubscriber(this,DRAG_L3_VALUE1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE1_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE3);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE3_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE12);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE12_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE14);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE14_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE22);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE22_1);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE24);
        notifier.RegisterSubscriber(this,DRAG_L3_VALUE24_1);

    }

    @Override
    public void UpdateAllElements(Events evt) {

        if(evt == Events.DRAG_L1_VALUE){
            Label value1 = getLabel("LabelValue1");
            Label synlabel1 = getLabel("SyntaxLabel1");

            value1.setPosition(140, MyGame.HEIGHT - 130);
            synlabel1.setPosition(175,185);
            synlabel1.setText("2");
        }
        else if (evt == Events.DRAG_L1_VALUE3){
            Label value3 = getLabel("LabelValue3");
            Label synlabel = getLabel("SyntaxLabel");

            value3.setPosition(170,MyGame.HEIGHT - 130);
            synlabel.setPosition(130,185);
            synlabel.setText("8");
        }
        else if (evt == Events.DRAG_L1_VALUE12){
            Label value12 = getLabel("LabelValue12");
            Label synlabel2 = getLabel("SyntaxLabel2");

            value12.setPosition(240,MyGame.HEIGHT - 250);
            synlabel2.setPosition(MyGame.WIDTH - 75,185);
            synlabel2.setText("7");
        }
        else if (evt == Events.DRAG_L1_VALUE14){
            Label value14 = getLabel("LabelValue14");
            Label synlabel3 = getLabel("SyntaxLabel3");

            value14.setPosition(270,MyGame.HEIGHT - 250);
            synlabel3.setPosition(MyGame.WIDTH - 120,185);
            synlabel3.setText("5");
        }
        else if (evt == Events.DRAG_L2_VALUE12){
            Label value12 = getLabel("LabelValue12");
            Label synlabelx1 = getLabel("SyntaxLabelx1");

            value12.setPosition(260,MyGame.HEIGHT - 130);
            synlabelx1.setPosition(MyGame.WIDTH - 150,235);
            synlabelx1.setText("8");
        }
        else if (evt == Events.DRAG_L2_VALUE14){
            Label value14 = getLabel("LabelValue1");
            Label synlabelx2 = getLabel("SyntaxLabelx2");

            value14.setPosition(290,MyGame.HEIGHT - 130);
            synlabelx2.setPosition(160,235);
            synlabelx2.setText("5");
        }
        else if (evt == Events.DRAG_L2_VALUEK1){
            Label valuek1 = getLabel("LabelValuek1");
            Label synlabelk1 = getLabel("SyntaxLabelk1");

            valuek1.setPosition(110,MyGame.HEIGHT - 150);
            synlabelk1.setPosition(150,150);
            synlabelk1.setText("3");
        }
        else if (evt == Events.DRAG_L2_VALUEK2){
            Label valuek2 = getLabel("LabelValuek2");
            Label synlabelk = getLabel("SyntaxLabelk");

            valuek2.setPosition(135,235);
            synlabelk.setVisible(false);
        }
        else if (evt == Events.DRAG_L2_VALUE1){
            Label value1 = getLabel("LabelValue1");
            Label synlabely1 = getLabel("SyntaxLabely1");

            value1.setPosition(120,MyGame.HEIGHT - 300);
            synlabely1.setPosition(MyGame.WIDTH - 150,235);
            synlabely1.setText("4");
        }
        else if (evt == Events.DRAG_L2_VALUE3){
            Label value3 = getLabel("LabelValue3");
            Label synlabely2 = getLabel("SyntaxLabely2");

            value3.setPosition(1140,MyGame.HEIGHT - 300);
            synlabely2.setPosition(160,235);
            synlabely2.setText("-3");
        }
        else if (evt == Events.DRAG_L2_VALUEK3){
            Label valuek3 = getLabel("LabelValuek3");
            Label synlabelk1 = getLabel("SyntaxLabelk1");

            valuek3.setPosition(MyGame.WIDTH - 100,MyGame.HEIGHT - 270);
            synlabelk1.setPosition(150,150);
            synlabelk1.setText("1");
        }
        else if (evt == Events.DRAG_L2_VALUEK4){
            Label valuek4 = getLabel("LabelValuek4");
            Label synlabelk = getLabel("SyntaxLabelk");

            valuek4.setPosition(135,235);
            synlabelk.setVisible(false);
        }
        else if (evt == Events.DRAG_L3_VALUE1){
            Label value1 = getLabel("LabelValue1");
            Label synlabelx33 = getLabel("SyntaxLabelx33");

            value1.setPosition(260,MyGame.HEIGHT - 130);
            synlabelx33.setPosition(MyGame.WIDTH - 140,105);
            synlabelx33.setText("8");
        }
        else if (evt == Events.DRAG_L3_VALUE1_1){
            Label value1_1 = getLabel("LabelValue1_1");
            Label synlabelx3 = getLabel("SyntaxLabelx3");

            value1_1.setPosition(MyGame.WIDTH - 140,185);
            synlabelx3.setVisible(false);
        }
        else if (evt == Events.DRAG_L3_VALUE3){
            Label value3 = getLabel("LabelValue3");
            Label synlabely33 = getLabel("SyntaxLabely33");

            value3.setPosition(290,MyGame.HEIGHT - 130);
            synlabely33.setPosition(170,110);
            synlabely33.setText("12");
        }
        else if (evt == Events.DRAG_L3_VALUE3_1){
            Label value3_1 = getLabel("LabelValue3_1");
            Label synlabely3 = getLabel("SyntaxLabely3");

            value3_1.setPosition(100,190);
            synlabely3.setVisible(false);
        }
        else if (evt == Events.DRAG_L3_VALUE12){
            Label value12 = getLabel("LabelValue12");
            Label synlabelx11 = getLabel("SyntaxLabelx11");

            value12.setPosition(120,MyGame.HEIGHT - 220);
            synlabelx11.setPosition(MyGame.WIDTH - 80,185);
            synlabelx11.setText("2");
        }
        else if (evt == Events.DRAG_L3_VALUE12_1){
            Label value12_1 = getLabel("LabelValue12_1");
            Label synlabelx1 = getLabel("SyntaxLabelx1");

            value12_1.setPosition(MyGame.WIDTH - 80,265);
            synlabelx1.setVisible(false);
        }
        else if (evt == Events.DRAG_L3_VALUE14){
            Label value14 = getLabel("LabelValue14");
            Label synlabelx22 = getLabel("SyntaxLabelx22");

            value14.setPosition(150,MyGame.HEIGHT - 220);
            synlabelx22.setPosition(MyGame.WIDTH - 80,105);
            synlabelx22.setText("8");
        }
        else if (evt == Events.DRAG_L3_VALUE14_1){
            Label value14_1 = getLabel("LabelValue14_1");
            Label synlabelx2 = getLabel("SyntaxLabelx2");

            value14_1.setPosition(MyGame.WIDTH - 140,265);
            synlabelx2.setVisible(false);
        }
        else if (evt == Events.DRAG_L3_VALUE22){
            Label value22 = getLabel("LabelValue22");
            Label synlabely11 = getLabel("SyntaxLabely11");

            value22.setPosition(240,MyGame.HEIGHT - 300);
            synlabely11.setPosition(170,190);
            synlabely11.setText("4");
        }
        else if (evt == Events.DRAG_L3_VALUE22_1){
            Label value22_1 = getLabel("LabelValue22_1");
            Label synlabely1 = getLabel("SyntaxLabely1");

            value22_1.setPosition(170,270);
            synlabely1.setVisible(false);
        }
        else if (evt == Events.DRAG_L3_VALUE24){
            Label value24 = getLabel("LabelValue24");
            Label synlabely22 = getLabel("SyntaxLabely22");

            value24.setPosition(270,MyGame.HEIGHT - 300);
            synlabely22.setPosition(100,110);
            synlabely22.setText("2");
        }
        else if (evt == Events.DRAG_L3_VALUE24_1){
            Label value24_1 = getLabel("LabelValue24_1");
            Label synlabely2 = getLabel("SyntaxLabely2");

            value24_1.setPosition(100,270);
            synlabely2.setVisible(false);
        }
    }

    private Label getLabel(String LabelShow) {

        for (Label updatable : visibleComponentsLabel) {
            String str = updatable.getName();

            if (str.equals(LabelShow)){
                return updatable;
            }
        }
        return null;
    }
    private Image getImage(String imageName) {

        for (Image updatable : visibleComponentsImage) {
            String str = updatable.getName();

            if (str.equals(imageName)){
                return updatable;
            }
        }
        return null;
    }
}
