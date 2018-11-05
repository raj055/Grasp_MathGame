package com.mygdx.game.Factory;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.mygdx.game.BuilderBlocks.DragAndDropElements;
import com.mygdx.game.BuilderBlocks.DragClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch7CoordinateGeometry.VisebalComponentsCh7;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter7 extends ChapterScreen implements Screen {

  private DragAndDropElements drag_L1_value;
  private DragAndDropElements drag_L1_value3;
  private DragAndDropElements drag_L1_value12;
  private DragAndDropElements drag_L1_value14;

  private DragAndDropElements drag_L2_value12;
  private DragAndDropElements drag_L2_value14;
  private DragAndDropElements drag_L2_valuek1;
  private DragAndDropElements drag_L2_valuek2;
  private DragAndDropElements drag_L2_value1;
  private DragAndDropElements drag_L2_value3;
  private DragAndDropElements drag_L2_valuek3;
  private DragAndDropElements drag_L2_valuek4;

  private DragAndDropElements drag_L3_value1;
  private DragAndDropElements drag_L3_value1_1;
  private DragAndDropElements drag_L3_value3;
  private DragAndDropElements drag_L3_value3_1;
  private DragAndDropElements drag_L3_value12;
  private DragAndDropElements drag_L3_value12_1;
  private DragAndDropElements drag_L3_value14;
  private DragAndDropElements drag_L3_value14_1;
  private DragAndDropElements drag_L3_value22;
  private DragAndDropElements drag_L3_value22_1;
  private DragAndDropElements drag_L3_value24;
  private DragAndDropElements drag_L3_value24_1;

  private VisebalComponentsCh7 visebalComponentsCh7;
  private ArrayList<DragClickListener> arrDragListener;

  private Label L1_value1,L1_value3,L1_value12,L1_value14,L2_value12,L2_value14,L2_valuek1,L2_valuek2;
  private Label L2_value1,L2_value3,L2_valuek3,L2_valuek4;
  private Label L3_value1,L3_value1_1,L3_value3,L3_value3_1,L3_value12,L3_value12_1,L3_value14,
          L3_value14_1,L3_value22,L3_value22_1,L3_value24,L3_value24_1;

  private Label synlabel,synlabel1,synlabel2,synlabel3;
  private Label L2_Syntaxlabelx1,L2_Syntaxlabelx2,L2_Syntaxlabelk1,L2_Syntaxlabelk,
          L2_Syntaxlabely1,L2_Syntaxlabely2,L2_s2_Syntaxlabelk1,L2_s2_Syntaxlabelk;

  private Label L3_sytaxlablex33,L3_sytaxlabley3,L3_sytaxlablex1,L3_sytaxlabley33,L3_sytaxlablex11,
          L3_sytaxlablex22,L3_sytaxlablex2,L3_sytaxlabley11,L3_sytaxlabley1,L3_sytaxlabley22,
          L3_sytaxlabley2,L3_sytaxlablex3;

  Chapter7(){
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

      time.RestartTime();

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

    if (updatables != null) {
      updatables.size();
      for (Label updatable : updatables) {
        String str = updatable.getName();
        if (str.equals("LabelValue1")) {
          L1_value1 = updatable;
        }else if (str.equals("LabelValue3")) {
          L1_value3 = updatable;
        }else if (str.equals("LabelValue12")) {
          L1_value12 = updatable;
        }else if (str.equals("LabelValue14")) {
          L1_value14 = updatable;
        }
        else if (str.contains("SyntaxLabel1")) {
          synlabel1 = updatable;
        }else if (str.equals("SyntaxLabel")) {
          synlabel = updatable;
        }else if (str.equals("SyntaxLabel2")) {
          synlabel2 = updatable;
        }else if (str.equals("SyntaxLabel3")) {
          synlabel3 = updatable;
        }
      }
      visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
    }

    drag_L1_value = new DragAndDropElements(Events.DRAG_L1_VALUE);
    Label PayloadValueL1_1 = new Label(L1_value1.getText(), L1_value1.getStyle());
    drag_L1_value.defineComponentLabelImage(PayloadValueL1_1,L1_value1,synlabel1);

    drag_L1_value3 = new DragAndDropElements(Events.DRAG_L1_VALUE);
    Label PayloadValueL1_3 = new Label(L1_value3.getText(), L1_value3.getStyle());
    drag_L1_value3.defineComponentLabelImage(PayloadValueL1_3,L1_value3,synlabel);

    drag_L1_value12 = new DragAndDropElements(Events.DRAG_L1_VALUE12);
    Label PayloadValueL1_12 = new Label(L1_value12.getText(), L1_value12.getStyle());
    drag_L1_value12.defineComponentLabelImage(PayloadValueL1_12,L1_value12,synlabel2);

    drag_L1_value14 = new DragAndDropElements(Events.DRAG_L1_VALUE14);
    Label PayloadValueL1_14 = new Label(L1_value14.getText(), L1_value14.getStyle());
    drag_L1_value14.defineComponentLabelImage(PayloadValueL1_14,L1_value14,synlabel3);

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6To10Components() {

    if (updatables != null){
      updatables.size();
      for (Label updatable : updatables){
        String str = updatable.getName();
        if (str.equals("LabelValue1")) {
          L3_value1 = updatable;
        }else if (str.equals("LabelValue1_1")) {
          L3_value1_1 = updatable;
        }else if (str.equals("LabelValue3")) {
          L3_value3 = updatable;
        }else if (str.equals("LabelValue3_1")) {
          L3_value3_1 = updatable;
        }else if (str.equals("LabelValue12")) {
          L3_value12 = updatable;
        }else if (str.equals("LabelValue12_1")) {
          L3_value12_1 = updatable;
        }else if (str.equals("LabelValue14")) {
          L3_value14 = updatable;
        }else if (str.equals("LabelValue14_1")) {
          L3_value14_1 = updatable;
        }else if (str.equals("LabelValue22")) {
          L3_value22 = updatable;
        }else if (str.equals("LabelValue22_1")) {
          L3_value22_1 = updatable;
        }else if (str.equals("LabelValue24")) {
          L3_value24 = updatable;
        }else if (str.equals("LabelValue24_1")) {
          L3_value24_1 = updatable;
        }
        else if (str.equals("SyntaxLabelx33")) {
          L3_sytaxlablex33 = updatable;
        }
        else if (str.equals("SyntaxLabelx3")) {
          L3_sytaxlablex3 = updatable;
        }
        else if (str.equals("SyntaxLabely33")) {
          L3_sytaxlabley33 = updatable;
        }
        else if (str.equals("SyntaxLabely3")) {
          L3_sytaxlabley3 = updatable;
        }
        else if (str.equals("SyntaxLabelx11")) {
          L3_sytaxlablex11 = updatable;
        }
        else if (str.equals("SyntaxLabelx1")) {
          L3_sytaxlablex1 = updatable;
        }
        else if (str.equals("SyntaxLabelx22")) {
          L3_sytaxlablex22 = updatable;
        }
        else if (str.equals("SyntaxLabelx2")) {
          L3_sytaxlablex2 = updatable;
        }
        else if (str.equals("SyntaxLabely11")) {
          L3_sytaxlabley11 = updatable;
        }
        else if (str.equals("SyntaxLabely1")) {
          L3_sytaxlabley1 = updatable;
        }
        else if (str.equals("SyntaxLabely22")) {
          L3_sytaxlabley22 = updatable;
        }
        else if (str.equals("SyntaxLabely2")) {
          L3_sytaxlabley2 = updatable;
        }

      }
      visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
    }

    drag_L3_value1 = new DragAndDropElements(Events.DRAG_L3_VALUE1);
    Label PayloadValueL3_1 = new Label(L3_value1.getText(), L3_value1.getStyle());
    drag_L3_value1.defineComponentLabelImage(PayloadValueL3_1,L3_value1,L3_sytaxlablex33);

    drag_L3_value1_1 = new DragAndDropElements(Events.DRAG_L3_VALUE1_1);
    Label PayloadValueL3_1_1 = new Label(L3_value1_1.getText(), L3_value1_1.getStyle());
    drag_L3_value1_1.defineComponentLabelImage(PayloadValueL3_1_1,L3_value1_1,L3_sytaxlablex3);

    drag_L3_value3 = new DragAndDropElements(Events.DRAG_L3_VALUE3);
    Label PayloadValueL3_3 = new Label(L3_value3.getText(), L3_value3.getStyle());
    drag_L3_value3.defineComponentLabelImage(PayloadValueL3_3,L3_value3,L3_sytaxlabley33);

    drag_L3_value3_1 = new DragAndDropElements(Events.DRAG_L3_VALUE3_1);
    Label PayloadValueL3_3_1 = new Label(L3_value3_1.getText(), L3_value3_1.getStyle());
    drag_L3_value3_1.defineComponentLabelImage(PayloadValueL3_3_1,L3_value3_1,L3_sytaxlabley3);

    drag_L3_value12 = new DragAndDropElements(Events.DRAG_L3_VALUE12);
    Label PayloadValueL3_12 = new Label(L3_value12.getText(), L3_value12.getStyle());
    drag_L3_value12.defineComponentLabelImage(PayloadValueL3_12,L3_value12,L3_sytaxlablex11);

    drag_L3_value12_1 = new DragAndDropElements(Events.DRAG_L3_VALUE12_1);
    Label PayloadValueL3_12_1 = new Label(L3_value12_1.getText(), L3_value12_1.getStyle());
    drag_L3_value12_1.defineComponentLabelImage(PayloadValueL3_12_1,L3_value12_1,L3_sytaxlablex1);

    drag_L3_value14 = new DragAndDropElements(Events.DRAG_L3_VALUE14);
    Label PayloadValueL3_14 = new Label(L3_value14.getText(), L3_value14.getStyle());
    drag_L3_value14.defineComponentLabelImage(PayloadValueL3_14,L3_value14,L3_sytaxlablex22);

    drag_L3_value14_1 = new DragAndDropElements(Events.DRAG_L3_VALUE14_1);
    Label PayloadValueL3_14_1 = new Label(L3_value14_1.getText(), L3_value14_1.getStyle());
    drag_L3_value14_1.defineComponentLabelImage(PayloadValueL3_14_1,L3_value14_1,L3_sytaxlablex2);

    drag_L3_value22 = new DragAndDropElements(Events.DRAG_L3_VALUE22);
    Label PayloadValueL3_22 = new Label(L3_value22.getText(), L3_value22.getStyle());
    drag_L3_value22.defineComponentLabelImage(PayloadValueL3_22,L3_value22,L3_sytaxlabley11);

    drag_L3_value22_1 = new DragAndDropElements(Events.DRAG_L3_VALUE22_1);
    Label PayloadValueL3_22_1 = new Label(L3_value22_1.getText(), L3_value22_1.getStyle());
    drag_L3_value22_1.defineComponentLabelImage(PayloadValueL3_22_1,L3_value22_1,L3_sytaxlabley1);

    drag_L3_value24 = new DragAndDropElements(Events.DRAG_L3_VALUE24);
    Label PayloadValueL3_24 = new Label(L3_value24.getText(), L3_value24.getStyle());
    drag_L3_value24.defineComponentLabelImage(PayloadValueL3_24,L3_value24,L3_sytaxlabley22);

    drag_L3_value24_1 = new DragAndDropElements(Events.DRAG_L3_VALUE24_1);
    Label PayloadValueL3_24_1 = new Label(L3_value24_1.getText(), L3_value24_1.getStyle());
    drag_L3_value24_1.defineComponentLabelImage(PayloadValueL3_24_1,L3_value24_1,L3_sytaxlabley2);

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel11To15Components() {

    if(GameStates.steps == Steps.STEP_1){
      if (updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          if (str.equals("LabelValue12")) {
            L2_value12 = updatable;
          }else if (str.equals("LabelValue14")) {
            L2_value14 = updatable;
          }else if (str.equals("LabelValuek1")) {
            L2_valuek1 = updatable;
          }else if (str.equals("LabelValuek2")) {
            L2_valuek2 = updatable;
          }
          else if (str.equals("SyntaxLabelx1")) {
              L2_Syntaxlabelx1 = updatable;
          }
          else if (str.equals("SyntaxLabelx2")) {
              L2_Syntaxlabelx2 = updatable;
          }
          else if (str.equals("SyntaxLabelk1")) {
              L2_Syntaxlabelk1 = updatable;
          }
          else if (str.equals("SyntaxLabelk")) {
              L2_Syntaxlabelk = updatable;
          }
        }

        visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);

        drag_L2_value12 = new DragAndDropElements(Events.DRAG_L2_VALUE12);
        Label PayloadValueL2_12 = new Label(L2_value12.getText(), L2_value12.getStyle());
        drag_L2_value12.defineComponentLabelImage(PayloadValueL2_12,L2_value12,L2_Syntaxlabelx1);

        drag_L2_value14 = new DragAndDropElements(Events.DRAG_L2_VALUE14);
        Label PayloadValueL2_14 = new Label(L2_value14.getText(), L2_value14.getStyle());
        drag_L2_value14.defineComponentLabelImage(PayloadValueL2_14,L2_value14,L2_Syntaxlabelx2);

        drag_L2_valuek1 = new DragAndDropElements(Events.DRAG_L2_VALUEK1);
        Label PayloadValueL2_K1 = new Label(L2_valuek1.getText(), L2_valuek1.getStyle());
        drag_L2_valuek1.defineComponentLabelImage(PayloadValueL2_K1,L2_valuek1,L2_Syntaxlabelk1);

        drag_L2_valuek2 = new DragAndDropElements(Events.DRAG_L2_VALUEK2);
        Label PayloadValueL2_K2 = new Label(L2_valuek2.getText(), L2_valuek2.getStyle());
        drag_L2_valuek2.defineComponentLabelImage(PayloadValueL2_K2,L2_valuek2,L2_Syntaxlabelk);
      }
    }
    else if (GameStates.steps == Steps.STEP_2){
      if (updatables != null) {
        updatables.size();
        for (Label updatable : updatables) {
          String str = updatable.getName();
          if (str.equals("LabelValue1")) {
            L2_value1 = updatable;
          }else if (str.equals("LabelValue3")) {
            L2_value3 = updatable;
          }else if (str.equals("LabelValuek3")) {
            L2_valuek3 = updatable;
          }else if (str.equals("LabelValuek4")) {
            L2_valuek4 = updatable;
          }
          else if (str.equals("SyntaxLabely1")) {
            L2_Syntaxlabely1 = updatable;
          }
          else if (str.equals("SyntaxLabely2")) {
            L2_Syntaxlabely2 = updatable;
          }
          else if (str.equals("SyntaxLabelk1")) {
            L2_s2_Syntaxlabelk1 = updatable;
          }
          else if (str.equals("SyntaxLabelk")) {
            L2_s2_Syntaxlabelk = updatable;
          }
        }

        drag_L2_value1 = new DragAndDropElements(Events.DRAG_L2_VALUE1);
        Label PayloadValueL2_1 = new Label(L2_value1.getText(), L2_value1.getStyle());
        drag_L2_value1.defineComponentLabelImage(PayloadValueL2_1,L2_value1,L2_Syntaxlabely1);

        drag_L2_value3 = new DragAndDropElements(Events.DRAG_L2_VALUE3);
        Label PayloadValueL2_3 = new Label(L2_value3.getText(), L2_value3.getStyle());
        drag_L2_value3.defineComponentLabelImage(PayloadValueL2_3,L2_value3,L2_Syntaxlabely2);

        drag_L2_valuek3 = new DragAndDropElements(Events.DRAG_L2_VALUEK3);
        Label PayloadValueL2_k3 = new Label(L2_valuek3.getText(), L2_valuek3.getStyle());
        drag_L2_valuek3.defineComponentLabelImage(PayloadValueL2_k3,L2_valuek3,L2_s2_Syntaxlabelk1);

        drag_L2_valuek4 = new DragAndDropElements(Events.DRAG_L2_VALUEK4);
        Label PayloadValueL2_K4 = new Label(L2_valuek4.getText(), L2_valuek4.getStyle());
        drag_L2_valuek4.defineComponentLabelImage(PayloadValueL2_K4,L2_valuek4,L2_s2_Syntaxlabelk);

        visebalComponentsCh7 = new VisebalComponentsCh7(displayImages, updatables);
      }
    }
    else if (GameStates.steps == Steps.STEP_3){}

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
    if (time.isTimeUp()){messageBox.TimeUpMessage();}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    messageBox.update(deltaTime);

    if (time.isTimeUp()){messageBox.TimeUpMessage();}

    //Move Screen to next Screen
    if(moveTheBg) { bg.act(deltaTime);}

    stage.draw();
    time.stage.draw();

  }
}
