package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.VisebalComponentsCh3;
import com.mygdx.game.ChapterClass.Ch7CoordinateGeometry.DragLabelCh7;
import com.mygdx.game.ChapterClass.Ch7CoordinateGeometry.VisebalComponentsCh7;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter7 extends ChapterScreen implements Screen {

  private Timer time;

  ArrayList<Image> DragComponent;
  ArrayList<Image> VisebalComponent;

  DragLabelCh7 drag_L1_value;
  DragLabelCh7 drag_L1_value3;
  DragLabelCh7 drag_L1_value12;
  DragLabelCh7 drag_L1_value14;

  DragLabelCh7 drag_L2_value12;
  DragLabelCh7 drag_L2_value14;
  DragLabelCh7 drag_L2_valuek1;
  DragLabelCh7 drag_L2_valuek2;
  DragLabelCh7 drag_L2_value1;
  DragLabelCh7 drag_L2_value3;
  DragLabelCh7 drag_L2_valuek3;
  DragLabelCh7 drag_L2_valuek4;

  DragLabelCh7 drag_L3_value1;
  DragLabelCh7 drag_L3_value1_1;
  DragLabelCh7 drag_L3_value3;
  DragLabelCh7 drag_L3_value3_1;
  DragLabelCh7 drag_L3_value12;
  DragLabelCh7 drag_L3_value12_1;
  DragLabelCh7 drag_L3_value14;
  DragLabelCh7 drag_L3_value14_1;
  DragLabelCh7 drag_L3_value22;
  DragLabelCh7 drag_L3_value22_1;
  DragLabelCh7 drag_L3_value24;
  DragLabelCh7 drag_L3_value24_1;

  VisebalComponentsCh7 visebalComponentsCh7;

  // component of level_1
  private Label synlabel,synlabel1,synlabel2,synlabel3;

  private Label value1,value3,value12,value14;

  // component of level_2
  private Label synlabelk1,synlabelk,labelvalue1,labelvalue3,valuek3,valuek4;

  private Label valuek2,valuek1,value1_1,value3_1,value12_1,value14_1,value22,value22_1,value24,value24_1;

  // component of level_3
  private Label synlabelx1,synlabelx11,synlabelx2,synlabelx22,synlabelx3,synlabelx33;
  private Label synlabely1,synlabely11,synlabely2,synlabely22,synlabely3,synlabely33;

  private GlobalsCommonCount glv;
  Number numLocal;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  Chapter7(){
    super();

    time = new Timer();
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

  void defineLevel1To5Components() {

    drag_L1_value = new DragLabelCh7(Events.DRAG_L1_VALUE);
    drag_L1_value3 = new DragLabelCh7(Events.DRAG_L1_VALUE3);
    drag_L1_value12 = new DragLabelCh7(Events.DRAG_L1_VALUE12);
    drag_L1_value14 = new DragLabelCh7(Events.DRAG_L1_VALUE14);

    if (updatables == null)
        return;

    updatables.size();
    for (Label updatable : updatables){
      String str = updatable.getName();

      if (str.equals("LabelValue1")){
        value1 = updatable;
        value1.addListener(drag_L1_value);
      }
      else if (str.equals("LabelValue3")){
        value3 = updatable;
        value3.addListener(drag_L1_value3);
      }
      else if (str.equals("LabelValue12")){
        value12 = updatable;
        value12.addListener(drag_L1_value12);
      }
      else if (str.equals("LabelValue14")){
        value14 = updatable;
        value14.addListener(drag_L1_value14);
      }
    }
    visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
  }
  void defineLevel6To10Components() {

    drag_L2_value12 = new DragLabelCh7(Events.DRAG_L2_VALUE12);
    drag_L2_value14 = new DragLabelCh7(Events.DRAG_L2_VALUE14);
    drag_L2_valuek1 = new DragLabelCh7(Events.DRAG_L2_VALUEK1);
    drag_L2_valuek2 = new DragLabelCh7(Events.DRAG_L2_VALUEK2);
    drag_L2_value1 = new DragLabelCh7(Events.DRAG_L2_VALUE1);
    drag_L2_value3 = new DragLabelCh7(Events.DRAG_L2_VALUE3);
    drag_L2_valuek3 = new DragLabelCh7(Events.DRAG_L2_VALUEK3);
    drag_L2_valuek4 = new DragLabelCh7(Events.DRAG_L2_VALUEK4);

    if (updatables == null)
      return;

    updatables.size();
    for (Label updatable : updatables){
      String str = updatable.getName();

      if (str.equals("LabelValue12")){
        value12 = updatable;
        value12.addListener(drag_L2_value12);
      }
      else if (str.equals("LabelValue14")){
        value14 = updatable;
        value14.addListener(drag_L2_value14);
      }
      else if (str.equals("LabelValuek1")){
        valuek1 = updatable;
        valuek1.addListener(drag_L2_valuek1);
      }
      else if (str.equals("LabelValuek2")){
        valuek2 = updatable;
        valuek2.addListener(drag_L2_valuek2);
      }
      else if (str.equals("LabelValue1")){
        labelvalue1 = updatable;
        labelvalue1.addListener(drag_L2_value1);
      }
      else if (str.equals("LabelValue3")){
        labelvalue3 = updatable;
        labelvalue3.addListener(drag_L2_value3);
      }
      else if (str.equals("LabelValuek3")){
        valuek3 = updatable;
        valuek3.addListener(drag_L2_valuek3);
      }
      else if (str.equals("LabelValuek4")){
        valuek4 = updatable;
        valuek4.addListener(drag_L2_valuek4);
      }
    }
    visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
  }
  void defineLevel11To15Components() {

    drag_L3_value1 = new DragLabelCh7(Events.DRAG_L3_VALUE1);
    drag_L3_value1_1 = new DragLabelCh7(Events.DRAG_L3_VALUE1_1);
    drag_L3_value3 = new DragLabelCh7(Events.DRAG_L3_VALUE3);
    drag_L3_value3_1 = new DragLabelCh7(Events.DRAG_L3_VALUE3_1);
    drag_L3_value12 = new DragLabelCh7(Events.DRAG_L3_VALUE12);
    drag_L3_value12_1 = new DragLabelCh7(Events.DRAG_L3_VALUE12_1);
    drag_L3_value14 = new DragLabelCh7(Events.DRAG_L3_VALUE14);
    drag_L3_value14_1 = new DragLabelCh7(Events.DRAG_L3_VALUE14_1);
    drag_L3_value22 = new DragLabelCh7(Events.DRAG_L3_VALUE22);
    drag_L3_value22_1 = new DragLabelCh7(Events.DRAG_L3_VALUE22_1);
    drag_L3_value24 = new DragLabelCh7(Events.DRAG_L3_VALUE24);
    drag_L3_value24_1 = new DragLabelCh7(Events.DRAG_L3_VALUE24_1);

    if (updatables == null)
      return;

    updatables.size();
    for (Label updatable : updatables){
      String str = updatable.getName();

      if (str.equals("LabelValue1")){
        value1 = updatable;
        value1.addListener(drag_L3_value1);
      }
      else if (str.equals("LabelValue1_1")){
        value1_1 = updatable;
        value1_1.addListener(drag_L3_value1_1);
      }
      else if (str.equals("LabelValue3")){
        value3 = updatable;
        value3.addListener(drag_L3_value3);
      }
      else if (str.equals("LabelValue3_1")){
        value3_1 = updatable;
        value3_1.addListener(drag_L3_value3_1);
      }
      else if (str.equals("LabelValue12")){
        value12 = updatable;
        value12.addListener(drag_L3_value12);
      }
      else if (str.equals("LabelValue12_1")){
        value12_1 = updatable;
        value12_1.addListener(drag_L3_value12_1);
      }
      else if (str.equals("LabelValue14")){
        value14 = updatable;
        value14.addListener(drag_L3_value14);
      }
      else if (str.equals("LabelValue14_1")){
        value14_1 = updatable;
        value14_1.addListener(drag_L3_value14_1);
      }
      else if (str.equals("LabelValue22")){
        value22 = updatable;
        value22.addListener(drag_L3_value22);
      }
      else if (str.equals("LabelValue22_1")){
        value22_1 = updatable;
        value22_1.addListener(drag_L3_value22_1);
      }
      else if (str.equals("LabelValue24")){
        value24 = updatable;
        value24.addListener(drag_L3_value24);
      }
      else if (str.equals("LabelValue24_1")){
        value24_1 = updatable;
        value24_1.addListener(drag_L3_value24_1);
      }
    }
    visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
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

  public void renderLevels(int index) {
//    renderLists[index].renderL( );
  }
  private void renderLevel1(float delta){
    update(delta);

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);

    if (time.isTimeUp()){}

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

    if (time.isTimeUp()){}

    stage.draw();
    time.stage.draw();

  }
}
