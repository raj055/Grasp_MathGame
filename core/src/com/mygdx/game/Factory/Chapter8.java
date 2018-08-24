package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch8Trigonometry.DoubleClickLabelCh8;
import com.mygdx.game.ChapterClass.Ch8Trigonometry.RelocateLabel;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

public class Chapter8 extends ChapterScreen implements Screen {

  private Timer time;

  private Label value1,value1_1,value3,value3_1,value5,value5_1;

  ArrayList<Label> LabelPosition;

  DoubleClickLabelCh8 clickLabelAC,clickLabelAC1,clickLabelAB,clickLabelAB1,clickLabelBC,clickLabelBC1;
  RelocateLabel relocateLabel;

  Chapter8(){
    super();

    time = new Timer();

    clickLabelAC = new DoubleClickLabelCh8(Events.DOUBLE_CLICK_AC);
    clickLabelAC1 = new DoubleClickLabelCh8(Events.DOUBLE_CLICK_AC1);
    clickLabelAB = new DoubleClickLabelCh8(Events.DOUBLE_CLICK_AB);
    clickLabelAB1 = new DoubleClickLabelCh8(Events.DOUBLE_CLICK_AB1);
    clickLabelBC = new DoubleClickLabelCh8(Events.DOUBLE_CLICK_BC);
    clickLabelBC1 = new DoubleClickLabelCh8(Events.DOUBLE_CLICK_BC1);

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

  void defineLevel1To5Components() {

    //check if the updatables are present
    if(updatables == null)
      return;

    LabelPosition = new ArrayList<Label>();

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.equals("LabelValue1")) {
        value1 = updatable;
        value1.addListener(clickLabelAC);

      }
      else if (str.equals("LabelValue1_1")) {
        value1_1 = updatable;
        value1_1.addListener(clickLabelAC1);
      }
      else if (str.equals("LabelValue3")) {
        value3 = updatable;
        value3.addListener(clickLabelAB);
      }
      else if (str.equals("LabelValue3_1")) {
        value3_1 = updatable;
        value3_1.addListener(clickLabelAB1);
      }
      else if (str.equals("LabelValue5")) {
        value5 = updatable;
        value5.addListener(clickLabelBC);
      }
      else if (str.equals("LabelValue5_1")) {
        value5_1 = updatable;
        value5_1.addListener(clickLabelBC1);
      }

      LabelPosition.add(updatable);
    }

      relocateLabel = new RelocateLabel(LabelPosition);
  }
  void defineLevel6To10Components() { }
  void defineLevel11To15Components() { }

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

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    time.update(deltaTime);

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();
    time.stage.draw();

  }
}
