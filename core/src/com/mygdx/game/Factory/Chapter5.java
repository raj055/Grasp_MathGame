package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.DoubleClickListener;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.DoubleClickImageCh5;
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.DragLabelCh5;
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.ScrollingUpdateCh5;
import com.mygdx.game.ChapterClass.Ch5ArithmeticProgressions.VisebalComponentsCh5;
import com.mygdx.game.Enum.ClickPluse;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter5 extends ChapterScreen implements Screen {

  private Timer time;

  ArrayList<Image> DragComponent;
  ArrayList<Image> VisebalComponent;

  DragLabelCh5 dragLabelCh5;
  VisebalComponentsCh5 visebalComponentsCh5;

  //Update components on clicking scrolling values
  ScrollingUpdateCh5 scrollingUpdateCh5;

  //Double click listeners for plus
  DoubleClickListener dblClickListenerPlus;

  ArrayList<Image> scrollingImages = null;

  // component of level_1
  private Label valueF,valueS,valueT,valueF1,valueS2,valueT2,valueF12;

  private Label value1,value2,value11,value12,value13,value14,value15,anser;

  private Label pluse,pluse1,pluse2,pluse3;

  private Image imgadd;

  private ClickPluse clickPluse;

  // component of level_2
  private Label cong;

  private Label valueA,valueN,valueD;

  private Label val4;

  // component of level_3

  private Label valL,valueL1,val1;


  private GlobalsCommonCount glv;

  ScrollingNumber numLocal;

  DoubleClickImageCh5 ImageADD;


  Chapter5(){
    super();

    time = new Timer();

    dragLabelCh5 = new DragLabelCh5(Events.DRAG_LABEL);
    visebalComponentsCh5 = new VisebalComponentsCh5(VisebalComponent);

    ImageADD = new DoubleClickImageCh5(Events.DOUBLE_CLICK_ADD);

    dblClickListenerPlus = new DoubleClickListener(Events.DOUBLE_CLICK_ADD);

    glv = GlobalsCommonCount.getInstance();

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
    //check if the displayImages are present
    if(displayImages != null) {

      //totalObjects
      displayImages.size();
      for (Image updatable : displayImages) {
        String str = updatable.getName();

        if (str.contains("PluseBttn")) {
          imgadd = updatable;
          imgadd.addListener(dblClickListenerPlus);
        }
      }
    }
    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects


    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Firstterm")) {
        valueF = updatable;
      }
      else if (str.contains("Secondterm")) {
        valueS = updatable;
      }
      else if (str.contains("Thirdterm")) {
        valueT = updatable;
      }
      else if (str.contains("Fourthterm")) {
        valueF1 = updatable;
      }
      else if (str.contains("Value1")) {
        value1 = updatable;
      }
      else if (str.contains("Value2")) {
        value2 = updatable;
      }
      else if (str.contains("Value11")) {
        value11 = updatable;
      }
      else if (str.equals("Pluse")) {
        pluse = updatable;
        pluse.addListener(dblClickListenerPlus);
      }
      else if (str.equals("Pluse1")) {
        pluse1 = updatable;
        pluse1.addListener(dblClickListenerPlus);
      }
      else if (str.equals("Pluse2")) {
        pluse2 = updatable;
        pluse2.addListener(dblClickListenerPlus);
      }
      else if (str.equals("Pluse3")) {
        pluse3 = updatable;
        pluse3.addListener(dblClickListenerPlus);
      }
      else if (str.contains("Value12")) {
        value12 = updatable;
      }
      else if (str.contains("Value13")) {
        value13 = updatable;
      }
      else if (str.contains("Value14")) {
        value14 = updatable;
      }
      else if (str.contains("ValueS2")) {
        valueS2 = updatable;
      }
      else if (str.contains("ValueT2")) {
        valueT2 = updatable;
      }
      else if (str.contains("ValueF12")) {
        valueF12 = updatable;
      }
    }
  }
  void defineLevel6To10Components() {

    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    //totalObjects
    scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);
    }
    numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh5);

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

//      if (str.contains("Value4")) {
//        val4 = updatable;
//      }
//      else  if (str.contains("ValueD")) {
//        valueD = updatable;
//      }
//      else  if (str.contains("Congratulations")) {
//        cong = updatable;
//      }
    }
    scrollingUpdateCh5 = new ScrollingUpdateCh5(updatables);

    for(Image numberI : scrollingPara)
    {
      stage.addActor(numberI);
    }

  }
  void defineLevel11To15Components() {

    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    //totalObjects
    scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

      numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh5);
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Value4")) {
        val4 = updatable;
      }
      else  if (str.contains("Value1")) {
        value1 = updatable;
      }
      else  if (str.contains("Labelval1")) {
        val1 = updatable;
      }
    }

    for(Image numberI : scrollingPara)
    {
      stage.addActor(numberI);
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

    if (time.isTimeUp()){ }

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);

    //Check if the local numbers are declared.
    if(numLocal != null)
      numLocal.update(delta);

//    if (glv.lableWrite){
//      valueD.setText(glv.lableUpdate + " ");
//      val4.setText("47");
//      cong.setVisible(true);
//    }


    if (time.isTimeUp()){}

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){

    time.update(deltaTime);

    numLocal.update(deltaTime);

    if (glv.lableWrite){

      val4.setText(glv.lableUpdate + " ");

    }

    if (time.isTimeUp()){}

    stage.draw();
    time.stage.draw();

  }
}
