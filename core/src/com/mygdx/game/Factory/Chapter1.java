package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Animation.AnimationClass;
import com.mygdx.game.BuilderBlocks.ChapterVariables;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ProgressData;
import com.mygdx.game.BuilderBlocks.ScrollingImageClick;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.ScrollingUpdateLabelCh1;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDragListener;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.DragBallIndicators;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.RemainderDragListener;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.VisibleComponents;
import com.mygdx.game.MyGame;
import com.mygdx.game.Timer.Timer;


import java.util.ArrayList;

import static com.mygdx.game.Global.GlobalsCommonCount.ValueA;


/**
 * Created by HP on 12-01-2018.
 */

public class Chapter1 extends ChapterScreen implements Screen {

  //Level 1 variables
  private Timer time;
  private GlobalsCommonCount glv;

  //Get the components of level 1
  private Image progbar1;
  ArrayList<Image> displayBalls = null;
  ArrayList<Image> remainderBall = null;

  ArrayList<Image> scrollingImages = null;

  ArrayList<Label> updateScrollLable = null;

  //Get the components of level 3
  Label labelX;

  boolean moveTheBg = false;

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

  //Animation
  AnimationClass animationClass;
  private float elapsed_time;

  Chapter1(){
    super();

    time = new Timer();

    glv = GlobalsCommonCount.getInstance();

    animationClass = new AnimationClass();
    animationClass.show();

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
  public void pause() {}

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

  private void defineLevel1To10Components() {

    //check if the updatable are present
    if(updatables == null)
      return;

    ChapterVariables chapterVariables = ChapterVariables.getInstance();

    //totalObjects
    updatables.size();

    ArrayList<ProgressData>  updateLabelsList = new ArrayList<ProgressData>();

    for (Label updatable : updatables)
    {
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

    if(displayImages == null)
      return;

    displayBalls = new ArrayList<Image>();
    displayBallList = new ArrayList<Image>();
    remainderBall = new ArrayList<Image>();

    displayImages.size();

    for (Image updatable : displayImages)
    {
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
      }
      else if (str.contains("RemBall"))
        remainderBall.add(updatable);
    }
    ballDragListener.setDisplayBalls(displayBalls);

    attachDraggables();
  }

  private void defineLevel11to15Components() {

    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    //totalObjects
    scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

    }

    numLocal.scrolling(scrollingImages);

    //check if the updatables are present
    if(updatables == null)
      return;

    updateScrollLable = new ArrayList<Label>();

    //totalObjects
    updatables.size();

    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB")) {
        labelX = updatable;
      }

      updateScrollLable.add(updatable);

    }

    scrollingUpdateLableCh1 = new ScrollingUpdateLabelCh1(updateScrollLable);

    for (int i = 0; i < BallDisplay.columns; i++){

      for (int j = 0; j < BallDisplay.rows; j++) {

        stage.addActor(scrollingUpdateLableCh1.ballDisplay.balls[i][j]);

        scrollingUpdateLableCh1.ballDisplay.balls[i][j].setVisible(false);

      }
    }

    for(Image numberI : scrollingPara)
    {
      stage.addActor(numberI);
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

    time.stage.draw();

    if (time.isTimeUp()){

      /*Image semiTransparentBG = new Image(new Texture("blur_bg1.png"));
      semiTransparentBG.setSize(MyGame.WIDTH,MyGame.HEIGHT);
      stage.addActor(semiTransparentBG);*/

      Image dialogbox = new Image(new Texture("data1/dialogbox.png"));
      dialogbox.setSize(240,300);
      dialogbox.setPosition(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-100);
      stage.addActor(dialogbox);

      elapsed_time += Gdx.graphics.getDeltaTime();
      animationClass.update(elapsed_time);
    }

  }
  private void renderLevel2(float delta){
    update(delta);

    if (time.isTimeUp()){

    }

    stage.draw();

    if(moveTheBg) {
      bg.act(delta);
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

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }
    stage.draw();
    time.stage.draw();
  }

}
