package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch6Triangles.DoubleClickLabelCh6;
import com.mygdx.game.ChapterClass.Ch6Triangles.DragShapeCh6;
import com.mygdx.game.ChapterClass.Ch6Triangles.UpdateImageCh6;
import com.mygdx.game.ChapterClass.Ch6Triangles.UpdateLabelCh6;
import com.mygdx.game.ChapterClass.Ch6Triangles.VisebalComponentsCh6;
import com.mygdx.game.Component.Numberch6;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Timer.Timer;

import java.util.ArrayList;

public class Chapter6 extends ChapterScreen implements Screen {

  private Timer time;

  ArrayList<Image> DragComponent;
  ArrayList<Image> VisebalComponent;
  ArrayList<Label> LableChange;
  ArrayList<Image> ImagePosition;

  ArrayList<Image> scrollingImages = null;

  DragShapeCh6 dragShapeCh6;
  VisebalComponentsCh6 visebalComponentsCh6;

  //Scrolling Number
  ScrollingNumber numLocal;

  // component of level_1
  Image square;
  Image square1;
  Image sercal;
  Image sercal1;
  Image triangle_p;

  // component of level_2
  private Label value,value1,value2,value3,value4,value5;

  private Label anser;

  private GlobalsCommonCount glv;

  private Numberch6 numberch6;

  private Image imgVlu1,imgVlu5,imgVlu7,imgVlu4,imgVlu8,imgVlu2,imgVlu,imgVlu6,imgVlu9_2,imgVlu9,imgVlu3;

  DoubleClickLabelCh6 doubleClickLabelAC, Click_imgVlu1, Click_imgVlu5, Click_imgVlu7, Click_imgVlu4,
   Click_imgVlu8, Click_imgVlu2, Click_imgVlu, Click_imgVlu6, Click_imgVlu9_2, Click_imgVlu9, Click_imgVlu3;

  UpdateLabelCh6 updateLabelCh6;
  UpdateImageCh6 updateImageCh6;

  Chapter6(){
    super();

    time = new Timer();

    doubleClickLabelAC = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_LabelAC);

    dragShapeCh6 = new DragShapeCh6(Events.DRAG_SHAPE);
    visebalComponentsCh6 = new VisebalComponentsCh6(VisebalComponent);

    Click_imgVlu = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG);
    Click_imgVlu1 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG1);
    Click_imgVlu2 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG2);
    Click_imgVlu3 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG3);
    Click_imgVlu4 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG4);
    Click_imgVlu5 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG5);
    Click_imgVlu6 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG6);
    Click_imgVlu7 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG7);
    Click_imgVlu8 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG8);
    Click_imgVlu9 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG9);
    Click_imgVlu9_2 = new DoubleClickLabelCh6(Events.DOUBLE_CLICK_IMG9_2);

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
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
    stage.dispose();
  }

  void defineLevel1To5Components() {
    if(displayImages == null)
      return;

    displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();
      if (str.contains("squareImage")) {
        square = updatable;
      } else if (str.contains("square1Image")) {
        square1 = updatable;
      } else if (str.contains("sercalImage")) {
        sercal = updatable;
      } else if (str.contains("sercal1Image")) {
        sercal1 = updatable;
      } else if (str.contains("triangle_p")) {
        triangle_p = updatable;
      }
    }
  }
  void defineLevel6To10Components() {

    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    scrollingPara.size();

    numberch6 = new Numberch6();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

      numLocal.scrolling(scrollingImages);

    }

    LableChange = new ArrayList<Label>();

    //check if the updatables are present
    if(updatables == null)
      return;

    updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("value4")) {
        value4 = updatable;
        value4.addListener(doubleClickLabelAC);
      } else if (str.contains("Labelanser")) {
        anser = updatable;
      }else if (str.contains("value")) {
        value = updatable;
      }else if (str.contains("value1")) {
        value1 = updatable;
      }else if (str.contains("value3")) {
        value3 = updatable;
      }

      LableChange.add(updatable);
    }

    for(Image numberI : scrollingPara)
    {
      stage.addActor(numberI);
    }

    updateLabelCh6 = new UpdateLabelCh6(LableChange);
  }
  void defineLevel11To15Components() {

    if(displayImages == null)
      return;

    ImagePosition = new ArrayList<Image>();

    displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      if (str.equals("ImageVlu1")) {
       imgVlu1 = updatable;
       imgVlu1.addListener(Click_imgVlu1);
      }
      else if (str.equals("imgValue5")) {
        imgVlu5 = updatable;
        imgVlu5.addListener(Click_imgVlu5);
      }
      else if (str.equals("ImageVlu7")) {
        imgVlu7 = updatable;
        imgVlu7.addListener(Click_imgVlu7);
      }
      else if (str.equals("imgVlu4")) {
        imgVlu4 = updatable;
        imgVlu4.addListener(Click_imgVlu4);
      }
      else if (str.equals("imgVlu8")) {
        imgVlu8 = updatable;
        imgVlu8.addListener(Click_imgVlu8);
      }
      else if (str.equals("imgVlu2")) {
        imgVlu2 = updatable;
        imgVlu2.addListener(Click_imgVlu2);
      }
      else if (str.equals("imgVlu")) {
        imgVlu = updatable;
        imgVlu.addListener(Click_imgVlu);
      }
      else if (str.equals("imgVlu3")) {
        imgVlu3 = updatable;
        imgVlu3.addListener(Click_imgVlu3);
      }
      else if (str.equals("ImageVlu5")) {
        imgVlu5 = updatable;
        imgVlu5.addListener(Click_imgVlu5);
      }
      else if (str.equals("imgVlu6")) {
        imgVlu6 = updatable;
        imgVlu6.addListener(Click_imgVlu6);
      }
      else if (str.equals("imgVlu8")) {
        imgVlu8 = updatable;
        imgVlu8.addListener(Click_imgVlu8);
      }
      else if (str.equals("imgVlu9_2")) {
        imgVlu9_2 = updatable;
        imgVlu9_2.addListener(Click_imgVlu9_2);
      }
      else if (str.equals("imgVlu9")) {
        imgVlu9 = updatable;
        imgVlu9.addListener(Click_imgVlu9);
      }

      ImagePosition.add(updatable);
    }

    updateImageCh6 = new UpdateImageCh6(ImagePosition);
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

   /* numberch6.update(delta);

    if (glv.lableWrite){

      switch (glv.countClick){
        case 1:
          value.setText(numberch6.string_labal + " ");
          break;

        case 2:
          value1.setText(numberch6.string_labal + " ");
          break;

        case 3:
          value3.setText(numberch6.string_labal + " ");
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
