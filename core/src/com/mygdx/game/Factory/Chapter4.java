package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.ScrollingUpdateCh4;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.VisebleComponentsCh4;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.Screens.MessageBox;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

public class Chapter4 extends ChapterScreen implements Screen {

  private ArrayList<Image> DragComponent;
  private ArrayList<Image> VisebalComponent;

  private DragClickListener draglight;
  private DragClickListener dragsquare;
  private DragClickListener dragsquare1;
  private DragClickListener dragsquare2;
  private DragClickListener dragbox1;

  private DragClickListener dragA1;
  private DragClickListener dragA2;
  private DragClickListener dragB1;
  private DragClickListener dragB2;
  private DragClickListener dragB3;
  private DragClickListener dragC1;
  private DragClickListener dragC2;

  private VisebleComponentsCh4 visebleComponentsCh4;
  private ArrayList<Image> scrollingImages = null;
  //Update on click scrolling components
  private ScrollingUpdateCh4 scrollingUpdateCh4;
  private ScrollingNumber numLocal;
  private BallDisplay ballDisplay;
  private DoubleClickListener doubleclicklistener;
  private ArrayList<DragClickListener> arrDragListener;

  Chapter4(){
    super();

    messageBox = new MessageBox();
    messageBox.AddStage(stage);

    visebleComponentsCh4 = new VisebleComponentsCh4(VisebalComponent);

    getLevelName();
    initialiseLevelComponents(currentLevelNumber);
  }

  @Override
  public void show() {}

  public void update(float dt){ time.update(dt); }
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
//        if(stageTranslate >= 1200) {
//          trnslate = 0;
//          stageTranslate = 0;
//        }

        //Get the Level Number and Initialise the Level Components.
        getLevelName();
        initialiseLevelComponents(currentLevelNumber);

        stage.getCamera().translate(trnslate,0,0);
        stage.getCamera().update();
      }
    }
  };

  void defineLevel1To5Components() {

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)){
      if(scrollingPara != null){
        numLocal = new ScrollingNumber();
        numLocal.setPositionX(xPosAdditionFactor - 400);
        scrollingImages = new ArrayList<Image>();

        for(Image img : scrollingPara){
          scrollingImages.add(img);
          stage.addActor(img);
        }
        numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh4);
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
    else if (GameStates.steps == Steps.STEP_3){
      String  updatableNamesLevel3Step3[] = {"Celllabel1", "Celllabel3", "Celllabel4","Celllabel5",
              "Celllabel7","Celllabel11","Celllabel12","Celllabel14","Celllabel16"};
    }

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6To10Components() {

    draglight = new DragClickListener(Events.DRAG_IMGLIGHT);
    dragsquare = new DragClickListener(Events.DRAG_IMGSQUARE);
    dragsquare1 = new DragClickListener(Events.DRAG_IMGSQUARE1);
    dragsquare2 = new DragClickListener(Events.DRAG_IMGSQUARE2);
    dragbox1 = new DragClickListener(Events.DRAG_IMGBOX1);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(draglight);
    arrDragListener.add(dragsquare);
    arrDragListener.add(dragsquare1);
    arrDragListener.add(dragsquare2);
    arrDragListener.add(dragbox1);

    String  updatableNamesLevel2Step1[] = {"light"};
    String  updatableNamesLevel2Step2[] = {"Square", "Square1", "Square2","box1"};

    if(GameStates.steps == Steps.STEP_1){
      //check if the displayImages are present
      if(displayImages != null) {
        //totalObjects
        displayImages.size();
        for (Image updatable : displayImages) {
          String str = updatable.getName();
          for(int count = 0; count < updatableNamesLevel2Step1.length; count++){
            if(str.equals(updatableNamesLevel2Step1[count]))
              updatable.addListener(arrDragListener.get(count));
          }
        }
      }
    }
    else if (GameStates.steps == Steps.STEP_2){
      //check if the displayImages are present
      if(displayImages != null) {
        //totalObjects
        displayImages.size();
        for (Image updatable : displayImages) {
          String str = updatable.getName();
          for(int count = 0; count < updatableNamesLevel2Step2.length; count++){
            if(str.equals(updatableNamesLevel2Step2[count]))
              updatable.addListener(arrDragListener.get(count));
          }
        }
      }
    }
    else if (GameStates.steps == Steps.STEP_3){}

    //check if the updatable are present
    if(updatables != null){
      //totalObjects
      updatables.size();
      for (Label updatable : updatables) {
        updatable.getName();
      }
    }
    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel11To15Components() {

    dragA1 = new DragClickListener(Events.DRAGA1);
    dragA2 = new DragClickListener(Events.DRAGA2);
    dragB1 = new DragClickListener(Events.DRAGB1);
    dragB2 = new DragClickListener(Events.DRAGB2);
    dragB3 = new DragClickListener(Events.DRAGB3);
    dragC1 = new DragClickListener(Events.DRAGC1);
    dragC2 = new DragClickListener(Events.DRAGC2);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(dragA1);
    arrDragListener.add(dragA2);
    arrDragListener.add(dragB1);
    arrDragListener.add(dragB2);
    arrDragListener.add(dragB3);
    arrDragListener.add(dragC1);
    arrDragListener.add(dragC2);

    String  updatableNamesLevel3[] = {"DragLabelA", "DragLabelA2", "DragLabelB","DragLabelB1",
            "DragLabelB2","DragLabelC","DragLabelC1"};

      //check if the updatable are present
      if(updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          for(int count = 0; count < updatableNamesLevel3.length; count++){
            if(str.equals(updatableNamesLevel3[count]))
              updatable.addListener(arrDragListener.get(count));
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

  interface LevelDefinition { void initialise(); }

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

  interface RenderLevel { void renderL(float delta); }

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

  private void renderLevel1(float deltaTime){

    //Update time
    update(deltaTime);

    //Update the scrolling variables if any
    if(numLocal != null)
      numLocal.update(deltaTime);

    //Time up
    if (time.isTimeUp()){ }

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    //Draw stage and timer
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    time.update(deltaTime);
    if (time.isTimeUp()){}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    if (time.isTimeUp()){}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
}
