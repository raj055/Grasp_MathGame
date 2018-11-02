package com.mygdx.game.Factory;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.DragAndDropElements;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch6Triangles.ScrollingUpdateCh6;
import com.mygdx.game.ChapterClass.Ch6Triangles.UpdateImageCh6;
import com.mygdx.game.ChapterClass.Ch6Triangles.VisebalComponentsCh6;
import com.mygdx.game.Component.Numberch6;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;

import java.util.ArrayList;

public class Chapter6 extends ChapterScreen implements Screen {

  private ArrayList<Image> DragComponent;
  private ArrayList<Image> VisebalComponent;
  private ArrayList<Label> LableChange;
  private ArrayList<Image> ImagePosition;
  private ArrayList<Image> scrollingImages = null;

  private DragAndDropElements dragShapeSquare;
  private DragAndDropElements dragShapeSquare1;
  private DragAndDropElements dragShapeCircle;
  private DragAndDropElements dragShapeCircle1;
  private DragAndDropElements dragShapeTriangle;

  private VisebalComponentsCh6 visebalComponentsCh6;

  private Numberch6 numberch6;

  private DoubleClickListener Click_imgVlu1, Click_imgVlu5, Click_imgVlu7, Click_imgVlu4, Click_imgVlu8,
          Click_imgVlu2, Click_imgVlu, Click_imgVlu6, Click_imgVlu9_2, Click_imgVlu9, Click_imgVlu3;

  private UpdateImageCh6 updateImageCh6;

  private DoubleClickListener doubleClickLabelAC;
  private DoubleClickListener doubleClickLabelAB;
  private DoubleClickListener doubleClickLabelBC;

  private ArrayList<DragClickListener> arrDragListener;
  private ArrayList<DoubleClickListener> arrDoubleListener;

  private ScrollingUpdateCh6 scrollingUpdateCh6 = null;

  private Image DragShape,squareShape,squareShape1,circleShape,circleShape1,targetTriangle;

