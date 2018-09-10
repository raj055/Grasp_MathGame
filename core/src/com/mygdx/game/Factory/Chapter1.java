package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Animation.AnimationClass;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ProgressData;
import com.mygdx.game.BuilderBlocks.ScrollingImageClick;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.ScrollingUpdateLabelCh1;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDragListener;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.DragBallIndicators;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.RemainderDragListener;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.VisibleComponents;
import com.mygdx.game.Timer.Timer;


import java.util.ArrayList;

import static com.mygdx.game.Global.GlobalsCommonCount.ValueA;


/**
 * Created by HP on 12-01-2018.
 */

public class Chapter1 extends ChapterScreen implements Screen {

  //Get the components of level 1
  private Image progbar1;
  ArrayList<Image> displayBalls = null;
  ArrayList<Image> remainderBall = null;
  ArrayList<Image> scrollingImages = null;
  ArrayList<Label> updateScrollLable = null;

  //Number of display balls for the LCM
  BallDisplay ballDisplay;

  //Ball Drag Listener
  BallDragListener ballDragListener;
  RemainderDragListener remBallDragListener;

  //Scrolling Number
  ScrollingNumber numLocal;

  //Indicators
  DragBallIndicators dragBallIndicators;

  //Dependant Components
  VisibleComponents visibleComponents;

  ScrollingUpdateLabelCh1 scrollingUpdateLableCh1;

  private ScrollingImageClick scrollingImageClick;

  //submit button
  private Image submitButton = null;

  //Animation
  AnimationClass animationClass;
  private float elapsed_time;

  Chapter1(){
    super();

    animationClass = new AnimationClass();
    animationClass.BirdAnimation();

    //Define all Listeners and Updation Objects
    ballDragListener = new BallDragListener(Events.BALL_DRAG_EVENT);
    remBallDragListener = new RemainderDragListener(Events.REMAINDER_BALL_DRAG);

    getLevelName();
    initialiseLevelComponents(currentLevelNumber);
  }

  //update the time
  public void update(float dt){
    time.update(dt);
  }
  @Override
  public void show() {}

  @Override
  public void render(float delta) {
    renderLists[currentLevelNumber].renderL(delta);
  }

  @Override
  public void resize(int width, int height) { }

  @Override
  public void pause() { }

  @Override
  public void resume() { }

  @Override
  public void hide() { }

  @Override
  public void dispose() {
    stage.dispose();
  }

  // Drag Remainder Ball
  private void attachDraggables(){
    if(draggable == null) {
      return;
    }
    try {
      for (Image draggables : draggable) {
        if (draggables.getName().contains("RemBall")) {
          draggables.addListener(remBallDragListener);
        } else {
            draggables.addListener(ballDragListener);
        }
      }
    }
    catch (Exception e){ }
  }

  // Submit Button ClickListener
  ClickListener submitButtonClicked = new ClickListener(){
    @Override
    public  void clicked(InputEvent event, float x, float y){

      if(goToNextStep() != true) {
        GameStates.screenStates = ScreenStates.LEVELSCREEN;
        time.dispose();
      }
      else{

        int trnslate = 400;
        stageTranslate += 400;
        //Get the Level Number and Initialise the Level Components.
        getLevelName();
        initialiseLevelComponents(currentLevelNumber);

        stage.getCamera().translate(trnslate,0,0);
        stage.getCamera().update();
      }
    }
  };

