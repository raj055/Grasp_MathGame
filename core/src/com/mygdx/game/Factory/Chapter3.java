package com.mygdx.game.Factory;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.DragLabelCh3;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.ScrollingUpdateCh3;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.UpdateVisibleComponent;
import com.mygdx.game.ChapterClass.Ch3LinearEquations.VisebalComponentsCh3;
import com.mygdx.game.Component.NumberCh3;
import com.mygdx.game.Component.TextveriabalCh3;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

public class Chapter3 extends ChapterScreen implements Screen {

  private Timer time;

  ArrayList<Image> ClickImage;
  ArrayList<Image> Changeposition;
  ArrayList<Image> VisebalComponent;

  ArrayList<Image> scrollingImages = null;

  ScrollingNumber numLocal;

  //Update labels on click scrolling components
  ScrollingUpdateCh3 scrollingUpdateCh3;

  DoubleClickListener clickListenerY1;
  DoubleClickListener clickListenerY2;
  DoubleClickListener clickListenerSq1;
  DoubleClickListener clickListenerSq2;
  DoubleClickListener clickListenerC1;
  DoubleClickListener clickListenerC2;
  UpdateVisibleComponent updateVisibleComponent;

  DragLabelCh3 dragListenerA1;
  DragLabelCh3 dragListenerB1;
  DragLabelCh3 dragListenerC1;
  DragLabelCh3 dragListenerA2;
  DragLabelCh3 dragListenerB2;
  DragLabelCh3 dragListenerC2;
  DragLabelCh3 dragListenerB11;
  DragLabelCh3 dragListenerB21;

  VisebalComponentsCh3 visebalComponentsCh3;
  VisebalComponentsCh3 visebalComponentsCh3Level11;

  // component of level_1
  private Label labelP,labelE;

//  Label value1,value3,value11,value13;
  private Label value1,value3,value11,value13;

  private Label value2,value12;

  private float elapsed;

  // component of level_2
  private Image imgsqureL,imgsqureL2,imgsquer,imground,imground1,imground2,imgShap1,imgShap2;
  private Image img_y1,img_y2;
  private Label y1,y2,label_x,num,eqval,min,label_2y,AnsValue;

  // component of level_3
  private Image imga1,imga2,imgb1,imgb2,imgc1,imgc2,img1b1,img1b2;

  private Label valueA,valueB,valueC,valueA1,valueB1,valueC1,valueB11,valueB12;

  private Label a,a2,b,b2,c,c2,b11,b12,AnsLabel;

  private GlobalsCommonCount glv;

  TextveriabalCh3 textveriabalch3;

  NumberCh3 numLocalch3;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  @Override
  public void show() {}

  Chapter3(){
    super();

    time = new Timer();


    glv = GlobalsCommonCount.getInstance();

    clickListenerY1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_Y1);
    clickListenerY2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_Y2);
    clickListenerSq1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_SQ1);
    clickListenerSq2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_SQ2);
    clickListenerC1 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_C1);
    clickListenerC2 = new DoubleClickListener(Events.DOUBLE_CLICK_IMG_C2);


    getLevelName();
    initialiseLevelComponents(currentLevelNumber);

  }
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
//    numLocalch3 = new NumberCh3();
//    textveriabalch3 = new TextveriabalCh3();

//    numLocalch3.addToStage(stage);
//    textveriabalch3.addToStage(stage);

    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();
    scrollingImages = new ArrayList<Image>();

    //totalObjects
    scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);
      stage.addActor(img);
    }
    numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh3);
    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

