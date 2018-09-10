package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch7CoordinateGeometry.VisebalComponentsCh7;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter7 extends ChapterScreen implements Screen {

  ArrayList<Image> DragComponent;
  ArrayList<Image> VisebalComponent;

  DragClickListener drag_L1_value;
  DragClickListener drag_L1_value3;
  DragClickListener drag_L1_value12;
  DragClickListener drag_L1_value14;

  DragClickListener drag_L2_value12;
  DragClickListener drag_L2_value14;
  DragClickListener drag_L2_valuek1;
  DragClickListener drag_L2_valuek2;
  DragClickListener drag_L2_value1;
  DragClickListener drag_L2_value3;
  DragClickListener drag_L2_valuek3;
  DragClickListener drag_L2_valuek4;

  DragClickListener drag_L3_value1;
  DragClickListener drag_L3_value1_1;
  DragClickListener drag_L3_value3;
  DragClickListener drag_L3_value3_1;
  DragClickListener drag_L3_value12;
  DragClickListener drag_L3_value12_1;
  DragClickListener drag_L3_value14;
  DragClickListener drag_L3_value14_1;
  DragClickListener drag_L3_value22;
  DragClickListener drag_L3_value22_1;
  DragClickListener drag_L3_value24;
  DragClickListener drag_L3_value24_1;

  VisebalComponentsCh7 visebalComponentsCh7;

  private GlobalsCommonCount glv;

  private Image submitButton = null;

  private ArrayList<DragClickListener> arrDragListener;

  Chapter7(){
    super();

    glv = GlobalsCommonCount.getInstance();

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

    drag_L1_value = new DragClickListener(Events.DRAG_L1_VALUE);
    drag_L1_value3 = new DragClickListener(Events.DRAG_L1_VALUE3);
    drag_L1_value12 = new DragClickListener(Events.DRAG_L1_VALUE12);
    drag_L1_value14 = new DragClickListener(Events.DRAG_L1_VALUE14);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(drag_L1_value);
    arrDragListener.add(drag_L1_value3);
    arrDragListener.add(drag_L1_value12);
    arrDragListener.add(drag_L1_value14);

    String  updatableNamesLevel1[] = {"LabelValue1", "LabelValue3", "LabelValue12","LabelValue14"};

    if (updatables != null) {

      updatables.size();
      for (Label updatable : updatables) {
        String str = updatable.getName();
        for(int count = 0; count < updatableNamesLevel1.length; count++){
          if(str.equals(updatableNamesLevel1[count]))
            updatable.addListener(arrDragListener.get(count));
        }
      }
      visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
    }
    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6To10Components() {

    drag_L2_value12 = new DragClickListener(Events.DRAG_L2_VALUE12);
    drag_L2_value14 = new DragClickListener(Events.DRAG_L2_VALUE14);
    drag_L2_valuek1 = new DragClickListener(Events.DRAG_L2_VALUEK1);
    drag_L2_valuek2 = new DragClickListener(Events.DRAG_L2_VALUEK2);
    drag_L2_value1 = new DragClickListener(Events.DRAG_L2_VALUE1);
    drag_L2_value3 = new DragClickListener(Events.DRAG_L2_VALUE3);
    drag_L2_valuek3 = new DragClickListener(Events.DRAG_L2_VALUEK3);
    drag_L2_valuek4 = new DragClickListener(Events.DRAG_L2_VALUEK4);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(drag_L2_value12);
    arrDragListener.add(drag_L2_value14);
    arrDragListener.add(drag_L2_valuek1);
    arrDragListener.add(drag_L2_valuek2);
    arrDragListener.add(drag_L2_value1);
    arrDragListener.add(drag_L2_value3);
    arrDragListener.add(drag_L2_valuek3);
    arrDragListener.add(drag_L2_valuek4);

    String  updatableNamesLevel2Step1[] = {"LabelValue12", "LabelValue14", "LabelValuek1","LabelValuek2"};
    String  updatableNamesLevel2Step2[] = {"LabelValue1", "LabelValue3", "LabelValuek3","LabelValuek4"};

    if(GameStates.steps == Steps.STEP_1){
      if (updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          for (int count = 0; count < updatableNamesLevel2Step1.length; count++) {
            if (str.equals(updatableNamesLevel2Step1[count]))
              updatable.addListener(arrDragListener.get(count));
          }
        }
        visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
      }
    }
    else if (GameStates.steps == Steps.STEP_2){
      if (updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          for (int count = 0; count < updatableNamesLevel2Step2.length; count++) {
            if (str.equals(updatableNamesLevel2Step2[count]))
              updatable.addListener(arrDragListener.get(count));
          }
        }
        visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
      }
    }
    else if (GameStates.steps == Steps.STEP_3){}

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel11To15Components() {

    drag_L3_value1 = new DragClickListener(Events.DRAG_L3_VALUE1);
    drag_L3_value1_1 = new DragClickListener(Events.DRAG_L3_VALUE1_1);
    drag_L3_value3 = new DragClickListener(Events.DRAG_L3_VALUE3);
    drag_L3_value3_1 = new DragClickListener(Events.DRAG_L3_VALUE3_1);
    drag_L3_value12 = new DragClickListener(Events.DRAG_L3_VALUE12);
    drag_L3_value12_1 = new DragClickListener(Events.DRAG_L3_VALUE12_1);
    drag_L3_value14 = new DragClickListener(Events.DRAG_L3_VALUE14);
    drag_L3_value14_1 = new DragClickListener(Events.DRAG_L3_VALUE14_1);
    drag_L3_value22 = new DragClickListener(Events.DRAG_L3_VALUE22);
    drag_L3_value22_1 = new DragClickListener(Events.DRAG_L3_VALUE22_1);
    drag_L3_value24 = new DragClickListener(Events.DRAG_L3_VALUE24);
    drag_L3_value24_1 = new DragClickListener(Events.DRAG_L3_VALUE24_1);

    arrDragListener = new ArrayList<DragClickListener>();
    arrDragListener.add(drag_L3_value1);
    arrDragListener.add(drag_L3_value1_1);
    arrDragListener.add(drag_L3_value3);
    arrDragListener.add(drag_L3_value3_1);
    arrDragListener.add(drag_L3_value12);
    arrDragListener.add(drag_L3_value12_1);
    arrDragListener.add(drag_L3_value14);
    arrDragListener.add(drag_L3_value14_1);
    arrDragListener.add(drag_L3_value22);
    arrDragListener.add(drag_L3_value22_1);
    arrDragListener.add(drag_L3_value24);
    arrDragListener.add(drag_L3_value24_1);

    String  updatableNamesLevel3[] = {"LabelValue1", "LabelValue1_1", "LabelValue3","LabelValue3_1",
            "LabelValue12","LabelValue12_1","LabelValue14","LabelValue14_1",
            "LabelValue22","LabelValue22_1", "LabelValue24","LabelValue24_1"};

    if (updatables != null){
      updatables.size();
      for (Label updatable : updatables){
        String str = updatable.getName();
        for (int count = 0; count < updatableNamesLevel3.length; count++) {
          if (str.equals(updatableNamesLevel3[count]))
            updatable.addListener(arrDragListener.get(count));
        }
      }
      visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
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

    if (time.isTimeUp()){}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(delta);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);

    if (time.isTimeUp()){}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(delta);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){

    time.update(deltaTime);

    if (time.isTimeUp()){}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();

  }
}
