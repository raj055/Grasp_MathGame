package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

public class MessageBox {

    public Image Dialogbox;
    public Image NextStep;

    public Label timeUp, pause, cong, wrongAnswer;

    public ArrayList<Image> numbers = new ArrayList<Image>();

    private GlobalsCommonCount gblVar;

    private BitmapFont font;

    private Label.LabelStyle labelStyle;

    int posX = Gdx.graphics.getWidth()/2-100;
    int posY = Gdx.graphics.getHeight()/2-100;

    public MessageBox(){

        gblVar = GlobalsCommonCount.getInstance();

        font = new BitmapFont(Gdx.files.internal("fonts/gamebird.fnt"));

        labelStyle = new Label.LabelStyle(font, Color.BLACK);

        Dialogbox = new Image(new Texture("dialogbox.png"));
        Dialogbox.setPosition(posX, posY);
        Dialogbox.setSize(240,300);
        Dialogbox.setVisible(false);

        NextStep = new Image(new Texture("data/next.png"));
        NextStep.setPosition(200,350);
        NextStep.setSize(50,50);
        NextStep.setVisible(false);

        timeUp = new Label("Time UP", labelStyle);
        timeUp.setFontScale(0.9f);
        timeUp.setPosition(160,430);
        timeUp.setVisible(false);

        pause = new Label("Pause", labelStyle);
        pause.setFontScale(0.9f);
        pause.setPosition(170,430);
        pause.setVisible(false);

        cong = new Label("Congratulations", labelStyle);
        cong.setFontScale(0.6f);
        cong.setPosition(140,430);
        cong.setVisible(false);

        wrongAnswer = new Label("Wrong Answer", labelStyle);
        wrongAnswer.setFontScale(0.6f);
        wrongAnswer.setPosition(140,430);
        wrongAnswer.setVisible(false);

        numbers.add(Dialogbox);
        numbers.add(NextStep);
    }

    public void AddStage(Stage stage){
        stage.addActor(Dialogbox);
        stage.addActor(NextStep);
        stage.addActor(timeUp);
        stage.addActor(pause);
        stage.addActor(cong);
        stage.addActor(wrongAnswer);
    }

    public void ShowDialog(){
        Dialogbox.setVisible(true);
        NextStep.setVisible(true);
    }

    public void TimeUpMessage(){
        ShowDialog();
        timeUp.setVisible(true);
    }

    public void PauseMessage(){
        ShowDialog();
        pause.setVisible(true);
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
        Dialogbox.setVisible(true);
        cong.setVisible(true);
    }

    public void WrongAnswer() {
        Dialogbox.setVisible(true);
        wrongAnswer.setVisible(true);
    }
}
