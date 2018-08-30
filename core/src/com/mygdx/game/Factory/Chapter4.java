package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.DoubleClickImageCh4;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.DragLabelCh4;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.ScrollingUpdateCh4;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.VisebleComponentsCh4;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter4 extends ChapterScreen implements Screen {

  private Timer time;

  ArrayList<Image> DragComponent;
  ArrayList<Image> VisebalComponent;

  DragLabelCh4 dragLabelCh4;
  VisebleComponentsCh4 visebleComponentsCh4;

  ArrayList<Image> scrollingImages = null;

  //Update on click scrolling components
  ScrollingUpdateCh4 scrollingUpdateCh4;

  //Chapter 4 Level 1 components
  public Label Labal_f1,Labal_f2,Labal_f3,Labal_f4;
  private int r = 0;

  // Level1 step2
  private Label value_f1, value_f2, value_f3;
  private Label num_1, num_2;

  // Level1 step3
  private Image background, click,imgspread,imgspread1;
  private Label cellLabel1,cellLabel2,cellLabel3,cellLabel4,cellLabel5,cellLabel6,cellLabel7;
  private Label cellLabel11,cellLabel12,cellLabel13,cellLabel14,cellLabel15,cellLabel16,cellLabel17,cellLabel18;
  private Label deviLabel1,deviLabel2,deviLabel3;
  private Label deviLabel11,deviLabel12,deviLabel13;

  // Component of level_2
  // Level2 step1
  private Image light;

  //Level2 step2
  private Image box1,box2,boxDisplay,square,square1,square2;
  private Label label_x2,plus,x4;

  // component of level_3
  private Label rLabelB,rLabelA,rLabelC,valueb,valuea,DragA1,DragA2,DragB1,DragB2,DragC1,Anser;

  private GlobalsCommonCount glv;

  ScrollingNumber numLocal;

  BallDisplay ballDisplay;

  DoubleClickImageCh4 doubleClickImageCh4;

  Chapter4(){
    super();

    time = new Timer();

    dragLabelCh4 = new DragLabelCh4(Events.DRAG_LABEL);
    visebleComponentsCh4 = new VisebleComponentsCh4(VisebalComponent);

    glv = GlobalsCommonCount.getInstance();

    getLevelName();

    initialiseLevelComponents(currentLevelNumber);
  }

  @Override
  public void show() {}

  public void update(float dt){
    time.update(dt);
  }
  @Override
  public void render(float delta) {
    renderLists[currentLevelNumber].renderL(delta);
  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
    stage.dispose();
  }

  void defineLevel1To5Components() {

    if(scrollingPara != null){

      numLocal = new ScrollingNumber();
      scrollingImages = new ArrayList<Image>();

      for(Image img : scrollingPara){
        scrollingImages.add(img);
      }
      numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh4);

      for(Image numberI : numLocal.numbers)
      {
        stage.addActor(numberI);
      }
    }
    //check if the updatables are present
    if(updatables != null) {

      ArrayList<Label> updateScrollable = new ArrayList<Label>();

      //totalObjects
      updatables.size();

      //Fill the array list for scrollable Updatables
      for (Label updatable : updatables) {
        updateScrollable.add(updatable);
      }
      scrollingUpdateCh4 = new ScrollingUpdateCh4(updateScrollable);

      //Add display balls equal to number of rows and columns.
      for (int i = 0; i < scrollingUpdateCh4.ballDisplay.columns; i++) {
        //Loop for rows
        for (int j = 0; j < scrollingUpdateCh4.ballDisplay.rows; j++) {
          stage.addActor(scrollingUpdateCh4.ballDisplay.balls[i][j]);
          scrollingUpdateCh4.ballDisplay.balls[i][j].setVisible(false);
        }
      }
    }
  }

  void defineLevel6To10Components() {

    //check if the displayImages are present
    if(displayImages == null)
      return;

    //totalObjects
    displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      if (str.contains("light")) {
        light = updatable;
        light.addListener(dragLabelCh4);
      }
      else if (str.contains("Square")) {
        square = updatable;
      }
      else if (str.contains("Square1")) {
        square1 = updatable;
      }
      else if (str.contains("Square2")) {
        square2 = updatable;
      }
      else if (str.contains("box1")) {
        box1 = updatable;
      }
      else if (str.contains("box2")) {
        box2 = updatable;
      }
      else if (str.contains("boxDisplay")) {
        boxDisplay = updatable;
      }

    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Labelx2")) {
        label_x2 = updatable;
      } else if (str.contains("Labelplus")) {
        plus = updatable;
      }else if (str.contains("Labelx4")) {
        x4 = updatable;
      }
    }
  }
  void defineLevel11To15Components() {
    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Valueb")) {
        valueb = updatable;
      } else if (str.contains("rLabelB")) {
        rLabelB = updatable;
      }else if (str.contains("rLabelA")) {
        rLabelA = updatable;
      }else if (str.contains("rLabelC")) {
        rLabelC = updatable;
      }else if (str.contains("Valuea")) {
        valuea = updatable;
      }else if (str.contains("DragLabelA")) {
        DragA1 = updatable;
      }else if (str.contains("DragLabelA2")) {
        DragA2 = updatable;
      }else if (str.contains("DragLabelB1")) {
        DragB1 = updatable;
      }else if (str.contains("DragLabelB2")) {
        DragB2 = updatable;
      }else if (str.contains("DragLabelC1")) {
        DragC1 = updatable;
      }
    }
  }

  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = (LevelDefinition[]) new LevelDefinition[] {
          new LevelDefinition() {
            public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },

  };

  public void initialiseLevelComponents(int index) {
    levelInitialisations[index].initialise();
  }

  interface RenderLevel {
    void renderL(float delta);
  }

  private RenderLevel[] renderLists = (RenderLevel[]) new RenderLevel[] {
          new RenderLevel() {
            public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } }
  };

  public void renderLevels(int index) {
//    renderLists[index].renderL( );
  }

  private void renderLevel1(float deltaTime){

    //Update time
    update(deltaTime);

    //Update the scrolling variables if any
    if(numLocal != null)
      numLocal.update(deltaTime);

    //Time up
    if (time.isTimeUp()){ }

    //Draw stage and timer
    stage.draw();
    time.stage.draw();
  }


  private void renderLevel2(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    time.update(deltaTime);

    if (time.isTimeUp()){}

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    time.update(deltaTime);

    if (time.isTimeUp()){}

    stage.draw();
    time.stage.draw();

  }
}
