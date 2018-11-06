package com.mygdx.game.Factory;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.DragAndDropElements;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.ScrollingUpdateCh4;
import com.mygdx.game.ChapterClass.Ch4QuadraticEquations.VisebleComponentsCh4;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;

import java.util.ArrayList;

public class Chapter4 extends ChapterScreen implements Screen {

  private ArrayList<Image> DragComponent;
  private ArrayList<Image> VisebalComponent;

  private DragAndDropElements draglight;
  private DragAndDropElements dragsquare;
  private DragAndDropElements dragsquare1;
  private DragAndDropElements dragsquare2;
  private DragAndDropElements dragbox1;

  private DragAndDropElements dragA1;
  private DragAndDropElements dragA2;
  private DragAndDropElements dragB1;
  private DragAndDropElements dragB2;
  private DragAndDropElements dragB3;
  private DragAndDropElements dragC1;
  private DragAndDropElements dragC2;

  private VisebleComponentsCh4 visebleComponentsCh4;
  private ArrayList<Image> scrollingImages = null;
  //Update on click scrolling components
  private ScrollingUpdateCh4 scrollingUpdateCh4;
  private ScrollingNumber numLocal;
  private BallDisplay ballDisplay;
  private DoubleClickListener doubleclicklistener;
  private ArrayList<DragClickListener> arrDragListener;

  private Label DragLabelA,DragLabelA2,DragLabelB1,DragLabelB2,
          DropValueA,DropRlabelA,DropValueB,DropRlabelB,DragLabelC1,DropRlabelC;

  private Image light,square1,ImgSquare,ImgSquare1,ImgSquare2,ImgBox1,ImgDrop;

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

    if(GameStates.steps == Steps.STEP_1){
      //check if the displayImages are present
      if(displayImages != null) {
        //totalObjects
        displayImages.size();
        for (Image updatable : displayImages) {
          String str = updatable.getName();
          if (str.equals("light")) {
            light = updatable;
          }else if (str.equals("square")) {
            square1 = updatable;
          }
        }
      }

      draglight = new DragAndDropElements(Events.DRAG_IMGLIGHT);
      draglight.defineComponentLabelImage(light,square1);

    }
    else if (GameStates.steps == Steps.STEP_2){
      //check if the displayImages are present
      if(displayImages != null) {
        //totalObjects
        displayImages.size();
        for (Image updatable : displayImages) {
          String str = updatable.getName();
          if (str.equals("Square")) {
            ImgSquare = updatable;
          }else if (str.equals("Square1")) {
            ImgSquare1 = updatable;
          }else if (str.equals("Square2")) {
            ImgSquare2 = updatable;
          }else if (str.equals("box1")) {
            ImgBox1 = updatable;
          }
          else if (str.equals("DisplayImage")) {
            ImgDrop = updatable;
          }
        }
      }

      dragsquare = new DragAndDropElements(Events.DRAG_IMGSQUARE);
      dragsquare.defineComponentLabelImage(ImgSquare,ImgDrop);
      dragsquare1 = new DragAndDropElements(Events.DRAG_IMGSQUARE1);
      dragsquare1.defineComponentLabelImage(ImgSquare1,ImgDrop);
      dragsquare2 = new DragAndDropElements(Events.DRAG_IMGSQUARE2);
      dragsquare2.defineComponentLabelImage(ImgSquare2,ImgDrop);
      dragbox1 = new DragAndDropElements(Events.DRAG_IMGBOX1);
      dragbox1.defineComponentLabelImage(ImgBox1,ImgDrop);

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

      //check if the updatable are present
      if(updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          if (str.equals("DragLabelA")) {
            DragLabelA = updatable;
          }else if (str.equals("DragLabelA2")) {
            DragLabelA2 = updatable;
          }else if (str.equals("DragLabelB1")) {
            DragLabelB1 = updatable;
          }else if (str.equals("DragLabelB2")) {
            DragLabelB2 = updatable;
          }else if (str.equals("DragLabelC1")) {
            DragLabelC1 = updatable;
          }
          else if (str.equals("Valuea")) {
            DropValueA = updatable;
          }
          else if (str.equals("rLabelA")) {
            DropRlabelA = updatable;
          }
          else if (str.equals("Valueb")) {
            DropValueB = updatable;
          }
          else if (str.equals("rLabelB")) {
            DropRlabelB = updatable;
          }
          else if (str.equals("rLabelC")) {
            DropRlabelC = updatable;
          }
        }
      }

    dragA1 = new DragAndDropElements(Events.DRAGA1);
    Label ValuePayloadA1 = new Label(DragLabelA.getText(), DragLabelA.getStyle());
    dragA1.defineComponentLabelImage(ValuePayloadA1,DragLabelA,DropValueA);

    dragA2 = new DragAndDropElements(Events.DRAGA2);
    Label ValuePayloadA2 = new Label(DragLabelA2.getText(), DragLabelA2.getStyle());
    dragA2.defineComponentLabelImage(ValuePayloadA2,DragLabelA2,DropRlabelA);

    dragB1 = new DragAndDropElements(Events.DRAGB1);
    Label ValuePayloadB1 = new Label(DragLabelB1.getText(), DragLabelB1.getStyle());
    dragB1.defineComponentLabelImage(ValuePayloadB1,DragLabelB1,DropValueB);

    dragB2 = new DragAndDropElements(Events.DRAGB2);
    Label ValuePayloadB2 = new Label(DragLabelB2.getText(), DragLabelB2.getStyle());
    dragB2.defineComponentLabelImage(ValuePayloadB2,DragLabelB2,DropRlabelB);

    dragC1 = new DragAndDropElements(Events.DRAGC1);
    Label ValuePayloadC1 = new Label(DragLabelC1.getText(), DragLabelC1.getStyle());
    dragC1.defineComponentLabelImage(ValuePayloadC1,DragLabelC1,DropRlabelC);

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
    messageBox.update(deltaTime);
    //Update the scrolling variables if any
    if(numLocal != null)
      numLocal.update(deltaTime);

    //Time up
    if (time.isTimeUp()){messageBox.TimeUpMessage(); }

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    //Draw stage and timer
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage();}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage();}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
}
