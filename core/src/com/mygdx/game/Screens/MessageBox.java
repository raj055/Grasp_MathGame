package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Animation.AnimationClass;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Tools.Assets;

import java.util.ArrayList;

public class MessageBox {

    public Image Dialogbox;
    public Image NextStep;

    public ArrayList<Image> numbers = new ArrayList<Image>();

    private GlobalsCommonCount gblVar;

    int posX = Gdx.graphics.getWidth()/2-100;
    int posY = Gdx.graphics.getHeight()/2-100;

    public MessageBox(){

        gblVar = GlobalsCommonCount.getInstance();

        Dialogbox = new Image(new Texture("dialogbox.png"));
        Dialogbox.setPosition(posX, posY);
        Dialogbox.setSize(240,300);
        Dialogbox.setVisible(false);

        NextStep = new Image(new Texture("data/next.png"));
        NextStep.setPosition(200,350);
        NextStep.setSize(50,50);
        NextStep.setVisible(false);

        numbers.add(Dialogbox);
        numbers.add(NextStep);
    }

    public void AddStage(Stage stage){
        stage.addActor(Dialogbox);
        stage.addActor(NextStep);
    }

    public void ShowDialog(){
        Dialogbox.setVisible(true);
        NextStep.setVisible(true);
    }

    public void setPositionX(int positionX){
        this.posX = positionX + 10;
    }

    public void update(float deltaTime){

        for(Image img : numbers)
        {
            float y = img.getY();
            img.setPosition(img.getX(),y);
            y = 250;
            float x;
            x = 100 + posX;
            img.setPosition(x, y);

        }
    }
    public void Congratulations() {

    }
}
