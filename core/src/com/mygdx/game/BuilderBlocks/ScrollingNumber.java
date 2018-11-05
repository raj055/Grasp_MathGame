package com.mygdx.game.BuilderBlocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Global.GlobalsCommonCount;


import java.util.ArrayList;

public class ScrollingNumber implements Disposable {

    public ArrayList<Image> numbers = null;

    private GlobalsCommonCount gblVar;

    public ArrayList<ScrollingImageClick> scrollingNumber;

    int posX = 10;
    int posY;
    int posXFactor = 0;

    public ScrollingNumber(){

        gblVar = GlobalsCommonCount.getInstance();

        numbers = new ArrayList<Image>();

        scrollingNumber = new ArrayList<ScrollingImageClick>();
    }

    public void scrolling(ArrayList<Image> imagescrolling, Events evt){

        int totalNumbers = imagescrolling.size();

        for(int numCount = 0; numCount < totalNumbers; numCount++)
        {
            ScrollingImageClick scrollingImageClick = new ScrollingImageClick(evt);

            final Image img = (imagescrolling.get(numCount));

            scrollingImageClick.setCount(numCount);

            posY = 700 + gblVar.posYNum[numCount];
            img.setPosition(posX,posY);
            posX += 40;

            img.addListener(scrollingImageClick);

            numbers.add(img);
        }
    }

    public void setPositionX(int positionX){
        this.posXFactor = positionX + 10;
        for(Image img : numbers) {
//          img.setPosition(posX + posXFactor, posY);
            img.setPosition(img.getX() + posXFactor,img.getY());
        }
    }

    public void update(float deltaTime){

        for(Image img : numbers)
        {
            float y = img.getY();
            y -= gblVar.posYDiff[0];
            img.setPosition(img.getX(),y);
            if (y <= 0) {
                y = 700;
                float x;
                x = MathUtils.random(50 + posXFactor, 360 + posXFactor);
                img.setPosition(x, y);
            }
        }
    }
    public void addToStage(Stage stg){
        for(Image img : numbers)
        {
            stg.addActor(img);
        }
    }
    @Override
    public void dispose() {}
}
