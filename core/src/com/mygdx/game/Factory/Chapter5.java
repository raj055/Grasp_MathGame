package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.ScrollingUpdateCh5;
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.VisebalComponentsCh5;
import com.mygdx.game.Enum.ClickPluse;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.Screens.MessageBox;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

public class Chapter5 extends ChapterScreen implements Screen {

  ArrayList<Image> DragComponent;
  ArrayList<Image> VisebalComponent;

  VisebalComponentsCh5 visebalComponentsCh5;

  //Update components on clicking scrolling values
  ScrollingUpdateCh5 scrollingUpdateCh5;

  //Double click listeners for plus
  DoubleClickListener dblClickListenerPlus;

  //Drag click listeners
  DragClickListener drag_l1_value1,drag_l1_value2,drag_l1_value12,drag_l1_value13;

  ArrayList<Image> scrollingImages = null;

  private GlobalsCommonCount glv;
  ScrollingNumber numLocal;

  private ArrayList<DragClickListener> arrDragListener;
  private ArrayList<DoubleClickListener> arrClickListener;

  Chapter5(){
    super();

    messageBox = new MessageBox();
    messageBox.AddStage(stage);

    glv = GlobalsCommonCount.getInstance();

    getLevelName();
    initialiseLevelComponents(currentLevelNumber);
  }

  @Override
  public void show() { }

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

    dblClickListenerPlus = new DoubleClickListener(Events.DOUBLE_CLICK_ADD);

    drag_l1_value1 = new DragClickListener(Events.DRAG_C5L1_VALUE1);
    drag_l1_value2 = new DragClickListener(Events.DRAG_C5L1_VALUE2);
    drag_l1_value12 = new DragClickListener(Events.DRAG_C5L1_VALUE12);
    drag_l1_value13 = new DragClickListener(Events.DRAG_C5L1_VALUE13);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(drag_l1_value1);

    arrClickListener = new ArrayList<DoubleClickListener>();
    arrClickListener.add(dblClickListenerPlus);

    String  updatableNamesLevel1Drag[] = {"Value1", "Value2", "Value12","Value13"};
    String  updatableNamesLevel1Click[] = {"Pluse", "Pluse1", "Pluse2","Pluse3"};

    if(updatables != null) {

      updatables.size();
      for (Label updatable : updatables) {
        String str = updatable.getName();
        for(int count = 0; count < updatableNamesLevel1Drag.length; count++){
          if(str.equals(updatableNamesLevel1Drag[count]))
            updatable.addListener(arrDragListener.get(count));
        }
        for(int count = 0; count < updatableNamesLevel1Click.length; count++){
          if(str.equals(updatableNamesLevel1Click[count]))
            updatable.addListener(arrClickListener.get(count));
        }
      }
    }

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6To10Components() {

      if(scrollingPara != null) {
        numLocal = new ScrollingNumber();
        scrollingImages = new ArrayList<Image>();

        //totalObjects
        scrollingPara.size();

        for (Image img : scrollingPara) {
          scrollingImages.add(img);
          stage.addActor(img);
        }
        numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh5);
      }
      //check if the updatable are present
      if(updatables != null) {
        //totalObjects
        updatables.size();
        for (Label updatable : updatables) {
          updatable.getName();
        }
        scrollingUpdateCh5 = new ScrollingUpdateCh5(updatables);
      }

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel11To15Components() {

    if(GameStates.steps == Steps.STEP_1){

    }
    else if ((GameStates.steps == Steps.STEP_2) || (GameStates.steps == Steps.STEP_3)){
      if(scrollingPara != null) {

        numLocal = new ScrollingNumber();
        numLocal.setPositionX(xPosAdditionFactor - 400);
        scrollingImages = new ArrayList<Image>();

        //totalObjects
        scrollingPara.size();

        for (Image img : scrollingPara) {
          scrollingImages.add(img);
          stage.addActor(img);
        }
        numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh5L3);
      }
        //check if the updatable are present
      if(updatables != null) {
        //totalObjects
        updatables.size();
        for (Label updatable : updatables) {
          updatable.getName();
        }
        scrollingUpdateCh5 = new ScrollingUpdateCh5(updatables);
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

  private void renderLevel1(float delta){
    update(delta);

    if (time.isTimeUp()){ }

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(delta);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);

    //Check if the local numbers are declared.
    if(numLocal != null)
      numLocal.update(delta);

    if (time.isTimeUp()){}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(delta);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){

    time.update(deltaTime);
    if(numLocal != null)
    numLocal.update(deltaTime);

    if (time.isTimeUp()){}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();

  }
}
