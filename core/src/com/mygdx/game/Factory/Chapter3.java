package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Animation.AnimationClass;
import com.mygdx.game.Animation.TrainAnimation;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.ScrollingUpdateCh3;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.VisebalComponentsCh3;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;

import java.util.ArrayList;

public class Chapter3 extends ChapterScreen implements Screen {

  private ArrayList<Image> ClickImage;
  private ArrayList<Image> Changeposition;
  private ArrayList<Image> VisebalComponent;
  private ArrayList<Image> scrollingImages = null;
  private ScrollingNumber numLocal;

  //Update labels on click scrolling components
  private ScrollingUpdateCh3 scrollingUpdateCh3;

  private DoubleClickListener clickListenerY1;
  private DoubleClickListener clickListenerY2;
  private DoubleClickListener clickListenerSq1;
  private DoubleClickListener clickListenerSq2;
  private DoubleClickListener clickListenerC1;
  private DoubleClickListener clickListenerC2;

  private DragClickListener dragListenerA1;
  private DragClickListener dragListenerB1;
  private DragClickListener dragListenerC1;
  private DragClickListener dragListenerA2;
  private DragClickListener dragListenerB2;
  private DragClickListener dragListenerC2;
  private DragClickListener dragListenerB11;
  private DragClickListener dragListenerB21;

  private VisebalComponentsCh3 visebalComponentsCh3;
  private VisebalComponentsCh3 visebalComponentsCh3Level11;

  private ArrayList<DragClickListener> arrDragListener;
  private ArrayList<DoubleClickListener> arrClickListener;

  //Animation
  private float elapsed_time;
  private AnimationClass animationClass;
  private TrainAnimation trainAnimation;
  int posX = 0;

  Chapter3(){
    super();

    messageBox = new MessageBox();
    messageBox.AddStage(stage);

    animationClass = new AnimationClass();
    animationClass.BirdAnimation();

    trainAnimation = new TrainAnimation();
    trainAnimation.TrainAnimation();

    getLevelName();
    initialiseLevelComponents(currentLevelNumber);
  }

  public void setPositionX(int positionX){
    this.posX = positionX + 10;
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

  // Submit Button ClickListener
  ClickListener submitButtonClicked = new ClickListener(){
    @Override
    public  void clicked(InputEvent event, float x, float y){

      if (scrollingPara != null) {
        for (Image img : scrollingPara) {
          img.remove();
        }
        scrollingPara.clear();
        scrollingImages.clear();
      }

      if(goToNextStep() != true) {
        messageBox.setPositionX(xPosAdditionFactor - 400);
        messageBox.ShowDialog();

        if (messageBox.NextStep.isTouchable()){
          messageBox.NextStep.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
              GameStates.screenStates = ScreenStates.LEVELSCREEN;
            }
          });
        }
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

  void defineLevel1To3Components() {

    if(GameStates.steps == Steps.STEP_1 || (GameStates.steps == Steps.STEP_2)
            ||(GameStates.steps == Steps.STEP_3) ||(GameStates.steps == Steps.STEP_4
            || (GameStates.steps == Steps.STEP_5) || (GameStates.steps == Steps.STEP_6))){
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
        numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh3);
        //check if the updatables are present
        if (updatables != null) {
          //totalObjects
          updatables.size();
          for (Label updatable : updatables) {
            updatable.getName();
          }
          scrollingUpdateCh3 = new ScrollingUpdateCh3(updatables);
        }
      }
    }

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel4To7Components() {

    clickListenerY1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_Y1);
    clickListenerY2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_Y2);
    clickListenerSq1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_SQ1);
    clickListenerSq2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_SQ2);
    clickListenerC1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_C1);
    clickListenerC2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_C2);

    arrClickListener = new ArrayList<DoubleClickListener>();
    arrClickListener.add(clickListenerY1);
    arrClickListener.add(clickListenerY2);
    arrClickListener.add(clickListenerSq1);
    arrClickListener.add(clickListenerSq2);
    arrClickListener.add(clickListenerC1);
    arrClickListener.add(clickListenerC2);

    String  updatableNamesLevel2[] = {"y1Image", "y2Image"};

    ClickImage = new ArrayList<Image>();
    Changeposition = new ArrayList<Image>();
    VisebalComponent = new ArrayList<Image>();

    if(displayImages != null) {
      displayImages.size();
      for (Image updatable : displayImages) {
        String str = updatable.getName();
        for(int count = 0; count < updatableNamesLevel2.length; count++){
          if(str.equals(updatableNamesLevel2[count]))
            updatable.addListener(arrClickListener.get(count));
        }
        ClickImage.add(updatable);
      }
    }

    //check if the updatables are present
    if(updatables != null) {
      //totalObjects
      updatables.size();
      for (Label updatable : updatables) {
        updatable.getName();
      }
      visebalComponentsCh3 = new VisebalComponentsCh3(displayImages, updatables);
    }
    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel8To11Components(){}
  void defineLevel12To15Components() {

    dragListenerA1 = new DragClickListener(Events.DRAG_VALUE_A1);
    dragListenerA2 = new DragClickListener(Events.DRAG_VALUE_A2);
    dragListenerB1 = new DragClickListener(Events.DRAG_VALUE_B1);
    dragListenerB2 = new DragClickListener(Events.DRAG_VALUE_B2);
    dragListenerC1 = new DragClickListener(Events.DRAG_VALUE_C1);
    dragListenerC2 = new DragClickListener(Events.DRAG_VALUE_C2);
    dragListenerB11 = new DragClickListener(Events.DRAG_VALUE_B11);
    dragListenerB21 = new DragClickListener(Events.DRAG_VALUE_B21);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(dragListenerA1);
    arrDragListener.add(dragListenerA2);
    arrDragListener.add(dragListenerB1);
    arrDragListener.add(dragListenerB2);
    arrDragListener.add(dragListenerC1);
    arrDragListener.add(dragListenerC2);
    arrDragListener.add(dragListenerB11);
    arrDragListener.add(dragListenerB21);

    String  updatableNamesLevel3[] = {"ValueA", "ValueB", "ValueB11","ValueC","ValueA1","ValueB1",
            "ValueB12","ValueC1"};

    if(displayImages != null) {
      displayImages.size();
      for (Image updatable : displayImages) {
        updatable.getName();
      }
    }
    if(updatables != null) {
      //totalObjects
      updatables.size();
      for (Label updatable : updatables) {
        String str = updatable.getName();
        for(int count = 0; count < updatableNamesLevel3.length; count++){
          if(str.equals(updatableNamesLevel3[count]))
            updatable.addListener(arrDragListener.get(count));
        }
      }
      visebalComponentsCh3Level11 = new VisebalComponentsCh3(displayImages, updatables);
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
            public void initialise() { defineLevel1To3Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To3Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To3Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel4To7Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel4To7Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel4To7Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel4To7Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel8To11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel8To11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel8To11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel8To11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel12To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel12To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel12To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel12To15Components(); } },
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
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel4(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel4(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel4(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel4(delta); } }
  };

  private void renderLevel1(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
    if(numLocal != null)
      numLocal.update(deltaTime);

    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();

    if (time.isTimeUp()){
      elapsed_time += Gdx.graphics.getDeltaTime();
      trainAnimation.update(elapsed_time);
    }

    if (submitButtonClicked.isPressed()){
      elapsed_time += Gdx.graphics.getDeltaTime();
      animationClass.update(elapsed_time);
    }

    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage();}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage(); }
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();

  }
  private void renderLevel4(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage(); }
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();

  }
}
