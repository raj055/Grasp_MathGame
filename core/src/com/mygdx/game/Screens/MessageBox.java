package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Animation.AnimationClass;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Factory.GameStates;

public class MessageBox {

    public Image Dialogbox;
    public Image NextStep;

    public MessageBox(){

        Dialogbox = new Image(new Texture("dialogbox.png"));
        Dialogbox.setPosition(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-100);
        Dialogbox.setSize(240,300);
        Dialogbox.setVisible(false);

        NextStep = new Image(new Texture("data/next.png"));
        NextStep.setPosition(200,350);
        NextStep.setSize(50,50);
        NextStep.setVisible(false);
    }

    public void AddStage(Stage stage){
        stage.addActor(Dialogbox);
        stage.addActor(NextStep);
    }

    public void ShowDialog(){
        Dialogbox.setVisible(true);
        NextStep.setVisible(true);
    }
    public void Congratulations() {

    }
}