  Chapter6(){
    super();

    messageBox = new MessageBox();
    messageBox.AddStage(stage);

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
        time.RestartTime();
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

  private void Drop(){

    dragShapeTriangle = new DragAndDropElements(Events.DRAG_TRIANGLE_P);
    dragShapeTriangle.defineComponentImages(DragShape,targetTriangle);

    dragShapeSquare = new DragAndDropElements(Events.DRAG_SQUARE);
    dragShapeSquare.defineComponentImages(squareShape,targetTriangle);

    dragShapeSquare1 = new DragAndDropElements(Events.DRAG_SQUARE1);
    dragShapeSquare1.defineComponentImages(squareShape1,targetTriangle);

    dragShapeCircle = new DragAndDropElements(Events.DRAG_CIRCLE);
    dragShapeCircle.defineComponentImages(circleShape,targetTriangle);

    dragShapeCircle1 = new DragAndDropElements(Events.DRAG_CIRCLE_1);
    dragShapeCircle1.defineComponentImages(circleShape1,targetTriangle);

  }

  void defineLevel1To5Components() {

    if(displayImages != null) {
      displayImages.size();
      for (Image updatable : displayImages) {
        String str = updatable.getName();
        if (str.equals("triangle_p")) {
          DragShape = updatable;
        }else if (str.equals("squareImage")) {
          squareShape = updatable;
        }else if (str.equals("square1Image")) {
          squareShape1 = updatable;
        }else if (str.equals("sercalImage")) {
          circleShape = updatable;
        }else if (str.equals("sercal1Image")) {
          circleShape1 = updatable;
        }else if (str.equals("triangleb_Image")) {
          targetTriangle = updatable;
        }
      }
    }

    Drop();

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }

  void defineLevel6To10Components() {

    doubleClickLabelAC = new DoubleClickListener(Events.DOUBLE_CLICK_LabelAC);
    doubleClickLabelAB = new DoubleClickListener(Events.DOUBLE_CLICK_LabelAB);
    doubleClickLabelBC = new DoubleClickListener(Events.DOUBLE_CLICK_LabelBC);

    arrDoubleListener = new ArrayList<DoubleClickListener>();
    arrDoubleListener.add(doubleClickLabelAC);
    arrDoubleListener.add(doubleClickLabelAB);
    arrDoubleListener.add(doubleClickLabelBC);

    //Define different scrolling parameters for different steps.
    scrollingParaLevel6To10();

    //define different updatable parameters for different steps.
    updatablesParaLevel6To10();

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }

  String  updatableNamesStep1[] = {"value4", "value3", "value5"};

  void updatablesParaLevel6To10(){
    if(GameStates.steps == Steps.STEP_1){
      //check if the updatable are present
      if(updatables != null) {

        LableChange = new ArrayList<Label>();
        updatables.size();

        for (Label updatable : updatables) {
          String str = updatable.getName();
          for(int count = 0; count < updatableNamesStep1.length; count++){
            if(str.equals(updatableNamesStep1[count]))
            updatable.addListener(arrDoubleListener.get(count));
          }
          LableChange.add(updatable);
        }
      }
      visebalComponentsCh6 = new VisebalComponentsCh6(displayImages,LableChange);
    }
    else if (GameStates.steps == Steps.STEP_2){
      //check if the updatable are present
      if(updatables != null) {
        scrollingUpdateCh6 = new ScrollingUpdateCh6(updatables);
      }
    }
    else if (GameStates.steps == Steps.STEP_3){
      if(updatables != null) {

        if (scrollingUpdateCh6 != null){
          scrollingUpdateCh6.setUpdatable(updatables);
        }
      }
    }
  }
  void scrollingParaLevel6To10(){
    if(GameStates.steps == Steps.STEP_1){
    }
    else if ((GameStates.steps == Steps.STEP_2) || (GameStates.steps == Steps.STEP_3)){
      if(scrollingPara != null) {
        numberch6 = new Numberch6();
        numberch6.setPositionX(xPosAdditionFactor - 400);
        scrollingPara.size();
        numberch6.addToStage(stage);
      }
    }
  }

  void defineLevel11To15Components() {

    if(GameStates.steps == Steps.STEP_1){

    }
    else if (GameStates.steps == Steps.STEP_2){

    }
    else if (GameStates.steps == Steps.STEP_3){

    }

    String  updatableNamesLevel11to15[] = {"ImageVlu1", "ImageVlu7" , "imgVlu4" , "imgVlu8" ,
            "imgVlu2" , "imgVlu" , "imgVlu3" , "ImageVlu5" , "imgVlu6" , "imgVlu9_2" , "imgVlu9"};

    Click_imgVlu = new DoubleClickListener(Events.DOUBLE_CLICK_IMG);
    Click_imgVlu1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG1);
    Click_imgVlu2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG2);
    Click_imgVlu3 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG3);
    Click_imgVlu4 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG4);
    Click_imgVlu5 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG5);
    Click_imgVlu6 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG6);
    Click_imgVlu7 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG7);
    Click_imgVlu8 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG8);
    Click_imgVlu9 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG9);
    Click_imgVlu9_2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG9_2);

    arrDoubleListener = new ArrayList<DoubleClickListener>();
    arrDoubleListener.add(Click_imgVlu);
    arrDoubleListener.add(Click_imgVlu1);
    arrDoubleListener.add(Click_imgVlu2);
    arrDoubleListener.add(Click_imgVlu3);
    arrDoubleListener.add(Click_imgVlu4);
    arrDoubleListener.add(Click_imgVlu5);
    arrDoubleListener.add(Click_imgVlu6);
    arrDoubleListener.add(Click_imgVlu7);
    arrDoubleListener.add(Click_imgVlu8);
    arrDoubleListener.add(Click_imgVlu9);
    arrDoubleListener.add(Click_imgVlu9_2);

    if(displayImages != null){
      ImagePosition = new ArrayList<Image>();

      displayImages.size();
      for (Image updatable : displayImages) {
        String str = updatable.getName();
        for(int count = 0; count < updatableNamesLevel11to15.length; count++){
          if(str.equals(updatableNamesLevel11to15[count]))
            updatable.addListener(arrDoubleListener.get(count));
        }
        ImagePosition.add(updatable);
      }
      updateImageCh6 = new UpdateImageCh6(ImagePosition);
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

  private void renderLevel1(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage();}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
   if(numberch6 != null)
    numberch6.update(deltaTime);

    if (time.isTimeUp()){messageBox.TimeUpMessage(); }

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage(); }

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();

  }
}
