package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch8Trigonometry.RelocateLabel;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

public class Chapter8 extends ChapterScreen implements Screen {

  private ArrayList<Label> LabelPosition;

  private DoubleClickListener clickLabelAC,clickLabelAC1,clickLabelAB,clickLabelAB1,clickLabelBC,clickLabelBC1;
  private RelocateLabel relocateLabel;

  private ArrayList<DoubleClickListener> arrDoubleListener;

  Chapter8(){
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

    clickLabelAC = new DoubleClickListener(Events.DOUBLE_CLICK_AC);
    clickLabelAC1 = new DoubleClickListener(Events.DOUBLE_CLICK_AC1);
    clickLabelAB = new DoubleClickListener(Events.DOUBLE_CLICK_AB);
    clickLabelAB1 = new DoubleClickListener(Events.DOUBLE_CLICK_AB1);
    clickLabelBC = new DoubleClickListener(Events.DOUBLE_CLICK_BC);
    clickLabelBC1 = new DoubleClickListener(Events.DOUBLE_CLICK_BC1);

    arrDoubleListener = new ArrayList<DoubleClickListener>();
    arrDoubleListener.add(clickLabelAC);
    arrDoubleListener.add(clickLabelAC1);
    arrDoubleListener.add(clickLabelAB);
    arrDoubleListener.add(clickLabelAB1);
    arrDoubleListener.add(clickLabelBC);
    arrDoubleListener.add(clickLabelBC1);


    String  updatableNamesStep1[] = {"LabelValue1", "LabelValue1_1", "LabelValue3","LabelValue3_1",
            "LabelValue5","LabelValue5_1"};

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)){

      if(updatables != null){
        LabelPosition = new ArrayList<Label>();
        //totalObjects
        updatables.size();

        for (Label updatable : updatables) {
          String str = updatable.getName();

          for(int count = 0; count < updatableNamesStep1.length; count++){
            if(str.equals(updatableNamesStep1[count]))
              updatable.addListener(arrDoubleListener.get(count));
          }
          LabelPosition.add(updatable);
        }
        relocateLabel = new RelocateLabel(LabelPosition);
      }
    }
    else if (GameStates.steps == Steps.STEP_3){}

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6To10Components() { }
  void defineLevel11To15Components() { }

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
    if (time.isTimeUp()){ }
    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){ }
    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){}
    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();

  }
}
