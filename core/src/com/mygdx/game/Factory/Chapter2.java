package com.mygdx.game.Factory;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.mygdx.game.BuilderBlocks.DragAndDropElements;
import com.mygdx.game.BuilderBlocks.Events;
import com.mygdx.game.BuilderBlocks.ScrollingImageClick;
import com.mygdx.game.BuilderBlocks.ScrollingNumber;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.BallDisplay;
import com.mygdx.game.ChapterClass.Ch1RealNumbers.ScrollingUpdateLabelCh1;
import com.mygdx.game.ChapterClass.Ch2Polynomials.ScrollingUpdateLabelCh2;
import com.mygdx.game.ChapterClass.Ch2Polynomials.VisebleComponetsCh2;
import com.mygdx.game.Component.Nagetiv_Num;
import com.mygdx.game.Component.TextVeriabal;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Screens.MessageBox;

import java.util.ArrayList;

public class Chapter2 extends ChapterScreen implements Screen {

    private ArrayList<Image> imagesLines;
    private ArrayList<Image> dragCircle;
    private ArrayList<Image> scrollingImages = null;
    private ArrayList<Label> updateScrollLable = null;
    private ArrayList<Image> imageViseble = null;

    //Update visible components on scrolling clicked
    private ScrollingUpdateLabelCh1 scrollingUpdateLableCh1;
    private TextVeriabal textVeriabal;
    private ScrollingNumber numLocal;
    private BallDisplay ballDisplay;
    private Nagetiv_Num nagetivNum;
    private DragAndDropElements dragPoint;
    private VisebleComponetsCh2 visebleComponetsCh2;
    private ScrollingImageClick scrollingImageClick;
    private ScrollingUpdateLabelCh2 scrollingUpdateLabelCh2;

    private Image DragCircle,LineTarget;
    private Label score;

  Chapter2(){
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

    private void Initdrgndrop() {
        dragPoint = new DragAndDropElements(Events.DRAG_CIRCLE);
        dragPoint.defineComponentImages(DragCircle,LineTarget);
}

  // Level's Component
  void defineLevel1to5Components() {

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)){

    }
    else if (GameStates.steps == Steps.STEP_3){ }

    if(displayImages != null) {

        imagesLines = new ArrayList<Image>();
        dragCircle = new ArrayList<Image>();

        //totalObjects
        displayImages.size();

        for (Image updatable : displayImages) {
            String str = updatable.getName();

            if (str.equals("line")){
                imagesLines.add(updatable);
            }
            else if (str.equals("horizantal")){
                LineTarget = updatable;
            }
        }
        visebleComponetsCh2 = new VisebleComponetsCh2(imagesLines,updatables);
    }

    if (draggable != null) {
        try {
            for (Image draggables : draggable) {
                String str = draggables.getName();
                if (str.equals("DragCircle")) {
                    DragCircle = draggables;
                }
            }

        } catch (Exception e) {}
    }

    Initdrgndrop();

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel6to10Components() {

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)){
        if(scrollingPara != null){
            numLocal = new ScrollingNumber();
            numLocal.setPositionX(xPosAdditionFactor - 400);
            scrollingImages = new ArrayList<Image>();
            updateScrollLable = new ArrayList<Label>();
            //totalObjects
            scrollingPara.size();

            for(Image img : scrollingPara)
            {
                scrollingImages.add(img);
                stage.addActor(img);
            }
            numLocal.scrolling(scrollingImages, Events.CLICK_SCROLLCH2_BALLDISPLAY);
            ballDisplay = new BallDisplay(8, 8);
        }

        //check if the updatable are present
        if(updatables != null){
            updatables.size();

            for (Label updatable : updatables) {
                updatable.getName();
                updateScrollLable.add(updatable);
            }
            scrollingUpdateLabelCh2 = new ScrollingUpdateLabelCh2(updateScrollLable);

            for (int i = 0; i < ballDisplay.columns; i++){

                for (int j = 0; j < ballDisplay.rows; j++) {

                    stage.addActor(scrollingUpdateLabelCh2.ballDisplay.balls[i][j]);

                    scrollingUpdateLabelCh2.ballDisplay.balls[i][j].setVisible(false);
                }
            }
        }
    }
    else if (GameStates.steps == Steps.STEP_3){
        numLocal = new ScrollingNumber();
        numLocal.dispose();
    }

    //Add Submit Button Listener.
    addSubmitButtonListner();
  }
  void defineLevel11to15Components() {

    if((GameStates.steps == Steps.STEP_1) || (GameStates.steps == Steps.STEP_2)){
        if(scrollingPara != null) {

            numLocal = new ScrollingNumber();
            numLocal.setPositionX(xPosAdditionFactor - 400);
            scrollingImages = new ArrayList<Image>();
            updateScrollLable = new ArrayList<Label>();
            imageViseble = new ArrayList<Image>();

            //totalObjects
            scrollingPara.size();

            for (Image img : scrollingPara) {
                scrollingImages.add(img);
                stage.addActor(img);
            }
            numLocal.scrolling(scrollingImages, Events.CLICK_ScrollingCh2);
        }

        if (updatables != null) {
            updatables.size();
            for (Label updatable : updatables) {
                updatable.getName();
                updateScrollLable.add(updatable);
            }
            scrollingUpdateLabelCh2 = new ScrollingUpdateLabelCh2(updateScrollLable);
        }

        if (displayImages != null) {
            displayImages.size();
            for (Image updatable : displayImages) {
                updatable.getName();
                imageViseble.add(updatable);
            }
            visebleComponetsCh2 = new VisebleComponetsCh2(imageViseble,updatables);
        }
    }
    else if (GameStates.steps == Steps.STEP_3){
        numLocal = new ScrollingNumber();
        numLocal.dispose();
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
            public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },

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
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel2(float deltaTime){
    time.update(deltaTime);
    numLocal.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage();}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    time.update(deltaTime);
    numLocal.update(deltaTime);
    messageBox.update(deltaTime);
    if (time.isTimeUp()){messageBox.TimeUpMessage();}
    if(moveTheBg) { bg.act(deltaTime);}
    stage.draw();
    time.stage.draw();
  }

}
