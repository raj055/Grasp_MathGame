package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingImageClick;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.ScrollingUpdateLabelCh1;
import com.mygdx.game.ChapterClass.Ch2Polynomials.DragPoint;
import com.mygdx.game.ChapterClass.Ch2Polynomials.ScrollingUpdateLabelCh2;
import com.mygdx.game.ChapterClass.Ch2Polynomials.VisebleComponetsCh2;
import com.mygdx.game.Component.Nagetiv_Num;
import com.mygdx.game.Component.TextVeriabal;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Global.Objects;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.Timer.Timer;

import java.awt.Event;
import java.util.ArrayList;


public class Chapter2 extends ChapterScreen implements Screen {

  private Timer time;

  ArrayList<Image> imagesLines;
  ArrayList<Image> dragCircle;
  ArrayList<Image> scrollingImages = null;
  ArrayList<Label> updateScrollLable = null;
  ArrayList<Image> imageViseble = null;

  private int stageTranslate = 0;

  int stepNo = 0;

  private Image submit = null;

  //Update visible components on scrolling clicked
  ScrollingUpdateLabelCh1 scrollingUpdateLableCh1;

  // component of level_2
  Label Labal_f2 = null;
  Label Labal_f3 = null;
  Label Labal_f4 = null;

  //submit button
  private Image submitButton = null;

  //level_2 step2
  Label num_1,num_2;
  //level_2 step1
  Label Labal_f1 = null;

  // component of level_3
  Image syntex1 = null;
  Image imggreen = null;
  Image imgsyntex1 = null;

  Label quotient;

  private GlobalsCommonCount glv;

  Objects object;

  TextVeriabal textVeriabal;

  ScrollingNumber numLocal;

  BallDisplay ballDisplay;

  Nagetiv_Num nagetivNum;

  boolean moveTheBg = false;

  private DragPoint dragPoint;

  private VisebleComponetsCh2 visebleComponetsCh2;

  private ScrollingImageClick scrollingImageClick;

  private ScrollingUpdateLabelCh2 scrollingUpdateLabelCh2;

