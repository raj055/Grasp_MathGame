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
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.ScrollingUpdateCh5;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;

import java.util.ArrayList;

public class Chapter5 extends ChapterScreen implements Screen {

  //Update components on clicking scrolling values
  private ScrollingUpdateCh5 scrollingUpdateCh5;

  //Double click listeners for plus
  private DoubleClickListener dblClickListenerPlus;

  //Drag12 click listeners
  private DragAndDropElements drag_l1_value1,drag_l1_value2,drag_l1_value12,drag_l1_value13;

  private DragAndDropElements drag_l2_value1,drag_l2_val1;

  private DragAndDropElements drag_l3_s1_value1,drag_l3_s1_val1,drag_l3_s2_value1,drag_l3_s2_val1;

  private ArrayList<Image> scrollingImages = null;

  private ScrollingNumber numLocal;

  private ArrayList<DragClickListener> arrDragListener;
  private ArrayList<DoubleClickListener> arrClickListener;

  private Label Value1,Value2,Value12,Value13;

  private Image PluseBttn,FirstImage,SecondImage,ThirdImage,FourImage;

  private Label L2_Value1,L2_ValueN,L2_Vall1,L2_ValueA;

  private Label L3_s1_Value1,L3_s1_ValueN,L3_s1_Vall1,L3_s1_ValueA,
          L3_s2_Value1,L3_s2_ValueN,L3_s2_Vall2,L3_s2_ValueA;

