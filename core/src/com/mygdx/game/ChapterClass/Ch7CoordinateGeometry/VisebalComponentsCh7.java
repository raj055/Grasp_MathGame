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

            if ((value1 != null) || (synlabel1 != null)) {
                value1.setPosition(140, MyGame.HEIGHT - 130);
                synlabel1.setText(value1.getText());
            }
        }
        else if (evt == Events.DRAG_L1_VALUE3){
            Label value3 = getLabel("LabelValue3");
            Label synlabel = getLabel("SyntaxLabel");

            if ((value3 != null) || (synlabel != null)) {
                value3.setPosition(170, MyGame.HEIGHT - 130);
                synlabel.setText("3");
            }
        }
        else if (evt == Events.DRAG_L1_VALUE12){
            Label value12 = getLabel("LabelValue12");
            Label synlabel2 = getLabel("SyntaxLabel2");

            if ((value12 != null) || (synlabel2 != null)) {
                value12.setPosition(240, MyGame.HEIGHT - 250);
                synlabel2.setText(value12.getText());
            }
        }
        else if (evt == Events.DRAG_L1_VALUE14){
            Label value14 = getLabel("LabelValue14");
            Label synlabel3 = getLabel("SyntaxLabel3");

            if ((value14 != null) || (synlabel3 != null)) {
                value14.setPosition(270, MyGame.HEIGHT - 250);
                synlabel3.setText("1");
            }
        }
        else if (evt == Events.DRAG_L2_VALUE12){
            Label value12 = getLabel("LabelValue12");
            Label synlabelx1 = getLabel("SyntaxLabelx1");

            if ((value12 != null) || (synlabelx1 != null)) {
                value12.setPosition(260, MyGame.HEIGHT - 130);
                synlabelx1.setText(value12.getText());
            }
        }
        else if (evt == Events.DRAG_L2_VALUE14){
            Label value14 = getLabel("LabelValue1");
            Label synlabelx2 = getLabel("SyntaxLabelx2");

            if ((value14 != null) || (synlabelx2 != null)) {
                value14.setPosition(290, MyGame.HEIGHT - 130);
                synlabelx2.setText(value14.getText());
            }
        }
        else if (evt == Events.DRAG_L2_VALUEK1){
            Label valuek1 = getLabel("LabelValuek1");
            Label synlabelk1 = getLabel("SyntaxLabelk1");

            if ((valuek1 != null) || (synlabelk1 != null)) {
                valuek1.setPosition(110, MyGame.HEIGHT - 150);
                synlabelk1.setText(valuek1.getText());
            }
        }
        else if (evt == Events.DRAG_L2_VALUEK2){
            Label valuek2 = getLabel("LabelValuek2");
            Label synlabelk = getLabel("SyntaxLabelk");

            if ((valuek2 != null) || (synlabelk != null)) {
                valuek2.setPosition(135, 235);
                synlabelk.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L2_VALUE1){
            Label value1 = getLabel("LabelValue1");
            Label synlabely1 = getLabel("SyntaxLabely1");

            if ((value1 != null) || (synlabely1 != null)) {
                value1.setPosition(120, MyGame.HEIGHT - 300);
                synlabely1.setText(value1.getText());
            }
        }
        else if (evt == Events.DRAG_L2_VALUE3){
            Label value3 = getLabel("LabelValue3");
            Label synlabely2 = getLabel("SyntaxLabely2");

            if ((value3 != null) || (synlabely2 != null)) {
                value3.setPosition(1140, MyGame.HEIGHT - 300);
                synlabely2.setText("-3");
            }
        }
        else if (evt == Events.DRAG_L2_VALUEK3){
            Label valuek3 = getLabel("LabelValuek3");
            Label synlabelk1 = getLabel("SyntaxLabelk1");

            if ((valuek3 != null) || (synlabelk1 != null)) {
                valuek3.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 270);
                synlabelk1.setText(valuek3.getText());
            }
        }
        else if (evt == Events.DRAG_L2_VALUEK4){
            Label valuek4 = getLabel("LabelValuek4");
            Label synlabelk = getLabel("SyntaxLabelk");

            if ((valuek4 != null) || (synlabelk != null)) {
                valuek4.setPosition(135, 235);
                synlabelk.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L3_VALUE1){
            Label value1 = getLabel("LabelValue1");
            Label synlabelx33 = getLabel("SyntaxLabelx33");

            if ((value1 != null) || (synlabelx33 != null)) {
                value1.setPosition(260, MyGame.HEIGHT - 130);
                synlabelx33.setText(value1.getText());
            }
        }
        else if (evt == Events.DRAG_L3_VALUE1_1){
            Label value1_1 = getLabel("LabelValue1_1");
            Label synlabelx3 = getLabel("SyntaxLabelx3");

            if ((value1_1 != null) || (synlabelx3 != null)) {
                value1_1.setPosition(MyGame.WIDTH - 140, 185);
                synlabelx3.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L3_VALUE3){
            Label value3 = getLabel("LabelValue3");
            Label synlabely33 = getLabel("SyntaxLabely33");

            if ((value3 != null) || (synlabely33 != null)) {
                value3.setPosition(290, MyGame.HEIGHT - 130);
                synlabely33.setText(value3.getText());
            }
        }
        else if (evt == Events.DRAG_L3_VALUE3_1){
            Label value3_1 = getLabel("LabelValue3_1");
            Label synlabely3 = getLabel("SyntaxLabely3");

            if ((value3_1 != null) || (synlabely3 != null)) {
                value3_1.setPosition(100, 190);
                synlabely3.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L3_VALUE12){
            Label value12 = getLabel("LabelValue12");
            Label synlabelx11 = getLabel("SyntaxLabelx11");

            if ((value12 != null) || (synlabelx11 != null)) {
                value12.setPosition(120, MyGame.HEIGHT - 220);
                synlabelx11.setText(value12.getText());
            }
        }
        else if (evt == Events.DRAG_L3_VALUE12_1){
            Label value12_1 = getLabel("LabelValue12_1");
            Label synlabelx1 = getLabel("SyntaxLabelx1");

            if ((value12_1 != null) || (synlabelx1 != null)) {
                value12_1.setPosition(MyGame.WIDTH - 80, 265);
                synlabelx1.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L3_VALUE14){
            Label value14 = getLabel("LabelValue14");
            Label synlabelx22 = getLabel("SyntaxLabelx22");

            if ((value14 != null) || (synlabelx22 != null)) {
                value14.setPosition(150, MyGame.HEIGHT - 220);
                synlabelx22.setText(value14.getText());
            }
        }
        else if (evt == Events.DRAG_L3_VALUE14_1){
            Label value14_1 = getLabel("LabelValue14_1");
            Label synlabelx2 = getLabel("SyntaxLabelx2");

            if ((value14_1 != null) || (synlabelx2 != null)) {
                value14_1.setPosition(MyGame.WIDTH - 140, 265);
                synlabelx2.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L3_VALUE22){
            Label value22 = getLabel("LabelValue22");
            Label synlabely11 = getLabel("SyntaxLabely11");

            if ((value22 != null) || (synlabely11 != null)) {
                value22.setPosition(240, MyGame.HEIGHT - 300);
                synlabely11.setText(value22.getText());
            }
        }
        else if (evt == Events.DRAG_L3_VALUE22_1){
            Label value22_1 = getLabel("LabelValue22_1");
            Label synlabely1 = getLabel("SyntaxLabely1");

            if ((value22_1 != null) || (synlabely1 != null)) {
                value22_1.setPosition(170, 270);
                synlabely1.setVisible(false);
            }
        }
        else if (evt == Events.DRAG_L3_VALUE24){
            Label value24 = getLabel("LabelValue24");
            Label synlabely22 = getLabel("SyntaxLabely22");

            if ((value24 != null) || (synlabely22 != null)) {
                value24.setPosition(270, MyGame.HEIGHT - 300);
                synlabely22.setText(value24.getText());
            }
        }
        else if (evt == Events.DRAG_L3_VALUE24_1){
            Label value24_1 = getLabel("LabelValue24_1");
            Label synlabely2 = getLabel("SyntaxLabely2");

            if ((value24_1 != null) || (synlabely2 != null)) {
                value24_1.setPosition(100, 270);
                synlabely2.setVisible(false);
            }
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