  Chapter2(){
    super();

    time = new Timer();

    glv = GlobalsCommonCount.getInstance();

    object = Objects.getInstance();

    dragPoint = new DragPoint(Events.DRAG_CIRCLE);

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
  public void resume() { }

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
        //Get the Level Number and Initialise the Level Components.
        getLevelName();
        initialiseLevelComponents(currentLevelNumber);

        stage.getCamera().translate(trnslate,0,0);
        stage.getCamera().update();
      }
    }
  };
  // Level's Component
  void defineLevel1to5Components() {

    if(displayImages == null)
      return;

    imagesLines = new ArrayList<Image>();
    dragCircle = new ArrayList<Image>();

   //totalObjects
    displayImages.size();

      for (Image updatable : displayImages) {
        String str = updatable.getName();

        if (str.contains("line")) {
          imagesLines.add(updatable);
        }
      }

    visebleComponetsCh2 = new VisebleComponetsCh2(imagesLines);

    if(draggable == null) {
      return;
    }
    try {
      for (Image draggables : draggable) {
        if (draggables.getName().contains("DragCircle")) {
          draggables.addListener(dragPoint);
          dragCircle.add(draggables);
        }
          dragPoint.setDisplayBalls(dragCircle);
      }
    }catch (Exception e){}
    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6to10Components() {

    if(scrollingPara != null){

      numLocal = new ScrollingNumber();
      numLocal.setPositionX(xPosAdditionFactor - 400);
      scrollingImages = new ArrayList<Image>();

      updateScrollLable = new ArrayList<Label>();

      //totalObjects
      scrollingPara.size();

      for(Image img : scrollingPara)
      {
        scrollingImages.add(img);
      }
      numLocal.scrolling(scrollingImages, Events.CLICK_SCROLLCH2_BALLDISPLAY);

      ballDisplay = new BallDisplay(8, 8);
    }

    //check if the updatable are present
    if(updatables != null){
      updatables.size();

      for (Label updatable : updatables) {
        updatable.getName();
        updateScrollLable.add(updatable);
      }
      scrollingUpdateLabelCh2 = new ScrollingUpdateLabelCh2(updateScrollLable);

      for (int i = 0; i < ballDisplay.columns; i++){

        for (int j = 0; j < ballDisplay.rows; j++) {

          stage.addActor(scrollingUpdateLabelCh2.ballDisplay.balls[i][j]);

          scrollingUpdateLabelCh2.ballDisplay.balls[i][j].setVisible(false);
        }
      }

      for(Image numberI : scrollingPara)
      {
        stage.addActor(numberI);
      }
    }

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel11to15Components() {

    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();
    numLocal.setPositionX(xPosAdditionFactor - 400);
    scrollingImages = new ArrayList<Image>();

    updateScrollLable = new ArrayList<Label>();

    imageViseble = new ArrayList<Image>();

    //totalObjects
    scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

    }

    numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh2);

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();

    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("quotient")) {
        quotient = updatable;
      }

      updateScrollLable.add(updatable);
    }

    scrollingUpdateLabelCh2 = new ScrollingUpdateLabelCh2(updateScrollLable);

    if(displayImages == null)
      return;

     displayImages.size();

    for (Image updatable : displayImages) {
      String str = updatable.getName();

      if (str.contains("Syntex1")) {
        syntex1 = updatable;
      }
      else if (str.contains("Imgsyntex1")) {
        imgsyntex1 = updatable;
      }

      imageViseble.add(updatable);

    }

    visebleComponetsCh2 = new VisebleComponetsCh2(imageViseble);

    for(Image numberI : scrollingPara)
    {
      stage.addActor(numberI);
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
            public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },

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

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();

    if(moveTheBg) {
      bg.act(delta);
//      moveTheBg = false;
    }

    time.stage.draw();


  }
  private void renderLevel2(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    time.update(deltaTime);

    numLocal.update(deltaTime);
//    ballDisplay.update(deltaTime);

 /*   int ballclick = 0;

    switch (GameStates.steps) {
      case STEP_1:
        if (glv.lableWrite) {

          switch (glv.countClick) {
            case 1:
              Labal_f1.setText(glv.lableUpdate + " ");
              ballclick = glv.click1 = glv.lableUpdate;
              break;
            case 2:
              Labal_f2.setText(glv.lableUpdate + " ");
              ballclick = glv.click2 = glv.lableUpdate;
              break;
            case 3:
              Labal_f3.setText(glv.lableUpdate + " ");
              ballclick = glv.click3 = glv.lableUpdate;
              break;
            case 4:
              Labal_f4.setText(glv.lableUpdate + " ");
              ballclick = glv.click4 = glv.lableUpdate;

              break;

            default:
              break;
          }

          for (int i = 0; i < ballclick; i++) {

            ballDisplay.balls[i][r].setVisible(true);

          }
        }
        break;

      case STEP_2:
        if (glv.lableWrite) {

          switch (glv.countClick) {
            case 1:
              num_1.setText(glv.lableUpdate + " ");
              break;
            case 2:
              num_2.setText(glv.lableUpdate + " ");

              break;

            default:
              break;
          }
        }
        break;

      default:
        break;
    }*/

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();

    if(moveTheBg) {
      bg.act(deltaTime);
//      moveTheBg = false;
    }

    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    time.update(deltaTime);

    numLocal.update(deltaTime);
/*
    if (glv.lableWrite){

      quotient.setText(textVeriabal.string_labal + " ");

      imggreen.setVisible(true);
      syntex1.setVisible(true);
      imgsyntex1.setVisible(true);
    }*/

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();

    if(moveTheBg) {
      bg.act(deltaTime);
//      moveTheBg = false;
    }

    time.stage.draw();
  }

}