  Chapter5(){
    super();

    messageBox = new MessageBox();
    messageBox.AddStage(stage);

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

    dblClickListenerPlus = new DoubleClickListener(Events.DOUBLE_CLICK_ADD);

    if(updatables != null) {
      updatables.size();
      for (Label updatable : updatables) {
        String str = updatable.getName();
        if (str.equals("Value1")) {
          Value1 = updatable;
        }else if (str.equals("Value2")) {
          Value2 = updatable;
        }else if (str.equals("Value12")) {
          Value12 = updatable;
        }else if (str.equals("Value13")) {
          Value13 = updatable;
        }
      }
    }
    if(displayImages != null) {
      displayImages.size();
      for (Image updatable : displayImages) {
        String str = updatable.getName();
         if (str.equals("PluseBttn")) {
            PluseBttn = updatable;
         }
         else if (str.equals("FirstRectangle")) {
           FirstImage = updatable;
         }
         else if (str.equals("SecondRectangle")) {
           SecondImage = updatable;
         }
         else if (str.equals("ThirdRectangle")) {
           ThirdImage = updatable;
         }
         else if (str.equals("FourRectangle")) {
           FourImage = updatable;
         }
      }
    }

    drag_l1_value1 = new DragAndDropElements(Events.DRAG_C5L1_VALUE1);
    Label PayloadValue_1 = new Label(Value1.getText(), Value1.getStyle());
    drag_l1_value1.defineComponentLabelImage(PayloadValue_1,Value1,FirstImage);

    drag_l1_value2 = new DragAndDropElements(Events.DRAG_C5L1_VALUE2);
    Label PayloadValue_2 = new Label(Value2.getText(), Value2.getStyle());
    drag_l1_value2.defineComponentLabelImage(PayloadValue_2,Value2,SecondImage);

    drag_l1_value12 = new DragAndDropElements(Events.DRAG_C5L1_VALUE12);
    Label PayloadValue_12 = new Label(Value12.getText(), Value12.getStyle());
    drag_l1_value12.defineComponentLabelImage(PayloadValue_12,Value12,ThirdImage);

    drag_l1_value13 = new DragAndDropElements(Events.DRAG_C5L1_VALUE13);
    Label PayloadValue_13 = new Label(Value13.getText(), Value13.getStyle());
    drag_l1_value13.defineComponentLabelImage(PayloadValue_13,Value13,FourImage);

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6To10Components() {

    if(updatables != null) {
      updatables.size();
      for (Label updatable : updatables) {
        String str = updatable.getName();
        if (str.equals("Value1")) {
          L2_Value1 = updatable;
        }else if (str.equals("Labelval1")) {
          L2_Vall1 = updatable;
        }
        else if (str.equals("ValueN")) {
          L2_ValueN = updatable;
        }else if (str.equals("ValueA")) {
          L2_ValueA = updatable;
        }
      }
    }

    drag_l2_value1 = new DragAndDropElements(Events.DRAG_C5L2_VALUE1);
    Label PayloadValue_1 = new Label(L2_Value1.getText(), L2_Value1.getStyle());
    drag_l2_value1.defineComponentLabelImage(PayloadValue_1,L2_Value1,L2_ValueN);

    drag_l2_val1 = new DragAndDropElements(Events.DRAG_C5L2_VAL1);
    Label PayloadVal_1 = new Label(L2_Vall1.getText(), L2_Vall1.getStyle());
    drag_l2_val1.defineComponentLabelImage(PayloadVal_1,L2_Vall1,L2_ValueA);

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
      if(updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          if (str.equals("Value1")) {
            L3_s1_Value1 = updatable;
          }else if (str.equals("Labelval1")) {
            L3_s1_Vall1 = updatable;
          }
          else if (str.equals("ValueN")) {
            L3_s1_ValueN = updatable;
          }
          else if (str.equals("ValueA")) {
            L3_s1_ValueA = updatable;
          }
        }
      }

      drag_l3_s1_value1 = new DragAndDropElements(Events.DRAG_C5L3S1_VALUE1);
      Label PayloadValue_s1_1 = new Label(L3_s1_Value1.getText(), L3_s1_Value1.getStyle());
      drag_l3_s1_value1.defineComponentLabelImage(PayloadValue_s1_1,L3_s1_Value1,L3_s1_ValueN);

      drag_l3_s1_val1 = new DragAndDropElements(Events.DRAG_C5L3S1_VAL1);
      Label PayloadVal_s1_1 = new Label(L3_s1_Vall1.getText(), L3_s1_Vall1.getStyle());
      drag_l3_s1_val1.defineComponentLabelImage(PayloadVal_s1_1,L3_s1_Vall1,L3_s1_ValueA);

    }
    else if ((GameStates.steps == Steps.STEP_2) || (GameStates.steps == Steps.STEP_3)){

      if(updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          if (str.equals("LabelValue1")) {
            L3_s2_Value1 = updatable;
          }else if (str.equals("LabelVal12")) {
            L3_s2_Vall2 = updatable;
          }
          else if (str.equals("ValueN")) {
            L3_s2_ValueN = updatable;
          }
          else if (str.equals("ValueA")) {
            L3_s2_ValueA = updatable;
          }
        }
      }

      drag_l3_s2_value1 = new DragAndDropElements(Events.DRAG_C5L3S2_VALUE1);
      Label PayloadValue_s2_1 = new Label(L3_s2_Value1.getText(), L3_s2_Value1.getStyle());
      drag_l3_s2_value1.defineComponentLabelImage(PayloadValue_s2_1,L3_s2_Value1,L3_s2_ValueN);

      drag_l3_s2_val1 = new DragAndDropElements(Events.DRAG_C5L3S2_VAL1);
      Label PayloadVal_s2_1 = new Label(L3_s2_Vall2.getText(), L3_s2_Vall2.getStyle());
      drag_l3_s2_val1.defineComponentLabelImage(PayloadVal_s2_1,L3_s2_Vall2,L3_s2_ValueA);

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

  private void renderLevel1(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage(); }

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
    //Check if the local numbers are declared.
    if(numLocal != null)
      numLocal.update(deltaTime);

    if (time.isTimeUp()){messageBox.TimeUpMessage();}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){

    time.update(deltaTime);
    messageBox.update(deltaTime);
    if(numLocal != null)
    numLocal.update(deltaTime);

    if (time.isTimeUp()){messageBox.TimeUpMessage();}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();

  }
}