  private void defineLevel1To10Components() {
    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)
            || (GameStates.steps == Steps.STEP_3) || (GameStates.steps == Steps.STEP_4)
            || (GameStates.steps == Steps.STEP_5) || (GameStates.steps == Steps.STEP_6)
            || (GameStates.steps == Steps.STEP_7)){

      //check if the updatable are present
      if(updatables != null) {
        updatables.size();

        ArrayList<ProgressData> updateLabelsList = new ArrayList<ProgressData>();

        for (Label updatable : updatables) {
          //Array List of Labels
          ProgressData prgDataLabel = new ProgressData();
          String txt = updatable.getText().toString();

          //Progress Data Label
          prgDataLabel.visibleEntity = updatable;
          prgDataLabel.valueVar = Integer.valueOf(txt);
          updateLabelsList.add(prgDataLabel);

          //Update Value of A
          chapterVariables.chapter1Variables.ValueOfA = ValueA[currentLevelNumber];
          Gdx.app.debug("Current Level Number", String.valueOf(currentLevelNumber));
          Gdx.app.debug("Value of A", String.valueOf(chapterVariables.chapter1Variables.ValueOfA));
        }
        //Put components
        dragBallIndicators = new DragBallIndicators(updateLabelsList);
      }

      if(displayImages != null) {

        displayBalls = new ArrayList<Image>();
        displayBallList = new ArrayList<Image>();
        remainderBall = new ArrayList<Image>();

        displayImages.size();

        for (Image updatable : displayImages) {
          String str = updatable.getName();
          if (str.contains("progBar1"))
            progbar1 = updatable;
          else if (str.contains("displayBall")) {
            displayBallList.add(updatable);
          }
        }
        //Components to be updated on receiving an event
        visibleComponents = new VisibleComponents(progbar1, displayBallList);

        draggable.size();

        for (Image updatable : draggable) {
          String str = updatable.getName();
          if (str.contains("DragBall")) {
            chapterVariables.chapter1Variables.ValueOfB++;
            displayBalls.add(updatable);
          } else if (str.contains("RemBall"))
            remainderBall.add(updatable);
        }
        ballDragListener.setDisplayBalls(displayBalls);

        attachDraggables();
      }
    }
    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  private void defineLevel11to15Components() {

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)
            || (GameStates.steps == Steps.STEP_3) || (GameStates.steps == Steps.STEP_4)
            || (GameStates.steps == Steps.STEP_5) || (GameStates.steps == Steps.STEP_6)){

      if(scrollingPara != null){
        numLocal = new ScrollingNumber();
        numLocal.setPositionX(xPosAdditionFactor - 400);
        scrollingImages = new ArrayList<Image>();
        scrollingPara.size();
        for(Image img : scrollingPara)
        {
          scrollingImages.add(img);
          stage.addActor(img);
        }
        numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh1);
      }
      //check if the updatable are present
      if(updatables != null) {
        updateScrollLable = new ArrayList<Label>();
        updatables.size();

        for (Label updatable : updatables) {
          updatable.getName();
          updateScrollLable.add(updatable);
        }
      }
      scrollingUpdateLableCh1 = new ScrollingUpdateLabelCh1(updateScrollLable);
      ballDisplay = new BallDisplay(9,9);

      for (int i = 0; i < ballDisplay.columns; i++){

        for (int j = 0; j < ballDisplay.rows; j++) {

          stage.addActor(scrollingUpdateLableCh1.ballDisplay.balls[i][j]);
          scrollingUpdateLableCh1.ballDisplay.balls[i][j].setVisible(false);
        }
      }
    }
    //Add Submit Button Listener.
    addSubmitButtonListner();
  }

  void addSubmitButtonListner(){
    //Add Click Listener to the Submit Button
    if(buttonsList != null){
      for(Image subBtn : buttonsList){
        String name = subBtn.getName();
        if (name.equalsIgnoreCase("SubmitButtn")){
          submitButton = subBtn;
          submitButton.addListener(submitButtonClicked);
        }
      }
    }
  }

  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = new LevelDefinition[] {
          new LevelDefinition() {
            public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },

  };

  private void initialiseLevelComponents(int index) {
    levelInitialisations[index].initialise();
  }

  interface RenderLevel {
    void renderL(float delta);
  }

  private RenderLevel[] renderLists = new RenderLevel[] {
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

  private void renderLevel1(float delta){
    update(delta);
    stage.draw();
    if (time.isTimeUp()){
      elapsed_time += Gdx.graphics.getDeltaTime();
      animationClass.update(elapsed_time);
    }
    if(moveTheBg) { bg.act(delta); }
    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);
    if (time.isTimeUp()){}
    stage.draw();
    if(moveTheBg) { bg.act(delta); }
    time.stage.draw();

  }
  private void renderLevel3(float deltaTime){
    numLocal.update(deltaTime);
    if (time.isTimeUp()){}
    if(moveTheBg) { bg.act(deltaTime); }
    stage.draw();
    time.stage.draw();
  }

}