//      if (str.contains("LabelB")) {
//        labelP = updatable;
//      }
//      else if (str.contains("LabelB")) {
//        labelE = updatable;
//      }
    }
    scrollingUpdateCh3 = new ScrollingUpdateCh3(updatables);



  }
  void defineLevel6To10Components() {

    ClickImage = new ArrayList<Image>();
    Changeposition = new ArrayList<Image>();
    VisebalComponent = new ArrayList<Image>();

    if(displayImages == null)
      return;

    displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      //check if the displayImages are present
      if (str.contains("y1Image")) {
        img_y1 = updatable;
        img_y1.addListener(clickListenerY1);
      }
      else if (str.contains("y2Image")) {
        img_y2 = updatable;
        img_y2.addListener(clickListenerY2);
      }
      else if (str.contains("SqurelImage")) {
        imgsqureL = updatable;
      }
      else if (str.contains("SquerImage")) {
        imgsquer = updatable;
      }
      else if (str.contains("Squrel2Image")) {
        imgsqureL2 = updatable;
      }
      else if (str.contains("RoundImage")) {
        imground = updatable;
      }
      else if (str.contains("Round1Image")) {
        imground1 = updatable;
      }
      else if (str.contains("Round2Image")) {
        imground2 = updatable;
      }
      else if (str.contains("Shap1")) {
        imgShap1 = updatable;
      }
      else if (str.contains("Shap2")) {
        imgShap2 = updatable;
      }

      ClickImage.add(updatable);

//      clickListener.setClick(ClickImage);
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();



    }
    visebalComponentsCh3 = new VisebalComponentsCh3(displayImages, updatables);
  }
  void defineLevel11To15Components() {

    dragListenerA1 = new DragLabelCh3(Events.DRAG_VALUE_A1);
    dragListenerA2 = new DragLabelCh3(Events.DRAG_VALUE_A2);
    dragListenerB1 = new DragLabelCh3(Events.DRAG_VALUE_B1);
    dragListenerB2 = new DragLabelCh3(Events.DRAG_VALUE_B2);
    dragListenerC1 = new DragLabelCh3(Events.DRAG_VALUE_C1);
    dragListenerC2 = new DragLabelCh3(Events.DRAG_VALUE_C2);
    dragListenerB11 = new DragLabelCh3(Events.DRAG_VALUE_B11);
    dragListenerB21 = new DragLabelCh3(Events.DRAG_VALUE_B21);


    if(displayImages == null)
      return;
    displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      //check if the displayImages are present
      if (str.contains("b1Image")) {
        imgb1 = updatable;
      }
      else if (str.contains("C2Image")) {
        imgc2 = updatable;
      }
      else if (str.contains("b2Image")) {
        imgb2 = updatable;
      }
      else if (str.contains("C1Image")) {
        imgc1 = updatable;
      }
      else if (str.contains("a1Image")) {
        imga1 = updatable;
      }
      else if (str.contains("b2Image1")) {
        img1b2 = updatable;
      }
      else if (str.contains("a2Image")) {
        imga2 = updatable;
      }
      else if (str.contains("b1Image1")) {
        img1b1 = updatable;
      }

    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.equals("ValueA")) {
        valueA = updatable;
        valueA.addListener(dragListenerA1);
      }
      else if (str.equals("ValueB")) {
        valueB = updatable;
        valueB.addListener(dragListenerB1);
      }
      else if (str.equals("ValueB11")) {
        valueB11 = updatable;
        valueB11.addListener(dragListenerB11);
      }
      else if (str.equals("ValueC")) {
        valueC = updatable;
        valueC.addListener(dragListenerC1);
      }
      else if (str.equals("ValueA1")) {
        valueA1 = updatable;
        valueA1.addListener(dragListenerA2);
      }
      else if (str.equals("ValueB1")) {
        valueB1 = updatable;
        valueB1.addListener(dragListenerB2);
      }
      else if (str.equals("ValueB12")) {
        valueB12 = updatable;
        valueB12.addListener(dragListenerB21);
      }
      else if (str.equals("ValueC1")) {
        valueC1 = updatable;
        valueC1.addListener(dragListenerC2);
      }
      else if (str.equals("Labelb")) {
        b = updatable;
      }
      else if (str.equals("Labelc2")) {
        c2 = updatable;
      }
      else if (str.equals("Labelb2")) {
        b2 = updatable;
      }
      else if (str.equals("Labelc1")) {
        c = updatable;
      }
      else if (str.equals("LabelA1")) {
        a = updatable;
      }
      else if (str.equals("Labelb12")) {
        b12 = updatable;
      }
      else if (str.equals("LabelA2")) {
        a2 = updatable;
      }
      else if (str.contains("Labelb11")) {
        b11 = updatable;
      }
      else if (str.contains("LabelAns")) {
        AnsLabel = updatable;
      }
    }
    visebalComponentsCh3Level11 = new VisebalComponentsCh3(displayImages, updatables);
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

//    textveriabalch3.update(deltaTime);
//    numLocalch3.update(deltaTime);
    if(numLocal != null)numLocal.update(deltaTime);

     /*if (glv.lableWrite) {

      switch (glv.countClick){
        case 1:
          labelP.setText(textveriabalch3.string_labal + " ");
          break;

        case 2:
          labelE.setText(textveriabalch3.string_labal + " ");

          break;

        default:
          break;
      }

    }*/

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

    time.update(deltaTime);

    if (time.isTimeUp()){
//      GameStates.screenStates = ScreenStates.DIALOGBOX;
    }

    stage.draw();
    time.stage.draw();

  }
}
